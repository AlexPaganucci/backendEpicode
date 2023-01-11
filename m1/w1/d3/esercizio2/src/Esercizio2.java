import java.util.Scanner;

public class Esercizio2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Scrivi un numero");
		int num = scanner.nextInt();
		String numStringa;
		switch(num) {
			case 0:
				numStringa="zero";
				break;
			case 1:
				numStringa="uno";
				break;
			case 2:
				numStringa="due";
				break;
			case 3:
				numStringa="tre";
				break;
			default:
				numStringa="numero inserito errato";
		}
		System.out.println(numStringa);
		
		scanner.close();

	}
	
	

}
