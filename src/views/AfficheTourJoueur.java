package views;

import javax.swing.*;
import javax.swing.border.Border;

import models.Joueur;
import models.Plateau;

import java.awt.*;

/**
public class AfficheJoueur extends JPanel { //NE MARCHE PAS
    private JFrame frame= new JFrame("J1");
    JPanel jp=new AfficheJoueur();

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor( new Color (200,150, 220));
        g2.fillRect(10,10,200,50);
        g2.setColor( new Color(0,0,0));
        g2.drawString("J1", 20, 20);
    }
}
 **/
//a faire plus tard

public class AfficheTourJoueur extends JPanel {

    private Plateau p;
    private Joueur j;
    private JLabel joueur;

    public AfficheTourJoueur(models.Plateau pla) {
        super();
        this.setBounds(0,0,150,30);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
        this.p = pla;
        this.j = p.getJoueurs().get(0);
        this.joueur= new JLabel("Au tour de : " + j.getName());
        this.add(this.joueur);
    }

    public void setLabels(Joueur J){
        this.j = J;
        this.joueur.setText("Au tour de : "+ j.getName());
        this.repaint();


    }


}
