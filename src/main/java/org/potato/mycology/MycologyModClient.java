package org.potato.mycology;

import net.fabricmc.api.ClientModInitializer;

public class MycologyModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MycologyMod.LOGGER.info("Initializing Mycology Mod Client");

		// Client-specific initialization will go here
		// (e.g., rendering, GUI, key bindings)

		MycologyMod.LOGGER.info("Mycology Mod Client initialized successfully");
	}
}
