package com.techgroup.core;

import com.techgroup.core.sensor.Sensor;
import com.techgroup.interfaces.Observable;
import com.techgroup.interfaces.Observer;
import com.techgroup.types.Component;
import com.techgroup.types.SensorOrder;
import com.techgroup.utilities.JsonParser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Represents a House object where devices will subscribe to get notifications when a component changes its state.
 */
public class House implements Observable {
    public static final String SUB_SEPARATOR = "----------------------------------------------------------------------";
    public static final String COMPONENT_SEPARATOR = "-------------------------------------------------";
    private final List<Observer> devices;
    private final Map<String, HouseComponent> houseComponentMap;

    /**
     * Initializes an instance of House object.
     *
     * @param houseDetails that describes all components that will be added to the house.
     * @throws FileNotFoundException if houseDetails file cannot be found in the specified path.
     */
    public House(final String houseDetails) throws FileNotFoundException {
        devices = new ArrayList<>();
        houseComponentMap = HouseComponentFactory.buildComponents(parseHouseDetails(houseDetails));
    }

    /**
     * Gets list of subscribed devices.
     *
     * @return list of Observer objects.
     */
    public List<Observer> getDevices() {
        return this.devices;
    }

    /**
     * Gets all house components added to the House.
     *
     * @return a Map of components with their corresponding name.
     */
    public Map<String, HouseComponent> getHouseComponentMap() {
        return this.houseComponentMap;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void addObserver(final Observer o) {
        String name = ((Device) o).getName();
        System.out.println(SUB_SEPARATOR);
        System.out.println(String.format("-- %s -- you were subscribed, you will start getting notifications", name));
        System.out.println(String.format("%s%n", SUB_SEPARATOR));
        this.devices.add(o);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void removeObserver(final Observer o) {
        String name = ((Device) o).getName();
        System.out.println(SUB_SEPARATOR);
        System.out.println(String.format("-- %s -- you were unsubscribed, you won't get notifications anymore", name));
        System.out.println(String.format("%s%n", SUB_SEPARATOR));
        this.devices.remove(o);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : devices) {
            observer.update("we have some updates for you: ");
        }
    }

    /**
     * Method that changes the state of all components listed in a json file.
     *
     * @param orders to follow in order to modify a component state.
     */
    public void changeComponentsState(final Map<String, SensorOrder> orders) throws InterruptedException {
        Thread.sleep(1000);
        printLoadAction();
        for (Map.Entry<String, SensorOrder> entry : orders.entrySet()) {
            System.out.println(COMPONENT_SEPARATOR);
            notifyObserver();
            ((Sensor) houseComponentMap.get(entry.getKey().toUpperCase())).changeState(entry.getValue());
            houseComponentMap.get(entry.getKey().toUpperCase()).printComponentState();
            System.out.println(COMPONENT_SEPARATOR);
            Thread.sleep(2000);
        }
    }

    /**
     * Method that changes the state of a group of components listed in a json file.
     *
     * @param modes to follow in order to modify a component state.
     */
    public void setMode(final Map<String, Map<String, SensorOrder>> modes) throws InterruptedException {
        for (Map.Entry<String, Map<String, SensorOrder>> entry : modes.entrySet()) {
            System.out.println(String.format("%n-- %s mode activated --", entry.getKey()));
            Thread.sleep(2000);
            changeComponentsState(entry.getValue());
        }
    }

    /**
     * Parses json file to Map<Component, String[].
     *
     * @param details represents the json file that will be parsed.
     * @return the following object: Map<Component, String[].
     * @throws FileNotFoundException if file cannot be found in the specified location.
     */
    private Map<Component, String[]> parseHouseDetails(final String details) throws FileNotFoundException {
        return JsonParser.parseJsonToComponentMap(details);
    }

    /**
     * Prints an animation loading.
     *
     * @throws InterruptedException if thread is interrupted.
     */
    private static void printLoadAction() throws InterruptedException {
        System.out.print("Loading updates ");
        StringBuilder dot = new StringBuilder(".");
        for (int i = 0; i < 6; i++) {
            System.out.print(dot.toString());
            Thread.sleep(1000);
            dot.append(".");
        }
        System.out.println();
    }
}
