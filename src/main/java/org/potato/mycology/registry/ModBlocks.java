package org.potato.mycology.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.potato.mycology.MycologyMod;
import org.potato.mycology.block.MushroomPlantBlock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data-driven registry for all mushroom blocks
 * Automatically loads and registers mushroom blocks from the shrooms index
 * NO INDIVIDUAL MUSHROOM REFERENCES - fully dynamic!
 */
public class ModBlocks {

    private static final Map<String, Block> MUSHROOM_BLOCKS = new HashMap<>();

    /**
     * Get a mushroom block by name
     */
    public static Block getMushroomBlock(String name) {
        return MUSHROOM_BLOCKS.get(name + "_mushroom");
    }

    /**
     * Get all registered mushroom blocks
     */
    public static Map<String, Block> getAllMushroomBlocks() {
        return new HashMap<>(MUSHROOM_BLOCKS);
    }

    /**
     * Register a mushroom block with standard properties
     */
    private static Block registerMushroomBlock(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, name);
        ResourceKey<Block> blockKey = ResourceKey.create(BuiltInRegistries.BLOCK.key(), id);
        Block block = new MushroomPlantBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_BROWN)
                        .noCollission()
                        .randomTicks()
                        .instabreak()
                        .sound(SoundType.GRASS)
                        .pushReaction(PushReaction.DESTROY)
                        .setId(blockKey)
        );
        Block registered = Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
        MUSHROOM_BLOCKS.put(name, registered);
        return registered;
    }

    /**
     * Load mushroom names from index file
     */
    private static List<String> loadMushroomNames() {
        List<String> names = new ArrayList<>();
        try {
            InputStream stream = ModBlocks.class.getResourceAsStream("/shrooms/_index.txt");
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
     * Initialize and register all blocks dynamically
     */
    public static void registerBlocks() {
        List<String> mushroomNames = loadMushroomNames();

        MycologyMod.LOGGER.info("Registering {} mushroom blocks dynamically from metadata", mushroomNames.size());

        for (String name : mushroomNames) {
            try {
                registerMushroomBlock(name + "_mushroom");
            } catch (Exception e) {
                MycologyMod.LOGGER.error("Failed to register block for mushroom: " + name, e);
            }
        }

        MycologyMod.LOGGER.info("Successfully registered {} mushroom blocks", MUSHROOM_BLOCKS.size());
    }
}
