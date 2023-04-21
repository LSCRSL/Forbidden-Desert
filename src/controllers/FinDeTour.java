package controllers;

import javax.swing.*;
import models.Case;

import models.Joueur;
import views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinDeTour extends JButton {

    private models.Plateau p;
    private views.Views v;

    public boolean isDefaite(){
        for (Joueur j: p.getJoueurs()){ //mort par soif
            if (j.getNiv_eau()<=-1){
                return true;
            }
        }
        return this.p.getSablePlateau()>=43 || this.p.getNiv_tempete()>=7; //mort par ensablement ou tempête
    }

    public boolean isVictoire(){
        for (Joueur j: p.getJoueurs()){ //on verfifie que tous les joueurs se trouvent sur la piste de décollage
            if (j.getPos().getType()!=Case.TYPE.DECOLLAGE){
                return false;
            }
        }
        if (p.getPiecesRecup().size()>=4){ //on vérifie que les 4 pièces ont bien été récupérées
            return true;
        }
        return false;
    }

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
                AfficheCarteTempete carte=v.getCarteTempete();
                float nbCartesT=p.getNiv_tempete();
                //note a moi même : appeler la fct tirer de PaquetCartes
                //p.getPaquets.tirer(); (ça renvoie la carte) faire un switch ensuite
                for (int i=0; i<nbCartesT-0.5; i++) {
                    int n = (int) Math.floor(Math.random() * 3);//génère entier entre 0 et 2
                    if (n == 0) {
                        carte.setLabel("Le Vent souffle");
                        //à garder mais voir si on peut pas utiliser une apporche similaire au paquet de cartes
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
                        }
                    } else if (n == 1) {
                        carte.setLabel("La Tempête se déchaine");
                        p.dechainer();
                    } else {
                        carte.setLabel("Vague de Chaleur");
                        for (Joueur j : p.getJoueurs()) {
                            if (j.getPos().getType()!=Case.TYPE.TUNNEL || (j.getPos().getType()== Case.TYPE.TUNNEL && !j.getPos().isExploree())) {
                                j.boire();
                            }
                        }
                    }
                    AfficheFin fin= v.getFin();
                    if (isDefaite()) {
                        fin.setLabel("C'est perdu...", 0);
                        /*v.getAp().setVisible(false);*/
                    }
                    if (isVictoire()) {
                        fin.setLabel("C'est gagné!",1);

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
        AfficheSable sab =this.v.getSab();
        sab.setLabels(this.p.getSablePlateau());
        AfficheTour tour =this.v.getAct();
        AfficheJoueurs joueurs = this.v.getJoueurs();

        //tenter de faire ça pour le joueur qui joue
        for (Joueur j : this.p.getJoueurs()) {
            j.reset_action();
        }
        //petits bugs d'affichage
        int id = p.getId_joueur_actuel();
        p.getJoueur_i(id).setMon_tour(false);
        id = (id + 1)%p.getJoueurs().size();
        p.setId_joueur_actuel(id);
        p.getJoueur_i(id).setMon_tour(true);
        //AfficheTourJoueur tj = this.v.getT_joueur();
        //tj.setLabels(p.getJoueur_i(id));
        p.getJoueur_i(id).reset_action();
        p.setAction(4);
        tour.setLabels(p.getJoueur_i(id));
        joueurs.setLabels();

    }
}
