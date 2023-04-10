package views;
import controllers.FinDeTour;

import javax.swing.JButton;

public class Views {

    private IG.Fenetre fenetre;
    private AffichePlateau ap;
    private JButton bouton;
    private AfficheTempete niv;
    private AfficheSable sab;
    private AfficheFin fin;


    public Views(String nom,models.Plateau p) {
        this.fenetre = new IG.Fenetre(nom);
        this.ap = new AffichePlateau(p);
        this.fenetre.setLocationRelativeTo(null);
        this.bouton = new FinDeTour(this.ap.getPlateau(),this);
        this.niv = new AfficheTempete(this.ap.getPlateau());
        this.sab= new AfficheSable(this.ap.getPlateau());
        this.fin= new AfficheFin(this.ap.getPlateau());

    }

    public AfficheTempete getNiv() {return this.niv;}

    public AfficheSable getSab(){ return  this.sab;}

    public AfficheFin getFin() {
        return this.fin;
    }

    public void affiche() {
        this.fenetre.ajouteElement(this.ap);
        this.fenetre.ajouteElement(this.bouton);
        this.fenetre.ajouteElement(this.niv);
        this.fenetre.ajouteElement(this.sab);
        //this.fenetre.ajouteElement(this.fin);
        this.fenetre.dessineFenetre();
    }

}
