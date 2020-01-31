/**
 * @(#) MyObservableJButton.java
 */

package fr.cnam.cour11.vue.mycustumswings;

import fr.cnam.mydesignpatterns.observer.MyObservable;
import fr.cnam.mydesignpatterns.observer.MyObserver;

import javax.swing.*;
import java.util.Vector;

public class MyObservableJButton extends JButton implements MyObservable

{


	private JButton myJButton;

	private Vector<MyObserver> myObservers;


	public MyObservableJButton(JButton myJButton) {
		this.myJButton = myJButton;
		this.myObservers = new Vector<>();
	}


	@Override
	public void registerObserver(MyObserver a_My_observer) {
		this.myObservers.add(a_My_observer);
	}

	@Override
	public void unregisterObserver(MyObserver a_My_observer) {

	}

	@Override
	public void notifyObservers() {
		for (MyObserver myObserver : this.myObservers) {
			myObserver.notifyMe();
		}
	}

}
