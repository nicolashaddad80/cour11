package fr.cnam.cour11.tests;

import fr.cnam.cour11.controllers.IncButtonController;
import fr.cnam.cour11.controllers.ResetButtonController;
import fr.cnam.cour11.model.CounterImp1;
import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.cour11.vue.CounterGUI;
import fr.cnam.myswingobjects.jbutton.MyObservableJButton;

import javax.swing.*;

public class CounterGuiLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CounterGuiLauncher().start());
    }

    private void start() {
        /*Create instance of Model*/
        Counter myCounter = new CounterImp1();

        /*Instantiating Vue Observables Elements and attach a specific controller for each of them*/

        /*Incrementation Button*/
        MyObservableJButton bInc = new MyObservableJButton("++");
        bInc.registerObserver(new IncButtonController(myCounter));

        /*Reset Button*/
        MyObservableJButton bRes = new MyObservableJButton("Reset");
        bRes.registerObserver(new ResetButtonController(myCounter));
        /*Instantiating a Vue*/
        new CounterGUI(myCounter, bInc, bRes);
    }
}
