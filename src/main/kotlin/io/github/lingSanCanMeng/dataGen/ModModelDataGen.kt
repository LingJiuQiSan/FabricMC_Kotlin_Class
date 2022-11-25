package io.github.lingSanCanMeng.dataGen

import io.github.lingSanCanMeng.blocks.ModBlocksMain
import io.github.lingSanCanMeng.item.ModItemsMain
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models

class ModModelDataGen(dataGenerator: FabricDataGenerator?) : FabricModelProvider(dataGenerator) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocksMain.ZINC_BLOCK)
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocksMain.ZINC_ORE)
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocksMain.DEEPSLATE_ZINC_ORE)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.register(ModItemsMain.ZINC_INGOT, Models.GENERATED)
        itemModelGenerator.register(ModItemsMain.ZINC_NUGGET, Models.GENERATED)
        itemModelGenerator.register(ModItemsMain.RAW_ZINC, Models.GENERATED)
        itemModelGenerator.register(ModItemsMain.GOBBER2_FOO, Models.GENERATED)
        itemModelGenerator.register(ModItemsMain.ZINC_ORE_DETECTION_ROD, Models.GENERATED)
    }
}