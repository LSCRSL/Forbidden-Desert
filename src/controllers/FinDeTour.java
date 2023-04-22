package controllers;

import javax.swing.*;

import models.Carte;
import models.Case;

import models.Joueur;
import views.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinDeTour extends JButton {

    private models.Plateau p;
    private views.Views v;


    public FinDeTour(models.Plateau plat, views.Views v) {
        super("Fin de tour");
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setBounds(0,0,180,50);
        this.p = plat;
        this.v = v;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AfficheCarteTempete carte= v.getCarteTempete();
                int nbCartesT = p.getNbCartesT();
                for (int i=0; i< nbCartesT; i++) {
                    Carte.Effet effet = p.getPaquets().tirer();
                    switch(effet){
                        case LE_VENT_SOUFFLE:
                            int f = 0;
                            int rdir = (int) Math.floor(Math.random() * 4);
                            int rfor = (int) Math.floor(Math.random() * 6);
                            if (rfor <= 2) {
                                f = 1;
                            } else if (rfor <= 4) {
                                f = 2;
                            } else {
                                f = 3;
                            }
                            if (rdir == 0) {
                                p.souffler(Case.Dir.HAUT, f);
                            } else if (rdir == 1) {
                                p.souffler(Case.Dir.BAS, f);
                            } else if (rdir == 2) {
                                p.souffler(Case.Dir.DROITE, f);
                            } else if (rdir == 3) {
                                p.souffler(Case.Dir.GAUCHE, f);
                            } break;
                        case LA_TEMPETE_SE_DECHAINE:
                            p.dechainer();
                            break;
                        case VAGUE_DE_CHALEUR:
                            for (Joueur j : p.getJoueurs()) {
                                if (j.getPos().getType()!=Case.TYPE.TUNNEL || (j.getPos().getType()== Case.TYPE.TUNNEL && !j.getPos().isExploree())) {
                                    j.boire();
                                }
                            }break;

                    }

                    //AfficheFin fin= v.getFin();
                    if (p.isDefaite()) {
                        affiche_fin(true);
                    }
                    if (p.isVictoire()) {
                        affiche_fin(false);
                    }
                }
                p.setAction(-1);
                refresh();
            }
        });

    }
    //NB : changer l'état de la case -> refresh change la couleur
    public void refresh(){

        p.affichePiece();//Ca beugue si je mets dans ControlCase... :/
        for (int i=0; i<p.getTaille();i++){
            for (int j=0; j<p.getTaille();j++){
                p.getCase(i,j).getCc().refresh();
            }
        }
        AfficheTempete temp = this.v.getNiv();
        temp.setLabel(this.p.getNiv_tempete());
        this.p.setNbCartesT();
        AfficheSable sab =this.v.getSab();
        sab.setLabels(this.p.getSablePlateau());
        AfficheTour tour =this.v.getAct();
        AfficheJoueurs joueurs = this.v.getJoueurs();

        //tenter de faire ça pour le joueur qui joue
        for (Joueur j : this.p.getJoueurs()) {
            j.reset_action();
        }
        int id = p.getId_joueur_actuel();
        p.getJoueur_i(id).setMon_tour(false);
        id = (id + 1)%p.getJoueurs().size();
        p.setId_joueur_actuel(id);
        p.getJoueur_i(id).setMon_tour(true);
        p.getJoueur_i(id).reset_action();
        p.setAction(4);
        tour.setLabels(p.getJoueur_i(id));
        joueurs.setLabels();

    }

    public void affiche_fin(boolean def) {
        JFrame end = new JFrame("Fin");
        end.setSize(400,400);
        end.setUndecorated(true);
        end.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        end.setLayout(null);
        end.pack();
        end.setSize(1920,1080);
        end.setLocationRelativeTo(null);
        end.setVisible(true);
        end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        v.getFdt().setVisible(false);
        v.getRamasser().setVisible(false);
        v.getCreuser().setVisible(false);
        v.getDeplacer().setVisible(false);
        v.getExplorer().setVisible(false);
        v.getDonner_eau().setVisible(false);
        v.getAction_spe().setVisible(false);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,200,200);
        JLabel texte;
        if(def) {
            panel.setBackground(Color.RED);
            texte = new JLabel("DEFAITE");
        }else {
            panel.setBackground(Color.GREEN);
            texte = new JLabel("VICTOIRE");
        }
        panel.add(texte);
        panel.setLocation(end.getWidth()/2 - 2*panel.getWidth(),end.getHeight()/2 - panel.getHeight());
        end.add(panel);

    }

}
