package it.epicode.pw.gestione_dispositivi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.pw.gestione_dispositivi.models.Utente;

@Configuration
public class UtenteConfig {

	@Bean
	@Scope("prototype")
	public Utente utente(String nome, String cognome, String username, String password, String email ) {
		return Utente.builder()
					.nome(nome)
					.cognome(cognome)
					.username(username)
					.password(password)
					.email(email)
					.build();
	}
}
