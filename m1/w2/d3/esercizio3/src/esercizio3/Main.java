package esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Main {

	private static final String ENCODING = "utf-8";
	
	public static void main(String[] args) {
		String fileName = "presenze.txt";
		File filePresenze = new File (fileName);
		
		Scanner in = new Scanner(System.in);
			System.out.println("Inserisci nome e cognome del dipendente");
			String d = in.nextLine();
			System.out.println("Inserisci le ore di presenza del dipendente");
			int o = Integer.parseInt(in.nextLine());
			RegistroPresenze p = new RegistroPresenze(d, o);	

			System.out.println("Inserisci nome e cognome del dipendente");
			String d1 = in.nextLine();
			System.out.println("Inserisci le ore di presenza del dipendente");
			int o1 = Integer.parseInt(in.nextLine());
			RegistroPresenze p1 = new RegistroPresenze(d1, o1);
			
			System.out.println("Inserisci nome e cognome del dipendente");
			String d2 = in.nextLine();
			System.out.println("Inserisci le ore di presenza del dipendente");
			int o2 = Integer.parseInt(in.nextLine());
			RegistroPresenze p2 = new RegistroPresenze(d2, o2);
			String a = p.nomeDipendente +"@"+ p.numeroPresenze + "#" + p1.nomeDipendente +"@"+ p1.numeroPresenze + "#" + p2.nomeDipendente +"@"+ p2.numeroPresenze;
			try {
				aggiungiAlFile(filePresenze, a);
			}catch(IOException e) {
				System.out.println("non riuscito");
			}

			try {
				leggiFile(filePresenze );
			} catch (IOException e) {
				System.out.println("non riuscito");
			}
				
			
		in.close();
	}
	
	public static void aggiungiAlFile(File f, String s) throws IOException {
		FileUtils.writeStringToFile(f, s, ENCODING);
	}

	public static void leggiFile(File file) throws IOException {
		System.out.println(FileUtils.readFileToString(file, ENCODING));
	}
}
