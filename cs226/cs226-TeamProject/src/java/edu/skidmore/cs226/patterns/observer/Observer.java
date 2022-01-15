package edu.skidmore.cs226.patterns.observer;

/**
 * Observer: Translated book example (page 300).
 * <p>
 * Defines the Observer interface all Observers must implement.
 * </p>
 * 
 * @author readda
 */
public interface Observer {
    void update(Subject theChangedSubject);
}
