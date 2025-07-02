package BrassAmber.com.brass_geodes.datagen;

import BrassAmber.com.brass_geodes.init.BGBlocks;
import BrassAmber.com.brass_geodes.BrassGeodes;
import BrassAmber.com.brass_geodes.util.BGTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
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
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
