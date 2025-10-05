package BrassAmber.com.brass_geodes.datagen;

import BrassAmber.com.brass_geodes.init.BGBlocks;
import BrassAmber.com.brass_geodes.BrassGeodes;
import BrassAmber.com.brass_geodes.util.BGTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BGBlockTagGenerator extends BlockTagsProvider  {
    public BGBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BrassGeodes.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BGTags.Blocks.GEMCORN_LOGS)
                .add(BGBlocks.GEMCORN_TRUNK.get())
                .add(BGBlocks.AMETHYST_TRUNK.get())
                .add(BGBlocks.TOPAZ_TRUNK.get())
                .add(BGBlocks.SAPPHIRE_TRUNK.get())
                .add(BGBlocks.RUBY_TRUNK.get())
                .add(BGBlocks.EMERALD_TRUNK.get())
                .add(BGBlocks.DIAMOND_TRUNK.get());

        this.tag(BGTags.Blocks.GEMCORN_CAN_GROW_THROUGH)
                .add(Blocks.CAVE_AIR);

        this.tag(Tags.Blocks.GLASS_TINTED)
                .add(BGBlocks.TOPAZ_TINTED_GLASS.get())
                .add(BGBlocks.SAPPHIRE_TINTED_GLASS.get())
                .add(BGBlocks.RUBY_TINTED_GLASS.get())
                .add(BGBlocks.EMERALD_TINTED_GLASS.get())
                .add(BGBlocks.DIAMOND_TINTED_GLASS.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BGBlocks.BUDDING_TOPAZ.get())
                .add(BGBlocks.BUDDING_SAPPHIRE.get())
                .add(BGBlocks.BUDDING_RUBY.get())
                .add(BGBlocks.BUDDING_EMERALD.get())
                .add(BGBlocks.BUDDING_DIAMOND.get())
                .add(BGBlocks.RAW_TOPAZ_BLOCK.get())
                .add(BGBlocks.RAW_SAPPHIRE_BLOCK.get())
                .add(BGBlocks.RAW_RUBY_BLOCK.get())
                .add(BGBlocks.RAW_EMERALD_BLOCK.get())
                .add(BGBlocks.RAW_DIAMOND_BLOCK.get())
                .add(BGBlocks.AMETHYST_GEM_BLOCK.get())
                .add(BGBlocks.TOPAZ_GEM_BLOCK.get())
                .add(BGBlocks.SAPPHIRE_GEM_BLOCK.get())
                .add(BGBlocks.RUBY_GEM_BLOCK.get())
                .add(BGBlocks.TOPAZ_CLUSTER.get())
                .add(BGBlocks.SAPPHIRE_CLUSTER.get())
                .add(BGBlocks.RUBY_CLUSTER.get())
                .add(BGBlocks.EMERALD_CLUSTER.get())
                .add(BGBlocks.DIAMOND_CLUSTER.get())
                .add(BGBlocks.LARGE_TOPAZ_BUD.get())
                .add(BGBlocks.LARGE_SAPPHIRE_BUD.get())
                .add(BGBlocks.LARGE_RUBY_BUD.get())
                .add(BGBlocks.LARGE_EMERALD_BUD.get())
                .add(BGBlocks.LARGE_DIAMOND_BUD.get())
                .add(BGBlocks.MEDIUM_TOPAZ_BUD.get())
                .add(BGBlocks.MEDIUM_SAPPHIRE_BUD.get())
                .add(BGBlocks.MEDIUM_RUBY_BUD.get())
                .add(BGBlocks.MEDIUM_EMERALD_BUD.get())
                .add(BGBlocks.MEDIUM_DIAMOND_BUD.get())
                .add(BGBlocks.SMALL_TOPAZ_BUD.get())
                .add(BGBlocks.SMALL_SAPPHIRE_BUD.get())
                .add(BGBlocks.SMALL_RUBY_BUD.get())
                .add(BGBlocks.SMALL_EMERALD_BUD.get())
                .add(BGBlocks.SMALL_DIAMOND_BUD.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BGBlocks.BUDDING_TOPAZ.get())
                .add(BGBlocks.BUDDING_SAPPHIRE.get())
                .add(BGBlocks.BUDDING_RUBY.get())
                .add(BGBlocks.BUDDING_EMERALD.get())
                .add(BGBlocks.BUDDING_DIAMOND.get())
                .add(BGBlocks.RAW_TOPAZ_BLOCK.get())
                .add(BGBlocks.RAW_SAPPHIRE_BLOCK.get())
                .add(BGBlocks.RAW_RUBY_BLOCK.get())
                .add(BGBlocks.RAW_EMERALD_BLOCK.get())
                .add(BGBlocks.RAW_DIAMOND_BLOCK.get())
                .add(BGBlocks.AMETHYST_GEM_BLOCK.get())
                .add(BGBlocks.TOPAZ_GEM_BLOCK.get())
                .add(BGBlocks.SAPPHIRE_GEM_BLOCK.get())
                .add(BGBlocks.RUBY_GEM_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BGBlocks.TOPAZ_CLUSTER.get())
                .add(BGBlocks.SAPPHIRE_CLUSTER.get())
                .add(BGBlocks.RUBY_CLUSTER.get())
                .add(BGBlocks.EMERALD_CLUSTER.get())
                .add(BGBlocks.DIAMOND_CLUSTER.get())
                .add(BGBlocks.LARGE_TOPAZ_BUD.get())
                .add(BGBlocks.LARGE_SAPPHIRE_BUD.get())
                .add(BGBlocks.LARGE_RUBY_BUD.get())
                .add(BGBlocks.LARGE_EMERALD_BUD.get())
                .add(BGBlocks.LARGE_DIAMOND_BUD.get())
                .add(BGBlocks.MEDIUM_TOPAZ_BUD.get())
                .add(BGBlocks.MEDIUM_SAPPHIRE_BUD.get())
                .add(BGBlocks.MEDIUM_RUBY_BUD.get())
                .add(BGBlocks.MEDIUM_EMERALD_BUD.get())
                .add(BGBlocks.MEDIUM_DIAMOND_BUD.get())
                .add(BGBlocks.SMALL_TOPAZ_BUD.get())
                .add(BGBlocks.SMALL_SAPPHIRE_BUD.get())
                .add(BGBlocks.SMALL_RUBY_BUD.get())
                .add(BGBlocks.SMALL_EMERALD_BUD.get())
                .add(BGBlocks.SMALL_DIAMOND_BUD.get())
                .add(BGBlocks.GEMCORN_TRUNK.get())
                .add(BGBlocks.AMETHYST_TRUNK.get())
                .add(BGBlocks.TOPAZ_TRUNK.get())
                .add(BGBlocks.SAPPHIRE_TRUNK.get())
                .add(BGBlocks.RUBY_TRUNK.get())
                .add(BGBlocks.EMERALD_TRUNK.get())
                .add(BGBlocks.DIAMOND_TRUNK.get());


        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BGBlocks.GEMCORN_TRUNK.get())
                .add(BGBlocks.AMETHYST_TRUNK.get())
                .add(BGBlocks.TOPAZ_TRUNK.get())
                .add(BGBlocks.SAPPHIRE_TRUNK.get())
                .add(BGBlocks.RUBY_TRUNK.get())
                .add(BGBlocks.EMERALD_TRUNK.get())
                .add(BGBlocks.DIAMOND_TRUNK.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
