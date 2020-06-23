package com.techgroup.interfaces;

/**
 * Interface that will be implemented by House class.
 */
public interface Observable {
    /**
     * Adds an object of type Observer.
     *
     * @param o that will be added.
     */
    void addObserver(final Observer o);

    /**
     * Removes an object of type Observer.
     *
     * @param o that will be removed.
     */
    void removeObserver(final Observer o);

    /**
     * Notifies Observer if something has changed in House class.
     */
    void notifyObserver();
}
