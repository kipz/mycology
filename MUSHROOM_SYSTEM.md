# Dynamic Mushroom System

## Overview
The Mycology mod now uses a **fully dynamic registration system**. You can add new mushrooms WITHOUT touching any Java code!

## How to Add a New Mushroom

### 1. Create the mushroom description file
Add a markdown file in `shrooms/new_mushroom_name.md` following the existing format:
```markdown
### Mushroom Name
*Scientific name*

**Quick Reference:**
- **Item ID:** `mycology:new_mushroom_name`
- **Edibility:** Choice Edible / Edible / Inedible / POISONOUS
- **Toxicity:** None / MILD / SEVERE / etc.
- **Season:** When it fruits
- **Habitat:** Where it grows

**In-Game Properties:**
- **Nutrition:** 4
- **Saturation:** 0.6
- **Effects:** None / Poison II (0:15), etc.
```

### 2. Run the generation scripts
```bash
# Generate metadata JSON
python3 generate_mushroom_metadata.py

# Generate texture
python3 generate_mushroom_textures.py

# Generate worldgen JSONs
python3 << 'GENEOF'
# (see generate_worldgen_json.py for full script)
GENEOF
```

### 3. Rebuild and run
```bash
./gradlew build
./gradlew runClient
```

That's it! The mushroom will automatically:
- ✅ Be registered as a block
- ✅ Be registered as an item
- ✅ Appear in the creative tab
- ✅ Have a texture
- ✅ Spawn in appropriate biomes
- ✅ Have correct food properties
- ✅ Have correct effects

## System Architecture

### Metadata Flow
```
shrooms/*.md → JSON metadata → Dynamic Registry → Blocks, Items, Worldgen
```

### Key Components

1. **MushroomDataLoader** - Reads JSON metadata files
2. **MushroomMetadata** - Data model for mushroom properties
3. **DynamicMushroomRegistry** - Auto-registers blocks and items
4. **ModFeatures** - Auto-registers worldgen features
5. **JSON metadata** - `/data/mycology/mushroom_metadata/*.json`
6. **Worldgen JSONs** - `/data/mycology/worldgen/{configured,placed}_feature/*.json`

### Current Stats
- 138 mushrooms fully registered
- 138 blocks auto-created
- 138 items auto-created  
- 138 worldgen features configured
- 138 textures generated
- ALL spawning in forest and taiga biomes

## No More Code Changes Needed!
Just add the .md file and run the Python scripts. The system handles everything else automatically.
