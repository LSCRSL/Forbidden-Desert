package models;

public class Plateau {

    //Attributs
    private final int taille;
    private Case[][] plateau;
    private int sable;
    private float niv_tempete;
    private int[] oeil;
    private int[] crash;

    private boolean hRev; //true si l'objet a déjà été révélé
    private boolean sRev;
    private boolean bRev;
    private boolean cRev;

    //Constructeurs
    public Plateau(int taille) {
        this.hRev=false;
        this.sRev=false;
        this.bRev=false;
        this.cRev=false;
        this.taille = taille;
        this.sable = 0;
        this.niv_tempete = 0;
        int[] oeil = {taille/2, taille/2};
        this.oeil = oeil;
        this.plateau = new Case[taille][taille];
        for (int i=0; i<taille; i++) {
            for (int j=0; j<taille;j++) {
                if (i != this.oeil[0] || j != this.oeil[1]) {
                    Case c= new Case(i, j, this, Case.TYPE.NORMALE);
                    this.plateau[i][j] = c;
                }else {
                    Case c = new Case(i, j, this, Case.TYPE.OEIL);
                    this.plateau[i][j] = c;
                }
            }
        }
        int crash=1;
        int oasis=2;
        int mirage=1;
        int engrenage=6;
        int tunnels=3;
        int piste=1;
        while (crash>0){
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX,rY).getType()== Case.TYPE.NORMALE){
                this.setCase((new Case(rX,rY,this, Case.TYPE.CRASH)), rX, rY);
                crash --;
                this.setCrash(new int[]{rX, rY});
            }
        }
        while (oasis>0){
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX,rY).getType()== Case.TYPE.NORMALE){
                this.setCase((new Case(rX,rY,this, Case.TYPE.OASIS)), rX, rY);
                oasis --;
            }
        }
        while (mirage>0){
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX,rY).getType()== Case.TYPE.NORMALE){
                this.setCase((new Case(rX,rY,this, Case.TYPE.MIRAGE)), rX, rY);
                mirage --;
            }
        }
        while (engrenage>0){
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX,rY).getType()== Case.TYPE.NORMALE){
                this.setCase((new Case(rX,rY,this, Case.TYPE.ENGRENAGE)), rX, rY);
                engrenage --;
            }
        }
        while (tunnels>0){
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX,rY).getType()== Case.TYPE.NORMALE){
                this.setCase((new Case(rX,rY,this, Case.TYPE.TUNNEL)), rX, rY);
                tunnels--;
            }
        }
        while (piste>0){
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX,rY).getType()== Case.TYPE.NORMALE){
                this.setCase((new Case(rX,rY,this, Case.TYPE.DECOLLAGE)), rX, rY);
                piste --;
            }
        }
        int helice=2;
        while (helice>0){
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX,rY).getType()== Case.TYPE.NORMALE){
                if (helice==2) {
                    this.setCase((new IndicePiece(rX, rY, this, Case.TYPE.INDICE, IndicePiece.Piece.HELICE, true)), rX, rY);
                }else{
                    this.setCase((new IndicePiece(rX, rY, this, Case.TYPE.INDICE, IndicePiece.Piece.HELICE, false)), rX, rY);
                }
                helice --;
            }
        }
        int bdv=2;
        while (bdv>0){
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX,rY).getType()== Case.TYPE.NORMALE){
                if (bdv==2) {
                    this.setCase((new IndicePiece(rX, rY, this, Case.TYPE.INDICE, IndicePiece.Piece.BOITE_DE_VITESSE, true)), rX, rY);
                }else{
                    this.setCase((new IndicePiece(rX, rY, this, Case.TYPE.INDICE, IndicePiece.Piece.BOITE_DE_VITESSE, false)), rX, rY);
                }
                bdv --;
            }
        }
        int cde=2;
        while (cde>0){
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX,rY).getType()== Case.TYPE.NORMALE){
                if (cde==2) {
                    this.setCase((new IndicePiece(rX, rY, this, Case.TYPE.INDICE, IndicePiece.Piece.CRISTAL_D_ENERGIE, true)), rX, rY);
                }else{
                    this.setCase((new IndicePiece(rX, rY, this, Case.TYPE.INDICE, IndicePiece.Piece.CRISTAL_D_ENERGIE, false)), rX, rY);
                }
                cde --;
            }
        }
        int sdn=2;
        while (sdn>0){
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX,rY).getType()== Case.TYPE.NORMALE){
                if (sdn==2) {
                    this.setCase((new IndicePiece(rX, rY, this, Case.TYPE.INDICE, IndicePiece.Piece.SYSTEME_DE_NAVIGATION,true)), rX, rY);
                }else{
                    this.setCase((new IndicePiece(rX, rY, this, Case.TYPE.INDICE, IndicePiece.Piece.SYSTEME_DE_NAVIGATION, false)), rX, rY);
                }
                sdn --;
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
    public int[] getCrash() { return crash; }

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
    public void setCrash(int[] cr) {
        this.oeil = cr;
    }

    public void setCase(Case c, int x, int y){
        this.plateau[x][y]= c;
    }

    public void bouge_oeil(Case.Dir d){ //A SUPPRIMER????
        //fct pour oeil car se déplace dans le sens inverse de la tempete
        //creer une fonction qui renvoie la direction opposée
        //fonction fausse (mais il y a de l'idée)
        int[] coord = getOeil();
        Case c = getCase(coord[0],coord[1]);
        this.oeil = c.voisine(d).getCoord();
    }
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
                while (oX+f>=5 && f>=0){
                    f--;
                }
                while (cpt!=f) {
                    cpt++;
                    Case t = getCase(oX+cpt, oY);
                    t.setCoord(oX+cpt-1, oY);
                    this.setCase(t,oX+cpt-1, oY );
                    t.ensabler();
                }
                this.setOeil(new int[] {oX + f, oY});
                oeil.setCoord(oX+f, oY);
                this.setCase(oeil,oX+f,oY);
                this.setSable(this.getSablePlateau()+f);
            case BAS:
                while (oX-f<0 && f>=0){
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
                oeil.setCoord(oX-f, oY);
                this.setCase(oeil,oX,oY-f);
                this.setSable(this.getSablePlateau()+f);
            case GAUCHE:
                while (oY+f>=5 && f>=0){
                    f--;
                }
                while (cpt!=f) {
                    cpt++;
                    Case t = getCase(oX,oY+cpt);
                    t.setCoord(oX,oY+cpt-1);
                    t.ensabler();
                    this.setCase(t, oX,oY+cpt-1);
                }
                this.setOeil(new int[] {oX , oY+f});
                oeil.setCoord(oX, oY+f);
                this.setCase(oeil,oX,oY+f);
                this.setSable(this.getSablePlateau()+f);
            case DROITE:
                while (oY-f<0 && f>=0){
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
                oeil.setCoord(oX, oY-f);
                this.setCase(oeil,oX,oY-f);
                this.setSable(this.getSablePlateau()+f);
        }
    }

    public void dechainer() {
        setNiv_tempete((float) (this.getNiv_tempete()+0.5));
    }

    public void affichePiece(){ //NE MARCHE PAS
        int helice=0;
        int hx=-1;
        int hy=-1;
        int cristal=0;
        int cx=-1;
        int cy=-1;
        int boite=0;
        int bx=-1;
        int by=-1;
        int systeme=0;
        int sx=-1;
        int sy=-1;
        for (int i=0; i<taille; i++){
            for (int j=0; j<taille; j++){
                if (this.getCase(i,j).getPiece()!= null){
                    switch(this.getCase(i,j).getPiece()){
                        case HELICE:
                            helice++;
                            if (this.getCase(i,j).getLigne()){
                                hx=i;
                            }else{
                                hy=j;
                            }
                        case CRISTAL_D_ENERGIE:
                            cristal++;
                            if (this.getCase(i,j).getLigne()){
                                cx=i;
                            }else{
                                cy=j;
                            }
                        case SYSTEME_DE_NAVIGATION:
                            systeme++;
                            if (this.getCase(i,j).getLigne()){
                                sx=i;
                            }else{
                                sy=j;
                            }
                        case BOITE_DE_VITESSE:
                            boite++;
                            if (this.getCase(i,j).getLigne()){
                                bx=i;
                            }else{
                                by=j;
                            }
                    }
                }
            }
        }
        if (helice==2 && !hRev){
            this.getCase(hx,hy).setPiece(IndicePiece.Piece.HELICE);
            this.hRev=true;
        }
        if (cristal==2 && !cRev){
            this.getCase(cx,cy).setPiece(IndicePiece.Piece.CRISTAL_D_ENERGIE);
            this.cRev=true;
        }
        if (boite==2 && !bRev){
            this.getCase(bx,by).setPiece(IndicePiece.Piece.BOITE_DE_VITESSE);
            this.bRev=true;
        }
        if (systeme==2 && !sRev){
            this.sRev=true;
            this.getCase(sx,sy).setPiece(IndicePiece.Piece.SYSTEME_DE_NAVIGATION);
        }
    }

}