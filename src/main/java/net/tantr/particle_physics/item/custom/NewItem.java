package net.tantr.particle_physics.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class NewItem extends Item{
    public NewItem(Settings settings) {super(settings); }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return super.useOnBlock(context);
    }
}
