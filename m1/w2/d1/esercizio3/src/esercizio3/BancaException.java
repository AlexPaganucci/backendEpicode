package esercizio3;


public class BancaException extends Exception {

	private String message;
	
	public BancaException (String message) {
		this.message = message;
	}
	
	
	@Override
	public String toString() {
		return message;
	}
}
