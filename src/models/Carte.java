package models;

public abstract class Carte {
    public abstract void piocher(Plateau p, Joueur j);

    public enum Effet {LE_VENT_SOUFFLE, LA_TEMPETE_SE_DECHAINE, VAGUE_DE_CHALEUR};

    public enum Equipement{Blaster, Jetpack, Bouclier_Solaire, Appareil};

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
        };
    }

    class carteTempete extends Carte { //Classe inutile!!!
        private Effet e;

        @Override
        public void piocher(Plateau p, Joueur j) { //PAS DU TOUT FINI et inutile
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

    class carteAventurier extends Carte {
        private Personnage perso;

        @Override
        public void piocher(Plateau p, Joueur j) {

        }
    }

    class carteEquipement extends Carte {
        //BONUS
        @Override
        public void piocher(Plateau p, Joueur j) {

        }
    }
}

