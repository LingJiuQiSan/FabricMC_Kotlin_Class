package io.github.lingsancanmeng.dataGen

import io.github.lingsancanmeng.blocks.ModBlocksMain
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Block
import net.minecraft.tag.TagKey
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

class ModBlockTagDataGen(dataGenerator: FabricDataGenerator?) : FabricTagProvider<Block>(dataGenerator, Registry.BLOCK) {
    override fun generateTags() {
        getOrCreateTagBuilder(TagKey.of(Registry.BLOCK_KEY, Identifier("minecraft","needs_iron_tool")))
            .add(ModBlocksMain.ZINC_BLOCK)
            .add(ModBlocksMain.ZINC_ORE)
            .add(ModBlocksMain.DEEPSLATE_ZINC_ORE)
        getOrCreateTagBuilder(TagKey.of(Registry.BLOCK_KEY, Identifier("minecraft","mineable/pickaxe")))
            .add(ModBlocksMain.ZINC_BLOCK)
            .add(ModBlocksMain.ZINC_ORE)
            .add(ModBlocksMain.DEEPSLATE_ZINC_ORE)
    }
}