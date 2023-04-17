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

    public ControleCase(models.Case c) {
        super("",150,150);
        int sable = c.getSable();
        if (c.isExploree()) {
            this.changeTexte(Integer.toString(sable) + "*");
        }
        if(c.getType()!= Case.TYPE.OEIL) {
            this.changeTexte(Integer.toString(sable));
        }
        this.c = c;
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
                    //mettre image
                    g.setColor(new Color(128, 128, 128));
                    g.fillRect(0, 0, getWidth(), getHeight());
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
                //rectangle coloré
                //g.setColor(new Color(220, 158, 0, 255));
                //g.fillRect(0, 0, getWidth(), getHeight());break;
            case INDICE:
                if (c.isExploree()) {
                    //mettre image de l'indice
                    g.setColor(new Color(220, 158, 0, 255));
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
                break;
            case TUNNEL:
                if (c.isExploree()) {
                    Image tun = new ImageIcon("resources/tunnel3.png").getImage();
                    int x3 = (this.getWidth() - tun.getWidth(null)) / 2;
                    int y3 = (this.getHeight() - tun.getHeight(null)) / 2;
                    g.drawImage(tun,x3,y3,null);
                }
                break;
            case OASIS:
                Image oa = new ImageIcon("resources/oasis.png").getImage();
                int x = (this.getWidth() - oa.getWidth(null)) /4; //on soustrait par case/2 pour centrer
                int y = (this.getHeight() - oa.getHeight(null)) /4;
                g.drawImage(oa,x,y,null);
                break;
            case MIRAGE:
                if (!c.isExploree()) {
                    Image oa1 = new ImageIcon("resources/oasis.png").getImage();
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
                    g.setColor(new Color(0,255,0));
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
                break;
        }
        Set<Joueur> pers = c.getJ();
        Image mumu = new ImageIcon("resources/mumu.png").getImage();
        for (Joueur j : pers) {
            //g.drawString(j.getName(), 20, 20);
            int x1 = (this.getWidth() - mumu.getWidth(null)) / 2;
            int y1 = (this.getHeight() - mumu.getHeight(null)) / 2;
            g.drawImage(mumu,0,0,null);
        }

    }


    public void refresh() {
        int sable = this.c.getSable();
        if(this.c.getType()== Case.TYPE.OEIL) {
            this.changeTexte(" ");
        }else{
            if (this.c.isExploree()) {
                if (this.c.getType()== Case.TYPE.INDICE){
                    this.changeTexte(this.c.strPiece()+Integer.toString(sable) +"* "+this.c.getIndice());
                }else{
                    this.changeTexte(this.c.strPiece()+Integer.toString(sable) + "* ");
                }
            } else {
                this.changeTexte(this.c.strPiece()+Integer.toString(sable));
            }
        }
        repaint();

    }

    @Override
    public void clicGauche() {
        System.out.println("OK1");
        //ai juste fait ça pour qu'on clique et que la case soit explorée

        if( !c.isExploree()){
            c.setExploree();
        }
        /*System.out.println("OKk");
        //p.affichePiece(); //NE MARCHE PAS
        Case C = p.getCase(2,2);
        System.out.println("OK2");
        Set<Joueur> J = C.getJ();
        System.out.println("OK3");
        for (Joueur j : J) {
            System.out.println(j.getPos());
            j.deplaceC(C);
            System.out.println(j.getPos());

            c.addJ(j);
        }*/

        this.refresh();
    }

    @Override
    public void clicDroit() {}

    @Override
    public void repaint() {
        super.repaint();
    }
}
