package controllers;

import javax.swing.*;
import models.Case;
import views.AfficheTempete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinDeTour extends JButton {

    private models.Plateau p;
    private views.Views v;

    public FinDeTour(models.Plateau p, views.Views v) {
        super("Fin de tour");
        this.p = p;
        this.v = v;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = (int) Math.random() * 2;
                //à enlever (juste pour voir)
                p.getCase(1,1).ensabler();
                /**
                if (n == 0) {
                    p.souffler(Case.Dir.HAUT, 1);
                } else {
                    p.dechainer();
                }**/
                p.dechainer();
                refresh(p);

            }
        });

    }
    //NB : changer l'état de la case -> refresh change la couleur
    public void refresh(models.Plateau p){
        for (int i=0; i<p.getTaille();i++){
            for (int j=0; j<p.getTaille();j++){
                Case c = p.getCase(i,j);

                c.getCc().refresh();
            }
        }
        AfficheTempete temp = this.v.getNiv();
        temp.setLabel(this.p.getNiv_tempete());
    }

}
