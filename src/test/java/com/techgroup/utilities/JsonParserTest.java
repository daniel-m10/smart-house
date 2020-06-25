package com.techgroup.utilities;

import com.techgroup.types.Component;
import com.techgroup.types.SensorOrder;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.techgroup.types.Component.DOOR;
import static com.techgroup.types.Component.LIGHTS;
import static com.techgroup.types.Component.MICROWAVE;
import static com.techgroup.types.Component.TV;
import static com.techgroup.types.Component.WINDOW;
import static com.techgroup.types.SensorOrder.CLOSE;
import static com.techgroup.types.SensorOrder.OPEN;
import static com.techgroup.types.SensorOrder.TURN_OFF;
import static com.techgroup.types.SensorOrder.TURN_ON;
import static org.junit.Assert.assertTrue;

/**
 * Test class the validate JsonParser methods
 */
public class JsonParserTest {
    private static final String ENTRANCE = "Entrance";
    private static final String GARAGE = "Garage";
    private static final String HALL = "Hall";
    private static final String BEDROOM_ONE = "1st_Floor_Bedroom";
    private static final String BEDROOM_TWO = "2nd_Floor_Bedroom";
    private static final String BATHROOM_ONE = "1st_Floor_Bathroom";
    private static final String BATHROOM_TWO = "2nd_Floor_Bathroom";
    private static final String KITCHEN = "Kitchen";
    private static final String ATTIC = "Attic";
    private static final String BASEMENT = "Basement";
    private static final String ENTRANCE_DOOR = "Entrance_Door";
    private static final String GARAGE_DOOR = "Garage_Door";
    private static final String KITCHEN_DOOR = "Kitchen_Door";
    private static final String BEDROOM_WINDOW = "2nd_Floor_Bedroom_Window";
    private static final String BASEMENT_TV = "Basement_Tv";
    private static final String KITCHEN_MICROWAVE = "Kitchen_Microwave";
    private static final String BATHROOM_LIGHTS = "1st_Floor_Bathroom_Lights";
    private static final String ATTIC_WINDOW = "Attic_Window";


    /**
     * Verifies if Map<Component, String[]> was created correctly from a specified json file.
     *
     * @throws FileNotFoundException if json file cannot be found.
     */
    @Test
    public void componentFileCanBeParsed() throws FileNotFoundException {
        String componentsPath = "src/main/resources/components.json";
        Map<Component, String[]> expectedResult = new EnumMap<>(Component.class);
        expectedResult.put(DOOR, new String[] {ENTRANCE, GARAGE, BEDROOM_ONE, BATHROOM_TWO, KITCHEN});
        expectedResult.put(WINDOW, new String[] {HALL, BEDROOM_TWO, KITCHEN, ATTIC});
        expectedResult.put(LIGHTS, new String[] {HALL, GARAGE, BATHROOM_ONE, KITCHEN, ATTIC, BASEMENT});
        expectedResult.put(TV, new String[] {HALL, BEDROOM_ONE, BASEMENT});
        expectedResult.put(MICROWAVE, new String[] {KITCHEN, BASEMENT});
        Map<Component, String[]> actualResult = JsonParser.parseJsonToComponentMap(componentsPath);
        assertTrue(areComponentMapsEqual(actualResult, expectedResult));
    }

    /**
     * Verifies if Map<String, SensorOrder> was created correctly from a specified json file.
     *
     * @throws FileNotFoundException if json file cannot be found.
     */
    @Test
    public void orderFileCanBeParsed() throws FileNotFoundException {
        String ordersPath = "src/main/resources/orders.json";
        Map<String, SensorOrder> expectedResult = new LinkedHashMap<>();
        expectedResult.put(ENTRANCE_DOOR, OPEN);
        expectedResult.put(GARAGE_DOOR, CLOSE);
        expectedResult.put(KITCHEN_DOOR, OPEN);
        expectedResult.put(BEDROOM_WINDOW, OPEN);
        expectedResult.put(BASEMENT_TV, TURN_ON);
        expectedResult.put(KITCHEN_MICROWAVE, TURN_OFF);
        expectedResult.put(BATHROOM_LIGHTS, TURN_ON);
        expectedResult.put(ATTIC_WINDOW, OPEN);
        Map<String, SensorOrder> actualResult = JsonParser.parseJsonToOrderMap(ordersPath);
        assertTrue(areOrderMapsEqual(actualResult, expectedResult));
    }

    /**
     * Determines if two Map of Components are equal.
     *
     * @param first  represents first map to compare.
     * @param second the other map will be compared with first map.
     * @return true if both maps are equal, false otherwise.
     */
    private boolean areComponentMapsEqual(final Map<Component, String[]> first, final Map<Component, String[]> second) {
        if (first.size() != second.size()) {
            return false;
        }
        return first.entrySet().stream().allMatch(e -> Arrays.equals(e.getValue(), second.get(e.getKey())));
    }

    /**
     * Determines if two Map of Orders are equal.
     *
     * @param first  represents first map to compare.
     * @param second the other map will be compared with first map.
     * @return true if both maps are equal, false otherwise.
     */
    private boolean areOrderMapsEqual(final Map<String, SensorOrder> first, final Map<String, SensorOrder> second) {
        if (first.size() != second.size()) {
            return false;
        }
        return first.entrySet().stream().allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }
}