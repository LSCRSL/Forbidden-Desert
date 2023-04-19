package views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
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
        this.setBounds(0,0,150,200);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
        this.p=plateau;
        this.label= new JLabel(" Pièces trouvées: \n");
        this.piece1 = new JLabel("\n");
        this.piece2 = new JLabel("\n");
        this.piece3 = new JLabel("\n");
        this.piece4 = new JLabel("\n");
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
                    piece1.setText("Boite de vitesse\n");
                    break;
                case HELICE:
                    piece2.setText("Hélice\n");
                    break;
                case CRISTAL_D_ENERGIE:
                    piece3.setText("Cristal d'énergie\n");
                    break;
                case SYSTEME_DE_NAVIGATION:
                    piece4.setText("Système de navigation\n");
                    break;
            }
        }
        this.repaint();
    }
}
