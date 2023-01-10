/**
 * 
 */

/**
 * @author alexp
 *
 */
public class Esercizio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rettangolo r1 = new Rettangolo(10, 20);
		Rettangolo r2 = new Rettangolo(5,15);
		stampaRettangolo(r1);
		stampaRettangolo(r2);
		stampaDueRettangoli(r1, r2);
	}
	
	public static void stampaRettangolo(Rettangolo r) {
		System.out.println("Perimetro rettangolo: " + r.calcolaPerimetro());
		System.out.println("Area rettangolo: " + r.calcolaArea());
	}
	
	public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
		stampaRettangolo(r1);
		stampaRettangolo(r2);
		
		double aree = r1.calcolaArea() + r2.calcolaArea();
		double perimetri = r1.calcolaPerimetro() + r2.calcolaPerimetro();
		
		System.out.println(aree);
		System.out.println(perimetri);
	}

}
