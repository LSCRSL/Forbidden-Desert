package controllers;

import models.Carte;
import models.Joueur;
import models.Plateau;
import views.Views;

public class Launcher {

    public Launcher(){ }

    public void launch() {
        Plateau plateau = new Plateau(5);
        // A CHANGER IMPERATIVEMENT
        plateau.addJoueur(0,"Lisa", Carte.Personnage.ALPINISTE);
        plateau.addJoueur(1,"Clement", Carte.Personnage.EXPLORATEUR);
        plateau.addJoueur(2,"Asterix", Carte.Personnage.PORTEUSE_D_EAU);
        plateau.addJoueur(3,"Obelix", Carte.Personnage.NAVIGATRICE);
        //plateau.addJoueur(4,"Yoshi", Carte.Personnage.ALPINISTE);
        plateau.getJoueur_i(0).setMon_tour(true);
        Views vue = new Views("ForbiddenDesert",plateau);
        vue.affiche();
    }
}
