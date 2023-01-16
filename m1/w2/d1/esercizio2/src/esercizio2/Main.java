package esercizio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int km;
		int litro;

		Scanner in = new Scanner(System.in);
		try {
			System.out.println("Digita i km percorsi");
			km = Integer.parseInt(in.nextLine());
			System.out.println("Digita i litri di carburante consumati");
			litro = Integer.parseInt(in.nextLine());
			calcConsumo(km, litro);
		} catch (NumberFormatException e) {
			System.out.println("Devi inserire dei numeri");
		}
		in.close();
	}

	private static void calcConsumo(int km, int litro) {
		try {
			int consumo = km / litro;
			System.out.println(consumo);
		}catch (ArithmeticException e) {
			System.out.println("Non puoi effettuare una divisione su 0");
		}
		
		
	}

}
