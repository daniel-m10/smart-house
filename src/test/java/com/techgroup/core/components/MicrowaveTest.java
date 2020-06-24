package com.techgroup.core.components;

import com.techgroup.core.HouseComponent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for Microwave class.
 */
public class MicrowaveTest {
    private HouseComponent microwave;

    /**
     * Creates a new instance of Microwave.
     */
    @Before
    public void setUp() {
        microwave = new Lights("Kitchen microwave");
    }

    /**
     * Verifies if a new Microwave can be created.
     */
    @Test
    public void aNewMicrowaveCanBeCreated() {
        String expectedResult = "Kitchen microwave";
        String actualResult = microwave.getName();
        assertEquals("Microwave object was not created correctly", expectedResult, actualResult);
    }

    /**
     * Verifies if Microwave object can change its state.
     */
    @Test
    public void aMicrowaveCanChangeItsState() {
        microwave.setState(true);
        assertTrue("Microwave state has not been changed", microwave.getState());
    }

    /**
     * Verifies if Microwave object can print its state.
     */
    @Test
    public void aMicrowaveCanPrintItsState() {
        String expectedResult = "Kitchen microwave is now turned on";
        microwave.setComponentStateMessage("turned on");
        microwave.printComponentState();
        assertEquals("Microwave should be turned on", expectedResult, microwave.getComponentStateMessage());
    }
}