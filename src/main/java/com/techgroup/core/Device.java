package com.techgroup.core;

import com.techgroup.interfaces.Observer;

/**
 * Represents a Device object that will be subscribed to subject to get notifications when this one modifies its state.
 */
public class Device implements Observer {
    private final String name;
    private String message;

    /**
     * Creates a new instance of Device.
     *
     * @param name that a new device will have.
     */
    public Device(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void update(final String message) {
        this.message = message;
        System.out.println(String.format("%s, %s", this.name, this.message));
    }

    /**
     * Gets the value of message variable.
     *
     * @return message value as String.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Gets the value of name variable.
     *
     * @return name value as String.
     */
    public String getName() {
        return this.name;
    }
}
