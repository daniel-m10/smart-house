package com.techgroup.core.components;

import com.techgroup.core.HouseComponent;
import com.techgroup.core.sensor.Sensor;
import com.techgroup.types.SensorOrder;

/**
 * Represents a Tv that is a specialized HouseComponent object.
 */
public class Tv extends HouseComponent implements Sensor {
    /**
     * Creates a new Tv object.
     *
     * @param name that will be used to create the microwave.
     */
    public Tv(final String name) {
        super(name);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void printComponentState() {
        String state = super.getState() ? "turned on" : "turned off";
        super.setComponentStateMessage(state);
        System.out.println(super.getComponentStateMessage());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void changeState(SensorOrder order) {
        super.setState(order == SensorOrder.TURN_ON);
    }
}
