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
        if (block == ModBlocks.MOREL_MUSHROOM) return ModItems.MOREL;
        if (block == ModBlocks.CEP_MUSHROOM) return ModItems.CEP;
        if (block == ModBlocks.ST_GEORGES_MUSHROOM_MUSHROOM) return ModItems.ST_GEORGES_MUSHROOM;
        if (block == ModBlocks.FAIRY_RING_CHAMPIGNON_MUSHROOM) return ModItems.FAIRY_RING_CHAMPIGNON;
        if (block == ModBlocks.AMETHYST_DECEIVER_MUSHROOM) return ModItems.AMETHYST_DECEIVER;
        if (block == ModBlocks.CHARCOAL_BURNER_MUSHROOM) return ModItems.CHARCOAL_BURNER;
        if (block == ModBlocks.VELVET_SHANK_MUSHROOM) return ModItems.VELVET_SHANK;
        if (block == ModBlocks.PENNY_BUN_MUSHROOM) return ModItems.PENNY_BUN;
        if (block == ModBlocks.COMMON_PUFFBALL_MUSHROOM) return ModItems.COMMON_PUFFBALL;
        if (block == ModBlocks.SLIPPERY_JACK_MUSHROOM) return ModItems.SLIPPERY_JACK;
        if (block == ModBlocks.WOOD_HEDGEHOG_MUSHROOM) return ModItems.WOOD_HEDGEHOG;
        if (block == ModBlocks.ORANGE_BIRCH_BOLETE_MUSHROOM) return ModItems.ORANGE_BIRCH_BOLETE;
        if (block == ModBlocks.HONEY_FUNGUS_MUSHROOM) return ModItems.HONEY_FUNGUS;
        if (block == ModBlocks.COMMON_EARTHBALL_MUSHROOM) return ModItems.COMMON_EARTHBALL;
        if (block == ModBlocks.SULPHUR_TUFT_MUSHROOM) return ModItems.SULPHUR_TUFT;
        if (block == ModBlocks.SICKENER_MUSHROOM) return ModItems.SICKENER;
        if (block == ModBlocks.BROWN_ROLL_RIM_MUSHROOM) return ModItems.BROWN_ROLL_RIM;
        if (block == ModBlocks.BLEWIT_MUSHROOM) return ModItems.BLEWIT;
        if (block == ModBlocks.SCARLET_WAXCAP_MUSHROOM) return ModItems.SCARLET_WAXCAP;
        if (block == ModBlocks.WOOLLY_MILK_CAP_MUSHROOM) return ModItems.WOOLLY_MILK_CAP;
        if (block == ModBlocks.DUNE_STINKHORN_MUSHROOM) return ModItems.DUNE_STINKHORN;
        return null;
    }
}
