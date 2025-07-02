package BrassAmber.com.brass_geodes.datagen;

import BrassAmber.com.brass_geodes.init.BGBlocks;
import BrassAmber.com.brass_geodes.init.BGItems;
import BrassAmber.com.brass_geodes.BrassGeodes;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BGItemModelProvider extends ItemModelProvider {
    public BGItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BrassGeodes.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(BGItems.TOPAZ);
        simpleItem(BGItems.SAPPHIRE);
        simpleItem(BGItems.RUBY);
        simpleItem(BGItems.PEARL);

        simpleBlockItem(BGBlocks.TOPAZ_CLUSTER);
        simpleBlockItem(BGBlocks.SAPPHIRE_CLUSTER);
        simpleBlockItem(BGBlocks.RUBY_CLUSTER);
        simpleBlockItem(BGBlocks.EMERALD_CLUSTER);
        simpleBlockItem(BGBlocks.DIAMOND_CLUSTER);

        simpleBlockItem(BGBlocks.SMALL_TOPAZ_BUD);
        simpleBlockItem(BGBlocks.SMALL_SAPPHIRE_BUD);
        simpleBlockItem(BGBlocks.SMALL_RUBY_BUD);
        simpleBlockItem(BGBlocks.SMALL_EMERALD_BUD);
        simpleBlockItem(BGBlocks.SMALL_DIAMOND_BUD);

        simpleBlockItem(BGBlocks.MEDIUM_TOPAZ_BUD);
        simpleBlockItem(BGBlocks.MEDIUM_SAPPHIRE_BUD);
        simpleBlockItem(BGBlocks.MEDIUM_RUBY_BUD);
        simpleBlockItem(BGBlocks.MEDIUM_EMERALD_BUD);
        simpleBlockItem(BGBlocks.MEDIUM_DIAMOND_BUD);

        simpleBlockItem(BGBlocks.LARGE_TOPAZ_BUD);
        simpleBlockItem(BGBlocks.LARGE_SAPPHIRE_BUD);
        simpleBlockItem(BGBlocks.LARGE_RUBY_BUD);
        simpleBlockItem(BGBlocks.LARGE_EMERALD_BUD);
        simpleBlockItem(BGBlocks.LARGE_DIAMOND_BUD);

        simpleExtraFolderBlockItem(BGBlocks.GEMCORN_BRANCH, "gemcorn");
        simpleExtraFolderBlockItem(BGBlocks.AMETHYST_BRANCH, "gemcorn");
        simpleExtraFolderBlockItem(BGBlocks.TOPAZ_BRANCH, "gemcorn");
        simpleExtraFolderBlockItem(BGBlocks.SAPPHIRE_BRANCH, "gemcorn");
        simpleExtraFolderBlockItem(BGBlocks.RUBY_BRANCH, "gemcorn");
        simpleExtraFolderBlockItem(BGBlocks.EMERALD_BRANCH, "gemcorn");
        simpleExtraFolderBlockItem(BGBlocks.DIAMOND_BRANCH, "gemcorn");

        saplingItem(BGBlocks.AMETHYST_SAPLING);
        saplingItem(BGBlocks.TOPAZ_SAPLING);
        saplingItem(BGBlocks.SAPPHIRE_SAPLING);
        saplingItem(BGBlocks.RUBY_SAPLING);
        saplingItem(BGBlocks.EMERALD_SAPLING);
        saplingItem(BGBlocks.DIAMOND_SAPLING);

    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BrassGeodes.MOD_ID,"item/" + item.getId().getPath().split("_")[0] + "_gemcorn"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BrassGeodes.MOD_ID, "item/" + item.getId().getPath()));
    }


    private ItemModelBuilder simpleExtraFolderItem(RegistryObject<Item> item, String folder) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BrassGeodes.MOD_ID, "item/"+ folder + "/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleExtraFolderBlockItem(RegistryObject<Block> item, String folder) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BrassGeodes.MOD_ID, "block/"+ folder + "/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BrassGeodes.MOD_ID,"block/" + item.getId().getPath()));
    }

}
