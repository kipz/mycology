package org.potato.mycology.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.potato.mycology.MycologyMod;
import org.potato.mycology.item.mushroom.MushroomProperties.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Loads mushroom metadata from JSON files
 */
public class MushroomDataLoader {

    private static final Map<String, MushroomMetadata> MUSHROOM_DATA = new HashMap<>();
    private static final Gson GSON = new Gson();

    /**
     * Load all mushroom metadata from JSON resources
     */
    public static void loadAllMushrooms() {
        MycologyMod.LOGGER.info("Loading mushroom metadata from JSON files...");

        // Get list of all mushroom names
        List<String> mushroomNames = getMushroomNames();

        for (String name : mushroomNames) {
            try {
                MushroomMetadata metadata = loadMushroomJson(name);
                if (metadata != null) {
                    MUSHROOM_DATA.put(name, metadata);
                }
            } catch (Exception e) {
                MycologyMod.LOGGER.error("Failed to load mushroom data for: " + name, e);
            }
        }

        MycologyMod.LOGGER.info("Loaded metadata for {} mushrooms", MUSHROOM_DATA.size());
    }

    /**
     * Load mushroom metadata from JSON file
     */
    private static MushroomMetadata loadMushroomJson(String name) {
        try {
            InputStream stream = MushroomDataLoader.class.getResourceAsStream(
                    "/data/mycology/mushroom_metadata/" + name + ".json");

            if (stream == null) {
                MycologyMod.LOGGER.warn("Mushroom metadata file not found: " + name);
                return null;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            JsonObject json = GSON.fromJson(reader, JsonObject.class);
            reader.close();

            return parseJsonMetadata(json);
        } catch (IOException e) {
            MycologyMod.LOGGER.error("Error reading mushroom metadata: " + name, e);
            return null;
        }
    }

    /**
     * Parse JSON into MushroomMetadata
     */
    private static MushroomMetadata parseJsonMetadata(JsonObject json) {
        String name = json.get("name").getAsString();
        String scientificName = json.get("scientific_name").getAsString();

        EdibilityRating edibility = EdibilityRating.valueOf(json.get("edibility").getAsString());
        ToxicityLevel toxicity = ToxicityLevel.valueOf(json.get("toxicity").getAsString());

        int nutrition = json.get("nutrition").getAsInt();
        float saturation = json.get("saturation").getAsFloat();

        // Parse effects array
        List<String> effectsList = new ArrayList<>();
        if (json.has("effects") && json.get("effects").isJsonArray()) {
            json.get("effects").getAsJsonArray().forEach(
                    element -> effectsList.add(element.getAsString())
            );
        }
        String[] effects = effectsList.toArray(new String[0]);

        return new MushroomMetadata(name, scientificName, edibility, toxicity,
                nutrition, saturation, effects);
    }

    /**
     * Get all mushroom names from index
     */
    public static List<String> getMushroomNames() {
        List<String> names = new ArrayList<>();

        try {
            InputStream stream = MushroomDataLoader.class.getResourceAsStream("/shrooms/_index.txt");
            if (stream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty() && !line.startsWith("#")) {
                        names.add(line);
                    }
                }
                reader.close();
            }
        } catch (IOException e) {
            MycologyMod.LOGGER.error("Could not read mushroom index", e);
        }

        return names;
    }

    /**
     * Get metadata for a specific mushroom
     */
    public static MushroomMetadata getMetadata(String name) {
        return MUSHROOM_DATA.get(name);
    }

    /**
     * Get all mushroom metadata
     */
    public static Map<String, MushroomMetadata> getAllMetadata() {
        return new HashMap<>(MUSHROOM_DATA);
    }
}
