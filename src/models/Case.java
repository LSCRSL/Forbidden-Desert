package models;

import controllers.ControleCase;

import java.util.HashSet;
import java.util.Set;

public class Case {

    public enum Dir {HAUT, BAS, GAUCHE, DROITE}
    public enum TYPE {NORMALE, OEIL, CRASH, DECOLLAGE, OASIS, MIRAGE, TUNNEL, ENGRENAGE, INDICE}
    public enum Piece {HELICE, BOITE_DE_VITESSE, CRISTAL_D_ENERGIE, SYSTEME_DE_NAVIGATION}

    //Attributs
    private Set<Joueur> J;
    private Plateau plateau;
    private int sable;
    private int x,y; //x indice ligne, y indice colonne, avec (0,0) en haut à gauche et première ligne -> x=0
    private boolean exploree;
    private TYPE type;
    private ControleCase cc;
    private Piece indice; //la pièce sur laquelle l'indice porte
    private boolean indLigne; //si la case INDICE indique la ligne ou non (ie la colonne)
    private Set<Piece> piece; //la (ou les) pièce révélée qui se trouve sur la case

    //Constructeur
    public Case(int x, int y, Plateau p, TYPE t){
        this.plateau = p;
        this.x = x;
        this.y = y;
        this.sable = 0;
        this.exploree = false;
        this.type = t;
        this.piece= new HashSet<>();
        this.indice=null;
        this.indLigne= false;
        this.J = new HashSet<Joueur>();
    }

    //Getters
    public int getSable() { return sable; }
    public int getX() { return x; }
    public int getY() { return y; }
    public Plateau getPlateau() { return this.plateau;}
    public int[] getCoord() {
        return new int[]{this.getX(), this.getY()};
    }
    public ControleCase getCc(){return cc;}
    public TYPE getType() {
        return type;
    }
    public boolean isExploree() { return exploree; }
    public Set<Joueur> getJ() { return J; }

    public String getDir(){
        if (this.indLigne){
            return "l";
        }else{
            return "c";
        }
    }
    public String getIndice() {
        String dir = this.getDir();
        switch (this.indicePiece()) {
            case HELICE:
                return dir + ": Hélice";
            case BOITE_DE_VITESSE:
                return dir + ": Boite";
            case CRISTAL_D_ENERGIE:
                return dir + ": Cristal";
            case SYSTEME_DE_NAVIGATION:
                return dir + ": Système";
        }
        return dir;
    }
    public Piece indicePiece(){ return this.indice; }

    public boolean indiceLigne(){ return this.indLigne;}

    public Set<Piece> getPiece() {
        return piece;
    }

    public String strPiece(){
        String res="";
        for (Piece p: this.piece) {
            switch (p) {
                case SYSTEME_DE_NAVIGATION:
                    res+="SYSTEME "; break;
                case BOITE_DE_VITESSE:
                    res+="BOITE "; break;
                case CRISTAL_D_ENERGIE:
                    res+="CRISTAL "; break;
                case HELICE:
                    res+="HELICE "; break;
            }
        }
        return res;
    }

    //Setters
    public void setCc(ControleCase CC){this.cc = CC;}
    public void ensabler() { this.sable++; }
    public void dessabler() { if (sable>=1){ this.sable--; this.getPlateau().setSable(this.getPlateau().getSablePlateau()-1); } }
    public void setType(TYPE t) { this.type = t; }
    public void setExploree(boolean exp){ this.exploree=exp;}
    public void setIndice(Piece pm, boolean isLigne){ this.indice=pm; this.indLigne=isLigne; }
    public void addPiece(Piece p){
        piece.add(p);
    }
    public void setPiece(Set<Piece> pm){
        this.piece=pm;
    }
    public void setSable(int quantite) {this.sable = quantite;}

    //Methode
    public void addJ(Joueur j){
        J.add(j);}
    public void remJ(Joueur j) { J.remove(j);}

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

    public boolean isVoisine(Case C){
        if (C.getType() == TYPE.OEIL){
            return false;
        }else {
            int X = C.getX();
            int Y = C.getY();
            if (X == this.x && Y == this.y-1 || X == this.x && Y == this.y+1
                    || X == this.x-1 && Y == this.y || X == this.x+1 && Y == this.y){
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isNavigateur(){
        Set<Joueur> J = this.getJ();
        for (Joueur j : J){
            if (j.getPerso() == Carte.Personnage.ALPINISTE){
                return true;
            }
        }
        return false;
    }

    public void explorer(){
        if (this.exploree){
            throw new RuntimeException("Case déjà explorée");
        }else{
            this.exploree=true;
        }
    }
}

