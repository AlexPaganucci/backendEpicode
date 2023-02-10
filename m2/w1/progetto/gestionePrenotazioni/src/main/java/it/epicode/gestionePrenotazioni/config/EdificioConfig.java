package it.epicode.gestionePrenotazioni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.gestionePrenotazioni.beans.Edificio;

@Configuration
public class EdificioConfig {

	@Bean
	public Edificio e(){
		Edificio e = Edificio.builder()
					.nome("Cjoidos")
					.indirizzo("Via G.Marconi 125")
					.citta("Milano")
					.build();
		return e;
	}
	
	@Bean
	public Edificio e2(){
		Edificio e2 = Edificio.builder()
				.nome("Qwerty")
				.indirizzo("Via C.Colombo 82")
				.citta("Roma")
				.build();
		return e2;
	}
	
	@Bean
	public Edificio e3(){
		Edificio e3 = Edificio.builder()
				.nome("Hjdiohs")
				.indirizzo("Via Flaminia 205")
				.citta("Roma")
				.build();
		return e3;
	}
}
