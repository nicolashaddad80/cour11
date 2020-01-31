package fr.cnam.cour11.model;

import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.mydesignpatterns.observer.MyObservable;
import fr.cnam.mydesignpatterns.observer.MyObservvableImp1;

public class CounterImp1 extends MyObservvableImp1 implements Counter {

    private int value = 0;

    @Override
    public void increment() {
        this.value++;
        this.notifyObservers();
    }

    @Override
    public void reset() {
        this.value = 0;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
