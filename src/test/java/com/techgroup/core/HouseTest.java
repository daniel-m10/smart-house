package com.techgroup.core;

import com.google.gson.internal.LinkedTreeMap;
import com.techgroup.types.SensorOrder;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class the validate House methods
 */
public class HouseTest {
    private House house;

    /**
     * Creates a new instance of House.
     */
    @Before
    public void setUp() throws FileNotFoundException {
        String componentsPath = "src/main/resources/components.json";
        house = new House(componentsPath);
    }

    /**
     * Verify if a new house was created.
     */
    @Test
    public void aNewHouseWithSmartComponentsWasCreated() {
        assertNotNull("House object was not created.", house);
    }

    /**
     * Verifies if an observed can be subscribed.
     */
    @Test
    public void anObserverCanBeSubscribed() {
        Device device = new Device("Daniel");
        int expectedResult = 1;
        house.addObserver(device);
        int actualResult = house.getDevices().size();
        assertEquals("Observer was not added.", expectedResult, actualResult);
    }

    /**
     * Verifies if an observed can be unsubscribed.
     */
    @Test
    public void anObserverCanBeUnsubscribed() {
        Device device = new Device("Daniel");
        house.addObserver(device);
        house.removeObserver(device);
        int expectedResult = 0;
        int actualResult = house.getDevices().size();
        assertEquals("Observer was not removed.", expectedResult, actualResult);
    }

    /**
     * Verifies if a house component can change its state.
     *
     * @throws InterruptedException if thread is interrupted somehow.
     */
    @Test
    public void houseComponentsStateCanBeChanged() throws InterruptedException {
        String door = "Entrance_Door";
        Map<String, SensorOrder> order = new LinkedTreeMap<>();
        order.put(door, SensorOrder.OPEN);
        house.changeComponentsState(order);
        boolean actualResult = house.getHouseComponentMap().get(door.toUpperCase()).getState();
        assertTrue("State was not changed.", actualResult);
    }

    /**
     * Verifies if a message is correctly updated for the observer.
     */
    @Test
    public void anObserverMessageIsCorrectlyUpdated() {
        Device device = new Device("Daniel");
        house.addObserver(device);
        house.notifyObserver();
        house.getDevices().get(0).update("we have some updates for you: ");
        String expectedResult = "we have some updates for you: ";
        String actualResult = ((Device) house.getDevices().get(0)).getMessage();
        assertEquals("Message was not updated", actualResult, expectedResult);
    }

    /**
     * Verifies if a house component can change using a mode command.
     *
     * @throws InterruptedException if thread is interrupted somehow.
     */
    @Test
    public void componentsCanBeUpdatedFollowingAModeAction() throws InterruptedException {
        String door = "Entrance_Door";
        Map<String, Map<String, SensorOrder>> mode = new LinkedTreeMap<>();
        Map<String, SensorOrder> order = new LinkedTreeMap<>();
        order.put(door, SensorOrder.OPEN);
        mode.put("Test", order);
        house.setMode(mode);
        boolean actualResult = house.getHouseComponentMap().get(door.toUpperCase()).getState();
        assertTrue("State was not changed.", actualResult);
    }
}