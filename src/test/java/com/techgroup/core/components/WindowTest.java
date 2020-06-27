package com.techgroup.core.components;

import com.techgroup.core.HouseComponent;
import com.techgroup.core.sensor.Sensor;
import com.techgroup.types.SensorOrder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for Window class.
 */
public class WindowTest {
    private HouseComponent window;

    /**
     * Creates a new instance of Window.
     */
    @Before
    public void setUp() {
        window = new Window("1st floor window");
    }

    /**
     * Verifies if a new Window can be created.
     */
    @Test
    public void aNewWindowCanBeCreated() {
        String expectedResult = "1st floor window";
        String actualResult = window.getName();
        assertEquals("Window object was not created correctly", expectedResult, actualResult);
    }

    /**
     * Verifies if Window object can change its state.
     */
    @Test
    public void aWindowCanChangeItsState() {
        window.setState(true);
        assertTrue("Window state has not been changed", window.getState());
    }

    /**
     * Verifies if Window object can change its state through a Sensor order.
     */
    @Test
    public void aWindowCanChangeItsStateBasedInASensorOrder() {
        ((Sensor)window).changeState(SensorOrder.CLOSE);
        assertFalse("Door should be closed", window.getState());
    }

    /**
     * Verifies if Window object can print its state.
     */
    @Test
    public void aWindowCanPrintItsState() {
        String expectedResult = "-- 1st floor window -- is now open";
        window.setComponentStateMessage("open");
        window.printComponentState();
        assertEquals("Window should be open", expectedResult.trim(), window.getComponentStateMessage().trim());
    }
}