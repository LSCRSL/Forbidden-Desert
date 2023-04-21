package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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


    public void melanger(LinkedList<Carte.Effet> cartes){
        Collections.shuffle(cartes);
        Collections.shuffle(cartes);
        Collections.shuffle(cartes);
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
