package org.potato.mycology.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Base class for mushroom blocks that spawn naturally in the world.
 * Similar to vanilla mushroom blocks.
 *
 * Note: Item drops are handled by ModLootTables using Fabric's PlayerBlockBreakEvents.
 */
public class MushroomPlantBlock extends BushBlock {
    public static final MapCodec<MushroomPlantBlock> CODEC = simpleCodec(MushroomPlantBlock::new);
    protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);

    public MushroomPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
