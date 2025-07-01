package BrassAmber.com.brass_geodes.worldgen;

import BrassAmber.com.brass_geodes.BGBlocks;
import BrassAmber.com.brass_geodes.BrassGeodes;
import BrassAmber.com.brass_geodes.worldgen.tree.custom.GemcornTrunkDecorator;
import BrassAmber.com.brass_geodes.worldgen.tree.custom.GemcornTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class BGConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETHYST_GEMCORN_KEY = registerKey("amethyst_gemcorn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TOPAZ_GEMCORN_KEY = registerKey("topaz_gemcorn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_GEMCORN_KEY = registerKey("sapphire_gemcorn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_GEMCORN_KEY = registerKey("ruby_gemcorn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EMERALD_GEMCORN_KEY = registerKey("emerald_gemcorn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIAMOND_GEMCORN_KEY = registerKey("diamond_gemcorn");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TOPAZ_GEODE_KEY = registerKey("topaz_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_GEODE_KEY = registerKey("sapphire_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_GEODE_KEY = registerKey("ruby_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EMERALD_GEODE_KEY = registerKey("emerald_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIAMOND_GEODE_KEY = registerKey("diamond_geode");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        registerGemcornTree(context, AMETHYST_GEMCORN_KEY, BGBlocks.AMETHYST_TRUNK.get(), BGBlocks.AMETHYST_BRANCH.get());
        registerGemcornTree(context, TOPAZ_GEMCORN_KEY, BGBlocks.TOPAZ_TRUNK.get(), BGBlocks.TOPAZ_BRANCH.get());
        registerGemcornTree(context, SAPPHIRE_GEMCORN_KEY, BGBlocks.SAPPHIRE_TRUNK.get(), BGBlocks.SAPPHIRE_BRANCH.get());
        registerGemcornTree(context, RUBY_GEMCORN_KEY, BGBlocks.RUBY_TRUNK.get(), BGBlocks.RUBY_BRANCH.get());
        registerGemcornTree(context, EMERALD_GEMCORN_KEY, BGBlocks.EMERALD_TRUNK.get(), BGBlocks.EMERALD_BRANCH.get());
        registerGemcornTree(context, DIAMOND_GEMCORN_KEY, BGBlocks.DIAMOND_TRUNK.get(), BGBlocks.DIAMOND_BRANCH.get());

        registerGeode(context, TOPAZ_GEODE_KEY, BGBlocks.RAW_TOPAZ_BLOCK.get(),
                BGBlocks.BUDDING_TOPAZ.get(),
                List.of(
                        BGBlocks.SMALL_TOPAZ_BUD.get().defaultBlockState(),
                        BGBlocks.MEDIUM_TOPAZ_BUD.get().defaultBlockState(),
                        BGBlocks.LARGE_TOPAZ_BUD.get().defaultBlockState(),
                        BGBlocks.TOPAZ_CLUSTER.get().defaultBlockState()
                )
        );
        registerGeode(context, SAPPHIRE_GEODE_KEY, BGBlocks.RAW_SAPPHIRE_BLOCK.get(),
                BGBlocks.BUDDING_SAPPHIRE.get(),
                List.of(
                        BGBlocks.SMALL_SAPPHIRE_BUD.get().defaultBlockState(),
                        BGBlocks.MEDIUM_SAPPHIRE_BUD.get().defaultBlockState(),
                        BGBlocks.LARGE_SAPPHIRE_BUD.get().defaultBlockState(),
                        BGBlocks.SAPPHIRE_CLUSTER.get().defaultBlockState()
                )
        );
        registerGeode(context, RUBY_GEODE_KEY, BGBlocks.RAW_RUBY_BLOCK.get(),
                BGBlocks.BUDDING_RUBY.get(),
                List.of(
                        BGBlocks.SMALL_RUBY_BUD.get().defaultBlockState(),
                        BGBlocks.MEDIUM_RUBY_BUD.get().defaultBlockState(),
                        BGBlocks.LARGE_RUBY_BUD.get().defaultBlockState(),
                        BGBlocks.RUBY_CLUSTER.get().defaultBlockState()
                )
        );
        registerRareGeode(context, EMERALD_GEODE_KEY, BGBlocks.RAW_EMERALD_BLOCK.get(),
                BGBlocks.BUDDING_EMERALD.get(),
                List.of(
                        BGBlocks.SMALL_EMERALD_BUD.get().defaultBlockState(),
                        BGBlocks.MEDIUM_EMERALD_BUD.get().defaultBlockState(),
                        BGBlocks.LARGE_EMERALD_BUD.get().defaultBlockState(),
                        BGBlocks.EMERALD_CLUSTER.get().defaultBlockState()
                )
        );
        registerRareGeode(context, DIAMOND_GEODE_KEY, BGBlocks.RAW_DIAMOND_BLOCK.get(),
                BGBlocks.BUDDING_DIAMOND.get(),
                List.of(
                        BGBlocks.SMALL_DIAMOND_BUD.get().defaultBlockState(),
                        BGBlocks.MEDIUM_DIAMOND_BUD.get().defaultBlockState(),
                        BGBlocks.LARGE_DIAMOND_BUD.get().defaultBlockState(),
                        BGBlocks.DIAMOND_CLUSTER.get().defaultBlockState()
                )
        );
    }

    public static void registerGemcornTree(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, Block trunkBlock, Block branchBlock) {
        register(context, key, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BGBlocks.GEMCORN_TRUNK.get()),
                        new GemcornTrunkPlacer(8, 0, 0),
                        BlockStateProvider.simple(Blocks.AIR),
                        new FancyFoliagePlacer(ConstantInt.of(1), ConstantInt.of(2), 1),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(
                        List.of(new GemcornTrunkDecorator(0.5F, trunkBlock.defaultBlockState(), branchBlock.defaultBlockState()))
                ).ignoreVines().dirt(BlockStateProvider.simple(Blocks.STONE)).build()
        );
    }


    public static void registerGeode(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, Block rawBlock, Block buddingBlock, List<BlockState> buds) {
        register(context, key, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(
                        BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(rawBlock),
                        BlockStateProvider.simple(buddingBlock),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        buds,
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.35D, 1.0D, 1), 0.35D, 0.083D,
                        false, UniformInt.of(4, 6),
                        UniformInt.of(3, 6), UniformInt.of(1, 2),
                        -14, 14, 0.05D, 1)
        );
    }

    public static void registerRareGeode(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, Block rawBlock, Block buddingBlock, List<BlockState> buds) {
        register(context, key, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(
                        BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(rawBlock),
                        BlockStateProvider.simple(buddingBlock),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        buds,
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.25D, 1.0D, 1), 0.35D, 0.083D,
                        false, UniformInt.of(2, 4),
                        UniformInt.of(3, 6), UniformInt.of(1, 2),
                        -12, 12, 0.05D, 1)
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(BrassGeodes.MOD_ID, name));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerMinecraftKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("minecraft", name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
