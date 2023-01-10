import java.util.Scanner;

/**
 * 
 */

/**
 * @author alexp
 *
 */
public class esercizio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci base del rettangolo");
		double base = scanner.nextDouble();
		System.out.println("inserisci altezza del rettangolo");
		double altezza = scanner.nextDouble();
		System.out.println(perimetroRettangolo(base, altezza));
		
		System.out.println("inserisci un numero se esce 0 è pari se esce 1 è dispari");
		int num = scanner.nextInt();
		System.out.println(pariDispari(num));

		System.out.println("inserisci base del triangolo");
		double baseTriangolo = scanner.nextDouble();
		System.out.println("inserisci altezza del triangolo");
		double altezzaTriangolo = scanner.nextDouble();
		System.out.println(perimetroTriangolo(baseTriangolo, altezzaTriangolo));
		
		scanner.close();

	}
	
	public static double perimetroRettangolo(double base, double altezza) {
		return base * altezza;
	}
	
	public static int pariDispari(int num) {
		if((num % 2)== 0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public static double perimetroTriangolo(double baseTriangolo, double altezzaTriangolo) {
		return baseTriangolo * altezzaTriangolo /2;
	}

}
