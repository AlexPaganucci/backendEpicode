package progetto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class Main {

	private static final String ENCODING = "utf-8";
	static String fileNameLibri = "libri.txt";
	static String fileNameRiviste = "riviste.txt";
	static File fileLibri = new File(fileNameLibri);
	static File fileRiviste = new File(fileNameRiviste);
	
	//istanzio degli autori dentro un ArrayList
	static List<Autore> autori = new ArrayList<>(
			Arrays.asList(
					new Autore("Mario Rossi"),
					new Autore("Anna Neri"),
					new Autore("Luigi Verdi"),
					new Autore("Bianca Bianchi"),
					new Autore("Gianni Gialli")
					)
			);
	
	//istanzio dei libri dentro un ArrayList
	static List<Libro> archivioLibri = new ArrayList<>(
			Arrays.asList(
				new Libro("Harry Potter", 2006, 350, autori.get(0), Genere.AVVENTURA),
				new Libro("Il signore degli anelli", 2003, 500, autori.get(1), Genere.BIOGRAFICO),
				new Libro("Il ritratto di Dorian Gray", 1920, 300, autori.get(2), Genere.ROMANTICO),
				new Libro("La divina commedia", 1400, 550, autori.get(3), Genere.HORROR),
				new Libro("I promessi sposi", 1550, 420, autori.get(4), Genere.THRILLER)
					)
			);
	
	//istanzio delle riviste dentro un ArrayList
	static List<Rivista> archivioRiviste = new ArrayList<>(
			Arrays.asList(
					new Rivista("Playboy", 2001, 100, Periodicita.SEMESTRALE),
					new Rivista("Quattroruote", 2021, 60, Periodicita.MENSILE),
					new Rivista("Focus", 2012, 120, Periodicita.SETTIMANALE),
					new Rivista("MensHealt", 2005, 80, Periodicita.SEMESTRALE),
					new Rivista("view", 2015, 210, Periodicita.MENSILE),
					new Rivista("Vogue", 2000, 180, Periodicita.SETTIMANALE)
					)
			);
	
	public static void main(String[] args) {
		//Scrivo dentro il file libri.txt tutto l'arrayList archivioLibri
		try {
			scriviArchivioLibri(archivioLibri);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Scrivo dentro il file riviste.txt tutto l'arrayList archivioRiviste
		try {
			scriviArchivioRiviste(archivioRiviste);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Leggo entrambi i file libri.txt e riviste.txt e le stampo in console
		try {
			leggiArchivio(fileLibri);
			leggiArchivio(fileRiviste);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ricercaLibro(archivioLibri.get(2).getCodiceISBN());
		ricercaLibro(archivioLibri.get(3).getAnnoPubblicazione());
		ricercaLibro(archivioLibri.get(1).getAutore());
		rimuoviLibro(archivioLibri.get(0).getCodiceISBN());
		ricercaLibro(archivioLibri.get(1).getAutore());
		
		//istanzio uno scanner per aggiungere un libro all'archivioLibri
		Scanner in = new Scanner(System.in);
		System.out.println("Per aggiungere un libro all'archivio digita il titolo!");
		String t1 = in.nextLine();
		System.out.println("anno di pubblicazione!");
		int anno = 0;
		try {
			anno = Integer.parseInt(in.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Non hai scritto un numero");
			in.close();
		}
		System.out.println("il numero delle pagine!");
		int nPagine = 0;
		try {
			nPagine = Integer.parseInt(in.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Non hai scritto un numero");
			in.close();
		}
		System.out.println("Digita il nome dell'autore");
		String a1 = in.nextLine();
		autori.add(new Autore(a1));
		System.out.println("Inserisci il genere del libro (digita 1 per HORROR, "
				+ "2 per THRILLER, 3 per ROMANTICO, 4 per BIOGRAFICO o "
				+ "5 per AVVENTURA");
		int g = Integer.parseInt(in.nextLine());
		Genere gen = Genere.AVVENTURA;
		try {
			switch(g) {
			case 1:
				gen = Genere.HORROR;
				break;
			case 2:
				gen = Genere.THRILLER;
				break;
			case 3:
				gen = Genere.ROMANTICO;
				break;
			case 4:
				gen = Genere.BIOGRAFICO;
				break;
			case 5:
				gen = Genere.AVVENTURA;
				break;
				default:
					System.out.println("Non hai inserito un numero corretto");
					in.close();
			}
		} catch (NumberFormatException e) {
			System.out.println("Devi inserire un numero");
			in.close();
		}
		archivioLibri.add(new Libro(t1, anno, nPagine, autori.get(5), gen));
		System.out.println(archivioLibri.toString());
		//Scrivo dentro il file libri.txt tutto l'arrayList archivioLibri
				try {
					scriviArchivioLibri(archivioLibri);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					leggiArchivio(fileLibri);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		in.close();


	}
	
	//Rimozione di un libro
	public static void rimuoviLibro(String codice) {
		archivioLibri.removeIf(l -> l.codiceISBN == codice);
	}

	//Ricerca di un libro tramite codiceISBN
	public static void ricercaLibro(String codice) {
		List<Libro> listaLibri = archivioLibri.stream().filter(l -> l.codiceISBN == codice)
			.collect(Collectors.toList());
		System.out.println(listaLibri);	
	}
	
	//Ricerca di un libro tramite anno di pubblicazione
	public static void ricercaLibro(int anno) {
		List<Libro> listaLibri = archivioLibri.stream().filter(l -> l.annoPubblicazione == anno)
				.collect(Collectors.toList());
		System.out.println(listaLibri);	
	}
	
	//Ricerca di un libro tramite autore
	public static void ricercaLibro(Autore autore) {
		List<Libro> listaLibri = archivioLibri.stream().filter(l -> l.autore == autore)
				.collect(Collectors.toList());
		System.out.println(listaLibri);	
	}

	//Ricerca di un libro tramite codiceISBN metodo alternativo
	
	/*public static void ricercaLibro(String codice) {;
		for (Libro libro : archivioLibri) {
			if (libro.codiceISBN == codice) {
				System.out.println(libro);
			}
		}
	}*/
	
	//Ricerca di un libro tramite anno di pubblicazione metodo alternativo
	
	/*public static void ricercaLibro(int anno) {
		for (Libro libro : archivioLibri) {
			if (libro.annoPubblicazione == anno) {
				System.out.println(libro);
			}
		}
	}*/
	
	//Ricerca di un libro tramite autore metodo alternativo
	/*public static void ricercaLibro(Autore autore) {
		for (Libro libro : archivioLibri) {
			if (libro.autore == autore) {
				System.out.println(libro);
			}
		}
	}*/
	
	//Metodo per scrivere all'interno del file libri.txt
	public static void scriviArchivioLibri(List<Libro> archivioLibri) throws IOException{
		StringBuilder scriviNelFile = new StringBuilder("");
		for (int i = 0; i < archivioLibri.size(); i++) {
			scriviNelFile.append(archivioLibri.get(i).toString() + System.lineSeparator());
		}
		String str = scriviNelFile.toString();
		FileUtils.writeStringToFile(fileLibri, str, ENCODING);
	}
	
	//Metodo per scrivere all'interno del file riviste.txt
	public static void scriviArchivioRiviste(List<Rivista> archivioRiviste) throws IOException{
		StringBuilder scriviNelFile = new StringBuilder("");
		for (int i = 0; i < archivioRiviste.size(); i++) {
			scriviNelFile.append(archivioRiviste.get(i).toString() + System.lineSeparator());
		}
		String str = scriviNelFile.toString();
		FileUtils.writeStringToFile(fileRiviste, str, ENCODING);
	}
	
	//Metodo per leggere i file libri.txt o riviste.txt
	public static void leggiArchivio(File file) throws IOException{
		System.out.println(FileUtils.readFileToString(file, ENCODING));
	}
}
