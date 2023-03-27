package controllers;

import java.awt.*;

public class ControleCase extends IG.ZoneCliquable {

    private models.Case c;

    public ControleCase(models.Case c) {
        super("",80,80);
        this.c = c;
    }

    @Override
    public void clicGauche() { this.setBackground(new Color(0,0,255)); }

    @Override
    public void clicDroit() { this.setBackground(new Color(255,255,255)); }
}
