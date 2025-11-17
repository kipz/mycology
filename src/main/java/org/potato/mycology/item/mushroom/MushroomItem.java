package org.potato.mycology.item.mushroom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.block.Block;
import org.potato.mycology.item.mushroom.MushroomProperties.EdibilityRating;
import org.potato.mycology.item.mushroom.MushroomProperties.ToxicityLevel;

import java.util.List;

/**
 * Base class for all mushroom items in the mod
 * Extends BlockItem to allow placing mushroom blocks
 */
public class MushroomItem extends BlockItem {
    private final MushroomProperties mushroomProperties;

    // Constructor for mushrooms with food properties and consumable effects
    public MushroomItem(Block block, MushroomProperties mushroomProperties, ResourceKey<Item> key, FoodProperties foodProperties, Consumable consumable) {
        super(block, new Properties()
                .setId(key)
                .component(DataComponents.FOOD, foodProperties)
                .component(DataComponents.CONSUMABLE, consumable));
        this.mushroomProperties = mushroomProperties;
    }

    // Constructor for mushrooms with food properties only (no effects)
    public MushroomItem(Block block, MushroomProperties mushroomProperties, ResourceKey<Item> key, FoodProperties foodProperties) {
        super(block, new Properties()
                .setId(key)
                .component(DataComponents.FOOD, foodProperties)
                .component(DataComponents.CONSUMABLE, Consumables.defaultFood().build()));
        this.mushroomProperties = mushroomProperties;
    }

    // Constructor for non-edible mushrooms (medicinal only)
    public MushroomItem(Block block, MushroomProperties mushroomProperties, ResourceKey<Item> key) {
        super(block, new Properties().setId(key));
        this.mushroomProperties = mushroomProperties;
    }

    public MushroomProperties getMushroomProperties() {
        return mushroomProperties;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);

        // Add scientific name
        tooltipComponents.add(Component.literal(mushroomProperties.getScientificName())
                .withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY));

        // Add edibility/toxicity warning
        if (mushroomProperties.getToxicityLevel() != ToxicityLevel.NONE) {
            String warning = switch (mushroomProperties.getToxicityLevel()) {
                case MILD -> "⚠ Mildly Toxic";
                case MODERATE -> "⚠ Toxic";
                case SEVERE -> "☠ Highly Toxic";
                case LETHAL -> "☠ DEADLY";
                default -> "";
            };
            ChatFormatting color = switch (mushroomProperties.getToxicityLevel()) {
                case MILD -> ChatFormatting.YELLOW;
                case MODERATE -> ChatFormatting.GOLD;
                case SEVERE -> ChatFormatting.RED;
                case LETHAL -> ChatFormatting.DARK_RED;
                default -> ChatFormatting.WHITE;
            };
            tooltipComponents.add(Component.literal(warning).withStyle(ChatFormatting.BOLD, color));
        } else if (mushroomProperties.getEdibilityRating() == EdibilityRating.CHOICE_EDIBLE) {
            tooltipComponents.add(Component.literal("★ Choice Edible")
                    .withStyle(ChatFormatting.GREEN, ChatFormatting.BOLD));
        } else if (mushroomProperties.getEdibilityRating() == EdibilityRating.MEDICINAL_ONLY) {
            tooltipComponents.add(Component.literal("⚕ Medicinal")
                    .withStyle(ChatFormatting.AQUA));
        }

        // Add category info
        String categoryText = switch (mushroomProperties.getCategory()) {
            case EDIBLE -> "Edible";
            case MEDICINAL -> "Medicinal";
            case POISONOUS -> "Poisonous";
        };
        tooltipComponents.add(Component.literal("Category: " + categoryText)
                .withStyle(ChatFormatting.DARK_GRAY));

        // In advanced tooltip mode, show identification features
        if (tooltipFlag.isAdvanced() && mushroomProperties.getIdentificationFeatures().length > 0) {
            tooltipComponents.add(Component.literal("Identification:")
                    .withStyle(ChatFormatting.GOLD));
            for (String feature : mushroomProperties.getIdentificationFeatures()) {
                tooltipComponents.add(Component.literal("• " + feature)
                        .withStyle(ChatFormatting.GRAY));
            }
        } else if (mushroomProperties.getIdentificationFeatures().length > 0) {
            tooltipComponents.add(Component.literal("Hold F3+H for identification features")
                    .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
        }
    }
}
