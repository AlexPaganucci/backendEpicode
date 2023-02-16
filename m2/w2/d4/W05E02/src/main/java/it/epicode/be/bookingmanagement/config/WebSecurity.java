package it.epicode.be.bookingmanagement.config;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import it.epicode.be.bookingmanagement.models.Role;
import it.epicode.be.bookingmanagement.models.User;
import it.epicode.be.bookingmanagement.services.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userSrv;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()	
				.antMatchers(HttpMethod.GET, "/login").permitAll()
	            .antMatchers(HttpMethod.GET, "/api/**").permitAll()
	            .antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
	            .antMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN")
	            .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
                .and()
    			.formLogin()
				.successForwardUrl("/api")
                .and()
                .logout()
                .and()
                .csrf().disable();
	}
    
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		Optional<User> authUserObj = userSrv.getUserById((long) 1);
		User authUser = authUserObj.get();
		String role = "USER";
		Set<Role> roles = authUser.getRoles();
		
		for( Role r : roles ) {
			if( r.getType().toString().contains("ADMIN") ) {
				role = "ADMIN";
				break;
			}
		}
		
		auth.inMemoryAuthentication()
			.withUser( authUser.getUsername() ).password( passwordEncoder().encode( authUser.getPassword() ) )
			.roles(role);
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
