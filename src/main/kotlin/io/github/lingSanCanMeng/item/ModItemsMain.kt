package io.github.lingSanCanMeng.item

import io.github.lingSanCanMeng.Main
import io.github.lingSanCanMeng.item.advanced.Gobber2foo
import io.github.lingSanCanMeng.item.advanced.ZincOreDetectionRod
import io.github.lingSanCanMeng.itemGroups.ModItemGroupsMain
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModItemsMain {
    val ZINC_INGOT: Item = registerItem(
        "zinc_ingot",
        Item(FabricItemSettings().group(ModItemGroupsMain.LSCM))
    )
    val ZINC_NUGGET: Item = registerItem(
        "zinc_nugget",
        Item(FabricItemSettings().group(ModItemGroupsMain.LSCM))
    )
    val RAW_ZINC: Item = registerItem(
        "raw_zinc",
        Item(FabricItemSettings().group(ModItemGroupsMain.LSCM))
    )
    val GOBBER2_FOO: Item = registerItem(
        "gobber2_foo",
        Gobber2foo(FabricItemSettings().group(ModItemGroupsMain.LSCM))
    )
    val ZINC_ORE_DETECTION_ROD: Item = registerItem(
        "zinc_ore_detection_rod",
        ZincOreDetectionRod(FabricItemSettings().group(ModItemGroupsMain.LSCM).maxCount(1).maxDamage(100))
    )

    private fun registerItem(itemname: String, item: Item): Item {
        return Registry.register(
            Registry.ITEM,
            Identifier(Main.MOD_ID, itemname),
            item
        )
    }

    fun registerItems() {
        Main.LOGGER.debug(Main.MOD_ID + "正在注册物品")
    }
}