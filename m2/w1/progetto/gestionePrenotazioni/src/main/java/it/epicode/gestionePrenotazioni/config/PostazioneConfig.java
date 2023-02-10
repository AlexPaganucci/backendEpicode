package it.epicode.gestionePrenotazioni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.gestionePrenotazioni.beans.Postazione;
import it.epicode.gestionePrenotazioni.beans.enums.StatoPostazione;
import it.epicode.gestionePrenotazioni.beans.enums.TipoPostazione;

@Configuration
public class PostazioneConfig {

	@Bean
	public Postazione p(){
		Postazione p = Postazione.builder()
					.tipo(TipoPostazione.PRIVATO)
					.stato(StatoPostazione.OCCUPATA)
					.nMaxOccupanti(1)
					.build();
		return p;
	}
	
	@Bean
	public Postazione p2(){
		Postazione p2 = Postazione.builder()
				.tipo(TipoPostazione.OPENSPACE)
				.stato(StatoPostazione.LIBERA)
				.nMaxOccupanti(4)
				.build();
		return p2;
	}
	
	@Bean
	public Postazione p3(){
		Postazione p3 = Postazione.builder()
				.tipo(TipoPostazione.SALA_RIUNIONI)
				.stato(StatoPostazione.LIBERA)
				.nMaxOccupanti(20)
				.build();
		return p3;
	}
}
