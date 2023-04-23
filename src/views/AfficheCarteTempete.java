package views;

import javax.swing.*;
import java.awt.*;

public class AfficheCarteTempete extends JPanel{
    private models.Plateau p;
    private JLabel label;

    public AfficheCarteTempete(models.Plateau plateau){
        super();
        this.setBounds(0,0,200,40);
        this.p = plateau;
        this.label = new JLabel("Nombre de cartes à piocher: " + p.getNbCartesT());
        this.add(this.label);

    }

    public void setLabel(){
        this.label.setText("Nombre de cartes à piocher: " + p.getNbCartesT());
        this.repaint();
    }

}
