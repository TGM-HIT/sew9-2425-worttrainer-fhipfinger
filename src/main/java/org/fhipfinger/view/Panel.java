package org.fhipfinger.view;

import org.fhipfinger.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Panel extends JPanel {
    private Controller controller;
    private JButton save;
    private JButton load;
    private JTextField input;
    private JLabel image;
    private JLabel totalAttempts;
    private JLabel correctAttempts;
    public Panel(Controller c) {
        this.controller = c;
        this.setLayout(new BorderLayout());

        JPanel input = new JPanel();
        input.setLayout(new GridLayout(2,1));
        JLabel inputLabel1 = new JLabel("Welches Wort wird unten dargestellt?");

        input.add(inputLabel1);
        this.input = new JTextField();
        input.add(this.input);
        this.add(input, BorderLayout.PAGE_START);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,1));
        try {
            ImageIcon imageIcon = new ImageIcon(new URL(controller.getCurrentUrl()));

            Image image = imageIcon.getImage();
            image = image.getScaledInstance(250,250,Image.SCALE_SMOOTH);
            this.image = new JLabel(new ImageIcon(image));
            center.add(this.image);
            this.add(center, BorderLayout.CENTER);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(2,3));

        this.correctAttempts = new JLabel(String.valueOf(controller.getCorrectAttempts()));
        this.totalAttempts = new JLabel(String.valueOf(controller.getTotalAttempts()));

        this.save = new JButton("Speichern");
        this.load = new JButton("Laden");

        bottom.add(new JLabel("Richtige Wörter: "));
        bottom.add(correctAttempts);
        bottom.add(save);
        bottom.add(new JLabel("Gesamtanzahl"));

        bottom.add(totalAttempts);
        bottom.add(load);
        this.add(bottom, BorderLayout.PAGE_END);

        this.input.addActionListener(this.controller);
        this.input.setActionCommand("textInput");

        this.save.addActionListener(this.controller);
        this.save.setActionCommand("save");

        this.load.addActionListener(this.controller);
        this.load.setActionCommand("load");
    }

    public String getInput() {
        return this.input.getText();

    }

    public void showNextWord() {
        this.input.setText("");
        this.totalAttempts.setText(String.valueOf(this.controller.getTotalAttempts()));
        this.correctAttempts.setText(String.valueOf(this.controller.getCorrectAttempts()));

        JPanel center = new JPanel();
        ImageIcon imageIcon = null;
        try {
            imageIcon = new ImageIcon(new URL(controller.getCurrentUrl()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(250,250, Image.SCALE_SMOOTH);
        this.image = new JLabel(new ImageIcon(image));
        center.add(this.image);
        this.add(center, BorderLayout.CENTER);
    }

}
