package BrassAmber.com.brass_geodes.worldgen.tree.custom;

import BrassAmber.com.brass_geodes.BGBlocks;
import BrassAmber.com.brass_geodes.block.GemcornBranch;
import BrassAmber.com.brass_geodes.util.BGUtil;
import BrassAmber.com.brass_geodes.worldgen.tree.BGTreeDecorators;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;

public class GemcornTrunkDecorator extends TreeDecorator {
    public static final Codec<GemcornTrunkDecorator> CODEC = RecordCodecBuilder.create((decoratorInstance) ->
            decoratorInstance.group(
                    Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((gemcornDecorator) -> gemcornDecorator.buddingProbability),
                    BlockState.CODEC.fieldOf("trunk_block").forGetter((gemcornDecorator) -> gemcornDecorator.trunkBlock),
                    BlockState.CODEC.fieldOf("branch_block").forGetter((gemcornDecorator) -> gemcornDecorator.branchBlock)
            ).apply(decoratorInstance, GemcornTrunkDecorator::new)
    );

    private final float buddingProbability;
    private final BlockState trunkBlock;
    private final BlockState branchBlock;

    public GemcornTrunkDecorator(float buddingProbability, BlockState trunkBlock, BlockState branchBlock) {
        this.buddingProbability = buddingProbability;
        this.trunkBlock = trunkBlock;
        this.branchBlock = branchBlock;
    }

    protected TreeDecoratorType<?> type() {
        return BGTreeDecorators.BUDDING_GEMCORN_DECORATOR.get();
    }

    public void place(TreeDecorator.Context context) {
        RandomSource randomsource = context.random();
        List<BlockPos> logList = context.logs();
        BlockPos startPos = logList.get(0);
        logList.forEach((logPos) -> {
            float nextChance = randomsource.nextFloat();
            if ((BGUtil.distanceTo3D(startPos, logPos) > 6 && nextChance <= this.buddingProbability)
                    || (BGUtil.distanceTo2D(startPos, logPos) > 0.5) || (BGUtil.distanceTo2D(startPos, logPos) == 0 && BGUtil.distanceTo3D(startPos, logPos) > 7)
            ) {
                context.setBlock(logPos, trunkBlock);
                for (Direction direction: Direction.values()) {
                    BlockPos checkPos = logPos.relative(direction);
                    if (context.isAir(checkPos)) {
                        if (randomsource.nextBoolean()) {
                            context.setBlock(checkPos, branchBlock.setValue(GemcornBranch.FACING, direction));
                        } else {
                            context.setBlock(checkPos, BGBlocks.GEMCORN_BRANCH.get().defaultBlockState().setValue(GemcornBranch.FACING, direction));
                        }

                    }
                }
            }
        });
    }

}
