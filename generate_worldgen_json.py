#!/usr/bin/env python3
"""Generate worldgen JSON files for all mushrooms that have blocks."""

import os
import json

# List of mushrooms that have blocks (from ModBlocks.java)
MUSHROOMS_WITH_BLOCKS = [
    "chanterelle",
    "porcini",
    "field_mushroom",
    "oyster_mushroom",
    "parasol_mushroom",
    "fly_agaric",
    "death_cap",
    "morel",
    "cep",
    "st_georges_mushroom",
    "fairy_ring_champignon",
    "amethyst_deceiver",
    "charcoal_burner",
    "velvet_shank",
    "penny_bun",
    "common_puffball",
    "slippery_jack",
    "wood_hedgehog",
    "orange_birch_bolete",
    "honey_fungus",
    "brown_birch_bolete",
    "bay_bolete"
]

def create_configured_feature(mushroom_name):
    """Create configured feature JSON for a mushroom."""
    block_name = f"{mushroom_name}_mushroom"

    return {
        "type": "minecraft:random_patch",
        "config": {
            "tries": 64,
            "xz_spread": 7,
            "y_spread": 3,
            "feature": {
                "feature": {
                    "type": "minecraft:simple_block",
                    "config": {
                        "to_place": {
                            "type": "minecraft:simple_state_provider",
                            "state": {
                                "Name": f"mycology:{block_name}"
                            }
                        }
                    }
                },
                "placement": [
                    {
                        "type": "minecraft:block_predicate_filter",
                        "predicate": {
                            "type": "minecraft:matching_blocks",
                            "offset": [0, -1, 0],
                            "blocks": ["minecraft:grass_block", "minecraft:dirt", "minecraft:podzol", "minecraft:coarse_dirt"]
                        }
                    }
                ]
            }
        }
    }

def create_placed_feature(mushroom_name, rarity=2):
    """Create placed feature JSON for a mushroom."""
    return {
        "feature": f"mycology:patch_{mushroom_name}",
        "placement": [
            {
                "type": "minecraft:rarity_filter",
                "chance": rarity
            },
            {
                "type": "minecraft:in_square"
            },
            {
                "type": "minecraft:height_range",
                "height": {
                    "type": "minecraft:uniform",
                    "min_inclusive": {
                        "absolute": 0
                    },
                    "max_inclusive": {
                        "absolute": 200
                    }
                }
            },
            {
                "type": "minecraft:biome"
            }
        ]
    }

def main():
    configured_dir = "src/main/resources/data/mycology/worldgen/configured_feature"
    placed_dir = "src/main/resources/data/mycology/worldgen/placed_feature"

    os.makedirs(configured_dir, exist_ok=True)
    os.makedirs(placed_dir, exist_ok=True)

    print(f"Generating worldgen JSON files for {len(MUSHROOMS_WITH_BLOCKS)} mushrooms with blocks...")

    for mushroom in MUSHROOMS_WITH_BLOCKS:
        # Create configured feature
        configured_path = os.path.join(configured_dir, f"patch_{mushroom}.json")
        with open(configured_path, 'w') as f:
            json.dump(create_configured_feature(mushroom), f, indent=2)
        print(f"  Created {configured_path}")

        # Create placed feature
        placed_path = os.path.join(placed_dir, f"patch_{mushroom}.json")
        with open(placed_path, 'w') as f:
            json.dump(create_placed_feature(mushroom), f, indent=2)
        print(f"  Created {placed_path}")

    print(f"\nGenerated {len(MUSHROOMS_WITH_BLOCKS) * 2} JSON files")
    print(f"\nNote: Only {len(MUSHROOMS_WITH_BLOCKS)} out of 138 mushrooms have blocks and can spawn naturally.")
    print("The remaining 116 mushrooms only exist as items and would need blocks created to spawn in world.")

if __name__ == '__main__':
    main()
