package it.epicode.esercizio1.application;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
	    Info info = new Info();
	    info.setNome("Mario");
	    info.setCognome("Rossi");
	    info.setDataDiNascita(new Date(85, 0, 1));
	    
	    UserData userData = new UserData();
	    DataSource adapter = new InfoAdapter(info);
	    userData.getData(adapter);
	    
	    System.out.println("Nome completo: " + info.getNome() + " " + info.getCognome());
	    System.out.println("Data di nascita: " + info.getDataDiNascita());
	    System.out.println("Età: " + adapter.getEta());

	}

}
