package models;

import controllers.ControleCase;

import java.util.HashSet;
import java.util.Set;

public class Plateau {

    //Attributs
    private final int taille;
    private Case[][] plateau;
    private int sable;
    private float niv_tempete;
    private int[] oeil;
    private int[] crash;
    private Set<Joueur> joueurs;
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
        this.joueurs = new HashSet<Joueur>();
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
            if (this.getCase(rX,rY).getType() == Case.TYPE.NORMALE){
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


    public Case getCase(int x, int y) {
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
        this.crash = cr;
    }

    public void setCase(Case c, int x, int y){
        this.plateau[x][y]= c;
    }

    public void addJoueur(int i, String nom, Carte.Personnage per) {
        Joueur j = new Joueur(i,this,nom,per);
        joueurs.add(j);
        j.getPos().addJ(j);
    }

    public void souffler(Case.Dir d, int f) {
        //rajouter des conditions si la force est trop élévée
        //les cases avec les indices se decouvrent quand on permutte
        int[] tmp=getOeil();
        int oX = tmp[0];
        int oY = tmp[1];
        int cpt=0;
        switch (d){
            case HAUT:
                while (cpt!=f) {
                    this.permute_case(this.getCase(oX,oY),this.getCase(oX-1,oY));
                    oX -=1;
                    cpt++;

                }
            case BAS:
                while (cpt!=f) {
                    this.permute_case(this.getCase(oX,oY),this.getCase(oX+1,oY));
                    oX +=1;
                    cpt++;

                }
            case GAUCHE:
                while (cpt!=f) {
                    this.permute_case(this.getCase(oX,oY),this.getCase(oX,oY-1));
                    oY -=1;
                    cpt++;

                }
            case DROITE:
                while (cpt!=f) {
                this.permute_case(this.getCase(oX,oY),this.getCase(oX,oY+1));
                oY +=1;
                cpt++;

            }
        }
    }

    public void permute_case(Case c1, Case c2) {
        int s1 = c1.getSable();
        boolean exp1 = c1.isExploree();
        Case.TYPE typ1 = c1.getType();
        ControleCase cc1 = c1.getCc();
        IndicePiece.Piece p1 = c1.getPiece();
        Set<Joueur> J1= c1.getJ();

        //mettre un switch ??
        if ( typ1 == Case.TYPE.OEIL) {
            int[] o ={c2.getX(), c2.getY()} ;
            setOeil(o);
        }
        if ( c2.getType() == Case.TYPE.OEIL) {
            int[] o ={c1.getX(), c1.getY()} ;
            setOeil(o);
        }

        if ( typ1 == Case.TYPE.CRASH) {
            int[] c ={c2.getX(), c2.getY()} ;
            setCrash(c);
        }
        if ( c2.getType() == Case.TYPE.CRASH) {
            int[] c ={c1.getX(), c1.getY()} ;
            setCrash(c);
        }
        /*boolean isI1=false;
        boolean iL1=false;
        IndicePiece.Piece piece1=null;
        if (c1.getType()==Case.TYPE.INDICE){
            c1=(IndicePiece) c1;
            isI1=true;
            iL1=c1.getLigne();
            piece1=c1.getPiece();
            c1=(Case) c1;
        }
        boolean isI2=false;
        boolean iL2=false;
        IndicePiece.Piece piece2=null;
        if (c2.getType()==Case.TYPE.INDICE){
            c2=(IndicePiece) c2;
            isI2=true;
            iL2=c2.getLigne();
            piece2=c2.getPiece();
            c2=(Case) c2;
        }*/

        c1.setType(c2.getType());
        /*if (isI2){
            //c1= new IndicePiece(c1.getX(), c1.getY(), this, Case.TYPE.INDICE, piece2, iL2);
            ((IndicePiece) c1).setIndice(piece2, iL2);
        }*/
        c1.setCc(c2.getCc());
        c1.setPiece(c2.getPiece());
        c1.setExploree2(c2.isExploree());
        System.out.print("Avant, c1:");
        System.out.print(J1);
        System.out.print("\nAvant, c2:");
        System.out.print(c2.getJ());
        c1.setJ(c2.getJ());
        if (c2.getType()!=Case.TYPE.OEIL) {
            c1.setSable(c2.getSable()+1);
            this.setSable(this.getSablePlateau()+1);
        }

        c2.setType(typ1);
        /*if (isI1){
            //c2= new IndicePiece(c2.getX(), c2.getY(), this, Case.TYPE.INDICE, piece1, iL1);
            ((IndicePiece) c2).setIndice(piece1, iL1);
        }*/
        c2.setCc(cc1);
        c2.setPiece(p1);
        c2.setExploree2(exp1);
        c2.setJ(J1);
        if (typ1!=Case.TYPE.OEIL) {
            c2.setSable(s1+1);
            this.setSable(this.getSablePlateau()+1);
        }
        System.out.print("\nAprès, c1:");
        System.out.print(c1.getJ());
        System.out.print("\nAprès, c2:");
        System.out.print(c2.getJ());
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