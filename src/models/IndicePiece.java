package models;

public class IndicePiece extends Case {
    public enum Piece {HELICE, BOITE_DE_VITESSE, CRISTAL_D_ENERGIE, SYSTEME_DE_NAVIGATION};
    private Piece pm;
    private boolean isLigne;

    public IndicePiece(int x, int y, Plateau p, TYPE t, Piece piece, boolean ligne) {
        super(x, y, p, t);
        this.pm = piece;
        this.isLigne = ligne;
    }

}
