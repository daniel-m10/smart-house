package com.techgroup.core;

import com.techgroup.utilities.JsonParser;

import java.io.FileNotFoundException;

/**
 * Simulates changes in some components from a House object.
 */
public final class Simulation {

    /**
     * Private constructor.
     */
    private Simulation() {
    }

    /**
     * Main method that start with simulation.
     *
     * @param args passed via console.
     * @throws FileNotFoundException if a json file cannot be found.
     * @throws InterruptedException  if a thread is interrupted.
     */
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        final String houseDetails = "src/main/resources/components.json";
        final String addingObserversMessage = "\nFirst we start adding new observers:";
        final String verifyingSubscribersMessage = "\nNow we'll verify that every subscribed user start getting notifications:\n";
        final String ordersPath = "src/main/resources/orders.json";
        final String verifyingUnsubscribedUsers = "\nNow we'll verify that an unsubscribed user won't get notifications:\n";
        final String modesPath = "src/main/resources/modes.json";
        final String verifyingModesMessage = "\nNow we'll verify that we can change a bunch of components through mode commands:\n";
        final House house = new House(houseDetails);
        final Device daniel = new Device("Daniel");
        final Device felipe = new Device("Felipe");
        System.out.println(addingObserversMessage);
        waitFor(4);
        house.addObserver(daniel);
        waitFor(3);
        house.addObserver(felipe);
        waitFor(3);
        waitFor(3);
        System.out.println(verifyingSubscribersMessage);
        waitFor(4);
        house.changeComponentsState(JsonParser.parseJsonToOrderMap(ordersPath));
        System.out.println(verifyingUnsubscribedUsers);
        waitFor(4);
        house.removeObserver(felipe);
        waitFor(2);
        house.changeComponentsState(JsonParser.parseJsonToOrderMap(ordersPath));
        System.out.println(verifyingModesMessage);
        waitFor(2);
        house.setMode(JsonParser.parseJsonToModeMap(modesPath));
    }

    /**
     * Waits for some specific time.
     *
     * @param seconds that process will wait before to continue.
     * @throws InterruptedException if thread is interrupted somehow.
     */
    private static void waitFor(final long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
