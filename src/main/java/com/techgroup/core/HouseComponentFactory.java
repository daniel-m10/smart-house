package com.techgroup.core;

import com.techgroup.core.components.Door;
import com.techgroup.core.components.Lights;
import com.techgroup.core.components.Microwave;
import com.techgroup.core.components.Tv;
import com.techgroup.core.components.Window;
import com.techgroup.types.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Class in charge to create as many HouseComponent objects needed.
 */
public final class HouseComponentFactory {

    /**
     * Private constructor.
     */
    private HouseComponentFactory() {
    }

    /**
     * Builds all HouseComponents objects listed in a json file.
     *
     * @param description will contain all HouseComponent objects that will be created.
     * @return a Map of HouseComponents.
     */
    public static Map<String, HouseComponent> buildComponents(final Map<Component, String[]> description) {
        Map<String, HouseComponent> componentMap = new HashMap<>();
        for (Map.Entry<Component, String[]> entry : description.entrySet()) {
            for (int i = 0; i < entry.getValue().length; i++) {
                String componentName = generateComponentIdentifier(entry.getValue()[i], entry.getKey());
                componentMap.put(componentName, getComponent(entry.getKey(), componentName));
            }
        }
        return componentMap;
    }

    /**
     * Creates a HouseComponent based of component type.
     *
     * @param component that will be created.
     * @param name      that will be assigned to the component.
     * @return a HouseComponent.
     */
    private static HouseComponent getComponent(final Component component, final String name) {
        switch (component) {
            case TV:
                return new Tv(name);
            case DOOR:
                return new Door(name);
            case LIGHTS:
                return new Lights(name);
            case WINDOW:
                return new Window(name);
            default:
                return new Microwave(name);
        }
    }

    /**
     * Creates a unique identifier for each HouseComponent.
     *
     * @param name      of HouseComponent.
     * @param component type of HouseComponent.
     * @return a unique identifier for a HouseComponent.
     */
    private static String generateComponentIdentifier(final String name, final Component component) {
        return String.format("%s_%s", name.toUpperCase(), component);
    }
}
