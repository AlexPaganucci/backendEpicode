package it.epicode.esercizio2.application;

import java.util.ArrayList;
import java.util.List;

public class Libro extends Componente{

	 	private List<String> autori = new ArrayList<>();
	    private double prezzo;
	    private List<Componente> sottoelementi = new ArrayList<>();

	    public Libro(String titolo, List<String> autori, double prezzo) {
	        super(titolo, 0);
	        this.autori = autori;
	        this.prezzo = prezzo;
	    }

	    public void aggiungiComponente(Componente componente) {
	        sottoelementi.add(componente);
	        numeroPagine += componente.getNumeroPagine();
	    }

	    public void rimuoviComponente(Componente componente) {
	        sottoelementi.remove(componente);
	        numeroPagine -= componente.getNumeroPagine();
	    }

	    public void aggiungiAutore(String autore) {
	        autori.add(autore);
	    }

	    public void stampa() {
	        System.out.println("Stampa libro: " + titolo);
	        for (Componente componente : sottoelementi) {
	            componente.stampa();
	        }
	    }

}
