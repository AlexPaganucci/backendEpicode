package it.epicode.esercizio2.application;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		        // Creazione di alcune pagine semplici
		        Pagina pagina1 = new Pagina("Contenuto della pagina 1", 1);
		        Pagina pagina2 = new Pagina("Contenuto della pagina 2", 2);
		        Pagina pagina3 = new Pagina("Contenuto della pagina 3", 3);
		        Pagina pagina4 = new Pagina("Contenuto della pagina 4", 4);

		        // Creazione di alcune sezioni
		        Sezione sezione1 = new Sezione("Sezione 1");
		        Sezione sezione2 = new Sezione("Sezione 2");

		        // Aggiunta delle pagine alle sezioni
		        sezione1.aggiungiComponente(pagina1);
		        sezione1.aggiungiComponente(pagina2);
		        sezione2.aggiungiComponente(pagina3);
		        sezione2.aggiungiComponente(pagina4);

		        // Creazione di una sezione che contiene altre sezioni e pagine
		        Sezione sezione3 = new Sezione("Sezione 3");
		        sezione3.aggiungiComponente(sezione1);
		        sezione3.aggiungiComponente(sezione2);
		        sezione3.aggiungiComponente(pagina1);

		        // Creazione del libro
		        Libro libro = new Libro("Titolo del libro", Arrays.asList("Autore 1", "Autore 2"), 20.0);
		        libro.aggiungiComponente(sezione3);

		        // Stampa di alcune parti del libro
		        System.out.println("----- Pagina 1 -----");
		        pagina1.stampa();
		        System.out.println("----- Sezione 1 -----");
		        sezione1.stampa();
		        System.out.println("----- Libro -----");
		        libro.stampa();

		        // Calcolo del numero totale di pagine del libro
		        int numeroPagine = libro.getNumeroPagine();
		        System.out.println("Numero totale di pagine: " + numeroPagine);
	}
}
