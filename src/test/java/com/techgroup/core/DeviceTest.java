package com.techgroup.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeviceTest {

    @Test
    public void aNewDeviceCanBeCreated() {
        Device device = new Device("Daniel's smartphone");
        String expectedResult = "Daniel's smartphone";
        assertEquals("Device was not created correctly.", expectedResult, device.getName());
    }

    @Test
    public void newDeviceCanPrintOutAMessage() {
        Device device = new Device("Daniel's smartphone");
        String expectedResult = "Lights from the kitchen have been turned off";
        device.update(expectedResult);
        assertEquals("Message displayed is not the correct one.", expectedResult, device.getMessage());
    }
}