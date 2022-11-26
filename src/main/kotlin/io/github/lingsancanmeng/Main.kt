package io.github.lingsancanmeng

import io.github.lingsancanmeng.blocks.ModBlocksMain
import io.github.lingsancanmeng.item.ModItemsFuelRegistry
import io.github.lingsancanmeng.item.ModItemsMain
import io.github.lingsancanmeng.villagers.ModVillagersMain
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

        ModVillagersMain.registerVillagers()
        ModVillagersMain.registerTrade()
    }
}