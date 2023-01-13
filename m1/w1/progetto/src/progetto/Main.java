package progetto;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Immagine i1 = new Immagine();
		Audio a1 = new Audio();
		Video v1 = new Video();
		Immagine i2 = new Immagine();
		Audio a2 = new Audio();
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digita il titolo dell'immagine");
		String titolo1 = scanner.next();
		i1.setTitolo(titolo1);
		System.out.println("Digita un numero per impostare la luminosità dell'immagine");
		int luminosita1 = scanner.nextInt();
		i1.setLuminosita(luminosita1);
		System.out.println("Digita il titolo dell'audio");
		String titolo2 = scanner.next();
		a1.setTitolo(titolo2);
		System.out.println("Digita un numero per impostare il volume dell'audio");
		int volume1 = scanner.nextInt();
		a1.setVolume(volume1);
		System.out.println("Digita la durata dell'audio");
		int durata1 = scanner.nextInt();
		a1.setDurata(durata1);
		System.out.println("Digita il titolo del video");
		String titolo3 = scanner.next();
		v1.setTitolo(titolo3);
		System.out.println("Digita un numero per impostare il volume del video");
		int volume2 = scanner.nextInt();
		System.out.println("Digita un numero per impostare la luminosità del video");
		int luminosita2 = scanner.nextInt();
		System.out.println("Digita la durata del video");
		int durata2 = scanner.nextInt();
		v1.setLuminosita(luminosita2);
		v1.setVolume(volume2);
		v1.setDurata(durata2);
		System.out.println("Digita il titolo dell'immagine");
		String titolo4 = scanner.next();
		i2.setTitolo(titolo4);
		System.out.println("Digita un numero per impostare la luminosità dell'immagine");
		int luminosita3 = scanner.nextInt();
		i2.setLuminosita(luminosita3);
		System.out.println("Digita il titolo del audio");
		String titolo5 = scanner.next();
		a2.setTitolo(titolo5);
		System.out.println("Digita un numero per impostare il volume dell'audio");
		int volume3 = scanner.nextInt();
		a2.setVolume(volume3);
		System.out.println("Digita la durata dell'audio");
		int durata3 = scanner.nextInt();
		a2.setDurata(durata3);
		
		int avvia;
		do {
			System.out.println("Digita un numero tra 1 e 5 per avviare il lettore multimediale, altrimenti digita 0 per spegnere il lettore.");
			avvia = scanner.nextInt();
			switch(avvia) {
			case 0:
				scanner.close();
				break;
			case 1:
				i1.show();
				break;
			case 2:
				a1.play();
				break;
			case 3:
				v1.play();
				break;
			case 4:
				i2.show();
				break;
			case 5:
				a2.play();
				break;
				default:
					System.out.println("Hai sbagliato a digitare il numero");
			}
		} while (avvia != 0);
	}
}
