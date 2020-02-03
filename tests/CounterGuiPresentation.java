package fr.cnam.cour11.tests;

import fr.cnam.cour11.controllers.PanelController;
import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.cour11.vue.CounterVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CounterGuiPresentation {
    private JFrame frame = new JFrame("CounterGuiPresentation");

    /*Create instance of Model*/
    private Counter myModel;
    private CounterVue myCounterVue;
    private PanelController myController;

    private JButton myExitButton = new JButton("Quitter");

    public CounterGuiPresentation(Counter a_myModel) {
        this.myModel = a_myModel;
        this.myCounterVue = new CounterVue(myModel);
        this.myController = new PanelController(myModel);
        this.myExitButton = new JButton("Quitter");

        Container content = this.frame.getContentPane();
        content.setLayout(new FlowLayout());
        /* Adding Vue Panel Part */
        content.add(this.myCounterVue);
        /* Adding controller Panel Part */
        content.add(this.myController);
        this.myExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myExit();
            }
        });
        /*Adding Exit Button*/
        content.add(this.myExitButton);

    }

    public void start() {
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                myExit();
            }
        });
        this.frame.setSize(500, 100);
        this.frame.setVisible(true);
    }

    private void myExit() {
        myCounterVue.destroy();
        System.out.println("Thank you Using this Application");
        System.exit(0);
    }

}
