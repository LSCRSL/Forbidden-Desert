package controllers;

import models.Plateau;
import views.AfficheTour;
import views.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Explorer extends JButton {
    private models.Plateau p;
    private views.Views v;

    public Explorer(Plateau P, Views V) {
        super("Explorer");
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setBounds(0, 0, 100, 50);
        this.p = P;
        this.v = V;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setAction(2);
                //je pense qu'il faut mettre ca apres le clique mais pas d'accès au view depuis controle case
                //on peut garder ca mais faire attention à pas toucher à 2 boutons à la suite !
                //sinon le nbre d'action diminue alors qu'on a pas joué
                AfficheTour act = v.getAct();
                int a = p.getJoueur_i(p.getId_joueur_actuel()).getNb_action();
            }
        });

    }
}
