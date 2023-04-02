package models;

public abstract class Carte {

}

class carteTempete extends Carte {
    public enum Effet {LE_VENT_SOUFFLE, LA_TEMPETE_SE_DECHAINE, VAGUE_DE_CHALEUR};
    private Effet e;
    public void piocher(Plateau p, Joueur j) { //PAS DU TOUT FINI
        switch (this.e) {
            case LE_VENT_SOUFFLE:
                p.souffler(Case.Dir.BAS, 1);
            case LA_TEMPETE_SE_DECHAINE:
                p.dechainer();
            case VAGUE_DE_CHALEUR:
                j.boire();
        }
    }
}

class carteAventurier extends Carte {}

class carteEquipement extends Carte {}

