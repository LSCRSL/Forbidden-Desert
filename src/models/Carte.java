package models;

public abstract class Carte {

    public enum Effet {LE_VENT_SOUFFLE, LA_TEMPETE_SE_DECHAINE, VAGUE_DE_CHALEUR, VOID}

    public enum Personnage {
        ALPINISTE {
            @Override
            public String toString() {
                return "Alpiniste";
            }
        },
        EXPLORATEUR {
            @Override
            public String toString() {
                return "Explorateur";
            }
        },
        PORTEUSE_D_EAU {
            @Override
            public String toString() {
                return "Porteuse d'eau";
            }
        },
        NAVIGATRICE {
            @Override
            public String toString() {
                return "Navigatrice";
            }
        },
        METEOROLOGUE {
            @Override
            public String toString() {
                return "Météorologue";
            }
        },
        ARCHEOLOGUE {
            @Override
            public String toString() {
                return "Archéologue";
            }
        }
    }

}

