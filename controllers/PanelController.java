package fr.cnam.cour11.controllers;

import fr.cnam.cour11.model.spec.Counter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelController extends JPanel {

    /**
     * Attributes
     */

    /**
     * Controller Model
     */

    /**
     * My Model is a simple  counter on which I will update Data according to different User interactions with my graphical elements
     */
    private Counter myModel;

    /**
     *  Vue Graphical Elements to show My Model data
     */
    /**
     * Button to allow user to increment myCounter Model value
     */
    private JButton incrementButton = new JButton("++");

    /**
     * Button to allow user to reset myCounter Model value
     */
    private JButton resetButton = new JButton("Reset");

    public PanelController(Counter a_myModel) {
        this.myModel = a_myModel;
        this.incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myModel.increment();
            }
        });

        this.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myModel.reset();
            }
        });

        /*adding my Graphical elements*/
        this.add(incrementButton);
        this.add(resetButton);
    }
}
