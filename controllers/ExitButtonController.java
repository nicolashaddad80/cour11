package fr.cnam.cour11.controllers;

import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.mydesignpatterns.observer.MyObserver;

public class ExitButtonController implements MyObserver {
    private Counter myCounter;

    public ExitButtonController(Counter myCounter) {
        this.myCounter = myCounter;
    }

    @Override
    public void notifyMe() {
        this.myCounter.reset();

    }
}
