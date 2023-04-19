package views;

import models.Joueur;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
//à combiner avec AfficheTourJoueurs
public class AfficheTour extends JPanel{
        private models.Plateau p;
        private JLabel action;
        private Joueur j;
        private JLabel joueur;
        private JLabel img;

        public AfficheTour(models.Plateau plateau){
            super();
            this.setBounds(0,0,200,70);
            Border blackline = BorderFactory.createLineBorder(Color.black);
            this.setBorder(blackline);
            this.p=plateau;
            this.action= new JLabel("Nombre d'actions restantes: "+ "4 \n");
            this.j = p.getJoueur_i(0);
            this.joueur= new JLabel("Au tour de : " + j.getName());
            this.add(this.joueur);
            this.img = new JLabel(new ImageIcon(j.getImg()));
            this.add(img);
            this.add(this.action);
        }
        public void setLabels(Joueur J){
            this.j = J;
            this.action.setText("Nombre d'actions restantes: "+ j.getNb_action() + "\n");
            this.joueur.setText("Au tour de : "+ J.getName());
            this.img.setIcon(new ImageIcon(J.getImg()));
            this.repaint();
        }

}

