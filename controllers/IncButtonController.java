package fr.cnam.cour11.controllers;

import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.mydesignpatterns.observer.MyObserver;

public class IncButtonController implements MyObserver {
    private Counter myCounter;

    public IncButtonController(Counter myCounter) {
        this.myCounter = myCounter;
    }

    @Override
    public void notifyMe() {
        this.myCounter.increment();

    }
}