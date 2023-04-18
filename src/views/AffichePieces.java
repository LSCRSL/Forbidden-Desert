package views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import models.Case;
import models.Plateau;

public class AffichePieces extends JPanel {

    private models.Plateau p;
    private JLabel label;


    public AffichePieces(models.Plateau plateau){
        super();
        this.setBounds(0,0,150,200);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
        this.p=plateau;
        this.label= new JLabel("Pièces trouvées: ");
        this.add(this.label);
    }
    public void setLabels(){
        String lab="Pièces trouvées : \n";
        for(Case.Piece pm : p.getPiecesRecup()){
            lab=lab+p.getStrPiece(pm)+" \n";
        }
        this.label.setText(lab);
        this.repaint();
    }

}
