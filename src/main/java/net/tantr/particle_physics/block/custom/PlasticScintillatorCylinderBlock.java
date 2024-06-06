package net.tantr.particle_physics.block.custom;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.tantr.particle_physics.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class PlasticScintillatorCylinderBlock extends HorizontalFacingBlock {
    public PlasticScintillatorCylinderBlock(Settings settings) {
        super(settings);
    }


    public static final BooleanProperty LIT = BooleanProperty.of("lit");


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient() && hand == Hand.MAIN_HAND && player.getMainHandStack().getItem() == ModItems.LASER_530NM)  {
            world.setBlockState(pos, state.cycle(LIT));
        }

        // add , ToolItem toolItem && toolItem.getName("ex");
        return super.onUse(state, world, pos, player, hand, hit);
    }

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(9.5, 0, 7, 10, 6, 9),
            Block.createCuboidShape(7, 0, 9.5, 9, 6, 10),
            Block.createCuboidShape(6, 0, 7, 6.5, 6, 9),
            Block.createCuboidShape(6.5, 5.75, 6.5, 9.5, 6, 9.5),
            Block.createCuboidShape(6.5, 0, 6.5, 9.5, 0.25, 9.5),
            Block.createCuboidShape(7, 0, 6, 9, 6, 6.5),
            Block.createCuboidShape(9.5, 0, 6.5, 9.75, 6, 7),
            Block.createCuboidShape(9, 0, 6.25, 9.5, 6, 6.5),
            Block.createCuboidShape(9.5, 0, 9, 9.75, 6, 9.5),
            Block.createCuboidShape(9, 0, 9.5, 9.5, 6, 9.75),
            Block.createCuboidShape(6.25, 0, 9, 6.5, 6, 9.5),
            Block.createCuboidShape(6.5, 0, 9.5, 7, 6, 9.75),
            Block.createCuboidShape(6.25, 0, 6.5, 6.5, 6, 7),
            Block.createCuboidShape(6.5, 0, 6.25, 7, 6, 6.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    // for different directional blocks, make unique .java VoxelShape files for each direction in BlockBench and make VoxelShape SHAPE_N, W, E, S
    // and in getOutlineShape make switch statement like so:


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;

        // switch (state.get(FACING)) {
        //      case NORTH:
        //          return SHAPE_N;
        //      ...
        //      default:
        //          return SHAPE_N;
    }






    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(LIT);
    }
}
