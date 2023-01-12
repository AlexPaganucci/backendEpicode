package esercizio;

public enum Livello {
	OPERAIO(1),
	IMPIEGATO(1.2),
	QUADRO(1.5),
	DIRIGENTE(2);
	
	private double moltiplicatoreStipendio;
	
	private Livello(double moltiplicatoreStipendio) {
		this.moltiplicatoreStipendio = moltiplicatoreStipendio;
	}
	
	public double getMoltiplicatoreStipendio() {
		return moltiplicatoreStipendio;
	}

}
