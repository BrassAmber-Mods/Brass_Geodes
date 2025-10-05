package BrassAmber.com.brass_geodes.block;

import BrassAmber.com.brass_geodes.BrassGeodes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GemcornSaplingBlock extends SaplingBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    public static final int MAX_AGE = BlockStateProperties.MAX_AGE_2;


    public GemcornSaplingBlock(AbstractTreeGrower treeGrower, Properties properties) {
        super(treeGrower, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, 0).setValue(AGE, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_221484_) {
        p_221484_.add(STAGE).add(AGE);
    }

    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(Blocks.STONE);
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (isFullyGrown(blockState)) {
            this.advanceTree(serverLevel, blockPos, blockState, randomSource);
        } else {
            if (randomSource.nextFloat() < .4) {
                serverLevel.setBlock(blockPos, blockState.cycle(AGE), 4);
            }
        }

        BrassGeodes.LOGGER.info("Gemcorn Tree Age: {}   Stage: {}", blockState.getValue(AGE), blockState.getValue(STAGE));

    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    private static boolean isFullyGrown(BlockState blockState) {
        return blockState.getValue(AGE) == MAX_AGE;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader p_256124_, BlockPos p_55992_, BlockState p_55993_, boolean p_55994_) {
        return false;
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        // return (double)level.random.nextFloat() < 0.1D;
        return false;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        // blockState.setValue(AGE, 2);
        // this.advanceTree(serverLevel, blockPos, blockState, randomSource);
        // this.randomTick(blockState, serverLevel, blockPos, randomSource);
    }
}
