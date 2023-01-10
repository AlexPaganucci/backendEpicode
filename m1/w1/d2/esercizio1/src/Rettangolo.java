/**
 * 
 */

/**
 * @author alexp
 *
 */
public class Rettangolo {
	double altezza;
	double larghezza;
	public Rettangolo(double altezza, double larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	public double calcolaArea() {
		return altezza * larghezza;
	}
	
	public double calcolaPerimetro() {
		return ((altezza*2)+(larghezza*2));
	}
}
