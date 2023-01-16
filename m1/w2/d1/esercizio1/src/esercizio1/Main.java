package esercizio1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int[] num = new int[5];
		double num1 = Math.random()*10;
		num[0] = (int)num1;
		double num2 = Math.random()*10;
		num[1] = (int)num2;
		double num3 = Math.random()*10;
		num[2] = (int)num3;
		double num4 = Math.random()*10;
		num[3] = (int)num4;
		double num5 = Math.random()*10;
		num[4] = (int)num5;
		
		System.out.println(Arrays.toString(num));
		
		int n;
		
		Scanner in = new Scanner(System.in);
			do {
				System.out.println("scrivi un numero da aggiungere all'array digita 0 per uscire");
				n = Integer.parseInt(in.nextLine());
				if(n == 0) {
					in.close();
				} else {
					try {
						System.out.println("scrivi la posizione in cui aggiungerlo tra 1 e 5");
						int p = Integer.parseInt(in.nextLine());
						num[p-1] = n;
					} catch (ArrayIndexOutOfBoundsException e){
						System.out.println("il numero inserito è errato!");
					}
				}
			} while (n != 0);

		in.close();

		System.out.println(Arrays.toString(num));
		
	}

}
