package org.potato.mycology;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import org.potato.mycology.registry.ModBlocks;

public class MycologyModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MycologyMod.LOGGER.info("Initializing Mycology Mod Client");

		// Register render layers for transparent mushroom blocks
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHANTERELLE_MUSHROOM, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PORCINI_MUSHROOM, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIELD_MUSHROOM_BLOCK, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OYSTER_MUSHROOM_BLOCK, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARASOL_MUSHROOM_BLOCK, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLY_AGARIC_MUSHROOM, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEATH_CAP_MUSHROOM, RenderType.cutout());

		MycologyMod.LOGGER.info("Mycology Mod Client initialized successfully");
	}
}
