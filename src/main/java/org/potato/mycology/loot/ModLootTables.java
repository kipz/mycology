package org.potato.mycology.loot;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import org.potato.mycology.MycologyMod;

/**
 * Data-driven loot table handler
 * Automatically maps mushroom blocks to their items using naming convention
 * NO INDIVIDUAL MUSHROOM REFERENCES - fully dynamic!
 */
public class ModLootTables {

    public static void register() {
        PlayerBlockBreakEvents.AFTER.register((level, player, pos, state, blockEntity) -> {
            if (level.isClientSide() || player.isCreative()) {
                return;
            }

            Item dropItem = getMushroomItemForBlock(state.getBlock());

            if (dropItem != null) {
                ItemStack itemStack = new ItemStack(dropItem);
                ItemEntity itemEntity = new ItemEntity(
                        level,
                        pos.getX() + 0.5,
                        pos.getY() + 0.5,
                        pos.getZ() + 0.5,
                        itemStack
                );
                itemEntity.setDefaultPickUpDelay();
                level.addFreshEntity(itemEntity);
            }
        });

        MycologyMod.LOGGER.info("Registered custom loot drop handlers for mushroom blocks");
    }

    /**
     * Get the item that should drop from a mushroom block
     * Uses naming convention: {name}_mushroom block → {name} item
     */
    @Nullable
    private static Item getMushroomItemForBlock(Block block) {
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(block);

        // Check if it's one of our mushroom blocks
        if (!blockId.getNamespace().equals(MycologyMod.MOD_ID)) {
            return null;
        }

        String blockName = blockId.getPath();
        if (!blockName.endsWith("_mushroom")) {
            return null;
        }

        // Convert block name to item name: remove "_mushroom" suffix
        String itemName = blockName.substring(0, blockName.length() - "_mushroom".length());

        // Look up the corresponding item
        ResourceLocation itemId = ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, itemName);
        return BuiltInRegistries.ITEM.getOptional(itemId).orElse(null);
    }
}
