package org.potato.mycology.data;

import org.potato.mycology.item.mushroom.MushroomProperties.*;

/**
 * Metadata for a mushroom loaded from the shrooms database
 */
public class MushroomMetadata {
    private final String name;  // e.g., "chanterelle"
    private final String scientificName;
    private final EdibilityRating edibilityRating;
    private final ToxicityLevel toxicityLevel;
    private final int nutrition;
    private final float saturation;
    private final String[] effects;

    public MushroomMetadata(String name, String scientificName, EdibilityRating edibilityRating,
                           ToxicityLevel toxicityLevel, int nutrition, float saturation, String[] effects) {
        this.name = name;
        this.scientificName = scientificName;
        this.edibilityRating = edibilityRating;
        this.toxicityLevel = toxicityLevel;
        this.nutrition = nutrition;
        this.saturation = saturation;
        this.effects = effects;
    }

    public String getName() {
        return name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public EdibilityRating getEdibilityRating() {
        return edibilityRating;
    }

    public ToxicityLevel getToxicityLevel() {
        return toxicityLevel;
    }

    public int getNutrition() {
        return nutrition;
    }

    public float getSaturation() {
        return saturation;
    }

    public String[] getEffects() {
        return effects;
    }

    /**
     * Determine mushroom category from edibility rating
     */
    public MushroomCategory getCategory() {
        return switch (edibilityRating) {
            case POISONOUS, DEADLY -> MushroomCategory.POISONOUS;
            case MEDICINAL_ONLY -> MushroomCategory.MEDICINAL;
            default -> MushroomCategory.EDIBLE;
        };
    }
}
