package BrassAmber.com.brass_geodes.worldgen.tree;

import BrassAmber.com.brass_geodes.BrassGeodes;
import BrassAmber.com.brass_geodes.worldgen.tree.custom.GemcornTrunkDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class BGTreeDecorators {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS
            = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, BrassGeodes.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<?>> BUDDING_GEMCORN_DECORATOR = TREE_DECORATORS.register(
            "budding_gemcorn_replacer",
            () -> new TreeDecoratorType<>(GemcornTrunkDecorator.CODEC)
    );

    public static void register(IEventBus eventBus) {
        TREE_DECORATORS.register(eventBus);
    }
}
