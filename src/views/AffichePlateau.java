package views;

import controllers.ControleCase;
import models.Plateau;

import javax.swing.*;
import java.awt.*;

public class AffichePlateau extends JPanel {

    private Plateau plateau;

    public AffichePlateau (Plateau p) {
        this.setLayout(new GridLayout(p.getTaille(), p.getTaille(), 2, 2));
        this.setSize(700,700);
        this.setBackground(new Color(220, 158, 0, 255));
        this.plateau = p;
        for (int i = 0; i < plateau.getTaille(); i ++) {
            for(int j = 0; j < plateau.getTaille(); j ++) {
                models.Case c = this.plateau.getCase(i,j);
                controllers.ControleCase cc = new ControleCase(c);
                this.add(cc);
                c.setCc(cc);
            }
        }
    }

    public Plateau getPlateau() {
        return plateau;
    }
}
