package esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Somma extends Thread {
    
    List<Integer> array;
    int inizio;
    int fine;
    int sommaParziale;
    
    public Somma(List<Integer> array, int inizio, int fine) {
        this.array= array;
        this.inizio = inizio;
        this.fine= fine;
    }
    
    @Override
    public void run() {
        for(int i = inizio; i<fine; i++) {
            sommaParziale += array.get(i);
        }
        System.out.println("somma parziale: " + sommaParziale);
    }
    public int getSomma() {
        return sommaParziale;
    }
    
}


public class Main {
    
    public static void main(String[] args) {

        List<Integer> array = new ArrayList<>();
        
        
        Random random = new Random();
        
        for(int i = 0; i<3000; i++) {
            array.add(random.nextInt());
        }
        
        Somma parte1 = new Somma(array, 0 , 1000);
        Somma parte2 = new Somma(array, 1000 , 2000);
        Somma parte3 = new Somma(array, 2000 ,3000);
    
        parte1.start();        
        parte2.start();        
        parte3.start();        
        
        try {
            parte1.join();    
            parte2.join();    
            parte3.join();    
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        int sommaTotale = parte1.getSomma() + parte2.getSomma() + parte3.getSomma();
        System.out.println("somma totale: " + sommaTotale);
    }
}