package BrassAmber.com.brass_geodes.init;

import BrassAmber.com.brass_geodes.BrassGeodes;
import BrassAmber.com.brass_geodes.item.GemItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BGItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, BrassGeodes.MOD_ID);

    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () -> new GemItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new GemItem(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new GemItem(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PEARL = ITEMS.register("pearl", () -> new GemItem(new Item.Properties().rarity(Rarity.RARE)));

    /**
     * Helper method for registering all Items
     */

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
