package models;

public class Plateau {

    //Attributs
    private final int taille;
    private Case[][] plateau;
    private int sable;
    private int niv_tempete;
    private int[] oeil;

    //Constructeurs
    public Plateau(int taille) {
        this.taille = taille;
        this.sable = 0;
        this.niv_tempete = 0;
        int[] oeil = {taille/2 + 1, taille/2 + 1};
        this.oeil = oeil;
        this.plateau = new Case[taille][taille];
        for (int i=0; i<taille; i++) {
            for (int j=0; j<taille;j++) {
                Case c = new Case(i,j,this);
                this.plateau[i][j] = c;
            }
        }
    }

    //Getters
    public int getSablePlateau() { return sable; }

    public int getNiv_tempete() { return niv_tempete; }

    public int getTaille() { return taille; }

    public int[] getOeil() { return oeil; }

    public Case getCase(int x,int y) {
        return this.plateau[x][y];
    }

    //Setters
    public void setNiv_tempete(int niveau) {
        this.niv_tempete = niveau;
    }
    public void setSable(int niv_sable) {
        this.sable = niv_sable;
    }
    public void bouge_oeil(Case.Dir d){
        //fct pour oeil car se déplace dans le sens inverse de la tempete
        //creer une fonction qui renvoie la direction opposée
        //fonction fausse (mais il y a de l'idée)
        int[] coord = getOeil();
        Case c = getCase(coord[0],coord[1]);
        this.oeil = c.voisine(d).getCoord();
    }

    //Methodes

    public void souffler(Case.Dir d, int f) {}

    public void dechainer() {}
}
