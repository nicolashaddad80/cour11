package fr.cnam.cour11.tests;

import fr.cnam.cour11.model.CounterImp1;
import fr.cnam.cour11.model.spec.Counter;

import javax.swing.*;

public class CounterGuiPresentationTest {



    public static void main(String[] args) {
        Counter myModel1= new CounterImp1();
        SwingUtilities.invokeLater(() -> new CounterGuiPresentation(myModel1).start());
      /*  SwingUtilities.invokeLater(() -> new CounterGuiPresentation(myModel1).start());
        SwingUtilities.invokeLater(() -> new CounterGuiPresentation(myModel1).start());
        SwingUtilities.invokeLater(() -> new CounterGuiPresentation(myModel1).start());
        */
    }
}
