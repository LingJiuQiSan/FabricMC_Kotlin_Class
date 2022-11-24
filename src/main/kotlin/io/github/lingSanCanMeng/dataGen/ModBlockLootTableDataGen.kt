package io.github.lingSanCanMeng.dataGen

import io.github.lingSanCanMeng.Main
import io.github.lingSanCanMeng.blocks.ModBlocksMain
import io.github.lingSanCanMeng.item.ModItemsMain
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider
import net.minecraft.data.server.BlockLootTableGenerator
import net.minecraft.enchantment.Enchantments
import net.minecraft.loot.LootTable
import net.minecraft.loot.context.LootContextTypes
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.entry.LeafEntry
import net.minecraft.loot.entry.LootPoolEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.util.Identifier
import java.util.function.BiConsumer

class ModBlockLootTableDataGen(dataGenerator: FabricDataGenerator?) :
    SimpleFabricLootTableProvider(dataGenerator, LootContextTypes.BLOCK) {
    override fun accept(t: BiConsumer<Identifier, LootTable.Builder>) {
        t.accept(
            Identifier(Main.MOD_ID, "block/zinc_block"),
            BlockLootTableGenerator.drops(ModBlocksMain.ZINC_BLOCK)
        )
        t.accept(
            Identifier(Main.MOD_ID, "block/zinc_ore"),
            BlockLootTableGenerator.oreDrops(ModBlocksMain.ZINC_ORE, ModItemsMain.RAW_ZINC)
        )
        t.accept(
            Identifier(Main.MOD_ID, "blocks/deepslate_zinc_ore"),
            BlockLootTableGenerator.dropsWithSilkTouch(
                ModBlocksMain.DEEPSLATE_ZINC_ORE,
                (BlockLootTableGenerator.applyExplosionDecay(
                    ModBlocksMain.DEEPSLATE_ZINC_ORE,
                    ((ItemEntry
                        .builder(ModItemsMain.RAW_ZINC)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 2f)))
                            ) as LeafEntry.Builder<*>)
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )) as LootPoolEntry.Builder<*>
            )
        )
    }
}