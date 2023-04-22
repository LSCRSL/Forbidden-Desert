package controllers;

import models.Carte;
import models.Case;
import models.Joueur;
import models.Plateau;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class ActionsSpeciales extends JButton {
    private Plateau plateau;

    public ActionsSpeciales(models.Plateau p){
        super("Actions");
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setBounds(0, 0, 100, 50);
        this.plateau = p;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Joueur joueur = plateau.getJoueur_i(plateau.getId_joueur_actuel());
                if (joueur.getPerso() == Carte.Personnage.METEOROLOGUE) {
                    Object[] choix = {"enlever", "regarder"};
                    int c = JOptionPane.showOptionDialog(null,
                            "Choisissez une action :",
                            "Action spéciale",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);
                    switch (c) {
                        case 0:
                            plateau.NbCartesT();
                            joueur.decremente_action();
                            break;
                        case 1:
                            Object[] choix2 = {"Mettre sous la pile", "Ne rien faire"};
                            int a = JOptionPane.showOptionDialog(null,
                                    plateau.getPaquets().getPaquet().getFirst().toString(),
                                    "Carte pioche",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null, choix2, choix2[0]);
                            if (a == 0) {
                                plateau.getPaquets().mettreSousPioche();
                            }
                            joueur.decremente_action();
                    }

                }
                if (joueur.getPerso() == Carte.Personnage.NAVIGATRICE) {
                    Set<Joueur> J = plateau.getJoueurs();
                    ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
                    for (Joueur j : J) {
                        if (j.getPerso() != Carte.Personnage.NAVIGATRICE){
                            joueurs.add(j);
                        }
                    }
                    int taille = joueurs.size();
                    Object[] choix = new Object[taille];
                    for (int i = 0; i<taille; i++) {
                        choix[i] = joueurs.get(i).getName();
                    }
                    int c = JOptionPane.showOptionDialog(null,
                            "Joueur a déplacer ",
                            "Déplacement",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, choix, choix[0]);
                    Joueur j = joueurs.get(c);
                    switch (j.getPerso()){

                    }
                }
                if(joueur.getPerso() == Carte.Personnage.ALPINISTE){
                    int c = JOptionPane.showConfirmDialog(null,
                            "Voulez-vous ammener quelqu'un avec vous ?",
                            "Déplacement supplémentaire",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (c == JOptionPane.YES_OPTION){
                        Set<Joueur> J = plateau.getJoueurs();
                        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
                        for (Joueur j : J) {
                            if (j.getPerso() != Carte.Personnage.ALPINISTE){
                                joueurs.add(j);
                            }
                        }
                        int taille = joueurs.size();
                        Object[] choix = new Object[taille];
                        for (int i = 0; i<taille; i++) {
                            choix[i] = joueurs.get(i).getName();
                        }
                        int r = JOptionPane.showOptionDialog(null,
                                "Joueur a déplacer ",
                                "Déplacement",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null, choix, choix[0]);
                        Joueur j = joueurs.get(r);
                        ControleCase cc = j.getPos().getCc();
                        Case cas = plateau.getJoueur_i(plateau.getId_joueur_actuel()).getPos();
                        j.deplaceC(cas);
                        j.decremente_action();
                        cc.refresh();

                    }

                }

            }
            });

    }


}
