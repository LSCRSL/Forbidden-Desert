package views;

//import sun.rmi.runtime.NewThreadAction;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AfficheSable extends JPanel {
    private models.Plateau p;
    private JLabel label;

    public AfficheSable(models.Plateau plateau){
        super();
        this.setBounds(0,0,160,30);
        this.p=plateau;
        this.label= new JLabel("Niveau sable: "+ this.p.getSablePlateau());
        this.add(this.label);
        this.setBackground(new Color(min(5*this.p.getSablePlateau(),255),max(255 - 5*this.p.getSablePlateau(),0),0));
    }
    public void setLabels(int nivs){
        this.label.setText("Niveau sable: "+ nivs);
        this.setBackground(new Color(5*nivs,255 - 5*nivs,0));
        this.repaint();
    }

}

