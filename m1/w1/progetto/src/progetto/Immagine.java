package progetto;

public class Immagine extends ElementoMultimediale implements Luminosita {
	int luminosita;

	public Immagine() {
		
	}
	
	public int getLuminosita() {
		return luminosita;
	}

	public void setLuminosita(int luminosita) {
		if(luminosita > 0) {
			this.luminosita = luminosita;
		} else {
			System.out.println("Devi inserire un numero superiore a 0");
		}
	}

	@Override
	public void aumentaLuminosita() {
		luminosita++;
		
	}

	@Override
	public void diminuisciLuminosita() {
		luminosita--;
	}

	public void show() {
		String asterisco = "";
		for (int l = 0; l < luminosita; l++) {
			asterisco += "*";
		}
		System.out.println(getTitolo() + " " + asterisco);
	}
}
