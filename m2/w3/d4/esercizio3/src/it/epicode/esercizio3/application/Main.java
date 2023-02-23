package it.epicode.esercizio3.application;

public class Main {

	public static void main(String[] args) {
	        
        Officer captain = new Captain();
        Officer major = new Major();
        Officer lieutenant = new Lieutenant();
        Officer colonel = new Colonel();
        Officer general = new General();
        
        captain.setSuperior(major);
        major.setSuperior(lieutenant);
        lieutenant.setSuperior(colonel);
        colonel.setSuperior(general);
        
        int amount = 2500;
        captain.handleRequest(amount);
	}

}
