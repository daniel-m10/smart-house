package com.techgroup.core.components;

import com.techgroup.core.HouseComponent;
import org.junit.Before;
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
     * Verifies if Door object can print its state.
     */
    @Test
    public void aDoorCanPrintItsState() {
        String expectedResult = "Garden door is now open";
        door.setComponentStateMessage("open");
        door.printComponentState();
        assertEquals("Door should be open", expectedResult, door.getComponentStateMessage());
    }
}