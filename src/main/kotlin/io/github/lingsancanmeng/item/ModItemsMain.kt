package io.github.lingsancanmeng.item

import io.github.lingsancanmeng.Main
import io.github.lingsancanmeng.blocks.ModBlocksMain
import io.github.lingsancanmeng.item.advanced.Gobber2foo
import io.github.lingsancanmeng.item.advanced.ZincOreDetectionRod
import io.github.lingsancanmeng.itemgroups.ModItemGroupsMain
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.AliasedBlockItem
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModItemsMain {
    val ZINC_INGOT = registerItem(
        "zinc_ingot",
        Item(FabricItemSettings().group(ModItemGroupsMain.LSCM))
    )
    val ZINC_NUGGET = registerItem(
        "zinc_nugget",
        Item(FabricItemSettings().group(ModItemGroupsMain.LSCM))
    )
    val RAW_ZINC = registerItem(
        "raw_zinc",
        Item(FabricItemSettings().group(ModItemGroupsMain.LSCM))
    )
    val GOBBER2_FOO = registerItem(
        "gobber2_foo",
        Gobber2foo(FabricItemSettings().group(ModItemGroupsMain.LSCM))
    )
    val ZINC_ORE_DETECTION_ROD = registerItem(
        "zinc_ore_detection_rod",
        ZincOreDetectionRod(FabricItemSettings().group(ModItemGroupsMain.LSCM).maxCount(1).maxDamage(100))
    )
    val EGGPLANT = registerItem(
        "eggplant",
        Item(FabricItemSettings().group(ModItemGroupsMain.LSCM))
    )
    val EGGPLANT_SEED = registerItem(
        "eggplant_seed",
        AliasedBlockItem(ModBlocksMain.EGGPLANT_CROP, FabricItemSettings().group(ModItemGroupsMain.LSCM))
    )

    private fun registerItem(itemName: String, item: Item): Item {
        return Registry.register(
            Registry.ITEM,
            Identifier(Main.MOD_ID, itemName),
            item
        )
    }

    fun registerItems() {
        Main.LOGGER.debug(Main.MOD_ID + "正在注册物品")
    }
}