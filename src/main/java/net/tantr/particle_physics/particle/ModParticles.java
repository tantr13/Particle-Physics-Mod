package net.tantr.particle_physics.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tantr.particle_physics.ParticlePhysics;

public class ModParticles {

    public static final DefaultParticleType GREEN_FLAME = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(ParticlePhysics.MOD_ID, "green_flame"), GREEN_FLAME);
    }
}