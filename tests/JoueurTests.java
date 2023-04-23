import junit.framework.TestCase;

import models.Carte;
import models.Joueur;
import models.Plateau;

public class JoueurTests extends TestCase {
    public void test() throws Exception {
        models.Plateau p= new Plateau(5);
        Joueur j1=new Joueur(1, p, "toto", Carte.Personnage.ARCHEOLOGUE);
        assertEquals(j1.getPerso(), Carte.Personnage.ARCHEOLOGUE);
        j1.setPos(p.getCase(2,0));
        j1.creuser(p.getCase(2,0));
        assertEquals(j1.getPos().getSable(),0);
        j1.boire();
        assertEquals(j1.getNiv_eau(),3);
        j1.remplirGourde();
        assertEquals(j1.getNiv_eau(),5);
        boolean bj= j1.deplaceC(p.getCase(1,0));
        assertEquals(j1.getPos(), p.getCase(1,0));
    }
}
