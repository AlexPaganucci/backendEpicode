import java.util.Scanner;

public class Esercizio4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("inserisci un numero e io farò il conto alla rovescia");
		int num = scanner.nextInt();
		for(int i = num; i >= 0; i--) {
			System.out.println(i);
		}
		scanner.close();
	}

}
