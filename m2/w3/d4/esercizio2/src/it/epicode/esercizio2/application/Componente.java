package it.epicode.esercizio2.application;

public abstract class Componente {

	protected String titolo;
    protected int numeroPagine;

    public Componente(String titolo, int numeroPagine) {
        this.titolo = titolo;
        this.numeroPagine = numeroPagine;
    }

    public abstract void stampa();

    public int getNumeroPagine() {
        return numeroPagine;
    }

}
