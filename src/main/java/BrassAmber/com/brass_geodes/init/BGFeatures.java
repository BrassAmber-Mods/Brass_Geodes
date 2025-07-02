package BrassAmber.com.brass_geodes.init;

import BrassAmber.com.brass_geodes.BrassGeodes;
import BrassAmber.com.brass_geodes.worldgen.tree.custom.BGGeode;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BGFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, BrassGeodes.MOD_ID);

    public static final Supplier<Feature<GeodeConfiguration>> BG_GEODE = registerFeature(
            "bg_geode", () -> new BGGeode(GeodeConfiguration.CODEC)
    );

    private static <T extends Feature<?>> Supplier<T> registerFeature(String name, Supplier<T> feature) {
        return FEATURES.register(name, feature);
    }

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
