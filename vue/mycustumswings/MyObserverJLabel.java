package fr.cnam.cour11.vue.mycustumswings;

import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.mydesignpatterns.observer.MyObserver;

import javax.swing.*;

public class MyObserverJLabel extends JLabel implements MyObserver {
    private Counter my_Counter;
    public JLabel myJLabel;
    public MyObserverJLabel(JLabel aJLabel, Counter a_Counter) {
        this.my_Counter=a_Counter;
        this.myJLabel=aJLabel;
        this.my_Counter.registerObserver(this);
        this.myJLabel.setText(""+this.my_Counter.getValue());
    }

    public JLabel getJLabel(){
        return this.myJLabel;
    }
    @Override
    public void notifyMe() {

        this.myJLabel.setText(""+this.my_Counter.getValue());

    }
}
