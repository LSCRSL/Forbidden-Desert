package views;

import javax.swing.*;
import java.awt.*;

public class AfficheCarteTempete extends JPanel{
    private models.Plateau p;
    private JLabel label;

    public AfficheCarteTempete(models.Plateau plateau){
        super();
        this.setBounds(0,0,180,40);
        this.p = plateau;
        this.label = new JLabel("" + p.getNbCartesT());
        this.add(this.label);

    }

    public void setLabel(){
        this.label.setText("" + p.getNbCartesT());
        this.repaint();
    }

}
