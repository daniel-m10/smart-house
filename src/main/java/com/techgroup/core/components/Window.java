package com.techgroup.core.components;

import com.techgroup.core.HouseComponent;
import com.techgroup.core.sensor.Sensor;
import com.techgroup.types.SensorOrder;

/**
 * Represents a Window that is a specialized HouseComponent object.
 */
public class Window extends HouseComponent implements Sensor {
    /**
     * Creates a new Window object.
     *
     * @param name that will be used to create the microwave.
     */
    public Window(final String name) {
        super(name);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void printComponentState() {
        String state = super.getState() ? "open" : "closed";
        super.setComponentStateMessage(state);
        System.out.println(super.getComponentStateMessage());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void changeState(final SensorOrder order) {
        super.setState(order == SensorOrder.OPEN);
    }
}
