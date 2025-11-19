package org.potato.mycology.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.potato.mycology.MycologyMod;
import org.potato.mycology.data.MushroomDataLoader;
import org.potato.mycology.data.MushroomMetadata;
import org.potato.mycology.item.mushroom.MushroomItem;
import org.potato.mycology.item.mushroom.MushroomProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Data-driven registry for all mushroom items
 * Automatically loads and registers mushroom items from JSON metadata
 * NO INDIVIDUAL MUSHROOM REFERENCES - fully dynamic!
 */
public class ModItems {

    private static final Map<String, Item> MUSHROOM_ITEMS = new HashMap<>();

    /**
     * Get a mushroom item by name
     */
    public static Item getMushroomItem(String name) {
        return MUSHROOM_ITEMS.get(name);
    }

    /**
     * Get all registered mushroom items
     */
    public static Map<String, Item> getAllMushroomItems() {
        return new HashMap<>(MUSHROOM_ITEMS);
    }

    /**
     * Register a mushroom item from metadata
     */
    private static Item registerMushroomItem(String name, MushroomMetadata metadata) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, name)
        );

        // Get the corresponding block
        Block block = ModBlocks.getMushroomBlock(name);
        if (block == null) {
            block = net.minecraft.world.level.block.Blocks.AIR; // Fallback for items without blocks
        }

        // Create mushroom properties from metadata
        MushroomProperties properties = new MushroomProperties.Builder()
                .scientificName(metadata.getScientificName())
                .category(metadata.getCategory())
                .edibilityRating(metadata.getEdibilityRating())
                .toxicityLevel(metadata.getToxicityLevel())
                .identificationFeatures("Loaded from metadata")
                .build();

        // Create food properties from metadata
        FoodProperties foodProperties = new FoodProperties.Builder()
                .nutrition(metadata.getNutrition())
                .saturationModifier(metadata.getSaturation())
                .build();

        // Create and register the item
        Item item = new MushroomItem(block, properties, itemKey, foodProperties);
        Item registered = Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        MUSHROOM_ITEMS.put(name, registered);
        return registered;
    }

    /**
     * Initialize and register all items dynamically from metadata
     */
    public static void registerItems() {
        // Load mushroom metadata
        MushroomDataLoader.loadAllMushrooms();

        MycologyMod.LOGGER.info("Registering mushroom items dynamically from metadata");

        // Register each mushroom item
        for (Map.Entry<String, MushroomMetadata> entry : MushroomDataLoader.getAllMetadata().entrySet()) {
            try {
                registerMushroomItem(entry.getKey(), entry.getValue());
            } catch (Exception e) {
                MycologyMod.LOGGER.error("Failed to register item for mushroom: " + entry.getKey(), e);
            }
        }

        MycologyMod.LOGGER.info("Successfully registered {} mushroom items", MUSHROOM_ITEMS.size());
    }
}
