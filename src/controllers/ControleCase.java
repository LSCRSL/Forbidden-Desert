package controllers;

import models.Case;
import models.IndicePiece;

import java.awt.*;

public class ControleCase extends IG.ZoneCliquable {
    private models.Case c;
    private models.Plateau p;

    public ControleCase(models.Case c) {
        super("",100,100);
        int sable = c.getSable();
        if (c.isExploree()) {
            this.changeTexte(Integer.toString(sable) + "*");
        }
        if(c.getType()== Case.TYPE.OEIL) {
            this.changeTexte("OEUIL");
        } else {
            this.changeTexte(Integer.toString(sable));
        }
        this.c = c;
        colore(c);
    }

    public void colore(models.Case c) {
        switch (c.getType()) {
            case ENGRENAGE:
                if (c.isExploree()) {
                    this.setBackground(new Color(128, 128, 128));
                }else{
                    this.setBackground(new Color(220, 158, 0, 255));
                }
                break;
            case CRASH:
                this.setBackground(new Color(255,0,0)); break;
            case NORMALE:
                this.setBackground(new Color(220, 158, 0, 255));
            case INDICE:
                if (c.isExploree()) {
                    this.setBackground(new Color(220, 158, 0, 255)); break;
                }else{
                    this.setBackground(new Color(220, 158, 0, 255));
                }
                break;
            case TUNNEL:
                if (c.isExploree()) {
                    this.setBackground(new Color(88,41,0)); break;
                }else{
                    this.setBackground(new Color(220, 158, 0, 255));
                }
                break;
            case OASIS:
                this.setBackground(new Color(0,128,255)); break;
            case MIRAGE:
                if (c.isExploree()) {
                    this.setBackground(new Color(0,128,128));
                }else{
                    this.setBackground(new Color(0,128,255));
                }
                break;
            case OEIL:
                this.setBackground(new Color(255, 255,255)); break;
            case DECOLLAGE:
                if (c.isExploree()) {
                    this.setBackground(new Color(0,255,0));
                }else{
                    this.setBackground(new Color(220, 158, 0, 255));
                }
                break;
        }
    }

    public void refresh() {
        int sable = c.getSable();
        if(c.getType()== Case.TYPE.OEIL) {
            this.changeTexte("OEUIL");
        }else{
            if (c.isExploree()) {
                if (c.getType()== Case.TYPE.INDICE){
                    this.changeTexte(Integer.toString(sable) +"* "+c.getIndice()+" "+c.strPiece());
                }else{
                    this.changeTexte(Integer.toString(sable) + "* "+c.strPiece());
                }
            } else {
                this.changeTexte(Integer.toString(sable)+" "+c.strPiece());
            }
        }
        this.c = c;
        this.colore(c);
    }

    @Override
    public void clicGauche() {
        if( !c.isExploree()){
            c.setExploree();
        }
        //p.affichePiece(); //NE MARCHE PAS
        this.refresh();
    }

    @Override
    public void clicDroit() {}
}
