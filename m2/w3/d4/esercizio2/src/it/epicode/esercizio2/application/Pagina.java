package it.epicode.esercizio2.application;

public class Pagina extends Componente{

	 public Pagina(String titolo, int numeroPagina) {
	        super(titolo, numeroPagina);
	    }

	    public void stampa() {
	        System.out.println("Stampa pagina singola: " + titolo);
	    }

}
