package edu.skidmore.cs226.patterns.observer;

/**
 * Observer: Translated book example (page 302).
 * <p>
 * Defines a concrete Observer.
 * </p>
 * 
 * @author readda
 */
public class DigitalClock implements Observer {
    private ClockTimer timer;

    public DigitalClock(ClockTimer timer) {
        this.timer = timer;
        timer.attach(this);
    }

    public void draw() {
        System.out.println("\nDigitalClock: " + timer.getHour() + ":"
            + timer.getMinute() + ":" + timer.getSecond());
    }

    @Override
    public void update(Subject theChangedSubject) {
        draw();
    }
}
