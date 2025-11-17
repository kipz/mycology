package org.potato.mycology.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import org.potato.mycology.MycologyMod;
import org.potato.mycology.item.mushroom.MushroomItem;
import org.potato.mycology.item.mushroom.MushroomProperties;
import org.potato.mycology.item.mushroom.MushroomProperties.EdibilityRating;
import org.potato.mycology.item.mushroom.MushroomProperties.ToxicityLevel;
import org.potato.mycology.item.mushroom.MushroomProperties.MushroomCategory;

/**
 * Registry for all mushroom items in the mod
 */
public class ModItems {

    // ========== CONSUMABLE COMPONENTS (for effects) ==========

    // Medicinal Mushrooms
    private static final Consumable JELLY_EAR_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.REGENERATION, 200, 0),
                    1.0f
            ))
            .build();

    private static final Consumable LIONS_MANE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 600, 0),
                    1.0f
            ))
            .build();

    // Poisonous Mushrooms - Deadly (multiple effects)
    private static final Consumable DEATH_CAP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WITHER, 600, 2),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 1200, 3),
                    1.0f
            ))
            .build();

    private static final Consumable DESTROYING_ANGEL_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WITHER, 600, 2),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 1200, 3),
                    1.0f
            ))
            .build();

    private static final Consumable DEADLY_FIBRECAP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 800, 2),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 600, 1),
                    1.0f
            ))
            .build();

    private static final Consumable DEADLY_WEBCAP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WITHER, 1200, 1),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 1200, 2),
                    1.0f
            ))
            .build();

    // Poisonous Mushrooms - Moderate/Severe
    private static final Consumable YELLOW_STAINER_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 400, 1),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 300, 0),
                    1.0f
            ))
            .build();

    private static final Consumable FLY_AGARIC_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 600, 2),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 400, 1),
                    1.0f
            ))
            .build();

    private static final Consumable PANTHER_CAP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 600, 2),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 800, 2),
                    1.0f
            ))
            .build();

    private static final Consumable FALSE_CHANTERELLE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 200, 0),
                    1.0f
            ))
            .build();

    // ========== EDIBLE MUSHROOMS ==========

    public static final Item CHANTERELLE = registerMushroomItem("chanterelle",
            ModBlocks.CHANTERELLE,
            new MushroomProperties.Builder()
                    .scientificName("Cantharellus cibarius")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Funnel-shaped yellow-orange cap",
                            "Forked ridges, not true gills",
                            "Fruity aroma",
                            "White flesh"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item PORCINI = registerMushroomItem("porcini",
            ModBlocks.PORCINI,
            new MushroomProperties.Builder()
                    .scientificName("Boletus edulis")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Large brown cap",
                            "Thick white stem with network pattern",
                            "Pores instead of gills"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationModifier(0.7f)
                    .build()
    );

    public static final Item FIELD_MUSHROOM = registerMushroomItem("field_mushroom",
            ModBlocks.FIELD_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Agaricus campestris")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "White to pale brown cap",
                            "Pink gills turning chocolate brown",
                            "White stem with ring"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .build()
    );

    public static final Item OYSTER_MUSHROOM = registerMushroomItem("oyster_mushroom",
            ModBlocks.OYSTER_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Pleurotus ostreatus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Fan-shaped white to grey cap",
                            "White gills running down stem",
                            "Grows in shelf-like clusters"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .build()
    );

    public static final Item PARASOL_MUSHROOM = registerMushroomItem("parasol_mushroom",
            ModBlocks.PARASOL_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Macrolepiota procera")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Large cap with brownish scales",
                            "Snakeskin pattern on tall stem",
                            "Double-edged movable ring"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item GIANT_PUFFBALL = registerMushroomItem("giant_puffball",
            new MushroomProperties.Builder()
                    .scientificName("Calvatia gigantea")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Large white spherical mushroom",
                            "Solid white interior when edible",
                            "No gills or stem"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.8f)
                    .build()
    );

    public static final Item BAY_BOLETE = registerMushroomItem("bay_bolete",
            new MushroomProperties.Builder()
                    .scientificName("Imleria badia")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Bay-brown cap",
                            "Pale yellow pores bruising blue-green",
                            "Must be cooked 15+ minutes"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item CHICKEN_OF_THE_WOODS = registerMushroomItem("chicken_of_the_woods",
            new MushroomProperties.Builder()
                    .scientificName("Laetiporus sulphureus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Bright yellow-orange bracket fungus",
                            "Grows in shelf-like clusters",
                            "Chicken-like texture"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationModifier(0.7f)
                    .build()
    );

    public static final Item HEDGEHOG_MUSHROOM = registerMushroomItem("hedgehog_mushroom",
            new MushroomProperties.Builder()
                    .scientificName("Hydnum repandum")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Spines instead of gills",
                            "Yellow to light orange cap",
                            "Sweet, nutty flavor"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item WOOD_BLEWIT = registerMushroomItem("wood_blewit",
            new MushroomProperties.Builder()
                    .scientificName("Lepista nuda")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Purple-lilac color when young",
                            "Fades to brownish with age",
                            "Must be cooked (never raw)"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .build()
    );

    public static final Item SHAGGY_INK_CAP = registerMushroomItem("shaggy_ink_cap",
            new MushroomProperties.Builder()
                    .scientificName("Coprinus comatus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Tall white cap with shaggy scales",
                            "Resembles lawyer's wig",
                            "Self-digests into black ink"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .build()
    );

    public static final Item HORN_OF_PLENTY = registerMushroomItem("horn_of_plenty",
            new MushroomProperties.Builder()
                    .scientificName("Craterellus cornucopioides")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Funnel-shaped, dark brown to black",
                            "Hides in leaf litter",
                            "Strong nutty, smoky flavor"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item BEEFSTEAK_FUNGUS = registerMushroomItem("beefsteak_fungus",
            new MushroomProperties.Builder()
                    .scientificName("Fistulina hepatica")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Resembles raw meat",
                            "Oozes red juice when cut",
                            "Rubbery texture, acidic flavor"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item SAFFRON_MILK_CAP = registerMushroomItem("saffron_milk_cap",
            new MushroomProperties.Builder()
                    .scientificName("Lactarius deliciosus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Salmon pink/orange cap",
                            "Exudes carrot-colored milk",
                            "Turns green when bruised"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .build()
    );

    public static final Item DRYADS_SADDLE = registerMushroomItem("dryads_saddle",
            new MushroomProperties.Builder()
                    .scientificName("Polyporus squamosus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Large fan-shaped bracket",
                            "Scaly brown pattern",
                            "Watermelon/cucumber scent"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    // ========== MEDICINAL MUSHROOMS ==========

    public static final Item TURKEY_TAIL = registerMushroomItem("turkey_tail",
            new MushroomProperties.Builder()
                    .scientificName("Trametes versicolor")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.MEDICINAL_ONLY)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Thin wavy brackets",
                            "Multiple colors (browns, blues, greys)",
                            "Creamy white edge"
                    )
                    .build()
    );

    public static final Item BIRCH_POLYPORE = registerMushroomItem("birch_polypore",
            new MushroomProperties.Builder()
                    .scientificName("Fomitopsis betulina")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.MEDICINAL_ONLY)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Kidney or shell-shaped",
                            "Brown top with white underside",
                            "Only grows on birch trees"
                    )
                    .build()
    );

    public static final Item JELLY_EAR = registerMushroomItem("jelly_ear",
            new MushroomProperties.Builder()
                    .scientificName("Auricularia auricula-judae")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Ear-shaped, gelatinous",
                            "Brown, resembles human ear",
                            "Rubbery when fresh"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build(),
            JELLY_EAR_CONSUMABLE
    );

    public static final Item HOOF_FUNGUS = registerMushroomItem("hoof_fungus",
            new MushroomProperties.Builder()
                    .scientificName("Fomes fomentarius")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.MEDICINAL_ONLY)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Large hoof-shaped bracket",
                            "Hard woody texture",
                            "Ancient fire-starting material"
                    )
                    .build()
    );

    public static final Item ARTISTS_BRACKET = registerMushroomItem("artists_bracket",
            new MushroomProperties.Builder()
                    .scientificName("Ganoderma applanatum")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.MEDICINAL_ONLY)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Large perennial bracket",
                            "Brown top",
                            "White pore surface (turns brown when scratched)"
                    )
                    .build()
    );

    public static final Item CHAGA = registerMushroomItem("chaga",
            new MushroomProperties.Builder()
                    .scientificName("Inonotus obliquus")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.MEDICINAL_ONLY)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Black charcoal-like mass",
                            "Only on birch trees",
                            "Antioxidant powerhouse"
                    )
                    .build()
    );

    public static final Item REISHI = registerMushroomItem("reishi",
            new MushroomProperties.Builder()
                    .scientificName("Ganoderma lucidum")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.MEDICINAL_ONLY)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Shiny lacquered reddish-brown cap",
                            "Kidney-shaped",
                            "Mushroom of immortality"
                    )
                    .build()
    );

    public static final Item LIONS_MANE = registerMushroomItem("lions_mane",
            new MushroomProperties.Builder()
                    .scientificName("Hericium erinaceus")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "White shaggy cascading spines",
                            "Looks like lion's mane",
                            "Seafood-like flavor"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build(),
            LIONS_MANE_CONSUMABLE
    );

    // ========== POISONOUS MUSHROOMS ==========

    public static final Item DEATH_CAP = registerMushroomItem("death_cap",
            ModBlocks.DEATH_CAP,
            new MushroomProperties.Builder()
                    .scientificName("Amanita phalloides")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.DEADLY)
                    .toxicityLevel(ToxicityLevel.LETHAL)
                    .identificationFeatures(
                            "White/yellow/pale green cap",
                            "Bulbous base with volva",
                            "Ring present on stem",
                            "DEADLY - causes liver/kidney failure"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build(),
            DEATH_CAP_CONSUMABLE
    );

    public static final Item DESTROYING_ANGEL = registerMushroomItem("destroying_angel",
            new MushroomProperties.Builder()
                    .scientificName("Amanita virosa")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.DEADLY)
                    .toxicityLevel(ToxicityLevel.LETHAL)
                    .identificationFeatures(
                            "Pure white throughout",
                            "Bulbous base with volva",
                            "Ring on stem",
                            "DEADLY - never consume white Amanitas"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build(),
            DESTROYING_ANGEL_CONSUMABLE
    );

    public static final Item DEADLY_FIBRECAP = registerMushroomItem("deadly_fibrecap",
            new MushroomProperties.Builder()
                    .scientificName("Inocybe erubescens")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.DEADLY)
                    .toxicityLevel(ToxicityLevel.LETHAL)
                    .identificationFeatures(
                            "Small conical cap",
                            "White turning pinkish-red when bruised",
                            "Highest muscarine concentration"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build(),
            DEADLY_FIBRECAP_CONSUMABLE
    );

    public static final Item DEADLY_WEBCAP = registerMushroomItem("deadly_webcap",
            new MushroomProperties.Builder()
                    .scientificName("Cortinarius rubellus")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.DEADLY)
                    .toxicityLevel(ToxicityLevel.LETHAL)
                    .identificationFeatures(
                            "Orange-brown to cinnamon cap",
                            "Cobweb-like veil when young",
                            "Delayed onset (2-14 days) kidney failure"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build(),
            DEADLY_WEBCAP_CONSUMABLE
    );

    public static final Item YELLOW_STAINER = registerMushroomItem("yellow_stainer",
            new MushroomProperties.Builder()
                    .scientificName("Agaricus xanthodermus")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MODERATE)
                    .identificationFeatures(
                            "Bright yellow staining when pressed",
                            "White cap when young",
                            "Unpleasant chemical smell"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build(),
            YELLOW_STAINER_CONSUMABLE
    );

    public static final Item FLY_AGARIC = registerMushroomItem("fly_agaric",
            ModBlocks.FLY_AGARIC,
            new MushroomProperties.Builder()
                    .scientificName("Amanita muscaria")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.SEVERE)
                    .identificationFeatures(
                            "Iconic bright red cap with white spots",
                            "White gills and stem with ring",
                            "Classic fairy tale toadstool"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build(),
            FLY_AGARIC_CONSUMABLE
    );

    public static final Item PANTHER_CAP = registerMushroomItem("panther_cap",
            new MushroomProperties.Builder()
                    .scientificName("Amanita pantherina")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.SEVERE)
                    .identificationFeatures(
                            "Dark brown cap with white scales",
                            "Bulbous base with marginate volva",
                            "More poisonous than Fly Agaric"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build(),
            PANTHER_CAP_CONSUMABLE
    );

    public static final Item FALSE_CHANTERELLE = registerMushroomItem("false_chanterelle",
            new MushroomProperties.Builder()
                    .scientificName("Hygrophoropsis aurantiaca")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "True gills (not forked ridges)",
                            "Paler orange than true Chanterelle",
                            "Grows on wood/pine needles"
                    )
                    .build(),
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build(),
            FALSE_CHANTERELLE_CONSUMABLE
    );

    /**
     * Register a mushroom item with food properties and consumable effects (with block)
     */
    private static Item registerMushroomItem(String name, Block block, MushroomProperties properties, FoodProperties foodProperties, Consumable consumable) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, name)
        );
        Item item = new MushroomItem(block, properties, itemKey, foodProperties, consumable);
        return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    }

    /**
     * Register a mushroom item with food properties only (no effects, with block)
     */
    private static Item registerMushroomItem(String name, Block block, MushroomProperties properties, FoodProperties foodProperties) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, name)
        );
        Item item = new MushroomItem(block, properties, itemKey, foodProperties);
        return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    }

    /**
     * Register a mushroom item with food properties and consumable effects (no block)
     */
    private static Item registerMushroomItem(String name, MushroomProperties properties, FoodProperties foodProperties, Consumable consumable) {
        // For mushrooms without blocks, use a dummy block (Blocks.AIR)
        return registerMushroomItem(name, net.minecraft.world.level.block.Blocks.AIR, properties, foodProperties, consumable);
    }

    /**
     * Register a mushroom item with food properties only (no effects, no block)
     */
    private static Item registerMushroomItem(String name, MushroomProperties properties, FoodProperties foodProperties) {
        // For mushrooms without blocks, use a dummy block (Blocks.AIR)
        return registerMushroomItem(name, net.minecraft.world.level.block.Blocks.AIR, properties, foodProperties);
    }

    /**
     * Register a mushroom item without food properties (medicinal only, with block)
     */
    private static Item registerMushroomItem(String name, Block block, MushroomProperties properties) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, name)
        );
        Item item = new MushroomItem(block, properties, itemKey);
        return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    }

    /**
     * Register a mushroom item without food properties (medicinal only, no block)
     */
    private static Item registerMushroomItem(String name, MushroomProperties properties) {
        // For mushrooms without blocks, use a dummy block (Blocks.AIR)
        return registerMushroomItem(name, net.minecraft.world.level.block.Blocks.AIR, properties);
    }

    /**
     * Initialize and register all items
     */
    public static void registerItems() {
        MycologyMod.LOGGER.info("Registering mushroom items for " + MycologyMod.MOD_ID);

        // Add items to creative tab
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(content -> {
            // Edible mushrooms
            content.accept(CHANTERELLE);
            content.accept(PORCINI);
            content.accept(FIELD_MUSHROOM);
            content.accept(OYSTER_MUSHROOM);
            content.accept(PARASOL_MUSHROOM);
            content.accept(GIANT_PUFFBALL);
            content.accept(BAY_BOLETE);
            content.accept(CHICKEN_OF_THE_WOODS);
            content.accept(HEDGEHOG_MUSHROOM);
            content.accept(WOOD_BLEWIT);
            content.accept(SHAGGY_INK_CAP);
            content.accept(HORN_OF_PLENTY);
            content.accept(BEEFSTEAK_FUNGUS);
            content.accept(SAFFRON_MILK_CAP);
            content.accept(DRYADS_SADDLE);
            content.accept(JELLY_EAR);
            content.accept(LIONS_MANE);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(content -> {
            // Medicinal mushrooms
            content.accept(TURKEY_TAIL);
            content.accept(BIRCH_POLYPORE);
            content.accept(HOOF_FUNGUS);
            content.accept(ARTISTS_BRACKET);
            content.accept(CHAGA);
            content.accept(REISHI);
        });

        // Note: Poisonous mushrooms intentionally not added to creative tabs
        // They will only be obtainable through world generation
    }
}
