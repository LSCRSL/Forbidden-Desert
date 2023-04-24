package controllers;

import models.Carte;
import models.Case;
import models.Joueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class DonnerEau extends JButton {
    private models.Plateau p;
    private views.Views v;

    public DonnerEau(models.Plateau plateau, views.Views vue){
        super("Donner eau");
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setBounds(0, 0, 100, 50);
        this.p = plateau;
        this.v = vue;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<Integer, Case> map = p.Porteuse();
                int id = map.keySet().stream().iterator().next();
                Set<Case> cases = p.Voisines(map.get(id));
                ArrayList<Joueur> voisins = new ArrayList<>();
                for (Case c : cases) {
                    Set<Joueur> J = c.getJ();
                    for (Joueur j : J) {
                        if (j.getPerso() != Carte.Personnage.PORTEUSE_D_EAU && j.getNiv_eau() < 5)
                            voisins.add(j);
                    }
                }
                int taille = voisins.size();
                if( taille > 0) {
                    Object[] choix = new Object[taille];
                    for (int i = 0; i < taille; i++) {
                        choix[i] = voisins.get(i).getName();
                    }
                    int c = JOptionPane.showOptionDialog(null,
                            "Joueur recevant l'eau ",
                            "Distribution d'eau",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, choix, choix[0]);
                    Joueur j = voisins.get(c);
                    j.setNiv_eau((j.getNiv_eau() + 1));
                    p.getJoueur_i(id).boire();
                    v.getJoueurs().setLabels();
                }

            }
        });
    }
}
