package edu.skidmore.cs226.patterns.observer;

/**
 * Observer: Demonstrate how the Observer and Subject instances are used.
 * 
 * @author readda
 */
public class UseObserver {
    private void useObserver() {
        ClockTimer timer = new ClockTimer();
        new DigitalClock(timer);
        new AnalogClock(timer);
        new Thread(timer).start();
    }
    public static void main(String[] args) {
        UseObserver observerCheck = new UseObserver();
        observerCheck.useObserver();
    }
}
