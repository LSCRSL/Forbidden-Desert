package views;

import models.Joueur;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

public class AfficheJoueurs extends JPanel {
    private models.Plateau p;
    private JLabel[] joueurs;
    private JLabel[] gourde;
    //class pour afficher les joueurs et leur niveau de gourde

    public AfficheJoueurs(models.Plateau plateau) {
        super();
        this.p=plateau;
        this.setBounds(0,0,250,70*p.getJoueurs().size());
        this.setBackground(new Color(	222,184,135));
        int nb = this.p.getJoueurs().size();
        this.joueurs = new JLabel[nb];
        this.gourde = new JLabel[nb];
        Set<Joueur> js = this.p.getJoueurs();
        for (Joueur j : js){
            JLabel casej = new JLabel("",SwingConstants.LEFT);
            JLabel caseg = new JLabel("",SwingConstants.LEFT);
            casej.setText(j.getName() + ": " + System.lineSeparator() + j.getPerso().toString());
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


