package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfficheInfos extends JButton {

    public AfficheInfos(){
        super("Infos");
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setBounds(0,0,50,50);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] choix = {"Alpiniste", "Porteuse d'eau", "Explorateur", "Navigatrice", "Archéologue", "Météorologue"};
                int c = JOptionPane.showOptionDialog(null,
                        "Choisissez le rôle :",
                        "Informations rôles",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, choix, choix[0]);
                JFrame frame = new JFrame();
                switch(c) {
                    case 0:
                        JOptionPane.showMessageDialog(frame, "L’alpiniste peut aller sur les tuiles bloquées (les tuiles ayant au moins 2 marqueurs Sable)." +"\n" +
                                "Elle peut aussi emmener un autre joueur avec elle à chaque fois qu’elle se déplace." +"\n" +
                                "Tous les pions sur la tuile de l’alpiniste ne sont jamais enlisés et peuvent quitter la tuile " +"\n" +
                                "de l’alpiniste même s’il y a 2 marqueurs Sable ou plus."); break;
                    case 1:
                        JOptionPane.showMessageDialog(frame,"La porteuse d’eau peut prendre 2 portions d’eau des tuiles « Point d’eau » déjà révélées pour 1 action. " +
                                "\n" + "Elle peut aussi donner de l’eau aux joueurs sur les tuiles adjacentes gratuitement et à tout moment. " + "\n" +
                                "Sa gourde commence avec 5 portions d’eau (au lieu de 4).");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(frame,"L’explorateur peut se déplacer, enlever du sable et utiliser les “Blasters”  diagonalement.");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(frame,"La navigatrice peut déplacer un autre joueur jusqu'à 3 tuiles non bloquées par action, tunnels inclus. " +
                                "\n" + "Elle peut déplacer l’explorateur diagonalement et peut déplacer l’alpiniste sur les tuiles bloquées. " +
                                "\n" + "Déplacée ainsi, l’alpiniste peut aussi utiliser son pouvoir et emmener un autre joueur (dont la navigatrice) !");
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(frame,"L'archéologue peut enlever 2 tonnes de sable sur la même tuile pour 1 action.");
                        break;
                    case 5 :
                        JOptionPane.showMessageDialog(frame,"La météorologue peut dépenser des actions pour tirer, à la fin de son tour, " +
                                "\n" + "moins de cartes tempête (1 carte par action) que ne le nécessite le niveau actuel " +
                                "\n" +"de la tempête de sable. Elle peut aussi dépenser 1 action pour regarder autant de " +
                                "\n" +"cartes Tempête que son niveau actuel, puis en placer éventuellement une sous la pile. " +
                                "\n" +"Les autres cartes sont remises sur le dessus de la pile dans l’ordre de son choix.");
                        break;
                }

            }
        });
    }
}
