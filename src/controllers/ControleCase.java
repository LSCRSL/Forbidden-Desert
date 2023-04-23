package controllers;

import models.Case;
import models.Plateau;
import models.Joueur;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class ControleCase extends IG.ZoneCliquable {
    private final models.Case c;
    private models.Plateau p;
    private views.Views v;

    public ControleCase(models.Case c, Plateau plateau, views.Views view) {
        super("",150,150);
        this.p = plateau;
        int sable = c.getSable();
        if (c.isExploree()) {
            this.changeTexte(sable + "*");
        }
        if(c.getType()!= Case.TYPE.OEIL) {
            this.changeTexte(Integer.toString(sable));
        }
        this.c = c;
        this.v = view;
    }

    public Case getC() {
        return c;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image s = new ImageIcon("resources/sand.jpg").getImage();
        int x7 = (this.getWidth() - s.getWidth(null)) / 2;
        int y7 = (this.getHeight() - s.getHeight(null)) / 2;
        g.drawImage(s,x7,y7,null);
        switch (c.getType()) {
            case ENGRENAGE:
                if (c.isExploree()) {
                    Image oa1 = new ImageIcon("resources/engrenage.png").getImage();
                    int x2 = (this.getWidth() - oa1.getWidth(null)) / 2;
                    int y2 = (this.getHeight() - oa1.getHeight(null)) / 2;
                    g.drawImage(oa1,x2,y2,null);
                }
                break;
            case CRASH:
                Image cr = new ImageIcon("resources/crash.png").getImage();
                int x4 = (this.getWidth() - cr.getWidth(null)) / 3;
                int y4 = (this.getHeight() - cr.getHeight(null)) / 3;
                g.drawImage(cr,x4,y4,null);
                break;
            case NORMALE:
                break;
            case TUNNEL:
                if (c.isExploree()) {
                    Image tun = new ImageIcon("resources/tunnel.png").getImage();
                    int x3 = (this.getWidth() - tun.getWidth(null)) / 2;
                    int y3 = (this.getHeight() - tun.getHeight(null)) / 2;
                    g.drawImage(tun,x3,y3,null);
                }
                break;
            case OASIS:
                Image oa = new ImageIcon("resources/oasis.png").getImage();
                int x = (this.getWidth() - oa.getWidth(null)) /2; //on soustrait par case/2 pour centrer
                int y = (this.getHeight() - oa.getHeight(null)) /2;
                g.drawImage(oa,x,y,null);
                break;
            case MIRAGE:
                if (!c.isExploree()) {
                    Image oa1 = new ImageIcon("resources/oasis.png").getImage();
                    int x2 = (this.getWidth() - oa1.getWidth(null)) / 2;
                    int y2 = (this.getHeight() - oa1.getHeight(null)) / 2;
                    g.drawImage(oa1,x2,y2,null);
                }else{
                    Image oa1 = new ImageIcon("resources/mirage.png").getImage();
                    int x2 = (this.getWidth() - oa1.getWidth(null)) / 4;
                    int y2 = (this.getHeight() - oa1.getHeight(null)) / 4;
                    g.drawImage(oa1,x2,y2,null);

                }
                break;
            case OEIL:
                Image tornade = new ImageIcon("resources/tornade.png").getImage();
                int x1 = (this.getWidth() - tornade.getWidth(null)) / 2;
                int y1 = (this.getHeight() - tornade.getHeight(null)) / 2;
                g.drawImage(tornade,x1,y1,null);
                break;
            case DECOLLAGE:
                if (c.isExploree()) {
                    Image oa1 = new ImageIcon("resources/decollage.png").getImage();
                    int x2 = (this.getWidth() - oa1.getWidth(null)) / 2;
                    int y2 = (this.getHeight() - oa1.getHeight(null)) / 2;
                    g.drawImage(oa1,x2,y2,null);
                }
                break;
            case INDICE:
                if (c.isExploree()) {
                    Set<Case.Piece> p = c.getPiece();
                    for (Case.Piece piece : p ){
                        switch (piece){
                            case SYSTEME_DE_NAVIGATION:
                                Image image = new ImageIcon("resources/systemeNavigation.png").getImage();
                                int X = (this.getWidth() - image.getWidth(null)) / 2;
                                int Y = (this.getHeight() - image.getHeight(null)) / 2;
                                g.drawImage(image,X,Y,null);
                                break;
                            case HELICE:
                                Image image1 = new ImageIcon("resources/helice.png").getImage();
                                int X1 = (this.getWidth() - image1.getWidth(null)) / 2;
                                int Y1 = (this.getHeight() - image1.getHeight(null)) / 2;
                                g.drawImage(image1,X1,Y1,null);
                                break;
                            case CRISTAL_D_ENERGIE:
                                Image image2 = new ImageIcon("resources/bouleCristal.png").getImage();
                                int X2 = (this.getWidth() - image2.getWidth(null)) / 2;
                                int Y2 = (this.getHeight() - image2.getHeight(null)) / 2;
                                g.drawImage(image2,X2,Y2,null);
                                break;
                            case BOITE_DE_VITESSE:
                                Image image3 = new ImageIcon("resources/boiteVitesse.png").getImage();
                                int X3 = (this.getWidth() - image3.getWidth(null)) / 2;
                                int Y3 = (this.getHeight() - image3.getHeight(null)) / 2;
                                g.drawImage(image3,X3,Y3,null);
                                break;
                        }
                    }
                }
                break;
        }
        Set<Joueur> pers = c.getJ();
        Image img ;
        int nb = this.c.getJ().size();
        int k = 0;
        for (Joueur j : pers) {
            img = j.getImg();
            switch (nb) {
                case 1: g.drawImage(img,0,0,null); break;
                case 2: if (k == 0) g.drawImage(img,0,0,null); else g.drawImage(img,100,0,null); break;
                case 3: if (k == 0) g.drawImage(img,0,0,null); if (k==1) g.drawImage(img,100,0,null); else g.drawImage(img,0,100,null); break;
                case 4: if (k == 0) g.drawImage(img,0,0,null); if (k==1) g.drawImage(img,100,0,null); if (k==2) g.drawImage(img,0,100,null); else g.drawImage(img,100,100,null); break;
                case 5: if (k == 0) g.drawImage(img,0,0,null); if (k==1) g.drawImage(img,100,0,null); if (k==2) g.drawImage(img,0,100,null); if (k==3) g.drawImage(img,100,100,null); else g.drawImage(img,50,100,null); break;
            }
            k++;
        }
    }

    public void refresh() {
        int sable = this.c.getSable();
        if(this.c.getType() == Case.TYPE.OEIL) {
            this.changeTexte(" ");
        }else{
            if (this.c.isExploree()) {
                if (this.c.getType()== Case.TYPE.INDICE){
                    this.changeTexte(this.c.strPiece()+sable +"* "+this.c.getIndice());
                }else{
                    this.changeTexte(this.c.strPiece()+sable + "* ");
                }
            } else {
                this.changeTexte(this.c.strPiece()+sable);
            }
        }
        this.repaint();
    }

    @Override
    public void clicGauche() {
        Set<Joueur> J = this.p.getJoueurs();
        for (Joueur j : J ) {
            if (j.isMon_tour()  && j.getNb_action() > 0) {
                if (p.getAction() == 0 && (j.CaseVoisine(c) || (j.getPos().getType()==Case.TYPE.TUNNEL
                        && c.getType()==Case.TYPE.TUNNEL && c.isExploree() && j.getPos().isExploree())) ) {
                    if (j.deplaceC(c)){
                        j.decremente_action();
                    }

                    this.v.getAct().setLabels(j);
                }
                if (p.getAction() == 1 && (j.CaseVoisine(c) || j.getPos() == c) && this.getC().getSable() > 0 ) {
                    j.creuser(c);
                    j.decremente_action();
                    this.v.getAct().setLabels(j);
                    this.v.getSab().setLabels(this.p.getSablePlateau());
                }
                //
                if (p.getAction() == 2) {
                    if (j.explorer()) {
                        j.decremente_action();
                    }
                    this.v.getAct().setLabels(j);
                    this.v.getJoueurs().setLabels();
                }

                if (p.getAction() == 3 && j.getPos() == c && c.isExploree() && c.getSable()<2) {
                    Set<Case.Piece> pc = j.ramasserPiece();
                    this.v.getPieces().setLabels(pc);
                    if (pc.size() != 0){
                        j.decremente_action();
                    }
                    this.v.getAct().setLabels(j);
                }
            }

        }
        for (int i=0; i<p.getTaille();i++){
            for (int j=0; j<p.getTaille();j++){
                p.getCase(i,j).getCc().refresh();
            }
        }
    }

    @Override
    public void clicDroit() {}

    @Override
    public void repaint() {
        super.repaint();
    }
}
