package io.github.lingSanCanMeng.item

import net.fabricmc.fabric.api.registry.FuelRegistry

object ModItemsFuelRegistry {
    fun registerFuels(){
        FuelRegistry.INSTANCE.add(ModItemsMain.GOBBER2_FOO, 64000)
    }
}