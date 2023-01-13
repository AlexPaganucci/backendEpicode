package progetto;

public abstract class Riproducibile extends ElementoMultimediale {
	public int durata;
	public int volume;

	
	public int getDurata() {
		return durata;
	}


	public void setDurata(int durata) {
		if(durata > 0) {
			this.durata = durata;
		} else {
			System.out.println("Devi inserire un numero superiore a 0");
		}
	}


	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) {
		if(volume > 0) {
			this.volume = volume;
		} else {
			System.out.println("Devi inserire un numero superiore a 0");
		}
	}
	
	public int abbassaVolume () {
		return volume--;
	}
	
	public int alzaVolume () {
		return volume++;
	}

	public void play() {
		for(int i = 0; i < durata; i++ ) {
			String esclamativo = "";
			for(int x = 0; x < volume; x++) {
				esclamativo += "!";
			}
			System.out.println(getTitolo() + " " + esclamativo);
		}
	}
}
