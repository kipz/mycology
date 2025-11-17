package org.potato.mycology.loot;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.potato.mycology.MycologyMod;
import org.potato.mycology.registry.ModBlocks;
import org.potato.mycology.registry.ModItems;

/**
 * Handles custom loot drops for mushroom blocks.
 * Uses Fabric's block break events to manually drop mushroom items.
 */
public class ModLootTables {

    public static void register() {
        // Register event handler for block breaking
        PlayerBlockBreakEvents.AFTER.register((level, player, pos, state, blockEntity) -> {
            // Only process on server side and in survival/adventure mode
            if (level.isClientSide() || player.isCreative()) {
                return;
            }

            // Get the item that should drop for this mushroom block
            Item dropItem = getMushroomItemForBlock(state.getBlock());

            if (dropItem != null) {
                // Drop the mushroom item at the block's position
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

                MycologyMod.LOGGER.debug("Dropped {} at {}", dropItem, pos);
            }
        });

        MycologyMod.LOGGER.info("Registered custom loot drop handlers for mushroom blocks");
    }

    @Nullable
    private static Item getMushroomItemForBlock(Block block) {
        if (block == ModBlocks.CHANTERELLE_MUSHROOM) return ModItems.CHANTERELLE;
        if (block == ModBlocks.PORCINI_MUSHROOM) return ModItems.PORCINI;
        if (block == ModBlocks.FIELD_MUSHROOM_BLOCK) return ModItems.FIELD_MUSHROOM;
        if (block == ModBlocks.OYSTER_MUSHROOM_BLOCK) return ModItems.OYSTER_MUSHROOM;
        if (block == ModBlocks.PARASOL_MUSHROOM_BLOCK) return ModItems.PARASOL_MUSHROOM;
        if (block == ModBlocks.FLY_AGARIC_MUSHROOM) return ModItems.FLY_AGARIC;
        if (block == ModBlocks.DEATH_CAP_MUSHROOM) return ModItems.DEATH_CAP;
        return null;
    }
}
