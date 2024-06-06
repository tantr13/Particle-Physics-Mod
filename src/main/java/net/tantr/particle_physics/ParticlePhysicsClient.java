package net.tantr.particle_physics;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.tantr.particle_physics.block.ModBlocks;

public class ParticlePhysicsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLASTIC_SCINTILLATOR_CYLINDER, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLASTIC_SCINTILLATOR_BLOCK, RenderLayer.getTranslucent());

    }
}
