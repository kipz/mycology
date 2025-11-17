# Mycology - UK Mushroom Foraging Mod

A comprehensive Minecraft mod featuring realistic UK mushroom species with identification systems, medicinal properties, and diverse foraging mechanics.

## Features

### 31 Authentic UK Mushroom Species

#### Edible Mushrooms (15 species)
- **Chanterelle** (Cantharellus cibarius) - Choice edible with fruity aroma
- **Porcini** (Boletus edulis) - Prized cep mushroom
- **Field Mushroom** (Agaricus campestris) - Common meadow mushroom
- **Oyster Mushroom** (Pleurotus ostreatus) - Easy-to-identify bracket fungus
- **Parasol Mushroom** (Macrolepiota procera) - Large distinctive mushroom
- **Giant Puffball** (Calvatia gigantea) - Massive spherical mushroom
- **Bay Bolete** (Imleria badia) - Common woodland bolete
- **Chicken of the Woods** (Laetiporus sulphureus) - Bright orange bracket
- **Hedgehog Mushroom** (Hydnum repandum) - Distinctive spined underside
- **Wood Blewit** (Lepista nuda) - Purple-lilac autumn mushroom
- **Shaggy Ink Cap** (Coprinus comatus) - Self-dissolving "Lawyer's Wig"
- **Horn of Plenty** (Craterellus cornucopioides) - Dark trumpet mushroom
- **Beefsteak Fungus** (Fistulina hepatica) - Meat-like bracket fungus
- **Saffron Milk Cap** (Lactarius deliciosus) - Orange milk-producing mushroom
- **Dryad's Saddle** (Polyporus squamosus) - Spring bracket with cucumber scent

#### Medicinal Mushrooms (8 species)
- **Turkey Tail** (Trametes versicolor) - Immune support
- **Birch Polypore** (Fomitopsis betulina) - Antimicrobial properties
- **Jelly Ear** (Auricularia auricula-judae) - Blood health, also edible
- **Hoof Fungus** (Fomes fomentarius) - Anti-inflammatory
- **Artist's Bracket** (Ganoderma applanatum) - Immunomodulatory
- **Chaga** (Inonotus obliquus) - Antioxidant powerhouse
- **Reishi** (Ganoderma lucidum) - "Mushroom of immortality"
- **Lion's Mane** (Hericium erinaceus) - Cognitive enhancement, also edible

#### Poisonous Mushrooms (8 species)
- **Death Cap** (Amanita phalloides) - ☠ DEADLY
- **Destroying Angel** (Amanita virosa) - ☠ DEADLY
- **Deadly Fibrecap** (Inocybe erubescens) - ☠ DEADLY
- **Deadly Webcap** (Cortinarius rubellus) - ☠ DEADLY
- **Yellow Stainer** (Agaricus xanthodermus) - ⚠ Toxic
- **Fly Agaric** (Amanita muscaria) - ⚠ Highly Toxic
- **Panther Cap** (Amanita pantherina) - ⚠ Highly Toxic
- **False Chanterelle** (Hygrophoropsis aurantiaca) - ⚠ Mildly Toxic

### Identification System
- Hover tooltips with scientific names
- Edibility ratings and toxicity warnings
- Detailed identification features (Advanced tooltips - F3+H)
- Based on real UK field guide characteristics
- Color-coded edibility indicators
- Clear toxicity warnings (⚠ and ☠ symbols)

### World Generation
- 4 mushroom species spawn naturally in the world
- Biome-specific placement (Forest, Taiga biomes)
- Random patch generation on grass blocks, dirt, and podzol
- Natural discovery and foraging gameplay

### Block System
- 7 placeable mushroom blocks (5 edible, 2 poisonous)
- Non-solid blocks with instant breaking
- Grass-like sound effects
- Proper loot drops when harvested

### Game Effects
- **Edible mushrooms**: Provide nutrition and saturation
- **Medicinal mushrooms**: Grant beneficial potion effects (Regeneration, Hero of the Village)
- **Poisonous mushrooms**: Apply harmful effects (Poison, Wither, Confusion) with severity matching real toxicity

### Creative Tabs Organization
- **Food & Drinks**: 17 edible mushroom items
- **Ingredients**: 6 medicinal mushroom items
- **Poisonous mushrooms**: Not in creative tabs (only obtainable through world generation for safety)

### Planned Features (Future Updates)
- Progressive learning system (unlock mushroom knowledge through discovery)
- Expanded world generation for all 31 species
- Tree association spawning (mycorrhizal relationships)
- Field Guide book item with identification flowcharts
- Medicinal crafting system (tinctures, teas, salves)
- Integration with vanilla brewing system
- Seasonal spawning mechanics
- Mushroom cultivation and farming
- Custom pixel art textures for all species

## Requirements

- Minecraft 1.21.4
- Fabric Loader 0.16.9 or higher
- Fabric API 0.111.0 or higher
- Java 21

## Installation

### For Players
1. Install Fabric Loader for Minecraft 1.21.4
2. Download Fabric API from Modrinth or CurseForge
3. Download the Mycology mod JAR file
4. Place both JAR files in your `.minecraft/mods` folder
5. Launch Minecraft with the Fabric profile

### For Developers

#### Prerequisites
- Java 21 JDK installed
- Git (optional)

#### Setup

1. **Install Java 21**
   - Download from [Adoptium](https://adoptium.net/) or [Oracle](https://www.oracle.com/java/technologies/downloads/)
   - Verify installation: `java -version`

2. **Clone or download this repository**
   ```bash
   git clone <repository-url>
   cd mc-plugin
   ```

3. **Build the mod**
   ```bash
   ./gradlew build
   ```

   The compiled JAR will be in `build/libs/`

4. **Run in development**
   ```bash
   ./gradlew runClient  # Launch Minecraft client
   ./gradlew runServer  # Launch dedicated server
   ```

5. **Generate IDE project files**
   ```bash
   ./gradlew idea        # IntelliJ IDEA
   ./gradlew eclipse     # Eclipse
   ```

## Project Structure

```
mc-plugin/
├── src/main/
│   ├── java/org/potato/mycology/
│   │   ├── MycologyMod.java              # Main mod entry point
│   │   ├── MycologyModClient.java        # Client-side initialization
│   │   ├── block/
│   │   │   └── MushroomPlantBlock.java   # Base mushroom block class
│   │   ├── item/mushroom/
│   │   │   ├── MushroomItem.java         # Base mushroom item class
│   │   │   └── MushroomProperties.java   # Mushroom characteristics
│   │   ├── registry/
│   │   │   ├── ModItems.java             # Item registration
│   │   │   ├── ModBlocks.java            # Block registration
│   │   │   └── ModItemGroups.java        # Creative tab setup
│   │   └── worldgen/
│   │       └── ModFeatures.java          # World generation features
│   └── resources/
│       ├── fabric.mod.json               # Mod metadata
│       ├── mycology.mixins.json          # Mixin configuration
│       ├── assets/mycology/
│       │   ├── lang/en_us.json           # English translations
│       │   ├── models/                   # Block and item models
│       │   ├── blockstates/              # Block state definitions
│       │   └── textures/item/            # Item textures (TODO)
│       └── data/mycology/
│           ├── worldgen/
│           │   ├── configured_feature/   # Feature configurations
│           │   └── placed_feature/       # Feature placements
│           └── loot_tables/blocks/       # Block drop tables
├── build.gradle                          # Build configuration
├── gradle.properties                     # Mod properties
└── README.md                             # This file
```

## Development Roadmap

### Phase 1: Core Items ✅
- [x] Create mushroom item system
- [x] Register all 31 species
- [x] Implement identification tooltips
- [x] Add food properties and effects
- [x] Create 7 mushroom blocks (Chanterelle, Porcini, Field Mushroom, Oyster, Parasol, Fly Agaric, Death Cap)
- [x] Add block models and blockstates

### Phase 2: World Generation (Partially Complete) ⏳
- [x] Create mushroom block entities
- [x] Implement basic biome-specific spawning for 4 species
- [x] Configure world generation features (configured_feature and placed_feature)
- [x] Add loot tables for mushroom blocks
- [ ] Expand world generation to all mushroom species
- [ ] Add tree association logic
- [ ] Configure rarity tiers
- [ ] Optional seasonal mechanics

### Phase 3: Progressive Learning
- [ ] Player knowledge tracking system
- [ ] Discovery mechanics
- [ ] Identification progression
- [ ] Examination GUI

### Phase 4: Field Guide
- [ ] Craftable Field Guide item
- [ ] Custom GUI with species entries
- [ ] Identification flowcharts
- [ ] Habitat information

### Phase 5: Medicinal System
- [ ] Vanilla brewing integration
- [ ] Custom tincture crafting station
- [ ] Direct consumption effects
- [ ] Preparation recipes

### Phase 6: Recipes & Crafting
- [ ] Mushroom-based food recipes
- [ ] Preservation mechanics
- [ ] Medicinal recipes
- [ ] Field Guide crafting

### Phase 7: Polish
- [ ] Create all 31 pixel art textures
- [ ] Write unit tests
- [ ] Balance spawning and effects
- [ ] Performance optimization
- [ ] Documentation

## Contributing

Contributions are welcome! Please ensure:
- Code follows existing style conventions
- All mushroom data is scientifically accurate
- UK-specific mushroom information is prioritized
- Test your changes before submitting

## Data Sources

All mushroom data is based on authentic UK mycological resources:
- Woodland Trust UK
- Wild Food UK
- First Nature Fungi Guide
- UK Wildlife Trusts
- Royal Botanic Gardens, Kew
- British Mycological Society resources

## License

MIT License

## Disclaimer

This mod is for entertainment purposes only. Do NOT use it as a real-world foraging guide. Always consult expert mycologists and multiple field guides before consuming wild mushrooms. Many mushrooms can cause serious illness or death if misidentified.

## Credits

- Mod Development: org.potato
- Mushroom Research: UK mycological databases and field guides
- Built with Fabric Mod Loader
