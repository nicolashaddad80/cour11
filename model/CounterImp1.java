package fr.cnam.cour11.model;

import fr.cnam.cour11.model.spec.Counter;

public class CounterImp1 implements Counter {

    private int value = 0;

    @Override
    public void increment() {
        this.value++;
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
