package com.techgroup.utilities;

import com.techgroup.types.Component;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import static com.techgroup.types.Component.DOOR;
import static com.techgroup.types.Component.LIGHTS;
import static com.techgroup.types.Component.MICROWAVE;
import static com.techgroup.types.Component.TV;
import static com.techgroup.types.Component.WINDOW;
import static org.junit.Assert.assertTrue;

/**
 * Test class the validate JsonParser methods
 */
public class JsonParserTest {
    private static final String ENTRANCE = "Entrance";
    private static final String GARAGE = "Garage";
    private static final String HALL = "Hall";
    private static final String BEDROOM_ONE = "1st Floor Bedroom";
    private static final String BEDROOM_TWO = "2nd Floor Bedroom";
    private static final String BATHROOM_ONE = "1st Floor Bathroom";
    private static final String BATHROOM_TWO = "2nd Floor Bathroom";
    private static final String KITCHEN = "Kitchen";
    private static final String ATTIC = "Attic";
    private static final String BASEMENT = "Basement";

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
}