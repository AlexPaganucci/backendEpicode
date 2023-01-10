/**
 * 
 */

/**
 * @author alexp
 *
 */
public class esercizio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = new String[5];
		a[0] = "primo";
		a[1] = "secondo";
		a[2] = "terzo";
		a[3] = "quarto";
		a[4] = "quinto";
		

			System.out.println(moltiplica());
			System.out.println(concatena());
			System.out.println(inserisciInArray(a, "sesto"));
			
			}

	

public static int moltiplica() {
	int a = 5;
	int b = 5;
	return a*b;
	}

public static String concatena() {
	String a = "ciaooo";
	int b = 5;
	return a + " " + b;
	}

public static String inserisciInArray(String[] a, String b) {
	String[] c = new String[6];
	c[0] = a[0];
	c[1] = a[1];
	c[2] = a[2];
	c[3] = b;
	c[4] = a[3];
	c[5] = a[4];
	return java.util.Arrays.toString(c);
	
	}

}
