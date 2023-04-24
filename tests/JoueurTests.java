import junit.framework.TestCase;

import models.Carte;
import models.Case;
import models.Joueur;
import models.Plateau;

import java.util.Set;
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
        Case c= j1.getPos();
        c.addPiece(Case.Piece.BOITE_DE_VITESSE);
        Set<Case.Piece> pr=j1.ramasserPiece();
        assertEquals(pr.size(),0);
        j1.getPos().explorer();
        pr=j1.ramasserPiece();
        assertEquals(pr.size(),1);
        assertTrue(j1.deplaceC(p.getCase(1,0)));
        j1.getPos().ensabler();
        j1.getPos().ensabler();
        assertFalse(j1.deplaceC(p.getCase(4,4)));
        Joueur j2= new Joueur(2,p, "j2", Carte.Personnage.ALPINISTE);
        j2.setPos(p.getCase(4,4));
        p.getCase(4,4).ensabler();
        p.getCase(4,4).ensabler();
        p.getCase(4,4).ensabler();
        p.getCase(4,4).ensabler();
        assertTrue(j2.CaseVoisine(p.getCase(4,3)));
        assertFalse(j2.CaseVoisine(p.getCase(0,0)));
        assertTrue(j2.deplaceC(p.getCase(4,3)));
        p.getCase(2,1).setExploree(false);
        j1.getPos().setSable(0);
        j2.getPos().setSable(0);
        j1.deplaceC(p.getCase(2,1));
        j2.deplaceC(p.getCase(2,1));
        assertEquals(p.getCase(2,1).getSable(),0);
        j1.setNiv_eau(2);
        assertEquals(j1.getNiv_eau(),2);
        assertEquals(j2.getNiv_eau(),4);
        j1.explorer();
        Joueur j3= new Joueur(3,p, "j3", Carte.Personnage.PORTEUSE_D_EAU);
        assertEquals(j3.getNiv_eau(),5);

    }
}
