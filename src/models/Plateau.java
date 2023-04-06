package models;

public class Plateau {

    //Attributs
    private final int taille;
    private Case[][] plateau;
    private int sable;
    private float niv_tempete;
    private int[] oeil;

    //Constructeurs
    public Plateau(int taille) {
        this.taille = taille;
        this.sable = 0;
        this.niv_tempete = 0;
        int[] oeil = {taille/2, taille/2};
        this.oeil = oeil;
        this.plateau = new Case[taille][taille];
        for (int i=0; i<taille; i++) {
            for (int j=0; j<taille;j++) {
                if (i != this.oeil[0] || j != this.oeil[1]) {
                    Case c = new Case(i, j, this, Case.TYPE.NORMALE);
                    this.plateau[i][j] = c;
                }else {
                    Case c = new Case(i, j, this, Case.TYPE.OEIL);
                    this.plateau[i][j] = c;
                }
            }
        }
        int[][] s = {{0,2},{1,1},{1,3},{2,0},{2,4},{3,1},{3,3},{4,2}};
        for (int[] t : s) {
            this.getCase(t[0],t[1]).ensabler();
        }
        this.setSable(8);
    }

    //Getters
    public int getSablePlateau() { return sable; }

    public float getNiv_tempete() { return niv_tempete; }

    public int getTaille() { return taille; }

    public int[] getOeil() { return oeil; }

    public Case getCase(int x,int y) {
        return this.plateau[x][y];
    }

    //Setters
    public void setNiv_tempete(float niveau) {
        this.niv_tempete = niveau;
    }
    public void setSable(int niv_sable) {
        this.sable = niv_sable;
    }

    public void setOeil(int[] oeil) {
        this.oeil = oeil;
    }

    public void setCase(Case c, int x, int y){
        this.plateau[x][y]= c;
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

    public void souffler(Case.Dir d, int f) {
        int[] tmp=getOeil();
        int oX = tmp[0];
        int oY = tmp[1];
        Case oeil=this.getCase(oX,oY);
        System.out.print("x="+oX+"\n");
        System.out.print("y="+oY+"\n");
        int cpt=0;
        switch (d){
            case HAUT:
                while (oX+f>=5){
                    f--;
                }
                while (cpt!=f) {
                    cpt++;
                    Case t = getCase(oX+cpt,oY);
                    t.setCoord(oX+cpt-1,oY);
                    t.ensabler();
                    this.setCase(t,oX+cpt-1,oY );
                }
                this.setOeil(new int[] {oX + f, oY});
                this.setCase(oeil,oX+f,oY);
            case BAS:
                while (oX-f<0){
                    f--;
                }
                while (cpt!=f) {
                    cpt++;
                    Case t = getCase(oX-cpt,oY);
                    t.setCoord(oX-cpt+1,oY);
                    t.ensabler();
                    this.setCase(t, oX-cpt+1,oY);
                }
                this.setOeil(new int[] {oX - f, oY});
                this.setCase(oeil,oX-f,oY);
            case GAUCHE:
                while (oY+f>=5){
                    f--;
                }
                while (cpt!=f) {
                    cpt++;
                    Case t = getCase(oX,oY+cpt);
                    t.setCoord(oX,oY+cpt-1);
                    t.ensabler();
                    this.setCase(t, oX,oY+cpt-1);
                }
                this.setOeil(new int[] {oX , oY+ f});
                this.setCase(oeil,oX,oY+f);
            case DROITE:
                while (oY-f<0){
                    f--;
                }
                while (cpt!=f) {
                    cpt++;
                    Case t = getCase(oX,oY-cpt);
                    t.setCoord(oX,oY-cpt+1);
                    t.ensabler();
                    this.setCase(t, oX,oY-cpt+1);
                }
                this.setOeil(new int[] {oX , oY-f});
                this.setCase(oeil,oX,oY-f);
        }
    }

    public void dechainer() {
        setNiv_tempete((float) (this.getNiv_tempete()+0.5));
    }
}
