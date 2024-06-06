package net.tantr.particle_physics;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.tantr.particle_physics.block.ModBlocks;
import net.tantr.particle_physics.particle.ModParticles;

public class ParticlePhysicsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(ParticlePhysics.MOD_ID, "particle/green_flame"));
        }));

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLASTIC_SCINTILLATOR_CYLINDER, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLASTIC_SCINTILLATOR_BLOCK, RenderLayer.getTranslucent());
        ParticleFactoryRegistry.getInstance().register(ModParticles.GREEN_FLAME, FlameParticle.Factory::new);
    }
}
