package BrassAmber.com.brass_geodes.datagen.loot;

import BrassAmber.com.brass_geodes.init.BGBlocks;
import BrassAmber.com.brass_geodes.init.BGItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class BGBlockLootTables extends BlockLootSubProvider {
    public BGBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(BGBlocks.RAW_TOPAZ_BLOCK.get());
        this.dropSelf(BGBlocks.RAW_SAPPHIRE_BLOCK.get());
        this.dropSelf(BGBlocks.RAW_RUBY_BLOCK.get());
        this.dropSelf(BGBlocks.RAW_EMERALD_BLOCK.get());
        this.dropSelf(BGBlocks.RAW_DIAMOND_BLOCK.get());

        this.dropSelf(BGBlocks.AMETHYST_GEM_BLOCK.get());
        this.dropSelf(BGBlocks.TOPAZ_GEM_BLOCK.get());
        this.dropSelf(BGBlocks.SAPPHIRE_GEM_BLOCK.get());
        this.dropSelf(BGBlocks.RUBY_GEM_BLOCK.get());

        this.clusterDrop(BGBlocks.TOPAZ_CLUSTER.get(), BGItems.TOPAZ.get());
        this.clusterDrop(BGBlocks.SAPPHIRE_CLUSTER.get(), BGItems.SAPPHIRE.get());
        this.clusterDrop(BGBlocks.RUBY_CLUSTER.get(), BGItems.RUBY.get());
        this.clusterDrop(BGBlocks.EMERALD_CLUSTER.get(), Items.EMERALD);
        this.clusterDrop(BGBlocks.DIAMOND_CLUSTER.get(), Items.DIAMOND);

        this.dropWhenSilkTouch(BGBlocks.SMALL_TOPAZ_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.SMALL_SAPPHIRE_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.SMALL_RUBY_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.SMALL_EMERALD_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.SMALL_DIAMOND_BUD.get());

        this.dropWhenSilkTouch(BGBlocks.MEDIUM_TOPAZ_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.MEDIUM_SAPPHIRE_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.MEDIUM_RUBY_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.MEDIUM_EMERALD_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.MEDIUM_DIAMOND_BUD.get());

        this.dropWhenSilkTouch(BGBlocks.LARGE_TOPAZ_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.LARGE_SAPPHIRE_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.LARGE_RUBY_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.LARGE_EMERALD_BUD.get());
        this.dropWhenSilkTouch(BGBlocks.LARGE_DIAMOND_BUD.get());

        this.noDrop(BGBlocks.BUDDING_TOPAZ.get());
        this.noDrop(BGBlocks.BUDDING_SAPPHIRE.get());
        this.noDrop(BGBlocks.BUDDING_RUBY.get());
        this.noDrop(BGBlocks.BUDDING_EMERALD.get());
        this.noDrop(BGBlocks.BUDDING_DIAMOND.get());

        this.noDrop(BGBlocks.GEMCORN_BRANCH.get());

        this.dropWhenSilkTouch(BGBlocks.GEMCORN_TRUNK.get());
        this.dropWhenSilkTouch(BGBlocks.AMETHYST_TRUNK.get());
        this.dropWhenSilkTouch(BGBlocks.TOPAZ_TRUNK.get());
        this.dropWhenSilkTouch(BGBlocks.SAPPHIRE_TRUNK.get());
        this.dropWhenSilkTouch(BGBlocks.RUBY_TRUNK.get());
        this.dropWhenSilkTouch(BGBlocks.EMERALD_TRUNK.get());
        this.dropWhenSilkTouch(BGBlocks.DIAMOND_TRUNK.get());

        this.silkTouchAndOtherWithFortune(
                BGBlocks.AMETHYST_BRANCH.get(), Items.AMETHYST_SHARD,
                1, 3, BGBlocks.AMETHYST_SAPLING.get()
        );
        this.silkTouchAndOtherWithFortune(
                BGBlocks.TOPAZ_BRANCH.get(), BGItems.TOPAZ.get(),
                1, 3, BGBlocks.TOPAZ_SAPLING.get()
        );
        this.silkTouchAndOtherWithFortune(
                BGBlocks.SAPPHIRE_BRANCH.get(), BGItems.SAPPHIRE.get(),
                1, 3, BGBlocks.SAPPHIRE_SAPLING.get()
        );
        this.silkTouchAndOtherWithFortune(
                BGBlocks.RUBY_BRANCH.get(), BGItems.RUBY.get(),
                1, 3, BGBlocks.RUBY_SAPLING.get()
        );
        this.silkTouchAndOtherWithFortune(
                BGBlocks.EMERALD_BRANCH.get(), Items.EMERALD,
                1, 2, BGBlocks.EMERALD_SAPLING.get()
        );
        this.silkTouchAndOtherWithFortune(
                BGBlocks.DIAMOND_BRANCH.get(), Items.DIAMOND,
                1, 1, BGBlocks.DIAMOND_SAPLING.get()
        );

        this.dropSelf(BGBlocks.TOPAZ_TINTED_GLASS.get());
        this.dropSelf(BGBlocks.SAPPHIRE_TINTED_GLASS.get());
        this.dropSelf(BGBlocks.RUBY_TINTED_GLASS.get());
        this.dropSelf(BGBlocks.EMERALD_TINTED_GLASS.get());
        this.dropSelf(BGBlocks.DIAMOND_TINTED_GLASS.get());

        this.dropSelf(BGBlocks.AMETHYST_SAPLING.get());
        this.dropSelf(BGBlocks.TOPAZ_SAPLING.get());
        this.dropSelf(BGBlocks.SAPPHIRE_SAPLING.get());
        this.dropSelf(BGBlocks.RUBY_SAPLING.get());
        this.dropSelf(BGBlocks.EMERALD_SAPLING.get());
        this.dropSelf(BGBlocks.DIAMOND_SAPLING.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BGBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected void dropWhenSilkTouchAndDropOtherAmount(Block block, ItemLike drop, float min, float max) {
        this.add(block, createSilkTouchOnlyTable(block).withPool(
                LootPool.lootPool().when(HAS_NO_SILK_TOUCH).setRolls(
                        UniformGenerator.between(min, max)
                ).add(LootItem.lootTableItem(drop)))
        );
    }

    protected void clusterDrop(Block block, ItemLike drop) {
        this.add(block,
                createSilkTouchDispatchTable(block, LootItem.lootTableItem(drop).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES))).otherwise(this.applyExplosionDecay(block, LootItem.lootTableItem(drop).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))))
        );
    }

    protected void silkTouchAndOtherWithFortune(Block block, ItemLike drop, float min, float max, ItemLike drop2){
        this.add(block,
                createSilkTouchDispatchTable(
                        block, this.applyExplosionDecay(block, LootItem.lootTableItem(drop)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))
                        .withPool(
                                LootPool.lootPool().when(HAS_NO_SILK_TOUCH).setRolls(ConstantValue.exactly(1f))
                                        .add(LootItem.lootTableItem(drop2).setWeight(1)).add(LootItem.lootTableItem(Items.AIR).setWeight(12))
                        )
        );
    }

    protected void noDrop(Block block) {
        this.add(block, noDrop());
    }

}
