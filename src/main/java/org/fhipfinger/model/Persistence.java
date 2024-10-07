package org.fhipfinger.model;

/**
 * Interface Persistence
 * @version 2024-10-07
 * @author Florian Hipfinger
 */
public interface Persistence {
    public void load(WordTrainer wordTrainer);
    public void store(WordTrainer wordTrainer);
}
