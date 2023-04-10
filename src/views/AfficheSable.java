package views;

import javax.swing.*;

public class AfficheSable extends JPanel {
    private models.Plateau p;
    private JLabel label;

    public AfficheSable(models.Plateau plateau){
        super();
        this.p=plateau;
        this.label= new JLabel("Niveau sable: "+ this.p.getSablePlateau());
        this.add(this.label);
    }
    public void setLabels(float nivs){
        this.label.setText("Niveau sable: "+ nivs);
        this.repaint();
    }

}

