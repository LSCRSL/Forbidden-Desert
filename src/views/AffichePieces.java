package views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AffichePieces extends JPanel {

    private models.Plateau p;
    private JLabel label;


    public AffichePieces(models.Plateau plateau){
        super();
        this.setBounds(0,0,150,30);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
        this.p=plateau;
        this.label= new JLabel("Pièces trouvées: ");
        this.add(this.label);
    }
    public void setLabels(){
        this.label.setText("Pièces trouvées : ");
        /**
        if (//piece decouverte)
            this.label.setText("nom_piece");
         **/
        this.repaint();
    }

}
