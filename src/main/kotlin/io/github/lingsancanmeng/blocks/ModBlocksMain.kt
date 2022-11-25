package io.github.lingsancanmeng.blocks

import io.github.lingsancanmeng.Main
import io.github.lingsancanmeng.blocks.advanced.NuclearBlock
import io.github.lingsancanmeng.blocks.advanced.ZincLamp
import io.github.lingsancanmeng.itemgroups.ModItemGroupsMain
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.block.OreBlock
import net.minecraft.item.BlockItem
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.util.registry.Registry

object ModBlocksMain {
    val ZINC_BLOCK = registerBlock(
        "zinc_block",
        Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(6f))
    )
    val ZINC_ORE = registerBlock(
        "zinc_ore",
        OreBlock(
            FabricBlockSettings.of(Material.STONE).requiresTool().strength(4f),
            UniformIntProvider.create(1, 2)
        )
    )
    val DEEPSLATE_ZINC_ORE = registerBlock(
        "deepslate_zinc_ore",
        OreBlock(
            FabricBlockSettings.of(Material.STONE).requiresTool().strength(4f).sounds(BlockSoundGroup.DEEPSLATE),
            UniformIntProvider.create(2,3)
        )
    )
    val NUCLEAR_CUBE = registerBlock(
        "nuclear_cube",
        NuclearBlock(FabricBlockSettings.of(Material.METAL))
    )
    val ZINC_LAMP = registerBlock(
        "zinc_lamp",
        ZincLamp(FabricBlockSettings.of(Material.METAL))
    )

    private fun registerBlock(blockName: String, block: Block): Block {
        Registry.register(
            Registry.ITEM,
            Identifier(Main.MOD_ID, blockName),
            BlockItem(block, FabricItemSettings().group(ModItemGroupsMain.LSCM))
        )
        return Registry.register(
            Registry.BLOCK,
            Identifier(Main.MOD_ID, blockName),
            block
        )
    }

    fun registerBlocks() {}
}