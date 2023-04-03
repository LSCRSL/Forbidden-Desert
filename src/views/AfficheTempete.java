package views;

import javax.swing.*;

public class AfficheTempete extends JPanel {
    private models.Plateau p;
    private JLabel label;

    public AfficheTempete(models.Plateau plateau){
        super();
        this.p = plateau;
        this.label = new JLabel("Niveau tempête : "+this.p.getNiv_tempete());
        this.add(this.label);
    }

    public void setLabel(float niveau){
        this.label.setText("Niveau tempête : "+ niveau);
        this.repaint();
    }

}
