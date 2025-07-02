package BrassAmber.com.brass_geodes.block;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GemcornBranch extends AmethystClusterBlock implements SimpleWaterloggedBlock {
    public GemcornBranch(int i, int i1, Properties properties) {
        super(i, i1, properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return false;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 0;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext p_152019_) {
        return super.getStateForPlacement(p_152019_);
    }

    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource random) {
        super.animateTick(blockState, level, blockPos, random);
        List<BlockPos> validPos = Lists.newArrayList();
        validPos.add(blockPos);
        if (random.nextInt(7) == 0) {
            BlockPos aOrb;
            if (level.getBlockState(blockPos.above()).isAir()) {
                aOrb = blockPos.above();
                if (level.getBlockState(blockPos.north()).isAir()) {
                    validPos.add(aOrb.north());
                } else if (level.getBlockState(blockPos.east()).isAir()) {
                    validPos.add(aOrb.east());
                } else if (level.getBlockState(blockPos.east()).isAir()) {
                    validPos.add(aOrb.south());
                } else if (level.getBlockState(blockPos.east()).isAir()) {
                    validPos.add(aOrb.west());
                }
            } else if (level.getBlockState(blockPos.below()).isAir()) {
                aOrb = blockPos.above();
                if (level.getBlockState(blockPos.north()).isAir()) {
                    validPos.add(aOrb.north());
                } else if (level.getBlockState(blockPos.east()).isAir()) {
                    validPos.add(aOrb.east());
                } else if (level.getBlockState(blockPos.east()).isAir()) {
                    validPos.add(aOrb.south());
                } else if (level.getBlockState(blockPos.east()).isAir()) {
                    validPos.add(aOrb.west());
                }
            }
            BlockPos particlePos = validPos.get(random.nextInt(validPos.size()));
            level.addParticle(ParticleTypes.ELECTRIC_SPARK, particlePos.getX(), particlePos.getY(), particlePos.getZ(), .2D, .1D, .2D);
            level.playSound(null, particlePos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 5F, 1F);
        }
    }
}
