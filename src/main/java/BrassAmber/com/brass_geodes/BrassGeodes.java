package BrassAmber.com.brass_geodes;

import BrassAmber.com.brass_geodes.client.BGBlockRender;
import BrassAmber.com.brass_geodes.worldgen.tree.BGTreeDecorators;
import BrassAmber.com.brass_geodes.worldgen.tree.BGTrunkPlacerTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(BrassGeodes.MOD_ID)
public class BrassGeodes {
    public static final String MOD_ID = "brass_geodes";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public BrassGeodes() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BGItems.register(eventBus);
        BGBlocks.register(eventBus);
        BGTreeDecorators.register(eventBus);
        BGTrunkPlacerTypes.register(eventBus);

        eventBus.addListener(this::setUpClient);
        eventBus.addListener(this::addCreative);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {

            event.accept(BGBlocks.RAW_TOPAZ_BLOCK);
            event.accept(BGBlocks.RAW_SAPPHIRE_BLOCK);
            event.accept(BGBlocks.RAW_RUBY_BLOCK);
            event.accept(BGBlocks.RAW_DIAMOND_BLOCK);
            event.accept(BGBlocks.RAW_EMERALD_BLOCK);

            event.accept(BGBlocks.AMETHYST_GEM_BLOCK);
            event.accept(BGBlocks.TOPAZ_GEM_BLOCK);
            event.accept(BGBlocks.SAPPHIRE_GEM_BLOCK);
            event.accept(BGBlocks.RUBY_GEM_BLOCK);

            event.accept(BGBlocks.TOPAZ_CLUSTER);
            event.accept(BGBlocks.SAPPHIRE_CLUSTER);
            event.accept(BGBlocks.RUBY_CLUSTER);
            event.accept(BGBlocks.EMERALD_CLUSTER);
            event.accept(BGBlocks.DIAMOND_CLUSTER);

            event.accept(BGBlocks.LARGE_TOPAZ_BUD);
            event.accept(BGBlocks.LARGE_SAPPHIRE_BUD);
            event.accept(BGBlocks.LARGE_RUBY_BUD);
            event.accept(BGBlocks.LARGE_EMERALD_BUD);
            event.accept(BGBlocks.LARGE_DIAMOND_BUD);

            event.accept(BGBlocks.MEDIUM_TOPAZ_BUD);
            event.accept(BGBlocks.MEDIUM_SAPPHIRE_BUD);
            event.accept(BGBlocks.MEDIUM_RUBY_BUD);
            event.accept(BGBlocks.MEDIUM_EMERALD_BUD);
            event.accept(BGBlocks.MEDIUM_DIAMOND_BUD);

            event.accept(BGBlocks.SMALL_TOPAZ_BUD);
            event.accept(BGBlocks.SMALL_SAPPHIRE_BUD);
            event.accept(BGBlocks.SMALL_RUBY_BUD);
            event.accept(BGBlocks.SMALL_EMERALD_BUD);
            event.accept(BGBlocks.SMALL_DIAMOND_BUD);

            event.accept(BGBlocks.BUDDING_TOPAZ);
            event.accept(BGBlocks.BUDDING_SAPPHIRE);
            event.accept(BGBlocks.BUDDING_RUBY);
            event.accept(BGBlocks.BUDDING_EMERALD);
            event.accept(BGBlocks.BUDDING_DIAMOND);

            event.accept(BGBlocks.GEMCORN_BRANCH);
            event.accept(BGBlocks.GEMCORN_TRUNK);

            event.accept(BGBlocks.AMETHYST_TRUNK);
            event.accept(BGBlocks.TOPAZ_TRUNK);
            event.accept(BGBlocks.SAPPHIRE_TRUNK);
            event.accept(BGBlocks.RUBY_TRUNK);
            event.accept(BGBlocks.EMERALD_TRUNK);
            event.accept(BGBlocks.DIAMOND_TRUNK);


            event.accept(BGBlocks.AMETHYST_BRANCH);
            event.accept(BGBlocks.TOPAZ_BRANCH);
            event.accept(BGBlocks.SAPPHIRE_BRANCH);
            event.accept(BGBlocks.RUBY_BRANCH);
            event.accept(BGBlocks.EMERALD_BRANCH);
            event.accept(BGBlocks.DIAMOND_BRANCH);

            event.accept(BGBlocks.AMETHYST_SAPLING);
            event.accept(BGBlocks.TOPAZ_SAPLING);
            event.accept(BGBlocks.SAPPHIRE_SAPLING);
            event.accept(BGBlocks.RUBY_SAPLING);
            event.accept(BGBlocks.EMERALD_SAPLING);
            event.accept(BGBlocks.DIAMOND_SAPLING);

        } else if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {

            event.accept(BGBlocks.TOPAZ_TINTED_GLASS);
            event.accept(BGBlocks.SAPPHIRE_TINTED_GLASS);
            event.accept(BGBlocks.RUBY_TINTED_GLASS);
            event.accept(BGBlocks.EMERALD_TINTED_GLASS);
            event.accept(BGBlocks.DIAMOND_TINTED_GLASS);

        } else if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {

            event.accept(BGBlocks.AMETHYST_GEM_BLOCK);
            event.accept(BGBlocks.TOPAZ_GEM_BLOCK);
            event.accept(BGBlocks.SAPPHIRE_GEM_BLOCK);
            event.accept(BGBlocks.RUBY_GEM_BLOCK);
            event.accept(BGBlocks.TOPAZ_TINTED_GLASS);
            event.accept(BGBlocks.SAPPHIRE_TINTED_GLASS);
            event.accept(BGBlocks.RUBY_TINTED_GLASS);
            event.accept(BGBlocks.EMERALD_TINTED_GLASS);
            event.accept(BGBlocks.DIAMOND_TINTED_GLASS);

        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(BGItems.PEARL);
            event.accept(BGItems.RUBY);
            event.accept(BGItems.SAPPHIRE);
            event.accept(BGItems.TOPAZ);
        }
    }

    private void setUpClient(final FMLClientSetupEvent event) {
        BGBlockRender.setRenderLayers();
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        LOGGER.debug("Running common setup.");

    }


    // Helper method for resource locations
    public static ResourceLocation locate(String name) {
        return new ResourceLocation(BrassGeodes.MOD_ID, name);
    }

}
