package edu.skidmore.cs226.patterns.observer;

import java.util.Date;

/**
 * Observer: Translated (and fabricated) book example (page 301).
 * <p>
 * Defines a concrete Subject (can be observed).
 * </p>
 * 
 * @author readda
 */
public class ClockTimer extends Subject implements Runnable {
    private static final int MILLIS_PER_SEC = 1000;

    private static final int MILLIS_PER_MIN = MILLIS_PER_SEC * 60;

    private static final int MILLIS_PER_HOUR = MILLIS_PER_MIN * 60;

    private static final int MILLIS_PER_DAY = MILLIS_PER_HOUR * 24;

    private long milliseconds;

    public ClockTimer() {
        
    }

    public int getHour() {
        return (int) (milliseconds % MILLIS_PER_DAY) / MILLIS_PER_HOUR;
    }

    public int getMinute() {
        return (int) (milliseconds % MILLIS_PER_HOUR) / MILLIS_PER_MIN;
    }

    public int getSecond() {
        return (int) (milliseconds % MILLIS_PER_MIN) / MILLIS_PER_SEC;
    }

    public void tick() {
        milliseconds = new Date().getTime();
        notifyObservers();
    }

    @Override
    public void run() {
        while (true) {
            tick();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie) {
                // Nothing to do
            }
        }
    }

}
