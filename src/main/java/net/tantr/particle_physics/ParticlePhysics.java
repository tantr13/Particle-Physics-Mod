package net.tantr.particle_physics;

import net.fabricmc.api.ModInitializer;
import net.tantr.particle_physics.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.tantr.particle_physics.item.ModItems;

public class ParticlePhysics implements ModInitializer {
	public static final String MOD_ID = "particle_physics";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks(); // ModBlocks
	}
}
