package org.fhipfinger.view;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame(JPanel panel) {
        super("Worttrainer Florian Hipfinger");
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
