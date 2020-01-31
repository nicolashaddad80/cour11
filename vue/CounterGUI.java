package fr.cnam.cour11.vue;


import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.mydesignpatterns.observer.MyObservable;
import fr.cnam.mydesignpatterns.observer.MyObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterGUI implements MyObserver {
    private MyObservable incButtonObservers;
    private MyObservable resetButtonObservers;
    private Counter counter;

    JLabel display;

    public CounterGUI(Counter a_counter, MyObservable a_incButtonObservers, MyObservable a_resetButtonObservers) {
        this.counter = a_counter;
        this.counter.registerObserver(this);
        this.incButtonObservers = a_incButtonObservers;
        this.resetButtonObservers = a_resetButtonObservers;

        this.display = new JLabel("" + counter.getValue());

        JFrame frame = new JFrame("Counter");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        content.setLayout(new FlowLayout());
        content.add(this.display);
        JButton bInc = new JButton("++");
        bInc.addActionListener(new incButtonListener());
        content.add(bInc);
        JButton bRes = new JButton("Reset");
        bRes.addActionListener(new resetButtonListener());
        content.add(bRes);
        JButton bQuit = new JButton("Quitter");
        bQuit.addActionListener(e -> System.exit(0));
        content.add(bQuit);
        frame.pack();
        frame.setVisible(true);
    }

    private class incButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            incButtonObservers.notifyObservers();
        }
    }


    private class resetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            resetButtonObservers.notifyObservers();
        }
    }


    @Override
    public void notifyMe() {
        this.display.setText("" + counter.getValue());
    }

}


