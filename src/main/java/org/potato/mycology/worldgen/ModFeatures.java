package org.potato.mycology.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.potato.mycology.MycologyMod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data-driven worldgen feature registry
 * Automatically loads and registers mushroom spawn features from the shrooms index
 * NO INDIVIDUAL MUSHROOM REFERENCES - fully dynamic!
 */
public class ModFeatures {

    private static final Map<String, ResourceKey<PlacedFeature>> FEATURE_KEYS = new HashMap<>();

    /**
     * Get a feature key by mushroom name
     */
    public static ResourceKey<PlacedFeature> getFeatureKey(String mushroomName) {
        return FEATURE_KEYS.get(mushroomName);
    }

    /**
     * Get all feature keys
     */
    public static Map<String, ResourceKey<PlacedFeature>> getAllFeatureKeys() {
        return new HashMap<>(FEATURE_KEYS);
    }

    /**
     * Load mushroom names from index file
     */
    private static List<String> loadMushroomNames() {
        List<String> names = new ArrayList<>();
        try {
            InputStream stream = ModFeatures.class.getResourceAsStream("/shrooms/_index.txt");
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
            MycologyMod.LOGGER.error("Failed to load mushroom index", e);
        }
        return names;
    }

    /**
     * Create resource key for a mushroom feature
     */
    private static ResourceKey<PlacedFeature> createKey(String mushroomName) {
        return ResourceKey.create(
                Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, "patch_" + mushroomName)
        );
    }

    /**
     * Register biome modifications for all mushrooms dynamically
     */
    public static void registerBiomeModifications() {
        List<String> mushroomNames = loadMushroomNames();

        MycologyMod.LOGGER.info("Registering {} mushroom features in biomes dynamically", mushroomNames.size());

        // Create and cache feature keys, then register them to biomes
        for (String name : mushroomNames) {
            try {
                ResourceKey<PlacedFeature> featureKey = createKey(name);
                FEATURE_KEYS.put(name, featureKey);

                // Add to forest and taiga biomes
                BiomeModifications.addFeature(
                        BiomeSelectors.tag(BiomeTags.IS_FOREST)
                                .or(BiomeSelectors.tag(BiomeTags.IS_TAIGA)),
                        GenerationStep.Decoration.VEGETAL_DECORATION,
                        featureKey
                );
            } catch (Exception e) {
                MycologyMod.LOGGER.error("Failed to register biome feature for: " + name, e);
            }
        }

        MycologyMod.LOGGER.info("Successfully registered {} mushroom features in biomes", FEATURE_KEYS.size());
    }
}
