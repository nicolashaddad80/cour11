package fr.cnam.cour11.tests;

import fr.cnam.cour11.controllers.PanelController;
import fr.cnam.cour11.model.CounterImp1;
import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.cour11.vue.CounterVue;

import javax.swing.*;
import java.awt.*;

public class CounterGuiPresentation {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CounterGuiPresentation().start());
    }

    private void start() {
        /*Create instance of Model*/
        Counter myModel = new CounterImp1();

        CounterVue myCounterVue = new CounterVue(myModel);
        PanelController myController = new PanelController(myModel);

        JFrame frame = new JFrame("CounterGuiPresentation");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();

        content.setLayout(new FlowLayout());

        /* Adding Vue Panel Part */
        content.add(myCounterVue);
        /* Adding controller Panel Part */
        content.add(myController);

        frame.pack();
        frame.setVisible(true);


        /*Instantiating a Vue*/
        //new CounterVue(myCounter/*clean, bInc, bRes*/);
    }
}
