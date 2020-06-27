package com.techgroup.core.components;

import com.techgroup.core.HouseComponent;
import com.techgroup.core.sensor.Sensor;
import com.techgroup.types.SensorOrder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for Tv class.
 */
public class TvTest {
    private HouseComponent tv;

    /**
     * Creates a new instance of Tv.
     */
    @Before
    public void setUp() {
        tv = new Tv("Hall Tv");
    }

    /**
     * Verifies if a new Tv can be created.
     */
    @Test
    public void aNewTvCanBeCreated() {
        String expectedResult = "Hall Tv";
        String actualResult = tv.getName();
        assertEquals("Tv object was not created correctly", expectedResult, actualResult);
    }

    /**
     * Verifies if Tv object can change its state.
     */
    @Test
    public void aTvCanChangeItsState() {
        tv.setState(true);
        assertTrue("Tv state has not been changed", tv.getState());
    }

    /**
     * Verifies if Tv object can change its state through a Sensor order.
     */
    @Test
    public void aTvCanChangeItsStateBasedInASensorOrder() {
        ((Sensor)tv).changeState(SensorOrder.CLOSE);
        assertFalse("Door should be closed", tv.getState());
    }

    /**
     * Verifies if Tv object can print its state.
     */
    @Test
    public void aTvCanPrintItsState() {
        String expectedResult = "-- Hall Tv -- is now turned on";
        tv.setComponentStateMessage("turned on");
        tv.printComponentState();
        assertEquals("Hall Tv should be turned on", expectedResult.trim(), tv.getComponentStateMessage().trim());
    }
}