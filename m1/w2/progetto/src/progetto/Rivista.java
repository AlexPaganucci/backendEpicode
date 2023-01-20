package progetto;

import java.util.UUID;

public class Rivista extends Biblioteca {

	Periodicita periodicita;

	public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.codiceISBN = UUID.randomUUID().toString();
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return this.titolo + " - " + this.annoPubblicazione + " - " + this.numeroPagine + " - " + this.periodicita;
	}
	
	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
	
}
