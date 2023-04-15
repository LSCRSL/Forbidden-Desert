package controllers;

import models.Plateau;
import views.Views;

public class Launcher {

    public Launcher(){ }

    public void launch() {
        Plateau plateau = new Plateau(5);
        int[] o = plateau.getOeil();
        Views vue = new Views("ForbiddenDesert",plateau);
        vue.affiche();
    }
}
