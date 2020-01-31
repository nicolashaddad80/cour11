package fr.cnam.cour11.vue;


import fr.cnam.cour11.model.CounterImp1;
import fr.cnam.cour11.model.spec.Counter;
import fr.cnam.mydesignpatterns.observer.MyObserver;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Scanner;

class CounterGUI  implements MyObserver{

    private Counter counter;
    JLabel display;
    public CounterGUI(Counter a_counter) {
        this.counter=a_counter;
        this.counter.registerObserver(this);
        this.display = new JLabel("" + counter.getValue());
        JFrame frame = new JFrame("Counter");

        Container content = frame.getContentPane();
        content.setLayout(new FlowLayout());


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


    @Override
    public void notifyMe() {
        this.display.setText("" + counter.getValue());
    }

    public static void main(String[] args) {
        Counter myCounter= new CounterImp1();
        new CounterGUI(myCounter);


        while(true){

            Scanner myCharReader = new Scanner(System.in);

            System.out.println("Tapez un caractere quelconque pour Incrémenter le compteur , veuillez surveiller la fenetre GUI du compteur pour voir s il s incremente");
            myCharReader.next().charAt(0);
            myCounter.increment();
        }


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


