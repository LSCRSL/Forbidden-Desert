package controllers;

import models.Case;

import java.awt.*;

public class ControleCase extends IG.ZoneCliquable {

    private models.Case c;

    private models.Plateau p;

    public ControleCase(models.Case c) {
        super("",100,100);
        int sable = c.getSable();
        if (sable >= 0) {
            this.changeTexte(Integer.toString(sable));
        }
        this.c = c;
        colore(c);
    }

    public void colore(models.Case c) {
        switch (c.getType()) {
            case ENGRENAGE:
                this.setBackground(new Color(128,128,128)); break;
            case CRASH:
                this.setBackground(new Color(256,0,0)); break;
            case NORMALE:
                this.setBackground(new Color(220,200,0)); break;
            case TUNNEL:
                this.setBackground(new Color(88,41,0)); break;
            case OASIS:
            case MIRAGE:
                this.setBackground(new Color(0,128,128)); break;
            case OEIL:
                this.setBackground(new Color(0,0,255)); break;
            case DECOLLAGE:
                this.setBackground(new Color(0,0,0)); break;
        }
    }

    public void refresh() {
        int sable = c.getSable();
        if (sable > 0) {
            this.changeTexte(Integer.toString(sable));
        }
        this.c = c;
        colore(c);
    }

    @Override
    public void clicGauche() { this.c.ensabler(); this.c.setType(Case.TYPE.OASIS); this.refresh(); }

    @Override
    public void clicDroit() {}
}
