package edu.skidmore.cs226.patterns.observer;

/**
 * Observer: Translated book example (page 303).
 * <p>
 * Defines a concrete Observer.
 * </p>
 * 
 * @author readda
 */
public class AnalogClock implements Observer {
    private ClockTimer timer;

    public AnalogClock(ClockTimer timer) {
        this.timer = timer;
        timer.attach(this);
    }

    public void draw() {
        System.out.println(
            "\nAnalogClock: " + timer.getHour() + "-->" + timer.getMinute());
    }

    @Override
    public void update(Subject theChangedSubject) {
        draw();
    }
}
