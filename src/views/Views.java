package views;
import controllers.FinDeTour;

import javax.swing.JButton;

public class Views {

    private IG.Fenetre fenetre;
    private AffichePlateau ap;
    private JButton bouton;
    private AfficheTempete niv;

    public Views(String nom,models.Plateau p) {
        this.fenetre = new IG.Fenetre(nom);
        this.ap = new AffichePlateau(p);
        this.fenetre.setLocationRelativeTo(null);
        this.bouton = new FinDeTour(this.ap.getPlateau(),this);
        this.niv = new AfficheTempete(this.ap.getPlateau());

    }

    public AfficheTempete getNiv() {return this.niv;}

    public void affiche() {
        this.fenetre.ajouteElement(this.ap);
        this.fenetre.ajouteElement(this.bouton);
        this.fenetre.ajouteElement(this.niv);
        this.fenetre.dessineFenetre();
    }

}
