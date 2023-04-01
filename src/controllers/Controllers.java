package controllers;

import models.Plateau;

public class Controllers extends IG.ZoneCliquable{

    private models.Plateau p;

    public Controllers(String texte, int x, int y) {
        super(texte, x, y);
    }

    boolean isDefaite(models.Plateau p){
        return p.getSablePlateau()>=43 || p.getNiv_tempete()>=7;
    }

    @Override
    public void clicGauche(){
        if (isDefaite(p)){
            print("Fin");
        }
    }

    private void print(String fin) {
    }

    @Override
    public void clicDroit() {

    }
}
