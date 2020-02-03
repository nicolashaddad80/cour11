package fr.cnam.cour11.vue;


import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.mydesignpatterns.observer.MyObserver;
import fr.cnam.mydesignpatterns.observer.OptimizedClass;

import javax.swing.*;


public class CounterVue extends JPanel implements MyObserver, OptimizedClass {

    /**
     * Attributes
     */

    /**
     * Vue Model
     */

    /**
     * My Model is a simple Observable counter that I will Observe by registering me to him
     */
    private Counter myModel;

    /**
     *  Vue Graphical Elements to show My Model data
     */


    /**
     * My Model is a simple Counter use simple swing label to show it in the screen
     */
    private JLabel displayCounterValue;

    /**
     * Constructor
     *
     * @param a_myModel: A simple counter as a Model for me.
     */
    public CounterVue(Counter a_myModel) {
        this.myModel = a_myModel;
        this.myModel.registerObserver(this);
        this.displayCounterValue = new JLabel("" + myModel.getValue());
        this.add(this.displayCounterValue);
    }

    /**
     * Implementing Observer Methods as I am a observer of my Model
     */
    @Override
    public void notifyMe() {
        this.displayCounterValue.setText("" + myModel.getValue());
    }

    /**
     * Implementing OptimizedClas as my Graphical elements are actualized on my Model notifications
     * need to unregister me from my Observable Model list
     * This is to allow garbage collector freeing my occupied memory space at my instantiation (creation)
     */
    @Override
    public void destroy() {
        this.myModel.unregisterObserver(this);
    }
}


