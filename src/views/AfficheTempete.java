package views;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AfficheTempete extends JPanel {
    private models.Plateau p;
    private JLabel label;

    public AfficheTempete(models.Plateau plateau){
        super();
        this.setBounds(0,0,150,30);
        this.p = plateau;
        this.label = new JLabel("Niveau tempête : "+this.p.getNiv_tempete());
        this.add(this.label);
        this.setBackground(Color.cyan);
        this.setBackground(new Color(0,max(255 - 36*(int)this.p.getNiv_tempete(),0),min(127 + 18*(int)this.p.getNiv_tempete(),255)));

    }

    public void setLabel(float niveau){
        this.label.setText("Niveau tempête : "+ niveau);
        this.setBackground(new Color(0,max(127 - 18*(int)(this.p.getNiv_tempete()),0),min(127 + 18*(int)this.p.getNiv_tempete(),255)));
        this.repaint();
    }

}
