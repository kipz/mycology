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

/**
 * Handles registration of worldgen features and biome modifications
 */
public class ModFeatures {

    // Feature keys
    public static final ResourceKey<PlacedFeature> PATCH_CHANTERELLE = createKey("patch_chanterelle");
    public static final ResourceKey<PlacedFeature> PATCH_PORCINI = createKey("patch_porcini");
    public static final ResourceKey<PlacedFeature> PATCH_FIELD_MUSHROOM = createKey("patch_field_mushroom");
    public static final ResourceKey<PlacedFeature> PATCH_FLY_AGARIC = createKey("patch_fly_agaric");

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, name));
    }

    /**
     * Register biome modifications to add our mushrooms to various biomes
     */
    public static void registerBiomeModifications() {
        MycologyMod.LOGGER.info("Registering biome modifications for mushroom features");

        // Add chanterelles to forest biomes (common in deciduous forests)
        BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.IS_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PATCH_CHANTERELLE
        );

        // Add porcini to forest and taiga biomes (loves coniferous forests)
        BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.IS_FOREST)
                        .or(BiomeSelectors.tag(BiomeTags.IS_TAIGA)),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PATCH_PORCINI
        );

        // Add field mushrooms to plains and meadows
        BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.IS_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PATCH_FIELD_MUSHROOM
        );

        // Add fly agaric to taiga and forest biomes (loves birch and pine)
        BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.IS_TAIGA)
                        .or(BiomeSelectors.tag(BiomeTags.IS_FOREST)),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PATCH_FLY_AGARIC
        );

        MycologyMod.LOGGER.info("Biome modifications registered successfully");
    }
}
