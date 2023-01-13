package progetto;

public class Video extends Riproducibile implements Luminosita {
	int luminosita;

	public Video() {
	}

	public int getLuminosita() {
		return luminosita;
	}

	public void setLuminosita(int luminosita) {
		if (luminosita > 0) {
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

	@Override
	public void play() {
		for (int i = 0; i < durata; i++) {
			String esclamativo = "";
			for (int x = 0; x < volume; x++) {
				esclamativo += "!";
			}
			String asterisco = "";
			for (int l = 0; l < luminosita; l++) {
				asterisco += "*";
			}
			System.out.println(getTitolo() + " " + esclamativo + " " + asterisco);
		}
	}
}
