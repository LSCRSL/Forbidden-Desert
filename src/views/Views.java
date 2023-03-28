package views;
import javax.swing.JButton;

public class Views {

    private IG.Fenetre fenetre;
    private AffichePlateau ap;
    private JButton bouton = new JButton("fin de tour");

    public Views(String nom,models.Plateau p) {
        this.fenetre = new IG.Fenetre(nom);
        this.ap = new AffichePlateau(p);
        this.fenetre.setLocationRelativeTo(null);
    }

    public void affiche() {
        this.fenetre.ajouteElement(this.ap);
        this.fenetre.ajouteElement(this.bouton);
        this.fenetre.dessineFenetre();
    }

}
