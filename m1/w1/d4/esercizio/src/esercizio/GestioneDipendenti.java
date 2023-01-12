package esercizio;

public class GestioneDipendenti {

	public static void main(String[] args) {
		Dipendente d1 = new Dipendente("1", 1000, 10, Livello.OPERAIO, Dipartimento.PRODUZIONE);
		Dipendente d2 = new Dipendente("2", 1000, 10, Livello.OPERAIO, Dipartimento.PRODUZIONE);
		Dipendente d3 = new Dipendente("3", 1200, 12, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		Dipendente d4 = new Dipendente("4", 2000, 20, Livello.DIRIGENTE, Dipartimento.VENDITE);
		Dipendente[] dipendenti = {d1, d2, d3, d4};
		
		d2.promuovi();
		d3.promuovi();
		
		double totale = 0;
		for( Dipendente d: dipendenti) {
			totale += Dipendente.calcolaPaga(d, 5);
			d.stampaDatiDipendente();
		}
		System.out.printf("Totale complessivo degli stipendi dovuti: %.2f €", totale);
		
	}

}
