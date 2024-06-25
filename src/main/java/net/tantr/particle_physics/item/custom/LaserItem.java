package net.tantr.particle_physics.item.custom;

import com.mojang.authlib.yggdrasil.response.User;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tantr.particle_physics.particle.ModParticles;

public class LaserItem extends Item {
    public LaserItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) {
            spawnMyParticles(world, user);

        }

        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();

            spawnFoundParticles(context, positionClicked);
        }
        return super.useOnBlock(context);
    }

    private void spawnMyParticles(World world, PlayerEntity user) {
        world.addParticle(ModParticles.GREEN_FLAME,
                user.getX(), user.getEyeY(), user.getZ(),
                user.getRotationVector().x, user.getRotationVector().y, user.getRotationVector().z);
    }

    private void spawnFoundParticles(ItemUsageContext pContext, BlockPos positionClicked) {
        for(int i = 0; i < 360; i++) {
            if(i % 20 == 0) {
                pContext.getWorld().addParticle(ModParticles.GREEN_FLAME,
                        positionClicked.getX() + 0.5d, positionClicked.getY() + 1, positionClicked.getZ() + 0.5d,
                        Math.cos(i) * 0.25d, 0.15d, Math.sin(i) * 0.25d);
            }
        }
    }



}
