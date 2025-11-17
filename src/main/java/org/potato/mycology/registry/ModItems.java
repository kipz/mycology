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
import net.minecraft.world.level.block.Block;
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

    // ========== NEW UK FUNGI CONSUMABLES ==========

    private static final Consumable COMMON_EARTHBALL_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 400, 1),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 300, 0),
                    1.0f
            ))
            .build();

    private static final Consumable SULPHUR_TUFT_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 600, 1),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WEAKNESS, 400, 0),
                    1.0f
            ))
            .build();

    private static final Consumable FUNERAL_BELL_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WITHER, 800, 2),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 1200, 3),
                    1.0f
            ))
            .build();

    private static final Consumable LIBERTY_CAP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 1200, 3),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.BLINDNESS, 400, 0),
                    1.0f
            ))
            .build();

    private static final Consumable FOOLS_FUNNEL_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 800, 3),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WEAKNESS, 1200, 2),
                    1.0f
            ))
            .build();

    private static final Consumable IVORY_FUNNEL_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 800, 3),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WEAKNESS, 1200, 2),
                    1.0f
            ))
            .build();

    private static final Consumable LIVID_PINKGILL_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 800, 2),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.HUNGER, 600, 2),
                    1.0f
            ))
            .build();

    private static final Consumable DEVILS_BOLETE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 600, 2),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 800, 1),
                    1.0f
            ))
            .build();

    private static final Consumable SICKENER_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 400, 1),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 600, 1),
                    1.0f
            ))
            .build();

    private static final Consumable BEECHWOOD_SICKENER_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 400, 1),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 600, 1),
                    1.0f
            ))
            .build();

    private static final Consumable BLACKENING_WAXCAP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 200, 0),
                    1.0f
            ))
            .build();

    private static final Consumable TIGER_SAWGILL_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 300, 0),
                    1.0f
            ))
            .build();

    private static final Consumable SPECTACULAR_RUSTGILL_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 600, 1),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 400, 0),
                    1.0f
            ))
            .build();

    private static final Consumable DEADLY_DAPPERLING_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WITHER, 600, 2),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 1000, 3),
                    1.0f
            ))
            .build();

    private static final Consumable RED_STAINING_INOCYBE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 800, 3),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WEAKNESS, 1200, 2),
                    1.0f
            ))
            .build();

    private static final Consumable LILAC_FIBRECAP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 400, 1),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 300, 0),
                    1.0f
            ))
            .build();

    private static final Consumable COMMON_WHITE_INOCYBE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 400, 1),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 300, 0),
                    1.0f
            ))
            .build();

    private static final Consumable DEADLY_PARASOL_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WITHER, 600, 2),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 1000, 3),
                    1.0f
            ))
            .build();

    private static final Consumable VERDIGRIS_AGARIC_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 300, 0),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 200, 0),
                    1.0f
            ))
            .build();

    private static final Consumable BROWN_ROLL_RIM_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 1000, 2),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WITHER, 800, 1),
                    1.0f
            ))
            .build();

    private static final Consumable POISON_PIE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 500, 1),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 400, 1),
                    1.0f
            ))
            .build();

    private static final Consumable BITTER_OYSTERLING_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WEAKNESS, 200, 0),
                    1.0f
            ))
            .build();

    private static final Consumable UGLY_MILK_CAP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 300, 0),
                    1.0f
            ))
            .build();

    private static final Consumable WOOLLY_MILK_CAP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 400, 1),
                    1.0f
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 300, 0),
                    1.0f
            ))
            .build();

    private static final Consumable RUFOUS_MILK_CAP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 200, 0),
                    1.0f
            ))
            .build();

    // ========== EDIBLE MUSHROOMS ==========

    public static final Item CHANTERELLE = registerMushroomItem("chanterelle",
            ModBlocks.CHANTERELLE_MUSHROOM,
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
            ModBlocks.PORCINI_MUSHROOM,
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
            ModBlocks.FIELD_MUSHROOM_BLOCK,
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
            ModBlocks.OYSTER_MUSHROOM_BLOCK,
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
            ModBlocks.PARASOL_MUSHROOM_BLOCK,
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
            ModBlocks.DEATH_CAP_MUSHROOM,
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
            ModBlocks.FLY_AGARIC_MUSHROOM,
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

    // ========== NEW UK FUNGI ITEMS ==========

    public static final Item MOREL = registerMushroomItem("morel",
            ModBlocks.MOREL_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Morchella esculenta")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Honeycomb cap with deep pits",
                            "Hollow stem and cap",
                            "Must be cooked thoroughly",
                            "Spring seasonal delicacy"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.8f)
                    .build()
    );

    public static final Item CEP = registerMushroomItem("cep",
            ModBlocks.CEP_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Boletus edulis")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Synonymous with porcini",
                            "Brown cap, white pores",
                            "Thick white stem",
                            "Excellent dried"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationModifier(0.7f)
                    .build()
    );

    public static final Item ST_GEORGES_MUSHROOM = registerMushroomItem("st_georges_mushroom",
            ModBlocks.ST_GEORGES_MUSHROOM_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Calocybe gambosa")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Appears around St George's Day (April 23)",
                            "Cream to white cap",
                            "Mealy smell",
                            "Grows in fairy rings"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item CAULIFLOWER_FUNGUS = registerMushroomItem("cauliflower_fungus",
            new MushroomProperties.Builder()
                    .scientificName("Sparassis crispa")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Brain-like appearance",
                            "Cream colored fronds",
                            "Grows at tree bases",
                            "Mild sweet flavor"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationModifier(0.7f)
                    .build()
    );

    public static final Item FAIRY_RING_CHAMPIGNON = registerMushroomItem("fairy_ring_champignon",
            ModBlocks.FAIRY_RING_CHAMPIGNON_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Marasmius oreades")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Forms fairy rings in grass",
                            "Tan bell-shaped cap",
                            "Tough wiry stem",
                            "Sweet smell"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .build()
    );

    public static final Item AMETHYST_DECEIVER = registerMushroomItem("amethyst_deceiver",
            ModBlocks.AMETHYST_DECEIVER_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Laccaria amethystina")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Vivid purple when young",
                            "Fades with age",
                            "Common in woodlands",
                            "Edible but not choice"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item BLUSHER = registerMushroomItem("blusher",
            new MushroomProperties.Builder()
                    .scientificName("Amanita rubescens")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Reddish-brown cap with warts",
                            "Flesh bruises wine-red",
                            "MUST be cooked - toxic raw",
                            "In Amanita genus - be careful"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item CHARCOAL_BURNER = registerMushroomItem("charcoal_burner",
            ModBlocks.CHARCOAL_BURNER_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Russula cyanoxantha")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Variable cap colors",
                            "Purple, green, or blue",
                            "Flexible gills",
                            "Mild taste"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item MILLER = registerMushroomItem("miller",
            new MushroomProperties.Builder()
                    .scientificName("Clitopilus prunulus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "White to grey cap",
                            "Mealy smell",
                            "Pink spore print",
                            "Easily confused with toxic species"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .build()
    );

    public static final Item VELVET_SHANK = registerMushroomItem("velvet_shank",
            ModBlocks.VELVET_SHANK_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Flammulina velutipes")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Orange-brown slimy cap",
                            "Dark velvety stem",
                            "Winter mushroom",
                            "Cultivated as enoki"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item SCARLETINA_BOLETE = registerMushroomItem("scarletina_bolete",
            new MushroomProperties.Builder()
                    .scientificName("Neoboletus luridiformis")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Red pores that bruise blue",
                            "MUST be cooked",
                            "Causes gastric upset if raw",
                            "Dark brown cap"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item SUMMER_TRUFFLE = registerMushroomItem("summer_truffle",
            new MushroomProperties.Builder()
                    .scientificName("Tuber aestivum")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Black warty exterior",
                            "Grows underground",
                            "Strong aromatic smell",
                            "Expensive delicacy"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationModifier(0.9f)
                    .build()
    );

    public static final Item PENNY_BUN = registerMushroomItem("penny_bun",
            ModBlocks.PENNY_BUN_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Boletus edulis")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Another name for cep/porcini",
                            "British common name",
                            "Robust build",
                            "Excellent eating"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationModifier(0.7f)
                    .build()
    );

    public static final Item COMMON_PUFFBALL = registerMushroomItem("common_puffball",
            ModBlocks.COMMON_PUFFBALL_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Lycoperdon perlatum")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Small pear-shaped puffball",
                            "Spiny when young",
                            "White inside when edible",
                            "Puffs spores when mature"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item STUMP_PUFFBALL = registerMushroomItem("stump_puffball",
            new MushroomProperties.Builder()
                    .scientificName("Lycoperdon pyriforme")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Grows on dead wood",
                            "Pear-shaped",
                            "White rooting cords",
                            "Forms dense clusters"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    public static final Item BOVINE_BOLETE = registerMushroomItem("bovine_bolete",
            new MushroomProperties.Builder()
                    .scientificName("Suillus bovinus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Slimy yellow-brown cap",
                            "Yellow pores",
                            "Associated with pine",
                            "Not highly rated"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item SLIPPERY_JACK = registerMushroomItem("slippery_jack",
            ModBlocks.SLIPPERY_JACK_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Suillus luteus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Very slimy brown cap",
                            "Ring on stem",
                            "Remove slimy skin before eating",
                            "Associated with pine"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .build()
    );

    public static final Item LARCH_BOLETE = registerMushroomItem("larch_bolete",
            new MushroomProperties.Builder()
                    .scientificName("Suillus grevillei")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Golden yellow cap",
                            "Only with larch trees",
                            "Slimy when wet",
                            "Ring on stem"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.5f)
                    .build()
    );

    public static final Item CLOUDED_FUNNEL = registerMushroomItem("clouded_funnel",
            new MushroomProperties.Builder()
                    .scientificName("Clitocybe nebularis")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Grey funnel-shaped cap",
                            "Strong smell",
                            "Can cause upset in some people",
                            "Common in autumn"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item DECEIVER = registerMushroomItem("deceiver",
            new MushroomProperties.Builder()
                    .scientificName("Laccaria laccata")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Variable appearance (deceiving)",
                            "Orange-brown when moist",
                            "Pale when dry",
                            "Very common"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    public static final Item JELLY_BABIES = registerMushroomItem("jelly_babies",
            new MushroomProperties.Builder()
                    .scientificName("Leotia lubrica")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Yellowish irregular cap",
                            "Gelatinous texture",
                            "Slimy when wet",
                            "Not particularly tasty"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    public static final Item TRUMPET_CHANTERELLE = registerMushroomItem("trumpet_chanterelle",
            new MushroomProperties.Builder()
                    .scientificName("Craterellus tubaeformis")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Funnel-shaped",
                            "Yellow-brown cap",
                            "Related to chanterelle",
                            "Excellent flavor"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item WINTER_CHANTERELLE = registerMushroomItem("winter_chanterelle",
            new MushroomProperties.Builder()
                    .scientificName("Craterellus tubaeformis")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Also called yellowfoot",
                            "Fruits late in season",
                            "Small funnel cap",
                            "Good flavor"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item TERRACOTTA_HEDGEHOG = registerMushroomItem("terracotta_hedgehog",
            new MushroomProperties.Builder()
                    .scientificName("Hydnum rufescens")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Orange-brown cap",
                            "Spines under cap",
                            "Related to hedgehog mushroom",
                            "Slightly bitter"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item WOOD_HEDGEHOG = registerMushroomItem("wood_hedgehog",
            ModBlocks.WOOD_HEDGEHOG_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Hydnum repandum")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Cream to pale orange",
                            "Brittle spines underneath",
                            "Very safe to identify",
                            "Mild peppery taste"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item BLACK_TRUMPET = registerMushroomItem("black_trumpet",
            new MushroomProperties.Builder()
                    .scientificName("Craterellus cornucopioides")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Dark grey to black",
                            "Trumpet shaped",
                            "Hard to spot",
                            "Excellent dried"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item GREY_KNIGHT = registerMushroomItem("grey_knight",
            new MushroomProperties.Builder()
                    .scientificName("Tricholoma terreum")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Grey scaly cap",
                            "Common in pine woods",
                            "Modest flavor",
                            "Safe to eat"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .build()
    );

    public static final Item YELLOW_KNIGHT = registerMushroomItem("yellow_knight",
            new MushroomProperties.Builder()
                    .scientificName("Tricholoma equestre")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "Yellow cap and gills",
                            "Can cause rhabdomyolysis if eaten in large quantities",
                            "Eat in moderation only",
                            "Associated with pine"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item CLUSTERED_BONNET = registerMushroomItem("clustered_bonnet",
            new MushroomProperties.Builder()
                    .scientificName("Mycena inclinata")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Grows in dense clusters",
                            "Small brown caps",
                            "On oak stumps",
                            "Too small and tough to eat"
                    )
                    .build()
    );

    public static final Item ORANGE_BIRCH_BOLETE = registerMushroomItem("orange_birch_bolete",
            ModBlocks.ORANGE_BIRCH_BOLETE_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Leccinum versipelle")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Orange-red cap",
                            "Black scales on stem",
                            "Only with birch",
                            "Must be cooked well"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item BROWN_BIRCH_BOLETE = registerMushroomItem("brown_birch_bolete",
            new MushroomProperties.Builder()
                    .scientificName("Leccinum scabrum")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Brown cap",
                            "Rough scaly stem",
                            "Only with birch",
                            "Modest edibility"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .build()
    );

    public static final Item RED_CRACKING_BOLETE = registerMushroomItem("red_cracking_bolete",
            new MushroomProperties.Builder()
                    .scientificName("Xerocomellus chrysenteron")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Cap cracks to show red",
                            "Yellow pores bruise blue",
                            "Common in mixed woods",
                            "Average edibility"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item SUEDE_BOLETE = registerMushroomItem("suede_bolete",
            new MushroomProperties.Builder()
                    .scientificName("Xerocomus subtomentosus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Olive-brown velvety cap",
                            "Yellow pores",
                            "Common",
                            "Mediocre taste"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item LURID_BOLETE = registerMushroomItem("lurid_bolete",
            new MushroomProperties.Builder()
                    .scientificName("Suillellus luridus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "Red to orange pores",
                            "Bruises intense blue",
                            "MUST be well cooked",
                            "Toxic if raw or undercooked"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item ROOTING_BOLETE = registerMushroomItem("rooting_bolete",
            new MushroomProperties.Builder()
                    .scientificName("Caloboletus radicans")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "Deeply rooting stem",
                            "Bruises blue",
                            "Bitter taste",
                            "Causes gastric upset"
                    )
                    .build()
    );

    public static final Item DOTTED_STEM_BOLETE = registerMushroomItem("dotted_stem_bolete",
            new MushroomProperties.Builder()
                    .scientificName("Boletus erythropus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "Red pores bruise blue",
                            "Red dots on stem",
                            "MUST be cooked thoroughly",
                            "Good when properly prepared"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item HONEY_FUNGUS = registerMushroomItem("honey_fungus",
            ModBlocks.HONEY_FUNGUS_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Armillaria mellea")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "Honey-colored caps",
                            "Ring on stem",
                            "Parasitic on trees",
                            "Must be cooked well - causes upset in some"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item TAWNY_GRISETTE = registerMushroomItem("tawny_grisette",
            new MushroomProperties.Builder()
                    .scientificName("Amanita fulva")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Brown cap with no ring",
                            "Striations on cap edge",
                            "Volva at base",
                            "Edible but in Amanita genus"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item GRISETTE = registerMushroomItem("grisette",
            new MushroomProperties.Builder()
                    .scientificName("Amanita vaginata")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Grey cap with no ring",
                            "Prominent volva",
                            "Edible when cooked",
                            "In Amanita genus - identify carefully"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item ORANGE_PEEL_FUNGUS = registerMushroomItem("orange_peel_fungus",
            new MushroomProperties.Builder()
                    .scientificName("Aleuria aurantia")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Bright orange cup",
                            "Resembles orange peel",
                            "No stem",
                            "Bland taste"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(0.2f)
                    .build()
    );

    public static final Item SCARLET_ELF_CUP = registerMushroomItem("scarlet_elf_cup",
            new MushroomProperties.Builder()
                    .scientificName("Sarcoscypha coccinea")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Brilliant red cup",
                            "Winter/early spring",
                            "On buried wood",
                            "Too tough to eat"
                    )
                    .build()
    );

    public static final Item COMMON_MOREL = registerMushroomItem("common_morel",
            new MushroomProperties.Builder()
                    .scientificName("Morchella esculenta")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.CHOICE_EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Honeycomb appearance",
                            "Hollow throughout",
                            "Spring delicacy",
                            "Never eat raw"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.8f)
                    .build()
    );

    public static final Item SCARLET_CATERPILLARCLUB = registerMushroomItem("scarlet_caterpillarclub",
            new MushroomProperties.Builder()
                    .scientificName("Cordyceps militaris")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.MEDICINAL_ONLY)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Parasitic on insect pupae",
                            "Orange club-shaped",
                            "Medicinal properties",
                            "Related to Chinese cordyceps"
                    )
                    .build()
    );

    public static final Item COMMON_EARTHBALL = registerMushroomItem("common_earthball",
            ModBlocks.COMMON_EARTHBALL_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Scleroderma citrinum")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MODERATE)
                    .identificationFeatures(
                            "Looks like puffball but isn't",
                            "Hard thick skin",
                            "Purple-black interior",
                            "Causes severe gastric upset"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            COMMON_EARTHBALL_CONSUMABLE
    );

    public static final Item THICK_MAZE_OAK_POLYPORE = registerMushroomItem("thick_maze_oak_polypore",
            new MushroomProperties.Builder()
                    .scientificName("Daedalea quercina")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Hard woody bracket",
                            "Maze-like pores",
                            "On oak only",
                            "Too tough to eat"
                    )
                    .build()
    );

    public static final Item CINNABAR_BRACKET = registerMushroomItem("cinnabar_bracket",
            new MushroomProperties.Builder()
                    .scientificName("Pycnoporus cinnabarinus")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Bright orange-red",
                            "Thin bracket",
                            "On dead hardwood",
                            "Too tough to eat"
                    )
                    .build()
    );

    public static final Item SULPHUR_TUFT = registerMushroomItem("sulphur_tuft",
            ModBlocks.SULPHUR_TUFT_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Hypholoma fasciculare")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MODERATE)
                    .identificationFeatures(
                            "Sulphur yellow clusters",
                            "Green-yellow gills",
                            "Very bitter",
                            "Causes vomiting and diarrhea"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            SULPHUR_TUFT_CONSUMABLE
    );

    public static final Item SPLIT_GILL = registerMushroomItem("split_gill",
            new MushroomProperties.Builder()
                    .scientificName("Schizophyllum commune")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.MEDICINAL_ONLY)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Small fan-shaped",
                            "Hairy white cap",
                            "Split gills",
                            "Medicinal in Asia"
                    )
                    .build()
    );

    public static final Item WILLOW_BRACKET = registerMushroomItem("willow_bracket",
            new MushroomProperties.Builder()
                    .scientificName("Phellinus igniarius")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Hard perennial bracket",
                            "Dark grey-brown",
                            "On willow",
                            "Medicinal properties"
                    )
                    .build()
    );

    public static final Item BEECH_WOODWART = registerMushroomItem("beech_woodwart",
            new MushroomProperties.Builder()
                    .scientificName("Hypoxylon fragiforme")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Small round bumps",
                            "Reddish-brown",
                            "On beech",
                            "Releases spore cloud"
                    )
                    .build()
    );

    public static final Item CRAMP_BALLS = registerMushroomItem("cramp_balls",
            new MushroomProperties.Builder()
                    .scientificName("Daldinia concentrica")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Black spherical",
                            "Concentric rings inside",
                            "On dead ash",
                            "Historically used for cramps"
                    )
                    .build()
    );

    public static final Item HAIRY_CURTAIN_CRUST = registerMushroomItem("hairy_curtain_crust",
            new MushroomProperties.Builder()
                    .scientificName("Stereum hirsutum")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Yellow-orange bracket",
                            "Hairy upper surface",
                            "Very common",
                            "Too tough to eat"
                    )
                    .build()
    );

    public static final Item FUNERAL_BELL = registerMushroomItem("funeral_bell",
            new MushroomProperties.Builder()
                    .scientificName("Galerina marginata")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.DEADLY)
                    .toxicityLevel(ToxicityLevel.LETHAL)
                    .identificationFeatures(
                            "Small brown mushroom",
                            "Contains amatoxins like death cap",
                            "DEADLY - same toxins as death cap",
                            "Often on wood"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            FUNERAL_BELL_CONSUMABLE
    );

    public static final Item LIBERTY_CAP = registerMushroomItem("liberty_cap",
            new MushroomProperties.Builder()
                    .scientificName("Psilocybe semilanceata")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MODERATE)
                    .identificationFeatures(
                            "Small conical cap",
                            "Pointed nipple",
                            "Psychoactive (illegal in UK)",
                            "Causes hallucinations"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            LIBERTY_CAP_CONSUMABLE
    );

    public static final Item FOOLS_FUNNEL = registerMushroomItem("fools_funnel",
            new MushroomProperties.Builder()
                    .scientificName("Clitocybe rivulosa")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.DEADLY)
                    .toxicityLevel(ToxicityLevel.LETHAL)
                    .identificationFeatures(
                            "Small white funnel",
                            "Deadly muscarine poisoning",
                            "Often in grass with edible species",
                            "Can be fatal"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            FOOLS_FUNNEL_CONSUMABLE
    );

    public static final Item IVORY_FUNNEL = registerMushroomItem("ivory_funnel",
            new MushroomProperties.Builder()
                    .scientificName("Clitocybe dealbata")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.DEADLY)
                    .toxicityLevel(ToxicityLevel.LETHAL)
                    .identificationFeatures(
                            "White funnel-shaped",
                            "Contains muscarine",
                            "Often with fairy ring champignons",
                            "Potentially fatal"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            IVORY_FUNNEL_CONSUMABLE
    );

    public static final Item LIVID_PINKGILL = registerMushroomItem("livid_pinkgill",
            new MushroomProperties.Builder()
                    .scientificName("Entoloma sinuatum")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.SEVERE)
                    .identificationFeatures(
                            "Large greyish cap",
                            "Pink gills",
                            "Severe gastric upset",
                            "Can hospitalize"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            LIVID_PINKGILL_CONSUMABLE
    );

    public static final Item DEVILS_BOLETE = registerMushroomItem("devils_bolete",
            new MushroomProperties.Builder()
                    .scientificName("Rubroboletus satanas")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.SEVERE)
                    .identificationFeatures(
                            "Pale cap",
                            "Blood red pores",
                            "Red netted stem",
                            "Causes severe vomiting"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            DEVILS_BOLETE_CONSUMABLE
    );

    public static final Item SICKENER = registerMushroomItem("sickener",
            ModBlocks.SICKENER_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Russula emetica")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MODERATE)
                    .identificationFeatures(
                            "Bright red cap",
                            "White stem and gills",
                            "Very acrid taste",
                            "Causes vomiting"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            SICKENER_CONSUMABLE
    );

    public static final Item BEECHWOOD_SICKENER = registerMushroomItem("beechwood_sickener",
            new MushroomProperties.Builder()
                    .scientificName("Russula nobilis")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MODERATE)
                    .identificationFeatures(
                            "Red cap",
                            "Under beech",
                            "Acrid taste",
                            "Causes gastric upset"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            BEECHWOOD_SICKENER_CONSUMABLE
    );

    public static final Item BLACKENING_WAXCAP = registerMushroomItem("blackening_waxcap",
            new MushroomProperties.Builder()
                    .scientificName("Hygrocybe conica")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "Orange-red conical cap",
                            "Blackens with age or handling",
                            "Waxy gills",
                            "Mildly toxic"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            BLACKENING_WAXCAP_CONSUMABLE
    );

    public static final Item TIGER_SAWGILL = registerMushroomItem("tiger_sawgill",
            new MushroomProperties.Builder()
                    .scientificName("Lentinus tigrinus")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "White cap with brown scales",
                            "Serrated gill edges",
                            "On wood",
                            "Causes gastric upset"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            TIGER_SAWGILL_CONSUMABLE
    );

    public static final Item SPECTACULAR_RUSTGILL = registerMushroomItem("spectacular_rustgill",
            new MushroomProperties.Builder()
                    .scientificName("Gymnopilus junonius")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MODERATE)
                    .identificationFeatures(
                            "Large orange-brown cap",
                            "Bitter taste",
                            "May contain psilocybin",
                            "Causes hallucinations and nausea"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            SPECTACULAR_RUSTGILL_CONSUMABLE
    );

    public static final Item DEADLY_DAPPERLING = registerMushroomItem("deadly_dapperling",
            new MushroomProperties.Builder()
                    .scientificName("Lepiota brunneoincarnata")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.DEADLY)
                    .toxicityLevel(ToxicityLevel.LETHAL)
                    .identificationFeatures(
                            "Small brown-scaled cap",
                            "Contains amatoxins",
                            "DEADLY like death cap",
                            "Causes liver failure"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            DEADLY_DAPPERLING_CONSUMABLE
    );

    public static final Item RED_STAINING_INOCYBE = registerMushroomItem("red_staining_inocybe",
            new MushroomProperties.Builder()
                    .scientificName("Inocybe patouillardii")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.DEADLY)
                    .toxicityLevel(ToxicityLevel.LETHAL)
                    .identificationFeatures(
                            "White cap that stains red",
                            "High muscarine content",
                            "Can be fatal",
                            "Fiber-like cap"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            RED_STAINING_INOCYBE_CONSUMABLE
    );

    public static final Item LILAC_FIBRECAP = registerMushroomItem("lilac_fibrecap",
            new MushroomProperties.Builder()
                    .scientificName("Inocybe geophylla var. lilacina")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MODERATE)
                    .identificationFeatures(
                            "Lilac colored",
                            "Small conical cap",
                            "Contains muscarine",
                            "Causes sweating and salivation"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            LILAC_FIBRECAP_CONSUMABLE
    );

    public static final Item COMMON_WHITE_INOCYBE = registerMushroomItem("common_white_inocybe",
            new MushroomProperties.Builder()
                    .scientificName("Inocybe geophylla")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MODERATE)
                    .identificationFeatures(
                            "Pure white",
                            "Silky cap",
                            "Contains muscarine",
                            "Common in woodlands"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            COMMON_WHITE_INOCYBE_CONSUMABLE
    );

    public static final Item DEADLY_PARASOL = registerMushroomItem("deadly_parasol",
            new MushroomProperties.Builder()
                    .scientificName("Lepiota helveola")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.DEADLY)
                    .toxicityLevel(ToxicityLevel.LETHAL)
                    .identificationFeatures(
                            "Small parasol-like",
                            "Brown scales",
                            "Contains amatoxins",
                            "DEADLY - liver damage"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            DEADLY_PARASOL_CONSUMABLE
    );

    public static final Item VERDIGRIS_AGARIC = registerMushroomItem("verdigris_agaric",
            new MushroomProperties.Builder()
                    .scientificName("Stropharia aeruginosa")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "Blue-green when young",
                            "Slimy cap",
                            "White scales",
                            "Suspected mildly toxic"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            VERDIGRIS_AGARIC_CONSUMABLE
    );

    public static final Item BROWN_ROLL_RIM = registerMushroomItem("brown_roll_rim",
            ModBlocks.BROWN_ROLL_RIM_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Paxillus involutus")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.DEADLY)
                    .toxicityLevel(ToxicityLevel.LETHAL)
                    .identificationFeatures(
                            "Brown cap with inrolled edge",
                            "Decurrent gills",
                            "Causes immune-mediated hemolysis",
                            "Can be fatal after repeated consumption"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            BROWN_ROLL_RIM_CONSUMABLE
    );

    public static final Item POISON_PIE = registerMushroomItem("poison_pie",
            new MushroomProperties.Builder()
                    .scientificName("Hebeloma crustuliniforme")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MODERATE)
                    .identificationFeatures(
                            "Pale brown cap",
                            "Smells of radish",
                            "White gills",
                            "Causes severe vomiting"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            POISON_PIE_CONSUMABLE
    );

    public static final Item COMMON_CAVALIER = registerMushroomItem("common_cavalier",
            new MushroomProperties.Builder()
                    .scientificName("Melanoleuca polioleuca")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Grey-brown cap",
                            "White gills",
                            "Common in grass",
                            "Not worthwhile eating"
                    )
                    .build()
    );

    public static final Item GERANIUM_BRITTLESTEM = registerMushroomItem("geranium_brittlestem",
            new MushroomProperties.Builder()
                    .scientificName("Psathyrella candolleana")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Fragile white to brown cap",
                            "Clusters on wood",
                            "Veil remnants on edge",
                            "Edible but not choice"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.2f)
                    .build()
    );

    public static final Item PLEATED_INKCAP = registerMushroomItem("pleated_inkcap",
            new MushroomProperties.Builder()
                    .scientificName("Parasola plicatilis")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Tiny pleated grey cap",
                            "Very short-lived",
                            "Common in grass",
                            "Too small to eat"
                    )
                    .build()
    );

    public static final Item GLISTENING_INKCAP = registerMushroomItem("glistening_inkcap",
            new MushroomProperties.Builder()
                    .scientificName("Coprinellus micaceus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Ochre brown caps in clusters",
                            "Mica-like granules when young",
                            "Autodigest to black liquid",
                            "Edible when young"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    public static final Item MAGPIE_INKCAP = registerMushroomItem("magpie_inkcap",
            new MushroomProperties.Builder()
                    .scientificName("Coprinopsis picacea")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Black and white patches",
                            "Large bell-shaped cap",
                            "Rare",
                            "Don't consume with alcohol"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    public static final Item FAIRIES_BONNET = registerMushroomItem("fairies_bonnet",
            new MushroomProperties.Builder()
                    .scientificName("Coprinellus disseminatus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Tiny caps in huge clusters",
                            "Hundreds together",
                            "Cream to grey",
                            "Too small to eat"
                    )
                    .build()
    );

    public static final Item TROOPING_FUNNEL = registerMushroomItem("trooping_funnel",
            new MushroomProperties.Builder()
                    .scientificName("Clitocybe geotropa")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Very large funnel",
                            "Cream colored",
                            "Forms troops/rings",
                            "Pleasant smell"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item ANISEED_FUNNEL = registerMushroomItem("aniseed_funnel",
            new MushroomProperties.Builder()
                    .scientificName("Clitocybe odora")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Blue-green color",
                            "Strong aniseed smell",
                            "Decurrent gills",
                            "Good for flavoring"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.4f)
                    .build()
    );

    public static final Item TAWNY_FUNNEL = registerMushroomItem("tawny_funnel",
            new MushroomProperties.Builder()
                    .scientificName("Lepista flaccida")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Tawny brown cap",
                            "Funnel shaped",
                            "Common in autumn",
                            "Modest edibility"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    public static final Item BLEWIT = registerMushroomItem("blewit",
            ModBlocks.BLEWIT_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Lepista nuda")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Purple-blue when young",
                            "Fades to tan",
                            "Good edible",
                            "Must be cooked"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()
    );

    public static final Item BITTER_OYSTERLING = registerMushroomItem("bitter_oysterling",
            new MushroomProperties.Builder()
                    .scientificName("Panellus stipticus")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "Small tan bracket",
                            "On dead wood",
                            "Extremely bitter",
                            "Bioluminescent in some regions"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            BITTER_OYSTERLING_CONSUMABLE
    );

    public static final Item PORCELAIN_FUNGUS = registerMushroomItem("porcelain_fungus",
            new MushroomProperties.Builder()
                    .scientificName("Oudemansiella mucida")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Translucent white cap",
                            "Very slimy",
                            "On beech",
                            "Edible but slimy"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    public static final Item ROSY_BONNET = registerMushroomItem("rosy_bonnet",
            new MushroomProperties.Builder()
                    .scientificName("Mycena rosea")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Small pink cap",
                            "Common in woods",
                            "Radish smell",
                            "Too small to eat"
                    )
                    .build()
    );

    public static final Item BLACKEDGE_BONNET = registerMushroomItem("blackedge_bonnet",
            new MushroomProperties.Builder()
                    .scientificName("Mycena pelianthina")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Purple-grey cap",
                            "Black gill edges",
                            "Radish smell",
                            "Too small to eat"
                    )
                    .build()
    );

    public static final Item BURGUNDYDROP_BONNET = registerMushroomItem("burgundydrop_bonnet",
            new MushroomProperties.Builder()
                    .scientificName("Mycena haematopus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Reddish-brown cap",
                            "Bleeds red juice",
                            "On wood",
                            "Too small to eat"
                    )
                    .build()
    );

    public static final Item CORAL_SPOT = registerMushroomItem("coral_spot",
            new MushroomProperties.Builder()
                    .scientificName("Nectria cinnabarina")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Tiny pink-red spots",
                            "Clusters on dead wood",
                            "Very common",
                            "Not a mushroom technically"
                    )
                    .build()
    );

    public static final Item BLEEDING_FAIRY_HELMET = registerMushroomItem("bleeding_fairy_helmet",
            new MushroomProperties.Builder()
                    .scientificName("Mycena sanguinolenta")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Small reddish cap",
                            "Stem bleeds red",
                            "Very common",
                            "Too small to eat"
                    )
                    .build()
    );

    public static final Item COLLARED_PARACHUTE = registerMushroomItem("collared_parachute",
            new MushroomProperties.Builder()
                    .scientificName("Marasmius rotula")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Tiny white parachute",
                            "Attached by collar",
                            "Thread-like stem",
                            "Too small to eat"
                    )
                    .build()
    );

    public static final Item HORSEHAIR_PARACHUTE = registerMushroomItem("horsehair_parachute",
            new MushroomProperties.Builder()
                    .scientificName("Marasmius androsaceus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Tiny brown cap",
                            "Black hair-like stem",
                            "On conifer needles",
                            "Too small to eat"
                    )
                    .build()
    );

    public static final Item SCARLET_WAXCAP = registerMushroomItem("scarlet_waxcap",
            ModBlocks.SCARLET_WAXCAP_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Hygrocybe coccinea")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Bright scarlet red cap",
                            "Waxy appearance",
                            "In grasslands",
                            "Indicator of good habitat"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    public static final Item GOLDEN_WAXCAP = registerMushroomItem("golden_waxcap",
            new MushroomProperties.Builder()
                    .scientificName("Hygrocybe chlorophana")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Bright yellow",
                            "Slimy cap",
                            "In unimproved grassland",
                            "Edible but small"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    public static final Item PARROT_WAXCAP = registerMushroomItem("parrot_waxcap",
            new MushroomProperties.Builder()
                    .scientificName("Gliophorus psittacinus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Green when fresh",
                            "Fades to yellow",
                            "Slimy cap",
                            "Too small to eat"
                    )
                    .build()
    );

    public static final Item SNOWY_WAXCAP = registerMushroomItem("snowy_waxcap",
            new MushroomProperties.Builder()
                    .scientificName("Cuphophyllus virgineus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Pure white",
                            "Small and delicate",
                            "Dry cap",
                            "In grassland"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(0.2f)
                    .build()
    );

    public static final Item BUTTER_CAP = registerMushroomItem("butter_cap",
            new MushroomProperties.Builder()
                    .scientificName("Rhodocollybia butyracea")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Greasy brown cap",
                            "Buttery feel",
                            "White stem",
                            "Modest edibility"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    public static final Item SPOTTED_TOUGHSHANK = registerMushroomItem("spotted_toughshank",
            new MushroomProperties.Builder()
                    .scientificName("Rhodocollybia maculata")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "White cap with red spots",
                            "Tough and fibrous",
                            "Common in conifer woods",
                            "Not worth eating"
                    )
                    .build()
    );

    public static final Item UGLY_MILK_CAP = registerMushroomItem("ugly_milk_cap",
            new MushroomProperties.Builder()
                    .scientificName("Lactarius turpis")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "Olive-brown sticky cap",
                            "White milk turns yellow",
                            "Acrid taste",
                            "Causes gastric upset"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            UGLY_MILK_CAP_CONSUMABLE
    );

    public static final Item WOOLLY_MILK_CAP = registerMushroomItem("woolly_milk_cap",
            ModBlocks.WOOLLY_MILK_CAP_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Lactarius torminosus")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MODERATE)
                    .identificationFeatures(
                            "Pink cap with woolly margin",
                            "Concentric zones",
                            "White acrid milk",
                            "Causes severe vomiting"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            WOOLLY_MILK_CAP_CONSUMABLE
    );

    public static final Item OAK_MILK_CAP = registerMushroomItem("oak_milk_cap",
            new MushroomProperties.Builder()
                    .scientificName("Lactarius quietus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Reddish-brown cap",
                            "Mild white milk",
                            "Oily smell",
                            "Under oak only"
                    )
                    .build()
    );

    public static final Item RUFOUS_MILK_CAP = registerMushroomItem("rufous_milk_cap",
            new MushroomProperties.Builder()
                    .scientificName("Lactarius rufus")
                    .category(MushroomCategory.POISONOUS)
                    .edibilityRating(EdibilityRating.POISONOUS)
                    .toxicityLevel(ToxicityLevel.MILD)
                    .identificationFeatures(
                            "Reddish-brown with central bump",
                            "Very acrid milk",
                            "Under pine",
                            "Inedible due to taste"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .build()
            ,
            RUFOUS_MILK_CAP_CONSUMABLE
    );

    public static final Item COCONUT_MILK_CAP = registerMushroomItem("coconut_milk_cap",
            new MushroomProperties.Builder()
                    .scientificName("Lactarius glyciosmus")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Greyish-brown cap",
                            "Smells of coconut",
                            "Under birch",
                            "Too small and acrid"
                    )
                    .build()
    );

    public static final Item FALSE_DEATH_CAP = registerMushroomItem("false_death_cap",
            new MushroomProperties.Builder()
                    .scientificName("Amanita citrina")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Pale yellow cap",
                            "Smells of raw potato",
                            "In Amanita genus",
                            "Not poisonous but unpleasant"
                    )
                    .build()
    );

    public static final Item GREY_SPOTTED_AMANITA = registerMushroomItem("grey_spotted_amanita",
            new MushroomProperties.Builder()
                    .scientificName("Amanita excelsa")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Grey-brown with grey warts",
                            "Easily confused with panther",
                            "Edible when cooked",
                            "Not recommended due to confusion risk"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
    );

    public static final Item YELLOW_BRAIN = registerMushroomItem("yellow_brain",
            new MushroomProperties.Builder()
                    .scientificName("Tremella mesenterica")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Bright yellow jelly fungus",
                            "Brain-like folds",
                            "On dead wood",
                            "Bland taste but edible"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(0.2f)
                    .build()
    );

    public static final Item WITCHES_BUTTER = registerMushroomItem("witches_butter",
            new MushroomProperties.Builder()
                    .scientificName("Exidia glandulosa")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Black jelly fungus",
                            "Brain-like with white dots",
                            "On dead oak",
                            "Too tough to eat"
                    )
                    .build()
    );

    public static final Item EARPICK_FUNGUS = registerMushroomItem("earpick_fungus",
            new MushroomProperties.Builder()
                    .scientificName("Auriscalpium vulgare")
                    .category(MushroomCategory.MEDICINAL)
                    .edibilityRating(EdibilityRating.INEDIBLE)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Small brown cap on thin stem",
                            "Spines underneath",
                            "On pine cones",
                            "Too tough to eat"
                    )
                    .build()
    );

    public static final Item DUNE_STINKHORN = registerMushroomItem("dune_stinkhorn",
            ModBlocks.DUNE_STINKHORN_MUSHROOM,
            new MushroomProperties.Builder()
                    .scientificName("Phallus hadriani")
                    .category(MushroomCategory.EDIBLE)
                    .edibilityRating(EdibilityRating.EDIBLE_CAUTION)
                    .toxicityLevel(ToxicityLevel.NONE)
                    .identificationFeatures(
                            "Pink 'egg' stage",
                            "Emerges as stinkhorn",
                            "In sand dunes",
                            "Edible at egg stage only"
                    )
                    .build()
            ,
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.3f)
                    .build()
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
