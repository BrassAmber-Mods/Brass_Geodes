package BrassAmber.com.brass_geodes.datagen;

import BrassAmber.com.brass_geodes.init.BGBlocks;
import BrassAmber.com.brass_geodes.init.BGItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class BGRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public BGRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }



    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> recipeOutput) {

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, Items.AMETHYST_SHARD, RecipeCategory.BUILDING_BLOCKS, BGBlocks.AMETHYST_GEM_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, BGItems.TOPAZ.get(), RecipeCategory.BUILDING_BLOCKS, BGBlocks.TOPAZ_GEM_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, BGItems.SAPPHIRE.get(), RecipeCategory.BUILDING_BLOCKS, BGBlocks.SAPPHIRE_GEM_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, BGItems.RUBY.get(), RecipeCategory.BUILDING_BLOCKS, BGBlocks.RUBY_GEM_BLOCK.get());

        twoByTwoPacker(recipeOutput,  RecipeCategory.BUILDING_BLOCKS, Blocks.AMETHYST_BLOCK, Items.AMETHYST_SHARD);
        twoByTwoPacker(recipeOutput,  RecipeCategory.BUILDING_BLOCKS, BGBlocks.RAW_TOPAZ_BLOCK.get(), BGItems.TOPAZ.get());
        twoByTwoPacker(recipeOutput,  RecipeCategory.BUILDING_BLOCKS, BGBlocks.RAW_SAPPHIRE_BLOCK.get(), BGItems.SAPPHIRE.get());
        twoByTwoPacker(recipeOutput,  RecipeCategory.BUILDING_BLOCKS, BGBlocks.RAW_RUBY_BLOCK.get(), BGItems.RUBY.get());
        twoByTwoPacker(recipeOutput,  RecipeCategory.BUILDING_BLOCKS, BGBlocks.RAW_EMERALD_BLOCK.get(), Items.EMERALD);
        twoByTwoPacker(recipeOutput,  RecipeCategory.BUILDING_BLOCKS, BGBlocks.RAW_DIAMOND_BLOCK.get(), Items.DIAMOND);

        stainedGlassFromGlassAndDye(recipeOutput, BGBlocks.TOPAZ_TINTED_GLASS.get(), BGItems.TOPAZ.get());
        stainedGlassFromGlassAndDye(recipeOutput, BGBlocks.SAPPHIRE_TINTED_GLASS.get(), BGItems.SAPPHIRE.get());
        stainedGlassFromGlassAndDye(recipeOutput, BGBlocks.RUBY_TINTED_GLASS.get(), BGItems.RUBY.get());
        stainedGlassFromGlassAndDye(recipeOutput, BGBlocks.EMERALD_TINTED_GLASS.get(), Items.EMERALD);
        stainedGlassFromGlassAndDye(recipeOutput, BGBlocks.DIAMOND_TINTED_GLASS.get(), Items.DIAMOND);
    }
    
}
