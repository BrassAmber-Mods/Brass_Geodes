package BrassAmber.com.brass_geodes.init;


import BrassAmber.com.brass_geodes.BrassGeodes;
import BrassAmber.com.brass_geodes.worldgen.tree.custom.GemcornTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BGTrunkPlacerTypes {
    public  static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, BrassGeodes.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<?>> GEMCORN_TREE_TRUNK_PLACER = TRUNK_PLACERS.register(
            "gemcorn_tree_trunk_placer",
            () -> new TrunkPlacerType<>(GemcornTrunkPlacer.CODEC)
    );

    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }
}