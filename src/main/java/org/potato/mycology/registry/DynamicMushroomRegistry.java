package org.potato.mycology.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.potato.mycology.MycologyMod;
import org.potato.mycology.block.MushroomPlantBlock;
import org.potato.mycology.data.MushroomDataLoader;
import org.potato.mycology.data.MushroomMetadata;
import org.potato.mycology.item.mushroom.MushroomItem;
import org.potato.mycology.item.mushroom.MushroomProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamically registers all mushrooms as blocks and items based on metadata
 */
public class DynamicMushroomRegistry {

    private static final Map<String, Block> MUSHROOM_BLOCKS = new HashMap<>();
    private static final Map<String, Item> MUSHROOM_ITEMS = new HashMap<>();

    /**
     * Register all mushrooms dynamically
     */
    public static void registerAll() {
        MycologyMod.LOGGER.info("Starting dynamic mushroom registration...");

        // Load mushroom metadata
        MushroomDataLoader.loadAllMushrooms();

        // Register each mushroom
        for (Map.Entry<String, MushroomMetadata> entry : MushroomDataLoader.getAllMetadata().entrySet()) {
            String name = entry.getKey();
            MushroomMetadata metadata = entry.getValue();

            try {
                // Register block
                Block block = registerBlock(name, metadata);
                MUSHROOM_BLOCKS.put(name, block);

                // Register item
                Item item = registerItem(name, metadata, block);
                MUSHROOM_ITEMS.put(name, item);

                MycologyMod.LOGGER.debug("Registered mushroom: {}", name);
            } catch (Exception e) {
                MycologyMod.LOGGER.error("Failed to register mushroom: " + name, e);
            }
        }

        MycologyMod.LOGGER.info("Dynamically registered {} mushroom blocks and items",
                MUSHROOM_BLOCKS.size());
    }

    /**
     * Register a mushroom block
     */
    private static Block registerBlock(String name, MushroomMetadata metadata) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, name + "_mushroom");

        // Create block properties
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_BROWN)
                .noCollission()
                .randomTicks()
                .instabreak()
                .sound(SoundType.GRASS)
                .pushReaction(PushReaction.DESTROY);

        // Create mushroom block
        Block block = new MushroomPlantBlock(properties);

        // Register block
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    /**
     * Register a mushroom item
     */
    private static Item registerItem(String name, MushroomMetadata metadata, Block block) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, name)
        );

        // Create mushroom properties
        MushroomProperties properties = new MushroomProperties.Builder()
                .scientificName(metadata.getScientificName())
                .category(metadata.getCategory())
                .edibilityRating(metadata.getEdibilityRating())
                .toxicityLevel(metadata.getToxicityLevel())
                .identificationFeatures("Loaded from metadata")
                .build();

        // Create food properties
        FoodProperties.Builder foodBuilder = new FoodProperties.Builder()
                .nutrition(metadata.getNutrition())
                .saturationModifier(metadata.getSaturation());

        // Add poison effect for poisonous mushrooms
        if (metadata.getEdibilityRating() == MushroomProperties.EdibilityRating.POISONOUS ||
            metadata.getEdibilityRating() == MushroomProperties.EdibilityRating.DEADLY) {
            // Effects will be added via consumables in a more advanced version
        }

        FoodProperties foodProperties = foodBuilder.build();

        // Create and register mushroom item
        Item item = new MushroomItem(block, properties, itemKey, foodProperties);
        return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    }

    /**
     * Get a registered mushroom block by name
     */
    public static Block getBlock(String name) {
        return MUSHROOM_BLOCKS.get(name);
    }

    /**
     * Get a registered mushroom item by name
     */
    public static Item getItem(String name) {
        return MUSHROOM_ITEMS.get(name);
    }

    /**
     * Get all registered mushroom blocks
     */
    public static Map<String, Block> getAllBlocks() {
        return new HashMap<>(MUSHROOM_BLOCKS);
    }

    /**
     * Get all registered mushroom items
     */
    public static Map<String, Item> getAllItems() {
        return new HashMap<>(MUSHROOM_ITEMS);
    }
}
