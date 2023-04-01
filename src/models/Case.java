package models;

public class Case {

    public enum Dir {HAUT, BAS, GAUCHE, DROITE};
    public enum TYPE {NORMALE, OEIL, CRASH, DECOLLAGE, OASIS, MIRAGE, TUNNEL, ENGRENAGE};

    //Attributs
    private Plateau plateau;
    private int sable;
    private int x,y;
    private boolean exploree;
    private TYPE type;

    //Constructeur
    public Case(int x, int y, Plateau p, TYPE t){
        this.plateau = p;
        this.x = x;
        this.y = y;
        this.sable = 0;
        this.exploree = false;
        this.type = t;
    }

    //Getters
    public int getSable() { return sable; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int[] getCoord() {
        int[] array = {this.getX(),this.getY()};
        return array;
    }
    public boolean isExploree() { return exploree; }

    public TYPE getType() {
        return type;
    }

    //Setters
    public void ensabler() { this.sable++; }
    public void dessabler() { this.sable--; }
    public void setType(TYPE t) { this.type = t; }

    public void setCoord(int cX, int cY){
        this.x=cX;
        this.y=cY;
    }

    //Methode
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
}
