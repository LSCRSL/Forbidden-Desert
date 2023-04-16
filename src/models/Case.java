package models;

import controllers.ControleCase;

import java.util.HashSet;
import java.util.Set;

public class Case {

    public enum Dir {HAUT,HAUT_DROIT, HAUT_GAUCHE, BAS,BAS_DROIT, BAS_GAUCHE, GAUCHE, DROITE};
    public enum TYPE {NORMALE, OEIL, CRASH, DECOLLAGE, OASIS, MIRAGE, TUNNEL, ENGRENAGE, INDICE};

    //Attributs
    private Set<Joueur> J;
    private Plateau plateau;
    private int sable;
    private int x,y; //x indice ligne, y indice colonne, avec (0,0) en haut à gauche et première lign -> x=0
    private boolean exploree;
    private TYPE type;
    private ControleCase cc;
    private IndicePiece.Piece piece;

    //Constructeur
    public Case(int x, int y, Plateau p, TYPE t){
        this.plateau = p;
        this.x = x;
        this.y = y;
        this.sable = 0;
        this.exploree = false;
        this.type = t;
        this.J = new HashSet<>();
    }

    //Getters
    public int getSable() { return sable; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int[] getCoord() {
        int[] array = {this.getX(),this.getY()};
        return array;
    }
    public ControleCase getCc(){return cc;}
    public TYPE getType() {
        return type;
    }
    public boolean isExploree() { return exploree; }

    public Set<Joueur> getJ() { return J; }

    public String getIndice(){return "";}

    public IndicePiece.Piece getPiece() {
        return null;
    }
    public boolean getLigne(){
        return false;
    }

    public boolean hasPlayer() { return !this.getJ().isEmpty();}

    public String strPiece(){
        if (this.piece != null){
            switch (this.piece){
                case SYSTEME_DE_NAVIGATION:
                    return "SYSTEME";
                case BOITE_DE_VITESSE:
                    return "BOITE";
                case CRISTAL_D_ENERGIE:
                    return "CRISTAL";
                case HELICE:
                    return "HELICE";
            }
        }
        return "";
    }

    //Setters
    public void setCc(ControleCase CC){this.cc = CC;}
    public void ensabler() { this.sable++; }
    public void dessabler() { if (sable>=1){ this.sable--; } }
    public void setType(TYPE t) { this.type = t; }

    public void setCoord(int cX, int cY){
        this.x=cX;
        this.y=cY;
    }

    public void setExploree(){ this.exploree=true;}

    public void setExploree2(boolean exp){ this.exploree=exp;}

    public void setPiece(IndicePiece.Piece pm){
        this.piece=pm;
    }

    public void setSable(int quantite) {this.sable = quantite;}

    //Methode

    public void addJ(Joueur j){
        J.add(j);
    }
    public void remJ(Joueur j) { J.remove(j);}

    /**
    public void setJ(Set<Joueur> JJ){
        for (Joueur jr : this.J){
            this.remJ(jr);
        }
        for (Joueur ja : JJ){
            this.addJ(ja);
        }
    }**/

    public void setJ(Set<Joueur> JJ) {
        this.J = JJ;
    }

    public Case voisine(Dir d) {
        int x = this.getX();
        int y= this.getY();
        try {
            switch (d) {
                case HAUT:
                    return this.plateau.getCase(x - 1, y);
                case BAS:
                    return this.plateau.getCase(x + 1, y);
                case GAUCHE:
                    return this.plateau.getCase(x, y - 1);
                case DROITE:
                    this.plateau.getCase(x, y + 1);
            }
        }catch (ArrayIndexOutOfBoundsException e) {}
        return this;
    }

    public void explorer(){
        if (this.exploree==true){
            throw new RuntimeException("Case déjà explorée");
        }else{
            this.exploree=true;
        }
    }
}

