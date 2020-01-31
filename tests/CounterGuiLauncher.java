package fr.cnam.cour11.tests;

import fr.cnam.cour11.controllers.IncButtonController;
import fr.cnam.cour11.controllers.ResetButtonController;
import fr.cnam.cour11.model.CounterImp1;
import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.cour11.vue.CounterGUI;
import fr.cnam.mydesignpatterns.observer.MyObservable;
import fr.cnam.mydesignpatterns.observer.MyObserver;
import fr.cnam.mydesignpatterns.observer.MyObservvableImp1;

import javax.swing.*;

public class CounterGuiLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CounterGuiLauncher().start());
    }

    private void start() {
        Counter myCounter = new CounterImp1();
        MyObservable resetButtonObservers = new MyObservvableImp1();
        MyObserver myResetButtonController = new ResetButtonController(myCounter);
        resetButtonObservers.registerObserver(myResetButtonController);
        MyObservable incButtonObservers = new MyObservvableImp1();
        MyObserver myIncButtonController = new IncButtonController(myCounter);
        incButtonObservers.registerObserver(myIncButtonController);
        new CounterGUI(myCounter, incButtonObservers, resetButtonObservers);
    }
}
