import junit.framework.TestCase;
import models.Carte;
import models.PaquetCartes;

import java.util.ArrayList;

public class PaquetTests extends TestCase {
    public void test() throws Exception {
        ArrayList<Carte.Effet> cartes = new ArrayList<>();
        cartes.add(Carte.Effet.LE_VENT_SOUFFLE);
        cartes.add(Carte.Effet.VAGUE_DE_CHALEUR);
        cartes.add(Carte.Effet.LE_VENT_SOUFFLE);
        cartes.add(Carte.Effet.LA_TEMPETE_SE_DECHAINE);
        PaquetCartes c = new PaquetCartes(cartes);
        assertEquals(c.getDefausse().size(), 0);
        assertEquals(c.getPaquet().size(), 4);
        c.mettreSousPioche();
        assertEquals(c.getPaquet().getFirst(), Carte.Effet.VAGUE_DE_CHALEUR);
        assertEquals(c.getPaquet().getLast(), Carte.Effet.LE_VENT_SOUFFLE);
        Carte.Effet c1 = c.tirer();
        Carte.Effet c2 = c.tirer();
        assertEquals(c.getPaquet().size(),2);
        assertEquals(c.getDefausse().size(),2);
        assertEquals(c.getDefausse().getFirst(), c1);
        assertEquals(c.getDefausse().getLast(), c2);
        for (int j = 0; j<3;j++){
            Carte.Effet cc = c.tirer();
        }
        assertEquals(c.getDefausse().size(), 1);
        assertEquals(c.getPaquet().size(), 3);
        c.melanger(c.getPaquet());
        assertEquals(c.getPaquet().size(), 3);

    }
}

