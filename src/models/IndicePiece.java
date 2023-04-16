package models;

public class IndicePiece extends Case {
    public enum Piece {HELICE, BOITE_DE_VITESSE, CRISTAL_D_ENERGIE, SYSTEME_DE_NAVIGATION};
    private Piece pm;
    private boolean isLigne;

    //Constructeur
    public IndicePiece(int x, int y, Plateau p, TYPE t, Piece piece, boolean ligne) {
        super(x, y, p, TYPE.INDICE);
        this.pm = piece;
        this.isLigne = ligne;
    }

    //getter
    @Override
    public Piece getPiece(){ return this.pm; }
    @Override
    public boolean getLigne(){
        return this.isLigne;
    }
    public String getDir(){
        if (this.isLigne){
            return "l";
        }else{
            return "c";
        }
    }

    public String getIndice() {
        String dir = this.getDir();
        switch (this.getPiece()) {
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

    //Setter
    public void setIndice(Piece pm, boolean iL){
        this.isLigne=iL;
        this.pm=pm;
    }
}
