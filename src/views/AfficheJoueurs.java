package views;

import models.Joueur;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Set;

public class AfficheJoueurs extends JPanel {
    private models.Plateau p;
    private JLabel[] joueurs;
    private JLabel[] gourde;
    //class pour afficher les joueurs et leur niveau de gourde

    public AfficheJoueurs(models.Plateau plateau) {
        super();
        this.p=plateau;
        this.setBounds(0,0,150,75*p.getJoueurs().size());
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
        int nb = this.p.getJoueurs().size();
        this.joueurs = new JLabel[nb];
        this.gourde = new JLabel[nb];
        Set<Joueur> js = this.p.getJoueurs();
        for (Joueur j : js){
            JLabel casej = new JLabel();
            JLabel caseg = new JLabel();
            casej.setText(j.getName());
            casej.setIcon(new ImageIcon(j.getImg()));
            caseg.setText("Niveau de gourde : " + j.getNiv_eau());
            this.joueurs[j.getId()] = casej;
            this.gourde[j.getId()] = caseg;
            this.add(this.joueurs[j.getId()]);
            this.add(this.gourde[j.getId()]);
        }
    }

    public void setLabels(){
        Set<Joueur> J = p.getJoueurs();
        for (Joueur j : J){
            this.gourde[j.getId()].setText("Niveau de gourde : " + j.getNiv_eau());
        }
        this.repaint();
    }
}


