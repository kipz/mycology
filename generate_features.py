#!/usr/bin/env python3
"""Generate complete ModFeatures.java with all mushroom spawn configurations."""

import os

def get_mushroom_biomes(name, content):
    """Determine appropriate biomes for a mushroom based on its description."""
    content_lower = content.lower()
    biomes = []

    # Check for specific habitat keywords
    if any(word in content_lower for word in ['conifer', 'pine', 'spruce', 'larch']):
        biomes.append('IS_TAIGA')

    if any(word in content_lower for word in ['forest', 'woodland', 'deciduous', 'beech', 'oak', 'birch']):
        biomes.append('IS_FOREST')

    if any(word in content_lower for word in ['grassland', 'meadow', 'pasture', 'lawn', 'grass', 'unimproved']):
        biomes.append('IS_FOREST')  # Fallback to forest

    # Special cases
    if 'underground' in content_lower or 'truffle' in name:
        biomes.append('IS_FOREST')

    # Default to forest if no biomes found
    if not biomes:
        biomes.append('IS_FOREST')

    return list(set(biomes))  # Remove duplicates

def main():
    shrooms_dir = 'shrooms'
    mushroom_files = sorted([f[:-3] for f in os.listdir(shrooms_dir) if f.endswith('.md')])

    output = []
    output.append("package org.potato.mycology.worldgen;")
    output.append("")
    output.append("import net.fabricmc.fabric.api.biome.v1.BiomeModifications;")
    output.append("import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;")
    output.append("import net.minecraft.core.registries.Registries;")
    output.append("import net.minecraft.resources.ResourceKey;")
    output.append("import net.minecraft.resources.ResourceLocation;")
    output.append("import net.minecraft.tags.BiomeTags;")
    output.append("import net.minecraft.world.level.levelgen.GenerationStep;")
    output.append("import net.minecraft.world.level.levelgen.placement.PlacedFeature;")
    output.append("import org.potato.mycology.MycologyMod;")
    output.append("")
    output.append("/**")
    output.append(" * Handles registration of worldgen features and biome modifications")
    output.append(f" * Generated for {len(mushroom_files)} mushroom types")
    output.append(" */")
    output.append("public class ModFeatures {")
    output.append("")
    output.append("    // Feature keys for all mushrooms")

    # Generate feature keys
    for name in mushroom_files:
        const_name = 'PATCH_' + name.upper()
        output.append(f'    public static final ResourceKey<PlacedFeature> {const_name} = createKey("patch_{name}");')

    output.append("")
    output.append("    private static ResourceKey<PlacedFeature> createKey(String name) {")
    output.append("        return ResourceKey.create(Registries.PLACED_FEATURE,")
    output.append("                ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, name));")
    output.append("    }")
    output.append("")
    output.append("    /**")
    output.append("     * Register biome modifications to add our mushrooms to various biomes")
    output.append("     */")
    output.append("    public static void registerBiomeModifications() {")
    output.append('        MycologyMod.LOGGER.info("Registering biome modifications for {} mushroom features", ' + str(len(mushroom_files)) + ');')
    output.append("")

    # Generate biome modifications
    for name in mushroom_files:
        const_name = 'PATCH_' + name.upper()

        # Read mushroom file
        with open(os.path.join(shrooms_dir, f"{name}.md"), 'r') as f:
            content = f.read()

        biomes = get_mushroom_biomes(name, content)

        # Generate biome selector
        if len(biomes) == 1:
            selector = f'BiomeSelectors.tag(BiomeTags.{biomes[0]})'
        else:
            selector = f'BiomeSelectors.tag(BiomeTags.{biomes[0]})'
            for biome in biomes[1:]:
                selector += f'\n                        .or(BiomeSelectors.tag(BiomeTags.{biome}))'

        output.append(f'        // {name.replace("_", " ").title()}')
        output.append(f'        BiomeModifications.addFeature(')
        output.append(f'                {selector},')
        output.append(f'                GenerationStep.Decoration.VEGETAL_DECORATION,')
        output.append(f'                {const_name}')
        output.append(f'        );')
        output.append("")

    output.append('        MycologyMod.LOGGER.info("Biome modifications registered successfully");')
    output.append("    }")
    output.append("}")

    # Write to file
    with open('src/main/java/org/potato/mycology/worldgen/ModFeatures.java', 'w') as f:
        f.write('\n'.join(output))

    print(f"Generated ModFeatures.java with {len(mushroom_files)} mushroom spawn configurations")

if __name__ == '__main__':
    main()
