package net.tantr.particle_physics;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.tantr.particle_physics.item.ModItems;
import net.tantr.particle_physics.block.ModBlocks;
import net.tantr.particle_physics.particle.ModParticles;

public class ParticlePhysics implements ModInitializer {
	public static final String MOD_ID = "particle_physics";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModParticles.registerParticles();
	}
}
