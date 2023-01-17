package esercizio3;

import java.util.HashMap;

public class Main {
	
	static HashMap<String, String> listaContatti = new HashMap<>();
	public static void main(String[] args) {
		inserisciCoppia("anna", "3332656987");
		inserisciCoppia("Marco", "3332656977");
		inserisciCoppia("Franco", "3112656977");
		inserisciCoppia("Giuseppe", "3222656977");
		eliminaCoppia("anna");
		cercaPersona("3112656977");
		cercaNumero("Giuseppe");
		System.out.println(listaContatti);
	}

	public static void inserisciCoppia(String nome, String valore) {
		listaContatti.put(nome, valore);
	}
	
	public static void eliminaCoppia(String nome){
		listaContatti.remove(nome);
	}
	
	public static void cercaPersona(String valore) {
		for(HashMap.Entry mEntry : listaContatti.entrySet()){
			if(mEntry.getValue().equals(valore)) {
				System.out.println(mEntry.getKey());
			}
		}
	}
	
	public static void cercaNumero(String nome) {
        System.out.println(listaContatti.get(nome));
    }
}
