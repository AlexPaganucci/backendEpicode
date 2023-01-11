
public class Esercizio1 {

	public static void main(String[] args) {
		System.out.println(stringaPariDispari("ciaooooo"));
		System.out.println(annoBisestile(2017));
		System.out.println(annoBisestile(2024));

	}

	public static Boolean stringaPariDispari(String stringa) {
		if (stringa.length()%2 == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean annoBisestile(int anno) {
		if(anno % 4 == 0 || anno % 100 == 0 && anno % 400 == 0){
			return true;
		}
		return false;
	}
	
}
