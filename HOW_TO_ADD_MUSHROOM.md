# How to Add a New Mushroom - Zero Code Changes Required!

## Step 1: Create Mushroom Description
Add `shrooms/your_mushroom_name.md`:
```markdown
### Your Mushroom Name
*Scientific name*

**Quick Reference:**
- **Item ID:** `mycology:your_mushroom_name`
- **Edibility:** Choice Edible / Edible / Inedible / POISONOUS
- **Toxicity:** None / MILD / SEVERE / LETHAL
- **Season:** When it fruits
- **Habitat:** Where it grows

**In-Game Properties:**
- **Nutrition:** 4
- **Saturation:** 0.6
- **Effects:** None
```

## Step 2: Run Generation Scripts
```bash
# 1. Generate JSON metadata from markdown
python3 generate_mushroom_metadata.py

# 2. Generate texture (32x32 PNG)
python3 generate_mushroom_textures.py

# 3. Generate worldgen JSONs
python3 << 'GENEOF'
import json, os
with open('src/main/resources/shrooms/_index.txt') as f:
    mushrooms = [line.strip() for line in f if line.strip()]
# ... (see generate script for full code)
GENEOF

# 4. Generate blockstate and model JSONs
python3 << 'MODELEOF'
import json, os
with open('src/main/resources/shrooms/_index.txt') as f:
    mushrooms = [line.strip() for line in f if line.strip()]
# ... (see above for full code)
MODELEOF
```

## Step 3: Update Index
Add your mushroom name to `src/main/resources/shrooms/_index.txt`

## Step 4: Build and Run
```bash
./gradlew build
./gradlew runClient
```

## What Happens Automatically:
✅ Block registered with standard mushroom properties  
✅ Item registered with correct food values from metadata
✅ Worldgen configured to spawn in forests/taiga
✅ Blockstate and models created for proper rendering
✅ Loot drops configured (block → item)
✅ Added to creative tab automatically
✅ Client rendering (cutout) configured

## NO JAVA CODE CHANGES NEEDED! 🚀

All registrations happen dynamically by reading:
- `/shrooms/_index.txt` - List of all mushrooms
- `/data/mycology/mushroom_metadata/{name}.json` - Properties for each mushroom
