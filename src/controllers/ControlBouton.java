package controllers;

import models.Case;
import models.Plateau;
import views.Views;

import javax.swing.*;
import java.awt.*;

public class ControlBouton extends IG.ZoneCliquable{
    private JButton bouton;
    private models.Plateau p;

    public ControlBouton(String texte, int x, int y) {
        super(texte, x, y);
    }

    boolean isDefaite(models.Plateau p){
        return p.getSablePlateau()>=43 || p.getNiv_tempete()>=7;
    }
    @Override
    public void clicGauche(){
        this.p.dechainer();
        if (isDefaite(this.p)){
            System.out.print("fin");
        }else{
            System.out.print("Not Yet");
        }
    }


    @Override
    public void clicDroit() {
        this.p.souffler(Case.Dir.HAUT,3);
        this.p.souffler(Case.Dir.BAS,3);
        this.p.souffler(Case.Dir.DROITE,3);
        this.p.souffler(Case.Dir.GAUCHE,3);
        if (isDefaite(this.p)){
            System.out.print("fin");
        }else{
            System.out.print("Not Yet");
        }

    }
}

