package BrassAmber.com.brass_geodes.client;

import BrassAmber.com.brass_geodes.init.BGBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BGBlockRender {

    public static void setRenderLayers() {
        RenderType rendertype = RenderType.cutout();
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.SMALL_DIAMOND_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.MEDIUM_DIAMOND_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.LARGE_DIAMOND_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.DIAMOND_CLUSTER.get(), rendertype);

        ItemBlockRenderTypes.setRenderLayer(BGBlocks.SMALL_EMERALD_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.MEDIUM_EMERALD_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.LARGE_EMERALD_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.EMERALD_CLUSTER.get(), rendertype);

        ItemBlockRenderTypes.setRenderLayer(BGBlocks.SMALL_RUBY_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.MEDIUM_RUBY_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.LARGE_RUBY_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.RUBY_CLUSTER.get(), rendertype);

        ItemBlockRenderTypes.setRenderLayer(BGBlocks.SMALL_SAPPHIRE_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.MEDIUM_SAPPHIRE_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.LARGE_SAPPHIRE_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.SAPPHIRE_CLUSTER.get(), rendertype);

        ItemBlockRenderTypes.setRenderLayer(BGBlocks.SMALL_TOPAZ_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.MEDIUM_TOPAZ_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.LARGE_TOPAZ_BUD.get(), rendertype);
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.TOPAZ_CLUSTER.get(), rendertype);

        ItemBlockRenderTypes.setRenderLayer(BGBlocks.TOPAZ_TINTED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.SAPPHIRE_TINTED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.RUBY_TINTED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.EMERALD_TINTED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BGBlocks.DIAMOND_TINTED_GLASS.get(), RenderType.translucent());
    }
    
}
