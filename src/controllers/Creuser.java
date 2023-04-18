package controllers;

import models.Plateau;
import views.AfficheTour;
import views.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Creuser extends JButton {
    private models.Plateau p;
    private views.Views v;

    public Creuser(Plateau P, Views V) {
        super("Creuser");
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setBounds(0,0,100,50);
        this.p = P;
        this.v = V;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setAction(1);
                AfficheTour act =v.getAct();
                int a = p.getJoueur_i(p.getId_joueur_actuel()).getNb_action();

            }
        });


    }
}
