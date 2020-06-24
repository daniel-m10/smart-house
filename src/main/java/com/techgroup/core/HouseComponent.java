package com.techgroup.core;

/**
 * Contains all abstraction that a HouseComponent object should have.
 */
public abstract class HouseComponent {
    private final String name;
    private boolean state;
    private String componentStateMessage;

    /**
     * Initializes HouseComponent attributes.
     *
     * @param name that will have the HouseComponent object.
     */
    public HouseComponent(final String name) {
        this.name = name;
        this.state = false;
        this.componentStateMessage = "%s is now %s";
    }

    /**
     * Gets the current HouseComponent state.
     *
     * @return HouseComponent state as boolean.
     */
    public boolean getState() {
        return this.state;
    }

    /**
     * Sets HouseComponent object state.
     *
     * @param state will indicate the new HouseComponent state.
     */
    public void setState(final boolean state) {
        this.state = state;
    }

    /**
     * Gets the HouseComponent object name.
     *
     * @return HouseComponent name as String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets HouseComponent state message.
     *
     * @param state that will be printed as part of HouseComponent state message.
     */
    public void setComponentStateMessage(final String state) {
        this.componentStateMessage = String.format(this.componentStateMessage, this.name, state);
    }

    /**
     * Gets HouseComponent state message.
     *
     * @return HouseComponent state message as String.
     */
    public String getComponentStateMessage() {
        return this.componentStateMessage;
    }

    /**
     * Abstract method that specific components will define by themselves.
     */
    public abstract void printComponentState();
}
