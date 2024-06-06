package net.tantr.particle_physics.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.tantr.particle_physics.ParticlePhysics;

public class ModItemGroup {
    public static final ItemGroup PHOTONICS = FabricItemGroupBuilder.build(
            new Identifier(ParticlePhysics.MOD_ID, "photonics"), () -> new ItemStack(ModItems.PMT));
    // ItemStack is the item displayed in Creative Mode for the ItemGroup
}
