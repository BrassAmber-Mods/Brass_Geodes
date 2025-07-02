package BrassAmber.com.brass_geodes.worldgen.tree.custom;

import BrassAmber.com.brass_geodes.init.BGTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class GemcornTrunkPlacer extends TrunkPlacer {
    public static final Codec<GemcornTrunkPlacer> CODEC = RecordCodecBuilder.create(gemcornTrunkPlacerInstance ->
            trunkPlacerParts(gemcornTrunkPlacerInstance).apply(gemcornTrunkPlacerInstance, GemcornTrunkPlacer::new));

    public static List<Direction> BRANCH_DIRECTIONS = List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

    public GemcornTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return BGTrunkPlacerTypes.GEMCORN_TREE_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> blockSetter,
                                                            RandomSource pRandom, int pFreeTreeHeight, BlockPos blockPos, TreeConfiguration treeConfig) {

        setDirtAt(pLevel, blockSetter, pRandom, blockPos.below(), treeConfig);

        int branch_count_b = pRandom.nextInt(3,5);
        int try_max = 50;

        List<List<Direction>> branches = new ArrayList<>();

        for (int i = 0; i < pFreeTreeHeight; i++) {
            placeLog(pLevel, blockSetter, pRandom, blockPos.above(i), treeConfig);
            branches.add(new ArrayList<>());
        }
        for (int j = 0; j < 6; j++) {
            Direction randDirection;
            int newBranchHeight;
            int tryAmt = 0;
            do {
                newBranchHeight = pRandom.nextInt(3, 7);
                randDirection = BRANCH_DIRECTIONS.get(pRandom.nextInt(4));
                tryAmt++;
            } while (
                    (branches.get(newBranchHeight).contains(randDirection)
                            || branches.get(newBranchHeight - 1).contains(randDirection)
                            || branches.get(newBranchHeight + 1).contains(randDirection))
                    && tryAmt < try_max
            );

            if (tryAmt < try_max) {
                branches.get(newBranchHeight).add(randDirection);
                placeBranch(pLevel, blockSetter, pRandom, blockPos.above(newBranchHeight), treeConfig, randDirection, newBranchHeight);
            }

        }

        for (int j = 0; j < branch_count_b; j++) {
            Direction randDirection;
            int newBranchHeight;
            int tryAmt = 0;
            do {
                newBranchHeight = pRandom.nextInt(6, pFreeTreeHeight -2);
                randDirection = BRANCH_DIRECTIONS.get(pRandom.nextInt(4));
                tryAmt++;
            } while (
                    (branches.get(newBranchHeight).contains(randDirection)
                            || branches.get(newBranchHeight - 1).contains(randDirection)
                            || branches.get(Math.min(pFreeTreeHeight - 2, newBranchHeight + 1)).contains(randDirection))
                    && tryAmt < try_max
            );

            if (tryAmt < try_max) {
                branches.get(newBranchHeight).add(randDirection);
                placeBranch(pLevel, blockSetter, pRandom, blockPos.above(newBranchHeight), treeConfig, randDirection, newBranchHeight);
            }
        }

        return List.of();
    }
    public int getTreeHeight(RandomSource randomSource) {
        return this.baseHeight + randomSource.nextInt(1, 3);
    }


    public void placeBranch(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> blockSetter,
                            RandomSource pRandom, BlockPos blockPos, TreeConfiguration treeConfig, Direction direction, int height) {
        placeLog(pLevel, blockSetter, pRandom, blockPos.relative(direction), treeConfig);
        if (height > 5) {
            placeLog(pLevel, blockSetter, pRandom, blockPos.relative(direction).relative(direction).above(), treeConfig);
        }

    }
}

