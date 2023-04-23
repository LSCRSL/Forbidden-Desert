package views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.ColorConvertOp;
import java.util.Set;

import models.Case;
import models.Plateau;

public class AffichePieces extends JPanel {

    private models.Plateau p;
    private JLabel label;
    private JLabel piece1;
    private JLabel piece2;
    private JLabel piece3;
    private JLabel piece4;



    public AffichePieces(models.Plateau plateau){
        super();
        this.setBounds(0,0,200,250);
        this.setBackground(new Color(	222,184,135));
        this.p=plateau;
        this.label= new JLabel(" Pièces trouvées: \n");
        this.piece1 = new JLabel("Boite de vitesse\n");
        this.piece2 = new JLabel("Hélice\n");
        this.piece3 = new JLabel("Cristal d'énergie\n");
        this.piece4 = new JLabel("Système de navigation\n");
        piece1.setForeground(Color.GRAY);
        piece2.setForeground(Color.GRAY);
        piece3.setForeground(Color.GRAY);
        piece4.setForeground(Color.GRAY);
        piece1.setIcon(new ImageIcon("resources/boiteVitesseNB.png"));
        piece2.setIcon(new ImageIcon("resources/heliceNB.png"));
        piece3.setIcon(new ImageIcon("resources/bouleCristalNB.png"));
        piece4.setIcon(new ImageIcon("resources/systemeNavigationNB.png"));
        this.add(this.label);
        this.add(this.piece1);
        this.add(this.piece2);
        this.add(this.piece3);
        this.add(this.piece4);



    }
    public void setLabels(Set<Case.Piece> cp){
        for (Case.Piece c : cp) {
            switch(c) {
                case BOITE_DE_VITESSE:
                    piece1.setForeground(Color.black);
                    piece1.setIcon(new ImageIcon("resources/boiteVitesse.png"));
                    break;
                case HELICE:
                    piece2.setForeground(Color.black);
                    piece2.setIcon(new ImageIcon("resources/helice.png"));
                    break;
                case CRISTAL_D_ENERGIE:
                    piece3.setForeground(Color.black);
                    piece3.setIcon(new ImageIcon("resources/bouleCristal.png"));
                    break;
                case SYSTEME_DE_NAVIGATION:
                    piece4.setForeground(Color.black);
                    piece4.setIcon(new ImageIcon("resources/systemeNavigation.png"));
                    break;
            }
        }
        this.repaint();
    }
}
