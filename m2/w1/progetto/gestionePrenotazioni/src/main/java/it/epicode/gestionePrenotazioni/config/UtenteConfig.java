package it.epicode.gestionePrenotazioni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.gestionePrenotazioni.beans.Utente;

@Configuration
public class UtenteConfig {

	@Bean
	public Utente u(){
		Utente u = Utente.builder()
					.username("MarioRos")
					.nomeCognome("Mario Rossi")
					.email("mario.rossi@gmail.com")
					.build();
		return u;
	}
	
	@Bean
	public Utente u2(){
		Utente u2 = Utente.builder()
				.username("LuigiVer")
				.nomeCognome("Luigi Verdi")
				.email("luigi.verdi@gmail.com")
				.build();
		return u2;
	}
	
	@Bean
	public Utente u3(){
		Utente u3 = Utente.builder()
				.username("AnnaNer")
				.nomeCognome("Anna Neri")
				.email("anna.neri@gmail.com")
				.build();
		return u3;
	}
	
	@Bean
	public Utente u4(){
		Utente u4 = Utente.builder()
				.username("FrancoBian")
				.nomeCognome("Franco Bianchi")
				.email("franco.bianchi@gmail.com")
				.build();
		return u4;
	}
	
	@Bean
	public Utente u5(){
		Utente u5 = Utente.builder()
				.username("AlessGiall")
				.nomeCognome("Alessandro Gialli")
				.email("alessandro.gialli@gmail.com")
				.build();
		return u5;
	}
	
	@Bean
	public Utente u6(){
		Utente u6 = Utente.builder()
				.username("FrankyePurple")
				.nomeCognome("Francesco Porpora")
				.email("francesco.porpora@gmail.com")
				.build();
		return u6;
	}
}
