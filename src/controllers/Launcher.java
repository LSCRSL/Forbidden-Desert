package controllers;

import models.Carte;
import models.Plateau;
import views.ChoixNbJoueurs;
import views.Views;

import java.util.ArrayList;

public class Launcher {
    private ArrayList<String> names;

    public Launcher(){
        this.names = new ArrayList<String>();
        ChoixNbJoueurs choix = new ChoixNbJoueurs(this);

    }

    public void setNames(ArrayList<String> nom) {
        this.names = nom;
    }

    public void launch() {
        Plateau plateau = new Plateau(5);
        int k = 0;
        //attention aux yeux c'est très laid
        ArrayList<Carte.Personnage> perso = new ArrayList<>();
        perso.add(Carte.Personnage.ALPINISTE);
        perso.add(Carte.Personnage.EXPLORATEUR);
        perso.add(Carte.Personnage.PORTEUSE_D_EAU);
        perso.add(Carte.Personnage.NAVIGATRICE);
        perso.add( Carte.Personnage.METEOROLOGUE);
        perso.add(Carte.Personnage.ARCHEOLOGUE);
        for (String j : names)  {
            int n = (int) Math.floor(Math.random() * perso.size());
            plateau.addJoueur(k,j, perso.get(n));
            perso.remove(n);
            k++;
        }

        ArrayList<Carte.Effet> cartes = new ArrayList<>();
        for (int i = 0; i<4; i++) {
            cartes.add(Carte.Effet.VAGUE_DE_CHALEUR);
        }
        for (int j = 0; j<3; j++) {
            cartes.add(Carte.Effet.LA_TEMPETE_SE_DECHAINE);
        }
        for (int l = 0; l<24;l++){
            cartes.add(Carte.Effet.LE_VENT_SOUFFLE);
        }
        plateau.setPaquets(cartes);
        plateau.getJoueur_i(0).setMon_tour(true);

        Views vue = new Views(plateau);
        vue.affiche();
    }
}
