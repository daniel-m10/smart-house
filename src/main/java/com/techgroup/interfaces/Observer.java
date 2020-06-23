package com.techgroup.interfaces;

/**
 * Interface that will be implemented by Device class.
 */
public interface Observer {
    /**
     * Gives a message if some object from House has changed its state.
     *
     * @param message that will describe what has changed.
     */
    void update(final String message);
}
