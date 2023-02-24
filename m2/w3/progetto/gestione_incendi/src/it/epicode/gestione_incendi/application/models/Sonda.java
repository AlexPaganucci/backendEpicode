package it.epicode.gestione_incendi.application.models;

import java.util.Observable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sonda extends Observable{
	
	 private int idSonda;
	    private double latitude;
	    private double longitude;
	    private double smokeLevel;
	    private CanaleDiComunicazione canaleComunicazione;

	    public Sonda(int id, double latitude, double longitude, double smokeLevel, CanaleDiComunicazione canaleComunicazione) {
	        this.idSonda = id;
	        this.latitude = latitude;
	        this.longitude = longitude;
	        this.smokeLevel = smokeLevel;
	        this.canaleComunicazione = canaleComunicazione;
	    }

	    public void setSmokeLevel(double smokeLevel) {
	        this.smokeLevel = smokeLevel;
	         //Controlliamo se il livello di fumo è maggiore di 5 e notifichiamo gli osservatori
	        if (this.smokeLevel > 5) {
	            setChanged();
	            notifyObservers(this);
	            canaleComunicazione.inviaMessaggio("http://host/alarm?=idsonda=" + idSonda + "&lat=" + latitude + "&lon=" + longitude + "&smokelevel=" + smokeLevel);
//	            String messaggio = "ALLARME: sonda " + idSonda + " rilevato livello di fumo " + smokeLevel;
//	            canaleComunicazione.inviaMessaggio(messaggio);
	        }
	    }
}
