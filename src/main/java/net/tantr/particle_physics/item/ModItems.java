package net.tantr.particle_physics.item;


import net.tantr.particle_physics.ParticlePhysics;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.tantr.particle_physics.item.custom.LaserItem;


public class ModItems {

    public static final Item PMT = registerItem("pmt",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTONICS)));

    public static final Item PLASTIC_SCINTILLATOR = registerItem("plastic_scintillator",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTONICS)));

    public static final Item LASER_530NM = registerItem("laser_530nm",
            new LaserItem(new FabricItemSettings().group(ModItemGroup.PHOTONICS)));

    public static final Item LASER_650NM = registerItem("laser_650nm",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTONICS)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ParticlePhysics.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ParticlePhysics.LOGGER.debug("Registering mod items for " + ParticlePhysics.MOD_ID);
    }
}
