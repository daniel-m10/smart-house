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
     * {@inheritDoc}.
     */
    @Override
    public void addObserver(final Observer o) {
        this.devices.add(o);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void removeObserver(final Observer o) {
        this.devices.remove(o);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : devices) {
            observer.update("the following component was changed its state");
        }
    }

    /**
     * Method that changes the state of all components listed in a json file.
     *
     * @param orders to follow in order to modify a component state.
     */
    public void changeComponentsState(final Map<String, SensorOrder> orders) {
        for (Map.Entry<String, SensorOrder> entry : orders.entrySet()) {
            notifyObserver();
            ((Sensor) houseComponentMap.get(entry.getKey().toUpperCase())).changeState(entry.getValue());
            houseComponentMap.get(entry.getKey().toUpperCase()).printComponentState();
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
}
