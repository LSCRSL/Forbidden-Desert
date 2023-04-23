package views;

import models.Carte;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class AfficheCarteTempete extends JPanel{
    private models.Plateau p;
    private JLabel label;
    private JLabel carte1;
    private JLabel carte2;
    private JLabel carte3;
    private JLabel carte4;

    public AfficheCarteTempete(models.Plateau plateau){
        super();
        this.setBounds(0,0,350,100);
        this.setBackground(new Color(	180,220,255));
        this.p = plateau;
        this.label = new JLabel("Nombre de cartes à piocher: " + p.getNbCartesT());
        this.add(this.label);
        this.carte1=new JLabel("              ");
        this.add(this.carte1);
        this.carte2=new JLabel("");
        this.add(this.carte2);
        this.carte3=new JLabel("");
        this.add(this.carte3);
        this.carte4=new JLabel("");
        this.add(this.carte4);
    }

    public void setLabel(){
        this.label.setText("Nombre de cartes à piocher: " + p.getNbCartesT());
        this.repaint();
    }

    public void setCartes(String e){
        e=e+": "+": "+": "+": ";
        String[] l= e.split(":");
        this.carte1.setText("Cartes piochées:    "+l[0]);
        this.carte2.setText(l[1]+"   "+l[2]);
        this.carte3.setText(l[3]+"   "+l[4]);
        this.carte4.setText(l[5]);
        this.repaint();
    }

}
