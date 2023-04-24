package controllers;

import models.Plateau;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ramasser extends JButton{
    private models.Plateau p;

    public Ramasser(Plateau P) {
        super("Ramasser");
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setBounds(0, 0, 100, 50);
        this.p = P;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setAction(3);
            }
        });
    }
}
