package fr.cnam.cour11.vue;


import fr.cnam.cour11.model.CounterImp1;
import fr.cnam.cour11.model.spec.Counter;

import javax.swing.*;
import java.awt.*;

class CounterGUI {
    private Counter counter;
    private JLabel counterLabel;


    public CounterGUI(Counter counter) {
        JFrame frame = new JFrame("Counter");

        Container content = frame.getContentPane();
        content.setLayout(new FlowLayout());

        JLabel display = new JLabel("" + counter.getValue());
        content.add(display);

        JButton bInc = new JButton("++");
        content.add(bInc);
        JButton bRes = new JButton("Reset");
        content.add(bRes);
        JButton bQuit = new JButton("Quitter");
        content.add(bQuit);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CounterGUI(new CounterImp1());
    }





       /*

        @Override
        public void actionPerformed(ActionEvent ev) {
            this.counter.increment();
            this.counterLabel.setText(""
                    + this.counter.getValue());
        }

        */
}


