package views;

import controllers.ControleCase;
import models.Plateau;

import java.awt.*;

public class AffichePlateau extends IG.Grille {

    private Plateau plateau;

    public AffichePlateau (Plateau p) {
        super(p.getTaille(),p.getTaille());
        this.setSize(700,700);
        this.setBackground(new Color(238,130,238));
        this.plateau = p;
        for (int i = 0; i < plateau.getTaille(); i ++) {
            for(int j = 0; j < plateau.getTaille(); j ++) {
                models.Case c = this.plateau.getCase(i,j);
                controllers.ControleCase cc = new ControleCase(c);
                this.ajouteElement(cc);
            }
        }
    }
}
