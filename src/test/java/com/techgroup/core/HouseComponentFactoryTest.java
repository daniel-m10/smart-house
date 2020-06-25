package com.techgroup.core;

import com.techgroup.types.Component;
import com.techgroup.utilities.JsonParser;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Test class the validate HouseComponentFactory methods
 */
public class HouseComponentFactoryTest {

    /**
     * Verifies that it's possible to create a Map of HouseComponents.
     *
     * @throws FileNotFoundException if json file with component details cannot be found.
     */
    @Test
    public void aMapOfComponentsCanBeCreatedFromAJsonFile() throws FileNotFoundException {
        final String jsonPath = "src/main/resources/components.json";
        Map<Component, String[]> description = JsonParser.parseJsonToComponentMap(jsonPath);
        int expectedResult = 20;
        int actualResult = HouseComponentFactory.buildComponents(description).size();
        assertEquals("The amount of components created should be equal to 20", expectedResult, actualResult);
    }
}