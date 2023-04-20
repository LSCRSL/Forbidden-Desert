package views;

import controllers.Launcher;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ChoixNbJoueurs extends JFrame {

    private ArrayList<String> noms;

    public ArrayList<String> getNoms() {
        return this.noms;
    }

    public  ChoixNbJoueurs(Launcher lauch){ //il faut mettre init en argument ici, creer une classe Init avec un attribut nbJoueur, et qui appelle ce constructeur dans son constructeur
        this.setTitle("Configuration");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0,1));
        Font myFont = new Font("SansSerif", Font.PLAIN, 25);
        Border border = BorderFactory.createTitledBorder(null,"Sélectionner le nombre de joueurs :", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, myFont, Color.BLACK);
        JButton ok = new JButton("OK");
        ok.setBounds(0,0, 5,5);
        panel.setBorder(border);
        //this.noms = new HashSet<Object>();
        ButtonGroup group = new ButtonGroup();
        JRadioButton r2 = new JRadioButton("2");
        //r2.setMnemonic(KeyEvent.VK_1);
        r2.setActionCommand("2");
        r2.setSelected(true);
        r2.setFont(r2.getFont().deriveFont(20.0f));

        JRadioButton r3 = new JRadioButton("3");
        r3.setMnemonic(KeyEvent.VK_1);
        r3.setActionCommand("3");
        r3.setFont(r2.getFont().deriveFont(20.0f));

        JRadioButton r4 = new JRadioButton("4");
        r4.setMnemonic(KeyEvent.VK_1);
        r4.setActionCommand("4");
        r4.setFont(r2.getFont().deriveFont(20.0f));

        JRadioButton r5 = new JRadioButton("5");
        r5.setMnemonic(KeyEvent.VK_1);
        r5.setActionCommand("5");
        r5.setFont(r2.getFont().deriveFont(20.0f));

        group.add(r2);
        panel.add(r2);
        group.add(r3);
        panel.add(r3);
        group.add(r4);
        panel.add(r4);
        group.add(r5);
        panel.add(r5);
        ok.setLocation(panel.getWidth()/2 - ok.getWidth()/2, panel.getHeight()/2);
        panel.add(ok);

        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds = graphicsEnvironment.getMaximumWindowBounds();
        int height = (int)maximumWindowBounds.getHeight();
        int width = (int)maximumWindowBounds.getWidth();


        Container contentPane = this.getContentPane();
        contentPane.add(panel,BorderLayout.CENTER);
        this.setSize(580,300);
        this.setLocation(width/2 - this.getWidth()/2,height/2 - this.getHeight()/2);
        this.setVisible(true);
        ChoixNbJoueurs frame = this;

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = group.getSelection().getActionCommand();
                int i = Integer.parseInt(s);
                frame.setVisible(false);
                frame.noms = new ArrayList<>(i);
                for (int x = 1; x<=i;x++) {
                    String result = JOptionPane.showInputDialog("Entrer le nom du joueur " + x);
                    frame.noms.add(result);

                }
                frame.dispose();
                Thread run = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        lauch.setNames(frame.getNoms());
                        lauch.launch();
                    }
                });
                run.start();
            }
        });;
    }

}
