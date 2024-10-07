package org.fhipfinger.controller;

import org.fhipfinger.model.WordTrainer;
import org.fhipfinger.view.Frame;
import org.fhipfinger.view.Panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private WordTrainer wordTrainer;
    private final Frame frame;
    private Panel panel;

    public Controller() {
        this.wordTrainer = new WordTrainer();
        this.wordTrainer.load();

        this.panel = new Panel(this);
        this.frame = new Frame(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "textInput":
                this.wordTrainer.checkInput(panel.getInput());

                this.panel.showNextWord();
                break;
            case "save":
                this.wordTrainer.store();
            case "load":
                this.wordTrainer.load();
                this.panel.showNextWord();
        }
    }

    public static void main(String[] args) {
        new Controller();
    }

    public String getCurrentUrl() {
        return wordTrainer.getRandomWordImage().getUrl();
    }

    public int getTotalAttempts() {
        return wordTrainer.getTotalAttempts();
    }

    public int getCorrectAttempts() {
        return wordTrainer.getCorrectAttempts();
    }
}
