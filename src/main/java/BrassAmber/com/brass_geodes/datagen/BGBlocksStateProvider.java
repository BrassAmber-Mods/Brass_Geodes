package BrassAmber.com.brass_geodes.datagen;

import BrassAmber.com.brass_geodes.init.BGBlocks;
import BrassAmber.com.brass_geodes.BrassGeodes;
import BrassAmber.com.brass_geodes.block.GemcornSaplingBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class BGBlocksStateProvider extends BlockStateProvider {
    public BGBlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BrassGeodes.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        cubeBlock(BGBlocks.RAW_TOPAZ_BLOCK);
        cubeBlock(BGBlocks.RAW_SAPPHIRE_BLOCK);
        cubeBlock(BGBlocks.RAW_RUBY_BLOCK);
        cubeBlock(BGBlocks.RAW_EMERALD_BLOCK);
        cubeBlock(BGBlocks.RAW_DIAMOND_BLOCK);

        cubeBlock(BGBlocks.AMETHYST_GEM_BLOCK);
        cubeBlock(BGBlocks.TOPAZ_GEM_BLOCK);
        cubeBlock(BGBlocks.SAPPHIRE_GEM_BLOCK);
        cubeBlock(BGBlocks.RUBY_GEM_BLOCK);

        clusterBlock(BGBlocks.TOPAZ_CLUSTER);
        clusterBlock(BGBlocks.SAPPHIRE_CLUSTER);
        clusterBlock(BGBlocks.RUBY_CLUSTER);
        clusterBlock(BGBlocks.EMERALD_CLUSTER);
        clusterBlock(BGBlocks.DIAMOND_CLUSTER);

        clusterBlock(BGBlocks.SMALL_TOPAZ_BUD);
        clusterBlock(BGBlocks.SMALL_SAPPHIRE_BUD);
        clusterBlock(BGBlocks.SMALL_RUBY_BUD);
        clusterBlock(BGBlocks.SMALL_EMERALD_BUD);
        clusterBlock(BGBlocks.SMALL_DIAMOND_BUD);

        clusterBlock(BGBlocks.MEDIUM_TOPAZ_BUD);
        clusterBlock(BGBlocks.MEDIUM_SAPPHIRE_BUD);
        clusterBlock(BGBlocks.MEDIUM_RUBY_BUD);
        clusterBlock(BGBlocks.MEDIUM_EMERALD_BUD);
        clusterBlock(BGBlocks.MEDIUM_DIAMOND_BUD);

        clusterBlock(BGBlocks.LARGE_TOPAZ_BUD);
        clusterBlock(BGBlocks.LARGE_SAPPHIRE_BUD);
        clusterBlock(BGBlocks.LARGE_RUBY_BUD);
        clusterBlock(BGBlocks.LARGE_EMERALD_BUD);
        clusterBlock(BGBlocks.LARGE_DIAMOND_BUD);

        cubeBlock(BGBlocks.BUDDING_TOPAZ);
        cubeBlock(BGBlocks.BUDDING_SAPPHIRE);
        cubeBlock(BGBlocks.BUDDING_RUBY);
        cubeBlock(BGBlocks.BUDDING_EMERALD);
        cubeBlock(BGBlocks.BUDDING_DIAMOND);

        branchBlock(BGBlocks.GEMCORN_BRANCH);
        branchBlock(BGBlocks.AMETHYST_BRANCH);
        branchBlock(BGBlocks.TOPAZ_BRANCH);
        branchBlock(BGBlocks.SAPPHIRE_BRANCH);
        branchBlock(BGBlocks.RUBY_BRANCH);
        branchBlock(BGBlocks.EMERALD_BRANCH);
        branchBlock(BGBlocks.DIAMOND_BRANCH);

        trunkBlock(BGBlocks.GEMCORN_TRUNK);
        trunkBlock(BGBlocks.AMETHYST_TRUNK);
        trunkBlock(BGBlocks.TOPAZ_TRUNK);
        trunkBlock(BGBlocks.SAPPHIRE_TRUNK);
        trunkBlock(BGBlocks.RUBY_TRUNK);
        trunkBlock(BGBlocks.EMERALD_TRUNK);
        trunkBlock(BGBlocks.DIAMOND_TRUNK);

        gemcornSapling(BGBlocks.AMETHYST_SAPLING, "amethyst_sapling");
        gemcornSapling(BGBlocks.TOPAZ_SAPLING, "topaz_sapling");
        gemcornSapling(BGBlocks.SAPPHIRE_SAPLING, "sapphire_sapling");
        gemcornSapling(BGBlocks.RUBY_SAPLING, "ruby_sapling");
        gemcornSapling(BGBlocks.EMERALD_SAPLING, "emerald_sapling");
        gemcornSapling(BGBlocks.DIAMOND_SAPLING, "diamond_sapling");

        cubeBlock(BGBlocks.TOPAZ_TINTED_GLASS);
        cubeBlock(BGBlocks.SAPPHIRE_TINTED_GLASS);
        cubeBlock(BGBlocks.RUBY_TINTED_GLASS);
        cubeBlock(BGBlocks.EMERALD_TINTED_GLASS);
        cubeBlock(BGBlocks.DIAMOND_TINTED_GLASS);

    }


    public void gemcornSapling(RegistryObject<Block> blockRegistryObject, String modelName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, (GemcornSaplingBlock) blockRegistryObject.get(), modelName);

        getVariantBuilder(blockRegistryObject.get()).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, GemcornSaplingBlock block, String modelName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        ResourceLocation texture = switch (state.getValue(block.getAgeProperty())) {
            case 0:
                yield BrassGeodes.locate("block/gemcorn/gemcorn_sapling");
            case 1:
                yield BrassGeodes.locate("block/gemcorn/gemcorn_sapling_grown");
            case 2:
                yield BrassGeodes.locate("block/gemcorn/"+ modelName);
            default:
                throw new IllegalStateException("Unexpected value: " + state.getValue(block.getAgeProperty()));
        };
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(block.getAgeProperty()), texture).renderType("cutout"));
        return models;
    }

    private void branchBlock(RegistryObject<Block> block) {
        directionalBlock(
                block.get(),
                models().cross(block.getId().getPath(), BrassGeodes.locate("block/gemcorn/" + block.getId().getPath())).renderType("cutout")
        );
    }

    private void clusterBlock(RegistryObject<Block> block) {
        directionalBlock(
                block.get(),
                models().cross(block.getId().getPath(), BrassGeodes.locate("block/" + block.getId().getPath()))
        );
    }

    private void simpleBlockWithItemFolder(RegistryObject<Block> block, String path) {
        simpleBlockWithItem(
                block.get(),
                models().cubeAll(block.getId().getPath(), BrassGeodes.locate("block/" + path + block.getId().getPath()))
        );
    }

    private void cubeBlock(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void trunkBlock(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().cubeAll(block.getId().getPath(), BrassGeodes.locate("block/gemcorn/" + block.getId().getPath())));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(BrassGeodes.locate("block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath())));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

}
