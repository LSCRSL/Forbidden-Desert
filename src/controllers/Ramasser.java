package controllers;

import models.Plateau;
import views.AfficheActions;
import views.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ramasser extends JButton{
    private models.Plateau p;
    private views.Views v;

    public Ramasser(Plateau P, Views V) {
        super("Ramasser");
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setBounds(0, 0, 100, 50);
        this.p = P;
        this.v = V;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AfficheActions act = v.getAct();
                act.setLabels(p.getJoueurs().get(p.getId_joueur_actuel()).getNb_action());

            }
        });

    }

}
