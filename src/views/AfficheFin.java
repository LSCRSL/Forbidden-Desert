package views;

import javax.swing.*;

public class AfficheFin extends JPanel {
    private models.Plateau p;
    private JLabel label;

    private String str;

    public AfficheFin(models.Plateau plateau){
        super();
        this.p = plateau;
        str="";
        if (/*this.p.isDefaite()*/ true){ //VALEURS A MODIFIER QUAND ON AURA FAIT LES METHODES DANS CONTROLLERS
            str="Perdu...";
        }
        if (/*this.p.isGagne()*/ false){
            str="Gagné!";
        }
        this.label = new JLabel(str);
        this.add(this.label);
    }

    public void setLabel(String str){
        this.label.setText(str);
        this.repaint();
    }

}