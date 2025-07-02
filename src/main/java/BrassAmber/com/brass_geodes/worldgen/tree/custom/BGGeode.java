package BrassAmber.com.brass_geodes.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.GeodeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;

public class BGGeode extends GeodeFeature {
    public BGGeode(Codec<GeodeConfiguration> p_159834_) {
        super(p_159834_);
    }

    @Override
    public boolean place(FeaturePlaceContext<GeodeConfiguration> placeContext) {
        BlockState checkState = placeContext.level().getBlockState(placeContext.origin().above(25));
        boolean badPlacement = (checkState.is(Blocks.AIR) && !checkState.is(Blocks.CAVE_AIR)) || checkState.getFluidState().isSource();

        return !badPlacement && super.place(placeContext);
    }
}
