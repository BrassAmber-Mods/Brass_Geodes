package BrassAmber.com.brass_geodes.worldgen;

import BrassAmber.com.brass_geodes.BrassGeodes;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate.matchesBlocks;

public class BGPlacedFeatures {

    public static final ResourceKey<PlacedFeature> AMETHYST_GEMCORN_PLACED_KEY = registerKey("amethyst_gemcorn");
    public static final ResourceKey<PlacedFeature> TOPAZ_GEMCORN_PLACED_KEY = registerKey("topaz_gemcorn");
    public static final ResourceKey<PlacedFeature> SAPPHIRE_GEMCORN_PLACED_KEY = registerKey("sapphire_gemcorn");
    public static final ResourceKey<PlacedFeature> RUBY_GEMCORN_PLACED_KEY = registerKey("ruby_gemcorn");
    public static final ResourceKey<PlacedFeature> EMERALD_GEMCORN_PLACED_KEY = registerKey("emerald_gemcorn");
    public static final ResourceKey<PlacedFeature> DIAMOND_GEMCORN_PLACED_KEY = registerKey("diamond_gemcorn");

    public static final ResourceKey<PlacedFeature> TOPAZ_GEODE_PLACED_KEY = registerKey("topaz_geode_placed");
    public static final ResourceKey<PlacedFeature> SAPPHIRE_GEODE_PLACED_KEY = registerKey("sapphire_geode_placed");
    public static final ResourceKey<PlacedFeature> RUBY_GEODE_PLACED_KEY = registerKey("ruby_geode_placed");
    public static final ResourceKey<PlacedFeature> EMERALD_GEODE_PLACED_KEY = registerKey("emerald_geode_placed");
    public static final ResourceKey<PlacedFeature> DIAMOND_GEODE_PLACED_KEY = registerKey("diamond_geode_placed");

    public static BlockPredicate AIR_PREDICATE = matchesBlocks(Blocks.AIR);

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        
        registerGemcornPlacedTree(context, AMETHYST_GEMCORN_PLACED_KEY, configuredFeatures, BGConfiguredFeatures.AMETHYST_GEMCORN_KEY, .5f, 48);
        registerGemcornPlacedTree(context, TOPAZ_GEMCORN_PLACED_KEY, configuredFeatures, BGConfiguredFeatures.TOPAZ_GEMCORN_KEY, .5f, 48);
        registerGemcornPlacedTree(context, SAPPHIRE_GEMCORN_PLACED_KEY, configuredFeatures, BGConfiguredFeatures.SAPPHIRE_GEMCORN_KEY, .5f, 48);
        registerGemcornPlacedTree(context, RUBY_GEMCORN_PLACED_KEY, configuredFeatures, BGConfiguredFeatures.RUBY_GEMCORN_KEY, .5f, 48);
        registerGemcornPlacedTree(context, EMERALD_GEMCORN_PLACED_KEY, configuredFeatures, BGConfiguredFeatures.EMERALD_GEMCORN_KEY, .25f, 48);
        registerGemcornPlacedTree(context, DIAMOND_GEMCORN_PLACED_KEY, configuredFeatures, BGConfiguredFeatures.DIAMOND_GEMCORN_KEY, .25f, 48);
        
        registerPlacedGeode(context, TOPAZ_GEODE_PLACED_KEY, configuredFeatures, BGConfiguredFeatures.TOPAZ_GEODE_KEY, 72, 6, 30);
        registerPlacedGeode(context, SAPPHIRE_GEODE_PLACED_KEY, configuredFeatures, BGConfiguredFeatures.SAPPHIRE_GEODE_KEY, 72, 6, 30);
        registerPlacedGeode(context, RUBY_GEODE_PLACED_KEY, configuredFeatures, BGConfiguredFeatures.RUBY_GEODE_KEY, 72, 6, 30);
        registerPlacedGeode(context, EMERALD_GEODE_PLACED_KEY, configuredFeatures, BGConfiguredFeatures.EMERALD_GEODE_KEY, 96, 6, 30);
        registerPlacedGeode(context, DIAMOND_GEODE_PLACED_KEY, configuredFeatures, BGConfiguredFeatures.DIAMOND_GEODE_KEY, 104, 6, 30);

    }

    public static void registerGemcornPlacedTree(
            BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
            HolderGetter<ConfiguredFeature<?, ?>> getter, ResourceKey<ConfiguredFeature<?, ?>> feature,
            float rarity, int topAnchor) {

        register(context, key, getter.getOrThrow(feature),
                List.of(
                        PlacementUtils.countExtra(0, rarity, 1),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(topAnchor)),
                        EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), matchesBlocks(Blocks.AIR), 12),
                        RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                        BiomeFilter.biome()
                )
        );
    }

    public static void registerPlacedGeode(
            BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, 
            HolderGetter<ConfiguredFeature<?, ?>> getter, ResourceKey<ConfiguredFeature<?, ?>> feature, 
            int rarity, int bottomAnchor, int topAnchor) {
        
        register(context, key, getter.getOrThrow(feature),
                List.of(RarityFilter.onAverageOnceEvery(rarity), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(bottomAnchor), VerticalAnchor.absolute(topAnchor)),
                        BiomeFilter.biome())
        );
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(BrassGeodes.MOD_ID, name));
    }

    private static ResourceKey<PlacedFeature> registerMinecraftKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("minecraft", name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
