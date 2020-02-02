package fr.cnam.cour11.vue;


import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.mydesignpatterns.observer.MyObserver;
import fr.cnam.myswingobjects.jbutton.MyObservableJButton;

import javax.swing.*;
import java.awt.*;


public class CounterGUI implements MyObserver {
    private Counter counter;
    private MyObservableJButton bInc;
    private MyObservableJButton bRes;

     /*to display Counter Value*/
    JLabel display;

    public CounterGUI(Counter a_counter, MyObservableJButton a_bInc, MyObservableJButton bRes) {
        this.counter = a_counter;
        this.counter.registerObserver(this);
        this.bInc= a_bInc;
        this.bRes= a_bInc;

        this.display = new JLabel("" + counter.getValue());
        JFrame frame = new JFrame("CounterGui");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        content.setLayout(new FlowLayout());
        content.add(this.display);

        /*Incrementation button "++" */
        content.add(bInc);

        /*Reset Button "reset"*/

        content.add(bRes);

        /*Exit Button "Quitter"*/
        JButton bQuit = new JButton("Quitter");
        bQuit.addActionListener(e -> System.exit(0));
        content.add(bQuit);


        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void notifyMe() {
        this.display.setText("" + counter.getValue());
    }

}


