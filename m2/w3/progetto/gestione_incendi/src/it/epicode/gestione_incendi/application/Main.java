package it.epicode.gestione_incendi.application;

import it.epicode.gestione_incendi.application.models.Sonda;
import it.epicode.gestione_incendi.application.models.CanaleDiComunicazione;
import it.epicode.gestione_incendi.application.models.CentroControllo;
import it.epicode.gestione_incendi.application.models.MioCanaleDiComunicazione;

public class Main {

	public static void main(String[] args) {
		
		// Creiamo un nuovo canale di comunicazione
		CanaleDiComunicazione canale = (CanaleDiComunicazione) new MioCanaleDiComunicazione();

        // Creiamo una nuova istanza del centro di controllo
        CentroControllo centroControllo = CentroControllo.getInstance(canale);

        // Creiamo due nuove sonde e le aggiungiamo al centro di controllo
        Sonda sonda1 = new Sonda(1, 45.4642, 9.1900, 0.0, canale);
        Sonda sonda2 = new Sonda(2, 45.4789, 9.2252, 0.0, canale);
        centroControllo.addSonda(sonda1);
        centroControllo.addSonda(sonda2);

        // Modifichiamo il livello di fumo della prima sonda e verifichiamo che venga inviato l'allarme
        sonda1.setSmokeLevel(6.5);

        // Modifichiamo il livello di fumo della seconda sonda e verifichiamo che non venga inviato l'allarme
        sonda2.setSmokeLevel(4.0);
        
        // Modifichiamo il livello di fumo della seconda sonda e verifichiamo che venga inviato l'allarme
        sonda2.setSmokeLevel(8);
        
        sonda1.setSmokeLevel(8);
	}

}
