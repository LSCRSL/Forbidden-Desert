package controllers;

import javafx.scene.effect.SepiaTone;
import models.Carte;
import models.Joueur;
import models.Plateau;
import views.ChoixNbJoueurs;
import views.Views;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
        /** je tenterai de trier le set en fonction de l'id
        Set<Joueur>J = plateau.getJoueurs();
        plateau.setJoueurs();**/

        plateau.getJoueur_i(0).setMon_tour(true);
        Views vue = new Views("ForbiddenDesert",plateau);
        vue.affiche();
    }


}
