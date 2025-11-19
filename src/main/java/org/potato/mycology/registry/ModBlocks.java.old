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

    // ========== NEW UK FUNGI BLOCKS ==========

    public static final Block MOREL_MUSHROOM = registerMushroomBlock("morel_mushroom");
    public static final Block CEP_MUSHROOM = registerMushroomBlock("cep_mushroom");
    public static final Block ST_GEORGES_MUSHROOM_MUSHROOM = registerMushroomBlock("st_georges_mushroom_mushroom");
    public static final Block FAIRY_RING_CHAMPIGNON_MUSHROOM = registerMushroomBlock("fairy_ring_champignon_mushroom");
    public static final Block AMETHYST_DECEIVER_MUSHROOM = registerMushroomBlock("amethyst_deceiver_mushroom");
    public static final Block CHARCOAL_BURNER_MUSHROOM = registerMushroomBlock("charcoal_burner_mushroom");
    public static final Block VELVET_SHANK_MUSHROOM = registerMushroomBlock("velvet_shank_mushroom");
    public static final Block PENNY_BUN_MUSHROOM = registerMushroomBlock("penny_bun_mushroom");
    public static final Block COMMON_PUFFBALL_MUSHROOM = registerMushroomBlock("common_puffball_mushroom");
    public static final Block SLIPPERY_JACK_MUSHROOM = registerMushroomBlock("slippery_jack_mushroom");
    public static final Block WOOD_HEDGEHOG_MUSHROOM = registerMushroomBlock("wood_hedgehog_mushroom");
    public static final Block ORANGE_BIRCH_BOLETE_MUSHROOM = registerMushroomBlock("orange_birch_bolete_mushroom");
    public static final Block HONEY_FUNGUS_MUSHROOM = registerMushroomBlock("honey_fungus_mushroom");
    public static final Block COMMON_EARTHBALL_MUSHROOM = registerMushroomBlock("common_earthball_mushroom");
    public static final Block SULPHUR_TUFT_MUSHROOM = registerMushroomBlock("sulphur_tuft_mushroom");
    public static final Block SICKENER_MUSHROOM = registerMushroomBlock("sickener_mushroom");
    public static final Block BROWN_ROLL_RIM_MUSHROOM = registerMushroomBlock("brown_roll_rim_mushroom");
    public static final Block BLEWIT_MUSHROOM = registerMushroomBlock("blewit_mushroom");
    public static final Block SCARLET_WAXCAP_MUSHROOM = registerMushroomBlock("scarlet_waxcap_mushroom");
    public static final Block WOOLLY_MILK_CAP_MUSHROOM = registerMushroomBlock("woolly_milk_cap_mushroom");
    public static final Block DUNE_STINKHORN_MUSHROOM = registerMushroomBlock("dune_stinkhorn_mushroom");

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
     * Register a mushroom block with default properties
     */
    private static Block registerMushroomBlock(String name) {
        return registerBlock(name,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .noCollission()
                        .instabreak()
                        .sound(SoundType.GRASS)
                        .pushReaction(PushReaction.DESTROY));
    }

    /**
     * Initialize and register all blocks
     */
    public static void registerBlocks() {
        MycologyMod.LOGGER.info("Registering mushroom blocks for " + MycologyMod.MOD_ID);
    }
}
