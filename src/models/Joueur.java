package models;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static models.Carte.Personnage.ARCHEOLOGUE;

public class Joueur {
    //Attributs
    private final int id;
    private int niv_eau;
    private models.Plateau p;
    private final String name;
    private Carte.Personnage perso;
    private Case pos;
    private int nb_action;
    private boolean mon_tour;
    private Image img;

    //Constructeur
    public Joueur(int i, models.Plateau p, String nom, Carte.Personnage per){
        this.id=i;
        this.p=p;
        if (per == Carte.Personnage.PORTEUSE_D_EAU) {
            this.niv_eau = 5;
        }else {
            this.niv_eau = 4;

        }
        this.name=nom;
        this.perso=per;
        this.pos = p.getCase(this.p.getCrash()[0],this.p.getCrash()[1]);
        this.nb_action = 4;
        this.mon_tour = false;

        Image img = new ImageIcon("resources/mumu.png").getImage();
        switch (per) {
            case EXPLORATEUR: img = new ImageIcon("resources/PionVert.png").getImage();break;
            case ALPINISTE: img = new ImageIcon("resources/PionRouge.png").getImage(); break;
            case ARCHEOLOGUE: img = new ImageIcon("resources/PionNoir.png").getImage(); break;
            case METEOROLOGUE: img = new ImageIcon("resources/PionBlanc.png").getImage(); break;
            case NAVIGATRICE: img = new ImageIcon("resources/PionViolet.png").getImage(); break;
            case PORTEUSE_D_EAU: img = new ImageIcon("resources/PionBleu.png").getImage(); break;
        }
        this.img = img;

    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName(){
        return this.name;
    }
    public int getNiv_eau(){
        return this.niv_eau;
    }

    public models.Case getPos(){ return this.pos;}

    public boolean isMon_tour() {
        return mon_tour;
    }

    public int getNb_action() {
        return nb_action;
    }

    public Image getImg() {
        return img;
    }


    public Carte.Personnage getPerso() {
        return perso;
    }



    //Setters
    public void setNiv_eau(int niv_eau) {
        this.niv_eau = niv_eau;
    }

    public void setPos(Case c){
        this.pos = c;
    }

    public void setMon_tour(boolean mon_tour) {
        this.mon_tour = mon_tour;
    }

    public void decremente_action() {
        this.nb_action --;
    }

    public void reset_action() {
        this.nb_action = 4;
    }

    //Méthodes
    
    public boolean explorer() {
        Carte.Personnage pers = this.getPerso();
        Case cPos = this.getPos();
        if (pers == Carte.Personnage.PORTEUSE_D_EAU) {
            if (cPos.getType() == Case.TYPE.OASIS) {
                this.remplirGourde();
                cPos.setExploree(true);
                return true;
            }else{
                if (!cPos.isExploree()){
                    cPos.explorer();
                    return true;
                }
            }
        } else {
            if (cPos.getSable() == 0 && !cPos.isExploree()) {
                cPos.explorer();
                if (cPos.getType() == Case.TYPE.OASIS) {
                    for (Joueur j : p.getJoueurs()) {
                        if (j.getPos() == cPos) {
                            j.remplirGourde();
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void deplacer(Case.Dir d){
        models.Case c=this.getPos();
        models.Case newC=c.voisine(d);
        int[] ncc=newC.getCoord();
        if (c.getCoord()!=ncc){
            this.pos = p.getCase(ncc[0], ncc[1]);
        }else{
            throw new RuntimeException("Deplacement impossible.");
        }
    }

    public boolean CaseVoisine(Case c){
        if (this.getPos().isVoisine(c)){
            return true;
        } else{
            int X_arr = c.getX();
            int Y_arr = c.getY();
            int X_dep = this.getPos().getX();
            int Y_dep = this.getPos().getY();
            if (this.getPerso() == Carte.Personnage.EXPLORATEUR){
                if ( (X_arr == X_dep-1  && Y_arr == Y_dep-1) || (X_arr == X_dep-1  && Y_arr == Y_dep+1)
                || (X_arr == X_dep+1  && Y_arr == Y_dep-1) || (X_arr == X_dep+1  && Y_arr == Y_dep+1) ){
                    return true;
                }
            }
            return false;
        }

    }
    public boolean deplaceC(Case c) {
        int[] ncc = c.getCoord();
        Carte.Personnage pers = this.getPerso();
        if (pers == Carte.Personnage.ALPINISTE ){
            this.pos.remJ(this);
            this.pos = c;
            c.addJ(this);
            return true;
        }
        if (this.getPos().getCoord() != ncc && c.getSable() <= 1 && this.getPos().getSable() <=1) {
            this.pos.remJ(this);
            this.pos = c;
            c.addJ(this);
            return true;
        }
        if (this.getPos().getCoord() != ncc && this.getPos().isNavigateur() && c.getSable() <=1){
            this.pos.remJ(this);
            this.pos = c;
            c.addJ(this);
            return true;
        }
        return false;
    }

    public void creuser(Case c){
        Carte.Personnage pers = this.getPerso();
        if (pers == ARCHEOLOGUE){
            if (c.getSable() > 1){
                c.dessabler();
                c.dessabler();
            } else {
                c.dessabler();
            }
        }else {
            c.dessabler();
        }
    }

    public void boire(){
        setNiv_eau(getNiv_eau()-1);
    }

    public void remplirGourde(){
        if (getNiv_eau() < 3) {
            setNiv_eau((getNiv_eau() + 2));
        } else {
            setNiv_eau(5);
        }
    }

    public Set<Case.Piece> ramasserPiece(){
        Case c=this.getPos();
        Set<Case.Piece> piece= c.getPiece();
        if (c.isExploree() && c.getSable()<2){
            c.setPiece(new HashSet<>());
            p.addPiecesRecup(piece);
            return piece;
        }
        return new HashSet<>();
    }

}