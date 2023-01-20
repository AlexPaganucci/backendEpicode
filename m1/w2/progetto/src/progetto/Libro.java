package progetto;

import java.util.UUID;

public class Libro extends Biblioteca {

	Autore autore;
	Genere genere;
	
	public Libro(String titolo, int annoPubblicazione, int numeroPagine, Autore autore, Genere genere) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.codiceISBN = UUID.randomUUID().toString();
		this.autore = autore;
		this.genere = genere;
	}
	
	@Override
	public String toString() {
		return this.titolo + " - " + this.annoPubblicazione + " - " + this.numeroPagine + " - " + this.autore.name + " - " + this.genere;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}
	
	
}
