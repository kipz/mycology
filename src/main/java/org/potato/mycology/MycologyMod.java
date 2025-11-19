package org.potato.mycology;

import net.fabricmc.api.ModInitializer;
import org.potato.mycology.loot.ModLootTables;
import org.potato.mycology.registry.ModBlocks;
import org.potato.mycology.registry.ModItemGroups;
import org.potato.mycology.registry.ModItems;
import org.potato.mycology.worldgen.ModFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MycologyMod implements ModInitializer {
	public static final String MOD_ID = "mycology";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Mycology Mod");

		// NOTE: Dynamic registration system is available but disabled due to worldgen timing issues
		// Worldgen JSONs are loaded before mod initialization, so blocks must be statically registered
		// DynamicMushroomRegistry.registerAll();

		// Register blocks (must be before items)
		ModBlocks.registerBlocks();

		// Register item groups (must be before items)
		ModItemGroups.registerItemGroups();

		// Register items
		ModItems.registerItems();

		// Register loot tables for mushroom blocks
		ModLootTables.register();

		// Register worldgen features and biome modifications
		ModFeatures.registerBiomeModifications();

		LOGGER.info("Mycology Mod initialized successfully");
	}
}
