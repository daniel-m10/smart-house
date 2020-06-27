package com.techgroup.core;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class HouseTest {
    private House house;
    @Before
    public void setUp() throws FileNotFoundException {
        String componentsPath = "src/main/resources/components.json";
        house = new House(componentsPath);
    }

    @Test
    public void aNewHouseWithSmartComponentsWasCreated() {
        assertNotNull("House object was not created.",house);
    }
}