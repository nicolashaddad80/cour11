package fr.cnam.cour11.model.spec;

import fr.cnam.mydesignpatterns.observer.MyObservable;

public interface Counter extends MyObservable {

    void increment();

    void reset();

    int getValue();
}
