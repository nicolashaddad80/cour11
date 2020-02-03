package fr.cnam.cour11.controllers;

import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.mydesignpatterns.observer.MyObserver;
import fr.cnam.mydesignpatterns.observer.OptimizedClass;

public class IncButtonController implements MyObserver,OptimizedClass {
    private Counter myCounter;

    public IncButtonController(Counter myCounter) {
        this.myCounter = myCounter;
    }


    @Override
    public void notifyMe() {
        this.myCounter.increment();
    }

    @Override
    public void destroy() {
        this.myCounter.unregisterObserver(this);
    }
}