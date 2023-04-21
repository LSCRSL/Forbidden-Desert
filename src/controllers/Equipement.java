package controllers;

import models.Carte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Equipement extends JButton { //pour le moment pas terminé, d'abord faire les roles et si volonte faire ça

    private models.Plateau p;

    public Equipement(models.Plateau plateau){
        super("Equipement");
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setBounds(0,0,180,50);
        this.p = plateau;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Carte.Equipement> c = p.getJoueur_i(p.getId_joueur_actuel()).getEquipement();
                Set<Carte.Equipement> s = new HashSet<Carte.Equipement>(c);
                Carte.Equipement[] choix = new Carte.Equipement[s.size()];
                //Object[] choix = new Object[](s);

            }
        });




    }
}
