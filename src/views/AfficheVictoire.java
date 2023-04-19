package views; //test pour afficher une fenêtre popup
// fonctionne bien mais pas au bon moment

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AfficheVictoire extends JFrame implements ActionListener {
    private JFrame f;

    // panel
    private JLabel l;

    // constructor
    AfficheVictoire() {
        // create a frame
        f = new JFrame("Victoire");

        f.setSize(400, 200);
        JOptionPane.showMessageDialog(f, "C'est gagné!");
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String d = e.getActionCommand();
        // if ok button is pressed hide the popup

    }
}
