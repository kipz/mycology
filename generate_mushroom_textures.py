#!/usr/bin/env python3
"""
Generate 32x32 pixel textures for all mushrooms based on their descriptions in the shrooms database.
"""

import os
import re
from PIL import Image, ImageDraw
import random

# Color mappings based on mushroom descriptions
COLOR_KEYWORDS = {
    # Reds and pinks
    'red': (220, 60, 60),
    'scarlet': (255, 36, 0),
    'crimson': (220, 20, 60),
    'pink': (255, 192, 203),
    'salmon': (250, 128, 114),
    'coral': (255, 127, 80),
    'burgundy': (128, 0, 32),
    'rusty': (183, 65, 14),
    'rust': (183, 65, 14),

    # Oranges and yellows
    'orange': (255, 140, 0),
    'yellow': (255, 215, 0),
    'golden': (255, 215, 0),
    'ochre': (204, 119, 34),
    'buff': (240, 220, 130),
    'honey': (235, 180, 70),
    'amber': (255, 191, 0),
    'terracotta': (226, 114, 91),

    # Browns
    'brown': (139, 90, 43),
    'chestnut': (149, 69, 53),
    'chocolate': (123, 63, 0),
    'tan': (210, 180, 140),
    'umber': (99, 81, 71),
    'cinnamon': (210, 105, 30),
    'sepia': (112, 66, 20),
    'bay': (123, 63, 0),

    # Greens
    'green': (107, 142, 35),
    'olive': (128, 128, 0),
    'verdigris': (67, 179, 174),

    # Purples and violets
    'purple': (128, 0, 128),
    'violet': (138, 43, 226),
    'lilac': (200, 162, 200),
    'amethyst': (153, 102, 204),

    # Whites and grays
    'white': (245, 245, 245),
    'cream': (255, 253, 208),
    'ivory': (255, 255, 240),
    'grey': (128, 128, 128),
    'gray': (128, 128, 128),
    'silver': (192, 192, 192),
    'pale': (220, 220, 220),

    # Blacks and darks
    'black': (40, 40, 40),
    'charcoal': (54, 69, 79),
    'dark': (70, 70, 70),
    'blackish': (50, 50, 50),
}

def extract_colors_from_text(text):
    """Extract color information from mushroom description."""
    text = text.lower()
    colors = []

    for keyword, rgb in COLOR_KEYWORDS.items():
        if keyword in text:
            colors.append(rgb)

    # Default to brown if no colors found
    if not colors:
        colors = [(139, 90, 43)]

    return colors

def extract_features(filename, content):
    """Extract visual features from mushroom description."""
    features = {
        'cap_color': None,
        'stem_color': None,
        'gill_color': None,
        'has_spots': False,
        'has_scales': False,
        'is_bracket': False,
        'is_puffball': False,
        'is_jelly': False,
        'is_coral': False,
    }

    content_lower = content.lower()

    # Check for specific types
    if 'bracket' in content_lower or 'polypore' in content_lower:
        features['is_bracket'] = True
    if 'puffball' in content_lower:
        features['is_puffball'] = True
    if 'jelly' in content_lower or 'gelatinous' in content_lower:
        features['is_jelly'] = True
    if 'coral' in filename or 'coral' in content_lower[:200]:
        features['is_coral'] = True

    # Check for surface features
    if 'spot' in content_lower or 'speckled' in content_lower or 'dotted' in content_lower:
        features['has_spots'] = True
    if 'scale' in content_lower or 'scaly' in content_lower:
        features['has_scales'] = True

    # Extract colors
    colors = extract_colors_from_text(content)
    features['cap_color'] = colors[0] if colors else (139, 90, 43)
    features['stem_color'] = colors[1] if len(colors) > 1 else darken_color(features['cap_color'])
    features['gill_color'] = (240, 230, 210)  # Default cream

    return features

def darken_color(rgb, factor=0.7):
    """Darken an RGB color."""
    return tuple(int(c * factor) for c in rgb)

def lighten_color(rgb, factor=1.3):
    """Lighten an RGB color."""
    return tuple(min(255, int(c * factor)) for c in rgb)

def draw_standard_mushroom(draw, features):
    """Draw a standard mushroom with cap and stem."""
    cap_color = features['cap_color']
    stem_color = features['stem_color']

    # Stem (lower part)
    stem_x = 16
    stem_width = 6
    stem_top = 18
    stem_bottom = 30
    draw.rectangle(
        [stem_x - stem_width//2, stem_top, stem_x + stem_width//2, stem_bottom],
        fill=stem_color,
        outline=darken_color(stem_color, 0.5)
    )

    # Cap (upper part) - ellipse
    cap_top = 6
    cap_bottom = 20
    cap_left = 6
    cap_right = 26
    draw.ellipse(
        [cap_left, cap_top, cap_right, cap_bottom],
        fill=cap_color,
        outline=darken_color(cap_color, 0.6)
    )

    # Highlight on cap
    highlight_color = lighten_color(cap_color, 1.4)
    draw.ellipse(
        [10, 8, 18, 14],
        fill=highlight_color,
        outline=None
    )

    # Gills (underside of cap)
    gill_color = features['gill_color']
    for x in range(8, 24, 2):
        draw.line([x, 18, 16, 20], fill=gill_color, width=1)

    # Add spots if needed
    if features['has_spots']:
        spot_color = lighten_color(cap_color, 1.5)
        for _ in range(random.randint(3, 6)):
            x = random.randint(8, 24)
            y = random.randint(8, 18)
            draw.ellipse([x, y, x+2, y+2], fill=spot_color)

    # Add scales if needed
    if features['has_scales']:
        scale_color = darken_color(cap_color, 0.5)
        for y in range(10, 18, 3):
            for x in range(8, 24, 4):
                draw.line([x, y, x+2, y+1], fill=scale_color, width=1)

def draw_bracket_fungus(draw, features):
    """Draw a bracket/shelf fungus."""
    cap_color = features['cap_color']

    # Multiple bracket layers
    for i, y in enumerate([12, 18, 24]):
        width = 20 - i * 3
        # Bracket shelf
        draw.ellipse(
            [8, y, 8 + width, y + 6],
            fill=cap_color,
            outline=darken_color(cap_color, 0.6)
        )
        # Underside
        draw.ellipse(
            [8, y + 4, 8 + width, y + 8],
            fill=lighten_color(cap_color),
            outline=darken_color(cap_color, 0.6)
        )

def draw_puffball(draw, features):
    """Draw a round puffball mushroom."""
    cap_color = features['cap_color']

    # Main sphere
    draw.ellipse(
        [8, 10, 24, 26],
        fill=cap_color,
        outline=darken_color(cap_color, 0.6)
    )

    # Highlight
    highlight_color = lighten_color(cap_color, 1.3)
    draw.ellipse(
        [10, 12, 18, 18],
        fill=highlight_color
    )

    # Texture
    texture_color = darken_color(cap_color, 0.8)
    for _ in range(15):
        x = random.randint(10, 22)
        y = random.randint(12, 24)
        draw.point((x, y), fill=texture_color)

def draw_jelly_fungus(draw, features):
    """Draw a jelly-like fungus."""
    cap_color = features['cap_color']

    # Irregular blob shape
    points = []
    center_x, center_y = 16, 16
    for angle in range(0, 360, 30):
        import math
        radius = random.randint(8, 12)
        x = center_x + int(radius * math.cos(math.radians(angle)))
        y = center_y + int(radius * math.sin(math.radians(angle)))
        points.append((x, y))

    draw.polygon(points, fill=cap_color, outline=darken_color(cap_color, 0.6))

    # Glossy appearance
    highlight = lighten_color(cap_color, 1.5)
    draw.ellipse([12, 10, 20, 16], fill=highlight)

def draw_coral_fungus(draw, features):
    """Draw a coral-like fungus."""
    cap_color = features['cap_color']

    # Draw branching structure
    def draw_branch(x, y, length, angle, depth):
        if depth == 0 or length < 2:
            return
        import math
        end_x = x + int(length * math.cos(math.radians(angle)))
        end_y = y + int(length * math.sin(math.radians(angle)))
        draw.line([x, y, end_x, end_y], fill=cap_color, width=2)

        # Branch
        if depth > 0:
            draw_branch(end_x, end_y, length * 0.7, angle - 30, depth - 1)
            draw_branch(end_x, end_y, length * 0.7, angle + 30, depth - 1)

    # Start from bottom
    draw_branch(16, 28, 12, -90, 3)

def generate_texture(mushroom_name, shrooms_dir, output_dir):
    """Generate a 32x32 texture for a mushroom."""
    # Read mushroom description
    shroom_file = os.path.join(shrooms_dir, f"{mushroom_name}.md")
    if not os.path.exists(shroom_file):
        print(f"Warning: No shroom file for {mushroom_name}")
        return

    with open(shroom_file, 'r') as f:
        content = f.read()

    # Extract features
    features = extract_features(mushroom_name, content)

    # Create image
    img = Image.new('RGBA', (32, 32), (0, 0, 0, 0))
    draw = ImageDraw.Draw(img)

    # Draw based on type
    if features['is_bracket']:
        draw_bracket_fungus(draw, features)
    elif features['is_puffball']:
        draw_puffball(draw, features)
    elif features['is_jelly']:
        draw_jelly_fungus(draw, features)
    elif features['is_coral']:
        draw_coral_fungus(draw, features)
    else:
        draw_standard_mushroom(draw, features)

    # Save texture
    output_path = os.path.join(output_dir, f"{mushroom_name}.png")
    img.save(output_path, 'PNG')
    print(f"Generated texture for {mushroom_name}")

def main():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    shrooms_dir = os.path.join(script_dir, 'shrooms')
    output_dir = os.path.join(script_dir, 'src/main/resources/assets/mycology/textures/item')

    # Create backup directory
    backup_dir = os.path.join(script_dir, 'texture_backup')
    if not os.path.exists(backup_dir):
        os.makedirs(backup_dir)
        print(f"Created backup directory: {backup_dir}")

    # Get all mushroom files
    mushroom_files = [f[:-3] for f in os.listdir(shrooms_dir) if f.endswith('.md')]
    mushroom_files.sort()

    print(f"Found {len(mushroom_files)} mushrooms")
    print("Generating textures...")

    # Generate textures
    for mushroom_name in mushroom_files:
        generate_texture(mushroom_name, shrooms_dir, output_dir)

    print(f"\nGenerated {len(mushroom_files)} textures in {output_dir}")
    print("Done!")

if __name__ == '__main__':
    main()
