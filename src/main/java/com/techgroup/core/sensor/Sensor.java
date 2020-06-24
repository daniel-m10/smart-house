package com.techgroup.core.sensor;

import com.techgroup.types.SensorOrder;

/**
 * A sensor that a HouseComponent can implement.
 */
public interface Sensor {
    /**
     * Change the state of HouseComponent object.
     *
     * @param order used to change HouseComponent state.
     */
    void changeState(final SensorOrder order);
}
