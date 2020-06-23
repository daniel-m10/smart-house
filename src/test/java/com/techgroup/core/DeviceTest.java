package com.techgroup.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Device class.
 */
public class DeviceTest {

    /**
     * Verifies if a new Device can be created.
     */
    @Test
    public void aNewDeviceCanBeCreated() {
        Device device = new Device("Daniel's smartphone");
        String expectedResult = "Daniel's smartphone";
        assertEquals("Device was not created correctly.", expectedResult, device.getName());
    }

    /**
     * Verifies if a new Device prints the correct message.
     */
    @Test
    public void newDeviceCanPrintOutAMessage() {
        Device device = new Device("Daniel's smartphone");
        String expectedResult = "Lights from the kitchen have been turned off";
        device.update(expectedResult);
        assertEquals("Message displayed is not the correct one.", expectedResult, device.getMessage());
    }
}