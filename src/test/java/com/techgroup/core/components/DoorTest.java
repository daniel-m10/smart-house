package com.techgroup.core.components;

import com.techgroup.core.HouseComponent;
import com.techgroup.core.sensor.Sensor;
import com.techgroup.types.SensorOrder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for Door class.
 */
public class DoorTest {
    private HouseComponent door;

    /**
     * Creates a new instance of Door.
     */
    @Before
    public void setUp() {
        door = new Door("Garden door");
    }

    /**
     * Verifies if a new Door can be created.
     */
    @Test
    public void aNewDoorCanBeCreated() {
        String expectedResult = "Garden door";
        String actualResult = door.getName();
        assertEquals("Door object was not created correctly", expectedResult, actualResult);
    }

    /**
     * Verifies if Door object can change its state.
     */
    @Test
    public void aDoorCanChangeItsState() {
        door.setState(true);
        assertTrue("Door state has not been changed", door.getState());
    }

    /**
     * Verifies if Door object can change its state through a Sensor order.
     */
    @Test
    public void aDoorCanChangeItsStateBasedInASensorOrder() {
        ((Sensor)door).changeState(SensorOrder.CLOSE);
        assertFalse("Door should be closed", door.getState());
    }

    /**
     * Verifies if Door object can print its state.
     */
    @Test
    public void aDoorCanPrintItsState() {
        String expectedResult = "-- Garden door -- is now open\n";
        door.setComponentStateMessage("open");
        door.printComponentState();
        assertEquals("Door should be open", expectedResult.trim(), door.getComponentStateMessage().trim());
    }
}