package dev.hiitsdevin.pastelwonderland.Base.Client;

import dev.hiitsdevin.pastelwonderland.Base.Blocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class Transparency {
    public static void init() {
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.RED_LEAF, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.RED_LEAF, RenderLayer.getCutout());
    }
}