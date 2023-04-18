package views;

import controllers.ControleCase;
import models.Carte;
import models.Case;
import models.Joueur;
import models.Plateau;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class AffichePlateau extends JPanel {

    private Plateau plateau;
    private Views view;

    public AffichePlateau (Plateau p, Views view) {
        this.setLayout(new GridLayout(p.getTaille(), p.getTaille(), 1, 1));
        this.setSize(700,700);
        this.setBackground(new Color(0, 0, 0));
        this.plateau = p;
        this.view = view;
        //on ajoute les cases
        for (int i = 0; i < plateau.getTaille(); i ++) {
            for(int j = 0; j < plateau.getTaille(); j ++) {
                Case c = this.plateau.getCase(i,j);
                ControleCase cc = new ControleCase(c,this.plateau,this.view);
                this.add(cc);
                c.setCc(cc);
            }
        }
    }

    public Plateau getPlateau() {
        return plateau;
    }
}
