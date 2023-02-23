package it.epicode.esercizio1.application;

public class UserData{
	
	private String nomeCompleto;
	private int eta;
	
	
	 public void getData(DataSource ds) { 
		 nomeCompleto = ds.getNomeCompleto(); 
		 eta = ds.getEta(); 
		 }

}
