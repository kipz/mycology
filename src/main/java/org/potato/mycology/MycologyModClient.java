package org.potato.mycology;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import org.potato.mycology.registry.ModBlocks;

/**
 * Client-side initialization - fully data-driven
 * Automatically registers render layers for all mushroom blocks
 * NO INDIVIDUAL MUSHROOM REFERENCES!
 */
public class MycologyModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MycologyMod.LOGGER.info("Initializing Mycology Mod Client");

		// Register cutout rendering for ALL mushroom blocks dynamically
		for (Block block : ModBlocks.getAllMushroomBlocks().values()) {
			BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
		}

		MycologyMod.LOGGER.info("Registered render layers for {} mushroom blocks",
				ModBlocks.getAllMushroomBlocks().size());
		MycologyMod.LOGGER.info("Mycology Mod Client initialized successfully");
	}
}
