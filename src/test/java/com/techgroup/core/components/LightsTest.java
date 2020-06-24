package com.techgroup.core.components;

import com.techgroup.core.HouseComponent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for Lights class.
 */
public class LightsTest {
    private HouseComponent lights;

    /**
     * Creates a new instance of Lights.
     */
    @Before
    public void setUp() {
        lights = new Lights("Main door lights");
    }

    /**
     * Verifies if new Lights can be created.
     */
    @Test
    public void newLightsCanBeCreated() {
        String expectedResult = "Main door lights";
        String actualResult = lights.getName();
        assertEquals("Lights object was not created correctly", expectedResult, actualResult);
    }

    /**
     * Verifies if Lights object can change its state.
     */
    @Test
    public void lightsCanChangeItsState() {
        lights.setState(true);
        assertTrue("Lights state has not been changed", lights.getState());
    }

    /**
     * Verifies if Lights object can print its state.
     */
    @Test
    public void lightsCanPrintItsState() {
        String expectedResult = "Main door lights is now turned on";
        lights.setComponentStateMessage("turned on");
        lights.printComponentState();
        assertEquals("Lights should be turned on", expectedResult, lights.getComponentStateMessage());
    }
}