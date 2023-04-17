package views;
import controllers.*;

import javax.swing.*;
import java.awt.*;

//ajouter un bouton annuler et valider pour les actions
public class Views {

    private JFrame fenetre;
    private JButton fdt;
    private JButton ramasser;
    private JButton creuser;
    private JButton explorer;
    private JButton deplacer;
    private JButton valider;
    private JButton annuler;


    private AffichePlateau ap;
    private AfficheActions act;
    private AfficheTempete niv;
    private AfficheSable sab;
    private AfficheFin fin;


    public Views(String nom,models.Plateau p) {
        int[] o = p.getOeil();
        //this.fenetre = new IG.Fenetre(nom);
        this.fenetre = new JFrame("ForbiddenDesert");
        this.fenetre.setSize(700,700);
        this.fenetre.setLayout(null);

        this.ap = new AffichePlateau(p);

        this.fdt = new FinDeTour(this.ap.getPlateau(),this);
        this.explorer = new Explorer(this.ap.getPlateau(),this);
        this.creuser = new Creuser(this.ap.getPlateau(),this);
        this.ramasser = new Ramasser(this.ap.getPlateau(),this);
        this.deplacer = new SeDeplacer(this.ap.getPlateau(),this);
        this.valider = new Valider(this.ap.getPlateau(),this);
        this.annuler = new Annuler(this.ap.getPlateau(),this);

        this.act = new AfficheActions(this.ap.getPlateau());
        this.niv = new AfficheTempete(this.ap.getPlateau());
        this.sab= new AfficheSable(this.ap.getPlateau());
        this.fin= new AfficheFin(this.ap.getPlateau());


    }

    public AfficheTempete getNiv() {return this.niv;}

    public AfficheSable getSab(){ return  this.sab;}

    public AfficheActions getAct() {return this.act;}

    public AfficheFin getFin() {
        return this.fin;
    }

    public void affiche() {
        //this.fenetre.add(this.ap);
        this.fenetre.pack();
        this.fenetre.setSize(1920,1080);
        this.fenetre.setLocationRelativeTo(null);
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.ap.setLocation((this.fenetre.getWidth() - ap.getWidth())/2, (this.fenetre.getHeight() - ap.getHeight())/2);
        this.fenetre.add(ap);

        this.fdt.setLocation(1150,700);
        this.fenetre.add(this.fdt);

        this.deplacer.setLocation(1100,390);
        this.fenetre.add(this.deplacer);

        this.creuser.setLocation(1200,390);
        this.fenetre.add(this.creuser);

        this.explorer.setLocation(1100,440);
        this.fenetre.add(this.explorer);

        this.ramasser.setLocation(1200,440);
        this.fenetre.add(this.ramasser);

        this.valider.setLocation(1100,510);
        this.valider.setBackground(Color.GREEN);
        this.fenetre.add(this.valider);

        this.annuler.setLocation(1200,510);
        this.annuler.setBackground(Color.RED);
        this.fenetre.add(this.annuler);

        this.niv.setLocation(1150,100);
        this.fenetre.add(this.niv);

        this.sab.setLocation(1150,140);
        this.fenetre.add(this.sab);

        this.act.setLocation(600,30);
        this.fenetre.add(this.act);
        //this.fenetre.ajouteElement(this.fin);

    }

}
