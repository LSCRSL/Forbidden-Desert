package controllers;

import views.AfficheTour;
import views.Views;

import models.Joueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeDeplacer extends JButton {
    private models.Plateau p;
    private views.Views v;

    public SeDeplacer(models.Plateau P, Views V){
        super("Se Déplacer");
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setBounds(0,0,100,50);
        this.p = P;
        this.v = V;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //decrémenter dans un premier temps le nbre d'action
                p.setAction(0);
                AfficheTour act =v.getAct();
                int a = p.getJoueur_i(p.getId_joueur_actuel()).getNb_action();
            }
        });
    }
}
