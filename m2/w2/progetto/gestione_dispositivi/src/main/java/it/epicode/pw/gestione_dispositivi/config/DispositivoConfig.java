package it.epicode.pw.gestione_dispositivi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.pw.gestione_dispositivi.models.Dispositivo;
import it.epicode.pw.gestione_dispositivi.models.enums.StatoDispositivo;
import it.epicode.pw.gestione_dispositivi.models.enums.TipoDispositivo;

@Configuration
public class DispositivoConfig {

	@Bean
	@Scope("prototype")
	public Dispositivo dispositivo(String nome, TipoDispositivo tipo, StatoDispositivo stato) {
		return Dispositivo.builder()
					.nome(nome)
					.tipo(tipo)
					.stato(stato)
					.build();
	}
}
