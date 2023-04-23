import junit.framework.TestCase;
import models.Case;
import models.Plateau;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PlateauTests extends TestCase {

    public void test() throws Exception {
        models.Plateau p= new Plateau(5);
        assertEquals(p.getNiv_tempete(),(float) 2.0);
        assertEquals(p.getSablePlateau(),8);
        p.dechainer();
        p.setSable(9);
        assertEquals(p.getNiv_tempete(),(float) 2.5);
        assertEquals(p.getSablePlateau(),9);
        Set<Case.Piece> test= new HashSet<>();
        assertEquals(p.getPiecesRecup(),test);
        test.add(Case.Piece.HELICE);
        p.addPiecesRecup(Collections.singleton(Case.Piece.HELICE));
        assertEquals(test, p.getPiecesRecup());
        assertEquals(p.getCase(2,2).getType(), Case.TYPE.OEIL);
        p.souffler(Case.Dir.HAUT,2);
        assertFalse(p.getCase(2,2).getType()== Case.TYPE.OEIL);

    }
}

