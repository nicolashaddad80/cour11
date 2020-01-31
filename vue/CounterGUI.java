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

    public CounterGUI(Counter a_counter, MyObservable a_incButtonObservers,MyObservable a_resetButtonObservers) {
        this.counter = a_counter;
        this.counter.registerObserver(this);
        this.incButtonObservers = a_incButtonObservers;
        this.resetButtonObservers=a_resetButtonObservers;

        this.display = new JLabel("" + counter.getValue());

        JFrame frame = new JFrame("Counter");
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
        bQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Container frame = bQuit.getParent();
                do
                    frame = frame.getParent();
                while (!(frame instanceof JFrame));
                ((JFrame) frame).dispose();
            }
        });
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

    /*Clean quitter
    public void windowClosing(WindowEvent e) {
        displayMessage("WindowListener method called: windowClosing.");
        //A pause so user can see the message before
        //the window actually closes.
        ActionListener task = new ActionListener() {
            boolean alreadyDisposed = false;
            public void actionPerformed(ActionEvent e) {
                if (frame.isDisplayable()) {
                    alreadyDisposed = true;
                    frame.dispose();
                }
            }
        };
        Timer timer = new Timer(500, task); //fire every half second
        timer.setInitialDelay(2000);        //first delay 2 seconds
        timer.setRepeats(false);
        timer.start();
    }

    public void windowClosed(WindowEvent e) {
        //This will only be seen on standard output.
        displayMessage("WindowListener method called: windowClosed.");
    }
*/

}


