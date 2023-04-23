package models;

import java.util.ArrayList;
import java.util.LinkedList;

public class PaquetCartes {
    private LinkedList<Carte.Effet> paquet;
    private LinkedList<Carte.Effet> defausse;


    public PaquetCartes(){
        this.paquet = new LinkedList<>();
        this.defausse = new LinkedList<>();
    }
    public PaquetCartes(ArrayList<Carte.Effet> cartes){
        this.paquet = new LinkedList<>();
        this.defausse = new LinkedList<>();
        for (Carte.Effet card : cartes){
            this.paquet.add(card);
        }
    }

    public LinkedList<Carte.Effet> getPaquet() {
        return paquet;
    }

    public LinkedList<Carte.Effet> getDefausse() {
        return defausse;
    }

    public void melanger(LinkedList<Carte.Effet> cartes) {

        int taille = cartes.size();
        Object[] cards = new Object[taille];
        for (int i = 0; i < taille; i++) {
            cards[i] = cartes.getFirst();
            cartes.removeFirst();
        }
        for (int j = 0; j < 200; j++) {
            int a = (int) Math.floor(Math.random() * taille);
            int b = (int) Math.floor(Math.random() * taille);
            Object obj = cards[a];
            cards[a] = cards[b];
            cards[b] = obj;
        }
        for (int k = 0; k < taille; k++) {
            cartes.addFirst((Carte.Effet) cards[k]);
        }
    }

    public void mettreSousPioche(){
        Carte.Effet c = this.paquet.getFirst();
        this.paquet.removeFirst();
        this.paquet.addLast(c);
    }



    public Carte.Effet tirer(){
        if (this.paquet.size() == 0){
            melanger(this.defausse);
            this.paquet =this.defausse;
            this.defausse = new LinkedList<>();
            return tirer();
        }else {
            Carte.Effet c = this.paquet.getFirst();
            this.paquet.removeFirst();
            this.defausse.add(c);
            return c;
        }
    }


}
