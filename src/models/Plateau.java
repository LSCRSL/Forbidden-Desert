package models;

import controllers.ControleCase;

import javax.management.RuntimeErrorException;
import java.util.ArrayList;
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
    private int id_joueur_actuel;
    private Set<Joueur> joueurs;
    private int nb_joueur;
    private Set<Case.Piece> piecesRecup;
    private boolean hRev; //true si l'objet a déjà été révélé
    private boolean sRev;
    private boolean bRev;
    private boolean cRev;
    private int action;

    //Constructeurs
    public Plateau(int taille) {
        this.hRev = false;
        this.sRev = false;
        this.bRev = false;
        this.cRev = false;
        this.piecesRecup = new HashSet<>();
        this.taille = taille;
        this.sable = 0;
        this.action = -1;
        this.id_joueur_actuel = 0;
        this.niv_tempete = 0;
        this.joueurs = new HashSet<Joueur>();
        int[] oeil = {taille / 2, taille / 2};

        this.oeil = oeil;

        this.plateau = new Case[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (i != this.oeil[0] || j != this.oeil[1]) {
                    Case c = new Case(i, j, this, Case.TYPE.NORMALE);
                    this.plateau[i][j] = c;
                } else {
                    Case c = new Case(i, j, this, Case.TYPE.OEIL);
                    this.plateau[i][j] = c;
                }
            }
        }
        int crash = 1;
        int oasis = 2;
        int mirage = 1;
        int engrenage = 6;
        int tunnels = 3;
        int piste = 1;
        while (crash > 0) {
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX, rY).getType() == Case.TYPE.NORMALE) {
                this.setCase((new Case(rX, rY, this, Case.TYPE.CRASH)), rX, rY);
                crash--;
                this.setCrash(new int[]{rX, rY});

            }
        }

        while (oasis > 0) {
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX, rY).getType() == Case.TYPE.NORMALE) {
                this.setCase((new Case(rX, rY, this, Case.TYPE.OASIS)), rX, rY);
                oasis--;
            }
        }

        while (mirage > 0) {
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX, rY).getType() == Case.TYPE.NORMALE) {
                this.setCase((new Case(rX, rY, this, Case.TYPE.MIRAGE)), rX, rY);
                mirage--;
            }
        }

        while (engrenage > 0) {
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX, rY).getType() == Case.TYPE.NORMALE) {
                this.setCase((new Case(rX, rY, this, Case.TYPE.ENGRENAGE)), rX, rY);
                engrenage--;
            }
        }

        while (tunnels > 0) {
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX, rY).getType() == Case.TYPE.NORMALE) {
                this.setCase((new Case(rX, rY, this, Case.TYPE.TUNNEL)), rX, rY);
                tunnels--;
            }
        }

        while (piste > 0) {
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX, rY).getType() == Case.TYPE.NORMALE) {
                this.setCase((new Case(rX, rY, this, Case.TYPE.DECOLLAGE)), rX, rY);
                piste--;
            }
        }

        int helice = 2;
        while (helice > 0) {
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX, rY).getType() == Case.TYPE.NORMALE) {
                if (helice == 2) {
                    this.setCase((new Case(rX, rY, this, Case.TYPE.INDICE)), rX, rY);
                    this.getCase(rX, rY).setIndice(Case.Piece.HELICE, true);
                } else {
                    this.setCase((new Case(rX, rY, this, Case.TYPE.INDICE)), rX, rY);
                    this.getCase(rX, rY).setIndice(Case.Piece.HELICE, false);
                }
                helice--;
            }
        }
        int bdv = 2;
        while (bdv > 0) {
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX, rY).getType() == Case.TYPE.NORMALE) {
                if (bdv == 2) {
                    this.setCase((new Case(rX, rY, this, Case.TYPE.INDICE)), rX, rY);
                    this.getCase(rX, rY).setIndice(Case.Piece.BOITE_DE_VITESSE, true);
                } else {
                    this.setCase((new Case(rX, rY, this, Case.TYPE.INDICE)), rX, rY);
                    this.getCase(rX, rY).setIndice(Case.Piece.BOITE_DE_VITESSE, false);
                }
                bdv--;
            }
        }
        int cde = 2;
        while (cde > 0) {
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX, rY).getType() == Case.TYPE.NORMALE) {
                if (cde == 2) {
                    this.setCase((new Case(rX, rY, this, Case.TYPE.INDICE)), rX, rY);
                    this.getCase(rX, rY).setIndice(Case.Piece.CRISTAL_D_ENERGIE, true);
                } else {
                    this.setCase((new Case(rX, rY, this, Case.TYPE.INDICE)), rX, rY);
                    this.getCase(rX, rY).setIndice(Case.Piece.CRISTAL_D_ENERGIE, false);
                }
                cde--;
            }
        }
        int sdn = 2;
        while (sdn > 0) {
            int rX = (int) Math.floor(Math.random() * 5);
            int rY = (int) Math.floor(Math.random() * 5);
            if (this.getCase(rX, rY).getType() == Case.TYPE.NORMALE) {
                if (sdn == 2) {
                    this.setCase((new Case(rX, rY, this, Case.TYPE.INDICE)), rX, rY);
                    this.getCase(rX, rY).setIndice(Case.Piece.SYSTEME_DE_NAVIGATION, true);
                } else {
                    this.setCase((new Case(rX, rY, this, Case.TYPE.INDICE)), rX, rY);
                    this.getCase(rX, rY).setIndice(Case.Piece.SYSTEME_DE_NAVIGATION, false);
                }
                sdn--;
            }
        }

        int[][] s = {{0, 2}, {1, 1}, {1, 3}, {2, 0}, {2, 4}, {3, 1}, {3, 3}, {4, 2}};
        for (int[] t : s) {
            this.getCase(t[0], t[1]).ensabler();
        }

        this.setSable(8);

    }

    //Getters
    public int getSablePlateau() {
        return sable;
    }

    public int getId_joueur_actuel() {
        return id_joueur_actuel;
    }

    public float getNiv_tempete() {
        return niv_tempete;
    }

    public int getTaille() {
        return taille;
    }

    public int[] getOeil() {
        return oeil;
    }

    public int[] getCrash() {
        return crash;
    }

    public int getAction() {
        return action;
    }


    public Case getCase(int x, int y) {
        return this.plateau[x][y];
    }

    public Set<Joueur> getJoueurs() {
        return this.joueurs;
    }

    public Joueur getJoueur_i(int i) {
            for (Joueur j : this.getJoueurs())
                if (j.getId() == i) return j;
            throw new RuntimeException("pas de joueur a l'indice"+i);
    }

    public Set<Case.Piece> getPiecesRecup() {
        return this.piecesRecup;
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

    public void setAction(int a) {
        this.action = a;
    }

    public void setCase(Case c, int x, int y) {
        this.plateau[x][y] = c;
    }

    public void setId_joueur_actuel(int id) {
        this.id_joueur_actuel = id;
    }

    public void addPiecesRecup(Set<Case.Piece> pm) {
        for (Case.Piece p : pm) {
            this.piecesRecup.add(p);
        }
    }

    public void addJoueur(int i, String name, Carte.Personnage per) {
        Joueur j = new Joueur(i, this, name, per);
        //System.out.println(this.getJoueur_i(0).getName() + " 1");
        this.joueurs.add(j);
        j.getPos().addJ(j);
        //System.out.println(this.getJoueur_i(0).getName());
        //System.out.println(this.getJoueurs().get(1));
    }

    public void printJ(){
        System.out.println(this.getJoueurs().toString());
    }


    public void souffler(Case.Dir d, int f) {
        //rajouter des conditions si la force est trop élévée --- ok?
        int[] tmp=getOeil();
        int oX = tmp[0];
        int oY = tmp[1];
        int cpt=0;
        try {
            switch (d) {
                case HAUT:
                    while (cpt != f) {
                        this.permute_case(this.getCase(oX, oY), this.getCase(oX - 1, oY));
                        oX -= 1;
                        cpt++;

                    }
                case BAS:
                    while (cpt != f) {
                        this.permute_case(this.getCase(oX, oY), this.getCase(oX + 1, oY));
                        oX += 1;
                        cpt++;

                    }
                case GAUCHE:
                    while (cpt != f) {
                        this.permute_case(this.getCase(oX, oY), this.getCase(oX, oY - 1));
                        oY -= 1;
                        cpt++;

                    }
                case DROITE:
                    while (cpt != f) {
                        this.permute_case(this.getCase(oX, oY), this.getCase(oX, oY + 1));
                        oY += 1;
                        cpt++;
                    }
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
    }

    public void permute_case(Case c1, Case c2) {
        int s1 = c1.getSable(); //niv_sabla
        boolean exp1 = c1.isExploree(); //si déjà explorée
        Case.TYPE typ1 = c1.getType(); //type
        ControleCase cc1 = c1.getCc();
        Set<Case.Piece> p1 = c1.getPiece(); //Piece présente sur Case1
        Set<Case.Piece> p2 = c2.getPiece(); //Piece présente sur Case2
        Set<Joueur> J = c1.getJ(); //Joueur présent sur Case
        Case.Piece ip1 = c1.indicePiece(); //indice pour piece
        boolean il1 = c1.indiceLigne(); //indice pour ligne
        if ( typ1 == Case.TYPE.OEIL) {
            int[] o ={c2.getX(), c2.getY()} ;
            setOeil(o);
            for (Case.Piece p: p1){
                p2.add(p);
            }
            p1=new HashSet<>();
        }
        if ( c2.getType() == Case.TYPE.OEIL) {
            int[] o ={c1.getX(), c1.getY()} ;
            setOeil(o);
            for (Case.Piece p: p2) {
                p1.add(p);
            }
            p2=new HashSet<>();
        }

        if ( typ1 == Case.TYPE.CRASH) {
            int[] c ={c2.getX(), c2.getY()} ;
            setCrash(c);
        }
        if ( c2.getType() == Case.TYPE.CRASH) {
            int[] c ={c1.getX(), c1.getY()} ;
            setCrash(c);
        }

        c1.setType(c2.getType());
        c1.setCc(c2.getCc());
        c1.setPiece(p2);
        c1.setIndice(c2.indicePiece(),c2.indiceLigne());
        c1.setExploree2(c2.isExploree());

        //on associe à la case les nouveaux joueurs
        c1.setJ(c2.getJ());
        //on associe aux joueurs la nouvelle case (car flèche bidirectionnelle)
        for (Joueur j : c1.getJ()){
            j.setPos(c1);
        }

        if (c2.getType()!=Case.TYPE.OEIL) {
            c1.setSable(c2.getSable()+1);
            this.setSable(this.getSablePlateau()+1);
        }

        c2.setType(typ1);
        c2.setCc(cc1);
        c2.setPiece(p1);
        c2.setIndice(ip1,il1);
        c2.setExploree2(exp1);
        c2.setJ(J);
        for (Joueur j : c2.getJ()){
            j.setPos(c2);
        }

        if (typ1!=Case.TYPE.OEIL) {
            c2.setSable(s1+1);
            this.setSable(this.getSablePlateau()+1);
        }

    }

    public void dechainer() {
        setNiv_tempete((float) (this.getNiv_tempete()+0.5));
    }

    public void affichePiece(){
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
                if(this.getCase(i,j).getType()== Case.TYPE.INDICE && this.getCase(i,j).isExploree()) {
                    Case.Piece p = this.getCase(i,j).indicePiece();
                    switch(p){
                        case HELICE:
                            helice++;
                            if (this.getCase(i,j).indiceLigne()){
                                hx=i;
                            }else{
                                hy=j;
                            } break;
                        case CRISTAL_D_ENERGIE:
                            cristal++;
                            if (this.getCase(i,j).indiceLigne()){
                                cx=i;
                            }else{
                                cy=j;
                            } break;
                        case SYSTEME_DE_NAVIGATION:
                            systeme++;
                            if (this.getCase(i,j).indiceLigne()){
                                sx=i;
                            }else{
                                sy=j;
                            } break;
                        case BOITE_DE_VITESSE:
                            boite++;
                            if (this.getCase(i,j).indiceLigne()){
                                bx=i;
                            }else{
                                by=j;
                            } break;
                    }
                }
            }
        }
        if (helice==2 && !hRev){
            this.getCase(hx,hy).addPiece(Case.Piece.HELICE);
            this.hRev=true;
        }
        if (cristal==2 && !cRev){
            this.getCase(cx,cy).addPiece(Case.Piece.CRISTAL_D_ENERGIE);
            this.cRev=true;
        }
        if (boite==2 && !bRev){
            this.getCase(bx,by).addPiece(Case.Piece.BOITE_DE_VITESSE);
            this.bRev=true;
        }
        if (systeme==2 && !sRev){
            this.getCase(sx,sy).addPiece(Case.Piece.SYSTEME_DE_NAVIGATION);
            this.sRev=true;
        }
    }

    public String getStrPiece(Case.Piece p){
        switch(p){
            case HELICE:
                return "Helice";
            case BOITE_DE_VITESSE:
                return "Boite de vitesse";
            case CRISTAL_D_ENERGIE:
                return "Cristal d'énergie";
            case SYSTEME_DE_NAVIGATION:
                return "Système de navigation";
        }
        return "";
    }

}