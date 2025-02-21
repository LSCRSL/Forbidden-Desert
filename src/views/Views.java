package views;
import controllers.*;

import javax.swing.*;

public class Views {

    private JFrame fenetre;
    private JButton fdt;
    private JButton ramasser;
    private JButton creuser;
    private JButton explorer;
    private JButton deplacer;
    private JButton donner_eau;
    private JButton action_spe;

    private AffichePlateau ap;
    private AfficheTour act;
    private AfficheTempete niv;
    private AfficheSable sab;
    private AfficheJoueurs joueurs;
    private AffichePieces pieces;
    private AfficheCarteTempete carte;
    private AfficheInfos info;


    public Views(models.Plateau p) {
        this.fenetre = new JFrame("ForbiddenDesert");
        this.fenetre.setSize(700,700);
        this.fenetre.setLayout(null);

        this.ap = new AffichePlateau(p,this);

        this.fdt = new FinDeTour(this.ap.getPlateau(),this);
        this.explorer = new Explorer(this.ap.getPlateau());
        this.creuser = new Creuser(this.ap.getPlateau());
        this.ramasser = new Ramasser(this.ap.getPlateau());
        this.deplacer = new SeDeplacer(this.ap.getPlateau());
        this.donner_eau = new DonnerEau(this.ap.getPlateau(),this);
        this.action_spe = new ActionsSpeciales(this.ap.getPlateau(),this);

        this.act = new AfficheTour(this.ap.getPlateau());
        this.niv = new AfficheTempete(this.ap.getPlateau());
        this.sab= new AfficheSable(this.ap.getPlateau());
        this.joueurs = new AfficheJoueurs(this.ap.getPlateau());
        this.pieces = new AffichePieces(this.ap.getPlateau());
        this.carte = new AfficheCarteTempete(this.ap.getPlateau());
        this.info = new AfficheInfos();

    }

    public JFrame getFenetre() { return fenetre;}

    public AfficheTempete getNiv() {return this.niv;}

    public AfficheSable getSab(){ return  this.sab;}

    public AfficheTour getAct() {return this.act;}

    public AffichePieces getPieces() { return this.pieces;}

    public AfficheJoueurs getJoueurs() { return this.joueurs;}


    public AfficheCarteTempete getCarteTempete(){ return this.carte;}


    public void affiche() {
        this.fenetre.pack();
        this.fenetre.setSize(1920,1080);
        this.fenetre.setLocationRelativeTo(null);
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.ap.setLocation((this.fenetre.getWidth() - ap.getWidth())/2, (this.fenetre.getHeight() - ap.getHeight())/2);
        this.fenetre.add(ap);

        this.fdt.setLocation(this.fenetre.getWidth() - this.fenetre.getWidth()/9*2 ,this.fenetre.getHeight() - this.fenetre.getHeight()/4);
        this.fenetre.add(this.fdt);

        this.deplacer.setLocation(this.fenetre.getWidth()- this.fenetre.getWidth()/4,this.fenetre.getHeight() - this.fenetre.getHeight()/2 );
        this.fenetre.add(this.deplacer);

        this.creuser.setLocation(this.fenetre.getWidth() - this.fenetre.getWidth()/6,this.fenetre.getHeight() - this.fenetre.getHeight()/2);
        this.fenetre.add(this.creuser);

        this.explorer.setLocation(this.fenetre.getWidth() - this.fenetre.getWidth()/4,this.fenetre.getHeight() - this.fenetre.getHeight()/2 + this.fenetre.getHeight()/8);
        this.fenetre.add(this.explorer);

        this.ramasser.setLocation(this.fenetre.getWidth() - this.fenetre.getWidth()/6,this.fenetre.getHeight() - this.fenetre.getHeight()/2 + this.fenetre.getHeight()/8);
        this.fenetre.add(this.ramasser);

        if (this.ap.getPlateau().existePorteuse()) {
            this.donner_eau.setLocation(this.fenetre.getWidth() - this.fenetre.getWidth() / 12, this.fenetre.getHeight() - this.fenetre.getHeight() / 2);
            this.fenetre.add(this.donner_eau);
        }

        this.action_spe.setLocation(this.fenetre.getWidth() - this.fenetre.getWidth() / 12,this.fenetre.getHeight() - this.fenetre.getHeight()/2 + this.fenetre.getHeight()/8);
        this.fenetre.add(this.action_spe);

        this.niv.setLocation(this.fenetre.getWidth() - this.fenetre.getWidth()/5,this.fenetre.getHeight()/8);
        this.fenetre.add(this.niv);

        this.sab.setLocation(this.fenetre.getWidth() - this.fenetre.getWidth()/5,this.fenetre.getHeight()/8 + 2*sab.getHeight());
        this.fenetre.add(this.sab);

        this.act.setLocation(this.fenetre.getWidth()/2 - this.act.getWidth()/2 ,act.getHeight()/6);
        this.fenetre.add(this.act);

        this.joueurs.setLocation(30, 30);
        this.fenetre.add(this.joueurs);

        this.pieces.setLocation(50,this.fenetre.getHeight() - this.fenetre.getHeight()/2);
        this.fenetre.add(this.pieces);

        this.carte.setLocation(this.fenetre.getWidth() - this.fenetre.getWidth()/9*2 - this.carte.getWidth()/8,this.fenetre.getHeight()-this.fenetre.getHeight()/7 - this.carte.getHeight()/4);
        this.fenetre.add(this.carte);

        this.info.setLocation(30,this.fenetre.getHeight() - this.fenetre.getHeight()/3 + 150);
        this.fenetre.add(this.info);

    }

}
