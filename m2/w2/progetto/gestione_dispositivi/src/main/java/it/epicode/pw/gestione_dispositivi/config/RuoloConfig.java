package it.epicode.pw.gestione_dispositivi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.pw.gestione_dispositivi.models.Ruolo;
import it.epicode.pw.gestione_dispositivi.models.enums.TipoRuolo;

@Configuration
public class RuoloConfig {

//	@Bean
//	@Scope("prototype")
//	public Ruolo ruolo() {
//		return Ruolo.builder()
//					.tipo(TipoRuolo.UTENTE)
//					.build();
//	}
	
	@Bean
	public Ruolo ruoloAmministratore() {
	    return Ruolo.builder().tipo(TipoRuolo.AMMINISTRATORE).build();
	}
	
	@Bean
	public Ruolo ruoloUtente() {
		return Ruolo.builder().tipo(TipoRuolo.UTENTE).build();
	}
}
