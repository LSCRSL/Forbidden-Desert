package controllers;

import models.Carte;
import models.Plateau;
import views.Views;

public class Launcher {

    public Launcher(){ }

    public void launch() {
        Plateau plateau = new Plateau(5);
        // A CHANGER IMPERATIVEMENT
        plateau.addJoueur(0,"J1", Carte.Personnage.ALPINISTE);
        plateau.addJoueur(1,"J2", Carte.Personnage.ARCHEOLOGUE);
        plateau.getJoueurs().get(0).setMon_tour(true);
        Views vue = new Views("ForbiddenDesert",plateau);
        vue.affiche();
    }
}
