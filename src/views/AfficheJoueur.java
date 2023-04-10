package views;

import javax.swing.*;
import java.awt.*;

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
