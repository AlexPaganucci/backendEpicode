package esercizio2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	static List<Integer> lista = new ArrayList<>();

	public static void main(String[] args) {
		creaLista(15);
		System.out.println(lista);
		System.out.println(CreaListaRovesciata(lista));
		pariDispari(lista, true);

	}

	public static List<Integer> creaLista(int n) {
		for (int i = 0; i < n; i++) {
			int n1 = (int) (Math.random() * 100);
			lista.add(n1);
		}
		return lista;
	}

	public static List<Integer> CreaListaRovesciata(List<Integer> lista2) {

		List<Integer> listaRovesciata = new ArrayList<Integer>();
		for (int i = lista2.size() - 1; i >= 0; i--) {

			listaRovesciata.add(lista2.get(i));
		}

		return listaRovesciata;
	}

	public static void pariDispari(List lista, boolean x) {

		for (int i = 0; i < lista.size(); i++) {
			if (x == true) {
				if (i % 2 == 0) {
					System.out.println(lista.get(i));
				}
			} else if (i % 2 != 0) {
				System.out.println(lista.get(i));
			}
		}

	}
}
