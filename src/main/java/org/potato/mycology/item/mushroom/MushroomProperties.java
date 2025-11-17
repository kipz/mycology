package org.potato.mycology.item.mushroom;

/**
 * Properties and characteristics of a mushroom species
 */
public class MushroomProperties {
    private final EdibilityRating edibilityRating;
    private final ToxicityLevel toxicityLevel;
    private final MushroomCategory category;
    private final String scientificName;
    private final String[] identificationFeatures;

    public MushroomProperties(EdibilityRating edibilityRating,
                            ToxicityLevel toxicityLevel,
                            MushroomCategory category,
                            String scientificName,
                            String... identificationFeatures) {
        this.edibilityRating = edibilityRating;
        this.toxicityLevel = toxicityLevel;
        this.category = category;
        this.scientificName = scientificName;
        this.identificationFeatures = identificationFeatures;
    }

    public EdibilityRating getEdibilityRating() {
        return edibilityRating;
    }

    public ToxicityLevel getToxicityLevel() {
        return toxicityLevel;
    }

    public MushroomCategory getCategory() {
        return category;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String[] getIdentificationFeatures() {
        return identificationFeatures;
    }

    public enum EdibilityRating {
        CHOICE_EDIBLE,      // Highly sought after, excellent taste
        EDIBLE,             // Safe to eat, good quality
        EDIBLE_CAUTION,     // Edible but requires preparation or has lookalikes
        INEDIBLE,           // Not toxic but unpalatable
        MEDICINAL_ONLY,     // Used for medicine, not food
        POISONOUS,          // Causes harm if consumed
        DEADLY              // Can be fatal
    }

    public enum ToxicityLevel {
        NONE,               // Safe, non-toxic
        MILD,               // Minor gastrointestinal upset
        MODERATE,           // Significant illness, medical attention advised
        SEVERE,             // Serious illness, hospitalization likely
        LETHAL              // Can cause death
    }

    public enum MushroomCategory {
        EDIBLE,
        MEDICINAL,
        POISONOUS
    }

    // Builder for easier construction
    public static class Builder {
        private EdibilityRating edibilityRating = EdibilityRating.INEDIBLE;
        private ToxicityLevel toxicityLevel = ToxicityLevel.NONE;
        private MushroomCategory category = MushroomCategory.EDIBLE;
        private String scientificName = "";
        private String[] identificationFeatures = new String[0];

        public Builder edibilityRating(EdibilityRating rating) {
            this.edibilityRating = rating;
            return this;
        }

        public Builder toxicityLevel(ToxicityLevel level) {
            this.toxicityLevel = level;
            return this;
        }

        public Builder category(MushroomCategory category) {
            this.category = category;
            return this;
        }

        public Builder scientificName(String name) {
            this.scientificName = name;
            return this;
        }

        public Builder identificationFeatures(String... features) {
            this.identificationFeatures = features;
            return this;
        }

        public MushroomProperties build() {
            return new MushroomProperties(
                edibilityRating,
                toxicityLevel,
                category,
                scientificName,
                identificationFeatures
            );
        }
    }
}
