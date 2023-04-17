package controllers;

import javax.swing.*;
import models.Case;

import models.Joueur;
import views.AfficheActions;
import views.AfficheSable;
import views.AfficheTempete;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FinDeTour extends JButton {

    private models.Plateau p;
    private views.Views v;

    public boolean isDefaite(){
        return this.p.getSablePlateau()>=43 || this.p.getNiv_tempete()>=7;
    }

    public FinDeTour(models.Plateau plat, views.Views v) {
        super("Fin de tour");
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setBounds(0,0,100,50);
        this.p = plat;
        this.v = v;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = (int) Math.floor(Math.random() * 3 );//génère entier entre 0 et 2
                if (n == 0) {
                    int f=0;
                    int rdir = (int) Math.floor(Math.random() * 4 );
                    int rfor = (int) Math.floor(Math.random() * 6 );
                    if (rfor<=2){
                        f=1;
                    }else if(rfor<=4){
                        f=2;
                    }else{
                        f=3;
                    }
                    if (rdir==0){
                        p.souffler(Case.Dir.HAUT, f);
                    }else if (rdir==1){
                        p.souffler(Case.Dir.BAS, f);
                    }else if (rdir==2){
                        p.souffler(Case.Dir.DROITE, f);
                    }else if (rdir==3){
                        p.souffler(Case.Dir.GAUCHE, f);
                    }
                } else if (n==1) {
                    //le sable n'augmente pas, à faire
                    p.dechainer();
                } else{
                    //Vague de chaleur, à implémenter quand on aura les joueurs
                }
                if (isDefaite()){
                    System.out.print("PERDU\n");
                }
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
        AfficheActions act =this.v.getAct();
        act.setLabels(4);
        //tenter de faire ça pour le joueur qui joue
        for (Joueur j : this.p.getJoueurs()) {
            j.reset_action();
        }
        //petits bugs d'affichage
        int id = p.getId_joueur_actuel();
        System.out.println(id);
        p.getJoueurs().get(id).setMon_tour(false);
        id = (id + 1)%p.getJoueurs().size();
        p.setId_joueur_actuel(id);
        p.getJoueurs().get(id).setMon_tour(true);

    }
}
