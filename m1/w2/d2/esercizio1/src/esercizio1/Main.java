package esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static Set<String> parole = new HashSet<>();
	static Set<String> paroleDuplicate = new HashSet<>();
	static int n;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Inserisci un numero che indica il numero di elementi da inserire");
			n = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e ){
			System.out.println("Hai sbagliato devi inserire un numero!");
		}
		for(int i = 0; i < n; i++) {
			System.out.println("Inserisci una parola");
			String p1 = scanner.nextLine();
			if(parole.contains(p1)) {
				paroleDuplicate.add(p1);
			}
			parole.add(p1);
		}

		System.out.println(paroleDuplicate);
		System.out.println(parole);
		System.out.println(parole.size());
		
		scanner.close();
	}

}
