package io.github.lingSanCanMeng

import io.github.lingSanCanMeng.blocks.ModBlocksMain
import io.github.lingSanCanMeng.item.ModItemsFuelRegistry
import io.github.lingSanCanMeng.item.ModItemsMain
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Main: ModInitializer {
    const val MOD_ID = "lscm"

    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        ModItemsMain.registerItems()
        ModBlocksMain.registerBlocks()
        ModItemsFuelRegistry.registerFuels()
    }
}