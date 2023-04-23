import junit.framework.TestCase;

import models.Carte;
import models.Case;
import models.Joueur;
import models.Plateau;

import java.util.HashSet;
import java.util.Set;

public class CaseTests extends TestCase {
    public void test() throws Exception {
        models.Plateau p=new Plateau(5);
        Case a= p.getCase(0,0);
        assertEquals(a.getSable(),0);
        Case b= p.getCase(2,0);
        assertEquals(b.getSable(),1);
        assertFalse(b.isExploree());
        b.explorer();
        assertTrue(b.isExploree());
        a.ensabler();
        assertEquals(a.getSable(), b.getSable());
        b.dessabler();
        assertEquals(b.getSable(),0);
        Case oeil= new Case(2,2,p,Case.TYPE.OEIL);
        assertEquals(oeil.getSable(),0);
        assertEquals(oeil.getX(), 2);
        assertEquals(oeil.getY(), 2);
        Joueur toto=new Joueur(1, p, "Toto", Carte.Personnage.PORTEUSE_D_EAU);
        a.addJ(toto);
        Set<Joueur> test= new HashSet<>();
        assertEquals(a.getPiece(),test);
        assertEquals(b.getJ(),test);
        test.add(toto);
        assertEquals(a.getJ(), test);
        assertFalse(b.isVoisine(a));
        Case c=p.getCase(0,1);
        assertTrue(a.isVoisine(c));
        assertFalse(a.isAlpiniste());
        Joueur nav= new Joueur(2,p,"Nav", Carte.Personnage.ALPINISTE);
        a.addJ(nav);
        assertTrue(a.isAlpiniste());
        a.addPiece(Case.Piece.HELICE);
        Set<Case.Piece> testP= new HashSet<>();
        testP.add(Case.Piece.HELICE);
        assertEquals(a.getPiece(), testP);




    }
}
