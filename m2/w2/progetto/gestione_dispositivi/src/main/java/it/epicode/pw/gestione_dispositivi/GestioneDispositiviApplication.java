package it.epicode.pw.gestione_dispositivi;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.pw.gestione_dispositivi.config.DispositivoConfig;
import it.epicode.pw.gestione_dispositivi.config.RuoloConfig;
import it.epicode.pw.gestione_dispositivi.config.UtenteConfig;
import it.epicode.pw.gestione_dispositivi.models.Dispositivo;
import it.epicode.pw.gestione_dispositivi.models.Ruolo;
import it.epicode.pw.gestione_dispositivi.models.Utente;
import it.epicode.pw.gestione_dispositivi.models.enums.StatoDispositivo;
import it.epicode.pw.gestione_dispositivi.models.enums.TipoDispositivo;
import it.epicode.pw.gestione_dispositivi.models.enums.TipoRuolo;
import it.epicode.pw.gestione_dispositivi.services.DispositivoService;
import it.epicode.pw.gestione_dispositivi.services.RuoloService;
import it.epicode.pw.gestione_dispositivi.services.UtenteService;

@SpringBootApplication
public class GestioneDispositiviApplication implements CommandLineRunner{

	@Autowired
	private DispositivoService dispositivoSrv;
	@Autowired
	private RuoloService ruoloSrv;
	@Autowired
	private UtenteService utenteSrv;
	
	public static void main(String[] args) {
		SpringApplication.run(GestioneDispositiviApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		popolaDb();
		
	}
	
	private void popolaDb() {
		ApplicationContext ctxd = new AnnotationConfigApplicationContext(DispositivoConfig.class);
		ApplicationContext ctxu = new AnnotationConfigApplicationContext(UtenteConfig.class);
		ApplicationContext ctxr = new AnnotationConfigApplicationContext(RuoloConfig.class);
		
//		Ruolo r1 = (Ruolo)ctxr.getBean("ruolo", TipoRuolo.AMMINISTRATORE);
//		Ruolo r2 = (Ruolo)ctxr.getBean("ruolo", TipoRuolo.UTENTE);
		Ruolo r1 = (Ruolo)ctxr.getBean("ruoloAmministratore");
		Ruolo r2 = (Ruolo)ctxr.getBean("ruoloUtente");
		Dispositivo d1 = (Dispositivo)ctxd.getBean("dispositivo", "galaxi i10", TipoDispositivo.SMARTPHONE, StatoDispositivo.DISPONIBILE);
		Dispositivo d2 = (Dispositivo)ctxd.getBean("dispositivo", "airBook pro", TipoDispositivo.LAPTOP, StatoDispositivo.DISPONIBILE);
		Utente u1 = (Utente)ctxu.getBean("utente", "Mario", "Rossi", "Rmario", "test", "mario.rossi@gmail.com");
		
		u1.setRuoli(new HashSet<>() {{
			add(r1);
		}});
		u1.setDispositivi(new HashSet<>() {{
			add(d1);
		}});
		d1.setStato(StatoDispositivo.ASSEGNATO);
		ruoloSrv.save(r1);
		ruoloSrv.save(r2);
		dispositivoSrv.save(d1);
		dispositivoSrv.save(d2);
		utenteSrv.save(u1);
		
		((AnnotationConfigApplicationContext)ctxd).close();
		((AnnotationConfigApplicationContext)ctxu).close();
		((AnnotationConfigApplicationContext)ctxr).close();
	}

}
