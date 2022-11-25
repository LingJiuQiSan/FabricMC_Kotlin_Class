package io.github.lingsancanmeng.itemgroups

import io.github.lingsancanmeng.Main
import io.github.lingsancanmeng.item.ModItemsMain
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier

object ModItemGroupsMain {

    val LSCM: ItemGroup = FabricItemGroupBuilder.build(
        Identifier(Main.MOD_ID, "lscm")
    ) { ItemStack(ModItemsMain.ZINC_INGOT) }

}