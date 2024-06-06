package net.tantr.particle_physics.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tantr.particle_physics.ParticlePhysics;
import net.tantr.particle_physics.block.custom.PlasticScintillatorCylinderBlock;
import net.tantr.particle_physics.item.ModItemGroup;

public class ModBlocks {

    public static final Block PLASTIC_SCINTILLATOR_BLOCK = registerBlock("plastic_scintillator_block",
            new Block(FabricBlockSettings.of(Material.STONE)
                    .strength(4f).requiresTool().nonOpaque()), ModItemGroup.PHOTONICS);

    public static final Block PLASTIC_SCINTILLATOR_CYLINDER = registerBlock("plastic_scintillator_cylinder",
            new PlasticScintillatorCylinderBlock(FabricBlockSettings.of(Material.GLASS)
                    .strength(4f).requiresTool().nonOpaque()
                    .luminance(state -> state.get(PlasticScintillatorCylinderBlock.LIT) ? 0 : 15)), ModItemGroup.PHOTONICS);








    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(ParticlePhysics.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(ParticlePhysics.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        ParticlePhysics.LOGGER.debug("Registering mod blocks for " + ParticlePhysics.MOD_ID);
    }
}
