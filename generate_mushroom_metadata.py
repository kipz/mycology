#!/usr/bin/env python3
"""Generate JSON metadata files for all mushrooms from their markdown files."""

import os
import re
import json

def parse_mushroom_markdown(name, content):
    """Parse mushroom markdown file to extract metadata."""

    # Extract scientific name (second line, in italics)
    lines = content.split('\n')
    scientific_name = ""
    for i, line in enumerate(lines[1:5]):  # Check first few lines
        match = re.search(r'\*([^*]+)\*', line)
        if match and i < 3:  # Scientific name is usually in first 3 lines
            scientific_name = match.group(1)
            break

    # Extract edibility
    edibility = "INEDIBLE"
    toxicity = "NONE"

    if "Choice Edible" in content:
        edibility = "CHOICE_EDIBLE"
    elif "DEADLY POISONOUS" in content or "**Edibility:** DEADLY" in content:
        edibility = "DEADLY"
        toxicity = "LETHAL"
    elif "POISONOUS" in content or "**Edibility:** POISONOUS" in content:
        edibility = "POISONOUS"
        toxicity = "SEVERE"
    elif "Edible" in content:
        if "MUST be" in content or "must be cooked" in content.lower():
            edibility = "EDIBLE_CAUTION"
            toxicity = "MILD"
        else:
            edibility = "EDIBLE"
    elif "Inedible" in content:
        edibility = "INEDIBLE"
    elif "Medicinal" in content and "medicinal" in content.lower()[:500]:
        edibility = "MEDICINAL_ONLY"

    # Extract nutrition
    nutrition_match = re.search(r'\*\*Nutrition:\*\*\s*(-?\d+)', content)
    nutrition = int(nutrition_match.group(1)) if nutrition_match else 3

    # Extract saturation
    saturation_match = re.search(r'\*\*Saturation:\*\*\s*([\d.]+)', content)
    saturation = float(saturation_match.group(1)) if saturation_match else 0.3

    # Extract effects
    effects = []
    effects_section = re.search(r'\*\*Effects:\*\*\s*(.+)', content)
    if effects_section:
        effect_text = effects_section.group(1)
        if "None" not in effect_text:
            effects.append(effect_text.strip())

    # Determine habitat for biome placement
    habitat = []
    content_lower = content.lower()
    if any(word in content_lower for word in ['forest', 'woodland', 'deciduous', 'beech', 'oak']):
        habitat.append("FOREST")
    if any(word in content_lower for word in ['conifer', 'pine', 'spruce', 'taiga']):
        habitat.append("TAIGA")
    if not habitat:
        habitat.append("FOREST")  # Default

    return {
        "name": name,
        "scientific_name": scientific_name,
        "edibility": edibility,
        "toxicity": toxicity,
        "nutrition": nutrition,
        "saturation": saturation,
        "effects": effects,
        "habitat": list(set(habitat)),
        "spawn_rarity": 2 if edibility in ["CHOICE_EDIBLE", "EDIBLE"] else 4
    }

def main():
    shrooms_dir = "shrooms"
    output_dir = "src/main/resources/data/mycology/mushroom_metadata"

    os.makedirs(output_dir, exist_ok=True)

    mushroom_files = sorted([f[:-3] for f in os.listdir(shrooms_dir) if f.endswith('.md')])

    print(f"Generating JSON metadata for {len(mushroom_files)} mushrooms...")

    all_metadata = {}

    for name in mushroom_files:
        with open(os.path.join(shrooms_dir, f"{name}.md"), 'r') as f:
            content = f.read()

        metadata = parse_mushroom_markdown(name, content)
        all_metadata[name] = metadata

        # Write individual file
        with open(os.path.join(output_dir, f"{name}.json"), 'w') as f:
            json.dump(metadata, f, indent=2)

        print(f"  Generated metadata for {name}")

    # Write master index
    with open(os.path.join(output_dir, "_all_mushrooms.json"), 'w') as f:
        json.dump(all_metadata, f, indent=2)

    print(f"\nGenerated {len(mushroom_files)} JSON metadata files")
    print(f"Master index: {output_dir}/_all_mushrooms.json")

if __name__ == '__main__':
    main()
