package views;

import javax.swing.*;
import java.awt.*;

public class AfficheActions extends JPanel{
        private models.Plateau p;
        private JLabel label;

        public AfficheActions(models.Plateau plateau){
            super();
            this.setBounds(0,0,250,30);
            this.setBackground(Color.magenta);
            this.p=plateau;
            this.label= new JLabel("Nombre d'actions restantes: "+ "4");
            this.add(this.label);
        }
        public void setLabels(int action){
            this.label.setText("Nombre d'actions restantes: "+ action);
            this.repaint();
        }

}

