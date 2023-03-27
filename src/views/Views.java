package views;

public class Views {

    private IG.Fenetre fenetre;
    private AffichePlateau ap;

    public Views(String nom,models.Plateau p) {
        this.fenetre = new IG.Fenetre(nom);
        this.ap = new AffichePlateau(p);
    }

    public void affiche() {
        this.fenetre.ajouteElement(this.ap);
        this.fenetre.dessineFenetre();
    }

}
