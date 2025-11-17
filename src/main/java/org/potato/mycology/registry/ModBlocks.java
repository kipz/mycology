package org.potato.mycology.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.potato.mycology.MycologyMod;
import org.potato.mycology.block.MushroomPlantBlock;

/**
 * Registry for all mushroom blocks in the mod
 */
public class ModBlocks {

    // ========== EDIBLE MUSHROOM BLOCKS ==========

    public static final Block CHANTERELLE_MUSHROOM = registerBlock("chanterelle_mushroom",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY));

    public static final Block PORCINI_MUSHROOM = registerBlock("porcini_mushroom",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY));

    public static final Block FIELD_MUSHROOM_BLOCK = registerBlock("field_mushroom",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOL)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY));

    public static final Block OYSTER_MUSHROOM_BLOCK = registerBlock("oyster_mushroom",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOL)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY));

    public static final Block PARASOL_MUSHROOM_BLOCK = registerBlock("parasol_mushroom",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY));

    // ========== POISONOUS MUSHROOM BLOCKS ==========

    public static final Block FLY_AGARIC_MUSHROOM = registerBlock("fly_agaric_mushroom",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY));

    public static final Block DEATH_CAP_MUSHROOM = registerBlock("death_cap_mushroom",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY));

    /**
     * Register a block with proper ResourceKey
     */
    private static Block registerBlock(String name, BlockBehaviour.Properties properties) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, name);
        ResourceKey<Block> blockKey = ResourceKey.create(BuiltInRegistries.BLOCK.key(), id);
        Block block = new MushroomPlantBlock(properties.setId(blockKey));
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    /**
     * Initialize and register all blocks
     */
    public static void registerBlocks() {
        MycologyMod.LOGGER.info("Registering mushroom blocks for " + MycologyMod.MOD_ID);
    }
}
