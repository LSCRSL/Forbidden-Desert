package views;

import javax.swing.*;
import java.awt.*;

public class AfficheFin extends JPanel {
    private models.Plateau p;
    private Views v;
    private JLabel label;

    private String str;

    public AfficheFin(models.Plateau plateau){
        super();
        this.p = plateau;
        this.setBounds(0,0,150, 30);
        str="   ";
        this.label = new JLabel(str);
        this.add(this.label);
    }

    public void setLabel(String str,int f){
        this.label.setText(str);
        if (f==1){
            this.setBackground(Color.green);
        }else if (f==0){
            this.setBackground(Color.red);
        }
        this.repaint();
    }

}