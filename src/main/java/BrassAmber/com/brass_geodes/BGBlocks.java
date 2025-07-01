package BrassAmber.com.brass_geodes;

import BrassAmber.com.brass_geodes.block.*;
import BrassAmber.com.brass_geodes.util.GemMaterial;
import BrassAmber.com.brass_geodes.worldgen.tree.GemcornTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BGBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrassGeodes.MOD_ID);

    public static final RegistryObject<Block> RAW_TOPAZ_BLOCK = registerBlock("raw_topaz", () -> new AmethystBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(3.0F, 6.0F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire", () -> new AmethystBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(3.0F, 6.0F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_RUBY_BLOCK = registerBlock("raw_ruby", () -> new AmethystBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(3.0F, 6.0F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_EMERALD_BLOCK = registerBlock("raw_emerald", () -> new AmethystBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).strength(3.0F, 6.0F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_DIAMOND_BLOCK = registerBlock("raw_diamond", () -> new AmethystBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).strength(3.0F, 6.0F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AMETHYST_GEM_BLOCK = registerBlock("amethyst_gem_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(5.0F, 6.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TOPAZ_GEM_BLOCK = registerBlock("topaz_gem_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(5.0F, 6.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SAPPHIRE_GEM_BLOCK = registerBlock("sapphire_gem_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(5.0F, 6.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RUBY_GEM_BLOCK = registerBlock("ruby_gem_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(5.0F, 6.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TOPAZ_CLUSTER = registerBlock("topaz_cluster", () -> new GemClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> SAPPHIRE_CLUSTER = registerBlock("sapphire_cluster", () -> new GemClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> RUBY_CLUSTER = registerBlock("ruby_cluster", () -> new GemClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> EMERALD_CLUSTER = registerBlock("emerald_cluster", () -> new GemClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).mapColor(MapColor.EMERALD)));
    public static final RegistryObject<Block> DIAMOND_CLUSTER = registerBlock("diamond_cluster", () -> new GemClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).mapColor(MapColor.DIAMOND)));

    public static final RegistryObject<Block> SMALL_TOPAZ_BUD = registerBlock("small_topaz_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> SMALL_SAPPHIRE_BUD = registerBlock("small_sapphire_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> SMALL_RUBY_BUD = registerBlock("small_ruby_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> SMALL_EMERALD_BUD = registerBlock("small_emerald_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).mapColor(MapColor.EMERALD)));
    public static final RegistryObject<Block> SMALL_DIAMOND_BUD = registerBlock("small_diamond_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).mapColor(MapColor.DIAMOND)));

    public static final RegistryObject<Block> MEDIUM_TOPAZ_BUD = registerBlock("medium_topaz_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> MEDIUM_SAPPHIRE_BUD = registerBlock("medium_sapphire_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> MEDIUM_RUBY_BUD = registerBlock("medium_ruby_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> MEDIUM_EMERALD_BUD = registerBlock("medium_emerald_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).mapColor(MapColor.EMERALD)));
    public static final RegistryObject<Block> MEDIUM_DIAMOND_BUD = registerBlock("medium_diamond_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).mapColor(MapColor.DIAMOND)));

    public static final RegistryObject<Block> LARGE_TOPAZ_BUD = registerBlock("large_topaz_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> LARGE_SAPPHIRE_BUD = registerBlock("large_sapphire_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> LARGE_RUBY_BUD = registerBlock("large_ruby_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> LARGE_EMERALD_BUD = registerBlock("large_emerald_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).mapColor(MapColor.EMERALD)));
    public static final RegistryObject<Block> LARGE_DIAMOND_BUD = registerBlock("large_diamond_bud", () -> new GemClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).mapColor(MapColor.DIAMOND)));

    public static final RegistryObject<Block> BUDDING_TOPAZ = registerBlock("budding_topaz",
          () ->  new BuddingGemBlock(BlockBehaviour.Properties.of().randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
                    SMALL_TOPAZ_BUD.get(), MEDIUM_TOPAZ_BUD.get(), LARGE_TOPAZ_BUD.get(), TOPAZ_CLUSTER.get(), Math.round(GemMaterial.TOPAZ.getRarity() * 300)));
    public static final RegistryObject<Block> BUDDING_SAPPHIRE = registerBlock("budding_sapphire",
          () ->  new BuddingGemBlock(BlockBehaviour.Properties.of().randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
                    SMALL_SAPPHIRE_BUD.get(), MEDIUM_SAPPHIRE_BUD.get(), LARGE_SAPPHIRE_BUD.get(), SAPPHIRE_CLUSTER.get(), Math.round(GemMaterial.SAPPHIRE.getRarity() * 300)));
    public static final RegistryObject<Block> BUDDING_RUBY = registerBlock("budding_ruby",
          () ->  new BuddingGemBlock(BlockBehaviour.Properties.of().randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
                    SMALL_RUBY_BUD.get(), MEDIUM_RUBY_BUD.get(), LARGE_RUBY_BUD.get(), RUBY_CLUSTER.get(), Math.round(GemMaterial.RUBY.getRarity() * 300)));
    public static final RegistryObject<Block> BUDDING_EMERALD = registerBlock("budding_emerald",
          () ->  new BuddingGemBlock(BlockBehaviour.Properties.of().randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
                    SMALL_EMERALD_BUD.get(), MEDIUM_EMERALD_BUD.get(), LARGE_EMERALD_BUD.get(), EMERALD_CLUSTER.get(), Math.round(GemMaterial.EMERALD.getRarity() * 300)));
    public static final RegistryObject<Block> BUDDING_DIAMOND = registerBlock("budding_diamond",
          () ->  new BuddingGemBlock(BlockBehaviour.Properties.of().randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
                    SMALL_DIAMOND_BUD.get(), MEDIUM_DIAMOND_BUD.get(), LARGE_DIAMOND_BUD.get(), DIAMOND_CLUSTER.get(), Math.round(GemMaterial.DIAMOND.getRarity() * 300)));


    public static final RegistryObject<Block> GEMCORN_BRANCH = registerBlock("gemcorn_branch",
            () -> new GemcornBranch(5, 3, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).replaceable().noCollission().instabreak().sound(SoundType.STONE).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> AMETHYST_BRANCH = registerBlock("amethyst_branch",
            () -> new GemcornBranch(5, 3, BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.AMETHYST_CLUSTER).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> TOPAZ_BRANCH = registerBlock("topaz_branch",
            () -> new GemcornBranch(5, 3, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).replaceable().noCollission().instabreak().sound(SoundType.AMETHYST_CLUSTER).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SAPPHIRE_BRANCH = registerBlock("sapphire_branch",
            () -> new GemcornBranch(5, 3, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).replaceable().noCollission().instabreak().sound(SoundType.AMETHYST_CLUSTER).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> RUBY_BRANCH = registerBlock("ruby_branch",
            () -> new GemcornBranch(5, 3, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).replaceable().noCollission().instabreak().sound(SoundType.AMETHYST_CLUSTER).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> EMERALD_BRANCH = registerBlock("emerald_branch",
            () -> new GemcornBranch(5, 3, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).replaceable().noCollission().instabreak().sound(SoundType.AMETHYST_CLUSTER).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> DIAMOND_BRANCH = registerBlock("diamond_branch",
            () -> new GemcornBranch(5, 3, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).replaceable().noCollission().instabreak().sound(SoundType.AMETHYST_CLUSTER).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> GEMCORN_TRUNK = registerBlock("gemcorn_trunk",
            () -> log(MapColor.DEEPSLATE, MapColor.STONE));

    public static final RegistryObject<Block> AMETHYST_TRUNK = registerBlock("amethyst_trunk",
            () -> new GemcornTrunk(
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY)
            ));
    public static final RegistryObject<Block> TOPAZ_TRUNK = registerBlock("topaz_trunk",
            () -> new GemcornTrunk(
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY)
            ));
    public static final RegistryObject<Block> SAPPHIRE_TRUNK = registerBlock("sapphire_trunk",
            () -> new GemcornTrunk(
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY)
            ));
    public static final RegistryObject<Block> RUBY_TRUNK = registerBlock("ruby_trunk",
            () -> new GemcornTrunk(
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY)
            ));
    public static final RegistryObject<Block> EMERALD_TRUNK = registerBlock("emerald_trunk",
            () -> new GemcornTrunk(
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY)
            ));
    public static final RegistryObject<Block> DIAMOND_TRUNK = registerBlock("diamond_trunk",
            () -> new GemcornTrunk(
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY)
            ));

    public static final RegistryObject<Block> AMETHYST_SAPLING = registerBlock("amethyst_sapling",
            () -> new GemcornSaplingBlock(new GemcornTreeGrower(GemMaterial.AMETHYST), BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(SoundType.COPPER)));

    public static final RegistryObject<Block> TOPAZ_SAPLING = registerBlock("topaz_sapling",
            () -> new GemcornSaplingBlock(new GemcornTreeGrower(GemMaterial.TOPAZ), BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(SoundType.COPPER)));

    public static final RegistryObject<Block> SAPPHIRE_SAPLING = registerBlock("sapphire_sapling",
            () -> new GemcornSaplingBlock(new GemcornTreeGrower(GemMaterial.SAPPHIRE), BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(SoundType.COPPER)));

    public static final RegistryObject<Block> RUBY_SAPLING = registerBlock("ruby_sapling",
            () -> new GemcornSaplingBlock(new GemcornTreeGrower(GemMaterial.RUBY), BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(SoundType.COPPER)));

    public static final RegistryObject<Block> EMERALD_SAPLING = registerBlock("emerald_sapling",
            () -> new GemcornSaplingBlock(new GemcornTreeGrower(GemMaterial.EMERALD), BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(SoundType.COPPER)));

    public static final RegistryObject<Block> DIAMOND_SAPLING = registerBlock("diamond_sapling",
            () -> new GemcornSaplingBlock(new GemcornTreeGrower(GemMaterial.DIAMOND), BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(SoundType.COPPER)));

    public static final RegistryObject<Block> TOPAZ_TINTED_GLASS = registerBlock("topaz_tinted_glass", () -> tintedGlass(MapColor.COLOR_ORANGE));

    public static final RegistryObject<Block> SAPPHIRE_TINTED_GLASS = registerBlock("sapphire_tinted_glass", () -> tintedGlass(MapColor.COLOR_BLUE));

    public static final RegistryObject<Block> RUBY_TINTED_GLASS = registerBlock("ruby_tinted_glass", () -> tintedGlass(MapColor.COLOR_RED));

    public static final RegistryObject<Block> EMERALD_TINTED_GLASS = registerBlock("emerald_tinted_glass", () -> tintedGlass(MapColor.EMERALD));

    public static final RegistryObject<Block> DIAMOND_TINTED_GLASS = registerBlock("diamond_tinted_glass", () -> tintedGlass(MapColor.DIAMOND));


    // Taken from Blocks.java (private function)
    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

    // Taken from Blocks.java (private function)
    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static RotatedPillarBlock log(MapColor mapColor, MapColor mapColor1) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((blockState) -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? mapColor : mapColor1).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD));
    }

    private static TintedGlassBlock tintedGlass(MapColor color) {
        return new TintedGlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).mapColor(color)
                .noOcclusion().isValidSpawn(BGBlocks::never).isRedstoneConductor(BGBlocks::never)
                .isSuffocating(BGBlocks::never).isViewBlocking(BGBlocks::never));
    }


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static  <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        BGItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
