package it.epicode.esercizio2.application;

import java.util.ArrayList;
import java.util.List;

public class Sezione extends Componente{

	 private List<Componente> sottoelementi = new ArrayList<>();

	    public Sezione(String titolo) {
	        super(titolo, 0);
	    }

	    public void aggiungiComponente(Componente componente) {
	        sottoelementi.add(componente);
	        numeroPagine += componente.getNumeroPagine();
	    }

	    public void rimuoviComponente(Componente componente) {
	        sottoelementi.remove(componente);
	        numeroPagine -= componente.getNumeroPagine();
	    }

	    public void stampa() {
	        System.out.println("Stampa sezione: " + titolo);
	        for (Componente componente : sottoelementi) {
	            componente.stampa();
	        }
	    }

}
