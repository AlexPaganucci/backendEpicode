package esercizio1;

public class Main extends Thread {

	String simbolo;
	
	public Main(String simbolo) {
		this.simbolo = simbolo;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(simbolo);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Main s1 = new Main("*");
		Main s2 = new Main("#");
		
		s1.start();
		s2.start();

	}

}
