package io.github.lingsancanmeng

import io.github.lingsancanmeng.blocks.ModBlocksMain
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer

object ClientMain: ClientModInitializer {
    override fun onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocksMain.EGGPLANT_CROP, RenderLayer.getCutout())
    }
}