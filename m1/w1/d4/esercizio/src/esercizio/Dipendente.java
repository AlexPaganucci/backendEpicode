package esercizio;

public class Dipendente {
	
	public static double stipendioBase = 1000;
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	
	
	public Dipendente (String matricola, double stipendio, double importoOrarioStraordinario, Livello livello, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}
	
	public Dipendente (String matricola, Dipartimento dipartimento) {
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
	}

	public double getStipendioBase() {
		return stipendioBase;
	}

	public String getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public Livello getLivello() {
		return livello;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	public void stampaDatiDipendente(){
		System.out.printf("id:%s%n stipendio:%.1f;%n importo orario straordinario %.1f;%n livello %s;%n dipartimento %s;%n",
				this.matricola, this.stipendio, this.importoOrarioStraordinario, this.livello, this.dipartimento);
	}
	
	public Livello promuovi() {
		if(this.livello == Livello.OPERAIO) {
			this.stipendio = Dipendente.stipendioBase*Livello.IMPIEGATO.getMoltiplicatoreStipendio();
			return Livello.IMPIEGATO;
		}else if (this.livello == Livello.IMPIEGATO) {
			this.stipendio = Dipendente.stipendioBase*Livello.QUADRO.getMoltiplicatoreStipendio();
			return Livello.QUADRO;
		}else if (this.livello == Livello.QUADRO) {
			this.stipendio = Dipendente.stipendioBase*Livello.DIRIGENTE.getMoltiplicatoreStipendio();
			return Livello.DIRIGENTE;
		}else {
			System.out.println("Errore, il tuo ruolo è il più importante:");
			return this.livello;
		}
	}

	public static double calcolaPaga(Dipendente dipendente) {
		return dipendente.getStipendio();
	}

	public static double calcolaPaga(Dipendente dipendente, double oreStraordinario) {
		double straordinario = oreStraordinario * dipendente.importoOrarioStraordinario;
		double stipendio = dipendente.getStipendio();
		return straordinario + stipendio;
	}
	
}
