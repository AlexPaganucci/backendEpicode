import java.util.Scanner;

public class Esercizio3 {
	
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Inserisci una stringa (:q per uscire): ");
            String stringa = scanner.nextLine();

            if (stringa.equals(":q")) {
                break;
            }

            String[] caratteri = stringa.split("");
            String caratteriVirgole = String.join(",", caratteri);
            System.out.println(caratteriVirgole);
        }

		scanner.close();

	}
}
