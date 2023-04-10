package models;

public class Joueur {
    //Attributs
    private static int id;
    private int niv_eau;

    private models.Plateau p;

    private static String name;

    private Carte.Personnage perso;

    private int x, y;

    private String description="";

    //Constructeur
    public Joueur(int i, models.Plateau p, String nom, Carte.Personnage per){
        this.id=i;
        this.p=p;
        this.niv_eau=4;
        this.name=nom;
        this.perso=per;
        this.x=this.p.getCrash()[0];
        this.y=this.p.getCrash()[1];
    }

    //Getters
    public String getName(){
        return this.name;
    }
    public int getNiv_eau(){
        return this.niv_eau;
    }

    public models.Case getCase(){
        return this.p.getCase(this.x, this.y);
    }

    //Setters
    public static void setName(String name) {
        Joueur.name = name;
    }

    public void setNiv_eau(int niv_eau) {
        this.niv_eau = niv_eau;
    }

    public void setPos(int[] pos){
        this.x=pos[0];
        this.y=pos[1];
    }

    //Méthodes
    public String giveDescription(){
        return "";
    }

    public void explorer(Case c){
        c.explorer();
    }

    public void deplacer(Case.Dir d){
        models.Case c=this.getCase();
        models.Case newC=c.voisine(d);
        int[] ncc=newC.getCoord();
        if (c.getCoord()!=ncc){
            this.x=ncc[0];
            this.y=ncc[1];
        }else{
            throw new RuntimeException("Deplacement impossible.");
        }
    }

    public void dessabler(Case c){
        c.dessabler();
    }

    public void boire(){
        setNiv_eau(getNiv_eau()-1);
    }

    public void remplirGourde(){
        setNiv_eau((getNiv_eau()+2));
    }

    public void ramasserPiece(){
        //TODO
    }

    public void partagerEau(Joueur j, int cran){
        this.setNiv_eau(j.getNiv_eau()-cran);
        j.setNiv_eau(j.getNiv_eau()+cran);
    }

}

class explorateur extends Joueur{
    public explorateur(int i, Plateau p, String nom) {
        super(i, p, nom, Carte.Personnage.EXPLORATEUR);
    }

    public String giveDescription(){
        return "L’explorateur peut se déplacer, enlever du sable et utiliser les “Blasters”  diagonalement.";
    }
}

class archeologue extends Joueur{
    public archeologue(int i, Plateau p, String nom) {
        super(i, p, nom, Carte.Personnage.ARCHEOLOGUE);
    }

    public String giveDescription(){
        return "L'archéologue peut enlever 2 tonnes de sable sur la même tuile pour 1 action.";
    }

    @Override
    public void dessabler(Case c){
        c.dessabler();
        c.dessabler();
    }
}

class alpiniste extends Joueur{
    public alpiniste(int i, Plateau p, String nom) {
        super(i, p, nom, Carte.Personnage.ALPINISTE);
    }

    public String giveDescription(){
        return "L’alpiniste peut aller sur les tuiles bloquées (les tuiles ayant au moins 2 marqueurs Sable). " +
                "Elle peut aussi emmener un autre joueur avec elle à chaque fois qu’elle se déplace. " +
                "Tous les pions sur la tuile de l’alpiniste ne sont jamais enlisés et peuvent quitter la tuile " +
                "de l’alpiniste même s’il y a 2 marqueurs Sable ou plus.";
    }
    @Override
    public void deplacer(Case.Dir d){
        //TODO
    }
}

class navigatrice extends Joueur{
    public navigatrice(int i, Plateau p, String nom) {
        super(i, p, nom, Carte.Personnage.NAVIGATRICE);
    }

    public String giveDescription(){
        return "La navigatrice peut déplacer un autre joueur jusqu'à 3 tuiles non bloquées par action, tunnels inclus. " +
                "Elle peut déplacer l’explorateur diagonalement et peut déplacer l’alpiniste sur les tuiles bloquées. " +
                "Déplacée ainsi, l’alpiniste peut aussi utiliser son pouvoir et emmener un autre joueur (dont la navigatrice) !";
    }
    public void deplacer(Case.Dir d){
        //TODO
    }
}

class meteorologue extends Joueur{
    public meteorologue(int i, Plateau p, String nom) {
        super(i, p, nom, Carte.Personnage.METEOROLOGUE);
    }

    public String giveDescription(){
        return "La météorologue peut dépenser des actions pour tirer, à la fin de son tour, " +
                "moins de cartes tempête (1 carte par action) que ne le nécessite le niveau actuel " +
                "de la tempête de sable. Elle peut aussi dépenser 1 action pour regarder autant de " +
                "cartes Tempête que son niveau actuel, puis en placer éventuellement une sous la pile. " +
                "Les autres cartes sont remises sur le dessus de la pile dans l’ordre de son choix.";
    }
}

class porteuseDEau extends Joueur{
    public porteuseDEau(int i, Plateau p, String nom) {
        super(i, p, nom, Carte.Personnage.PORTEUSE_D_EAU);
        this.setNiv_eau(5);
    }

    public String giveDescription(){
        return "La porteuse d’eau peut prendre 2 portions d’eau des tuiles « Point d’eau » déjà révélées pour 1 action. " +
                "Elle peut aussi donner de l’eau aux joueurs sur les tuiles adjacentes gratuitement et à tout moment. " +
                "Sa gourde commence avec 5 portions d’eau (au lieu de 4).";
    }
}