package it.epicode.esercizio1.application;

import java.util.Calendar;

public class InfoAdapter implements DataSource{

	 private Info info;
	    
	    public InfoAdapter(Info info) {
	        this.info = info;
	    }

	    public String getNomeCompleto() {
	        return info.getNome() + " " + info.getCognome();
	    }

	    public int getEta() {
	        Calendar dob = Calendar.getInstance();
	        dob.setTime(info.getDataDiNascita());
	        Calendar now = Calendar.getInstance();
	        int age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
	        if (now.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
	            age--;
	        }
	        return age;
	    }
}
