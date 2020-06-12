package com.techgroup.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.techgroup.types.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Utility class used for parsing json files to a specified type of Map.
 */
public final class JsonParser {
    private static final Gson gson;
    private static final Type componentMap;

    static {
        gson = new Gson();
        componentMap = new TypeToken<Map<Component, String[]>>() {}.getType();
    }

    /**
     * Private constructor, no one can create an instance of the object.
     */
    private JsonParser() {
    }

    /**
     * Parses a json to a Component Map, this one will be used by HouseComponentFactory class.
     *
     * @param filePath represents the relative path of file that contains list of components.
     * @return a Map of components with the names that represent a component in the house.
     * @throws FileNotFoundException if file cannot be found in the specified path.
     */
    public static Map<Component, String[]> parseJsonToComponentMap(final String filePath) throws FileNotFoundException {
        return gson.fromJson(getFile(filePath), componentMap);
    }

    /**
     * Uses to create an FileReader instance that will be used by gson.fromJson() method.
     *
     * @param path represents the relative path from which file will be read.
     * @return a new FileReader instance.
     * @throws FileNotFoundException if file cannot be found in the specified path.
     */
    private static FileReader getFile(final String path) throws FileNotFoundException {
        try {
            return new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(String.format("File was not found at %s", path));
        }
    }
}
