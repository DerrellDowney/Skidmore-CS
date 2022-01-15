package edu.skidmore.cs226.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer: Translated book example (page 301).
 * <p>
 * Defines a class that can be observed.
 * </p>
 * 
 * @author readda
 */
public abstract class Subject {
    private List<Observer> observers;

    protected Subject() {
        observers = new ArrayList<>();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    /**
     * Note that in the book this is "notify." However, in Java the notify()
     * method is final in the Object class and is related to thread
     * notification.
     */
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}
