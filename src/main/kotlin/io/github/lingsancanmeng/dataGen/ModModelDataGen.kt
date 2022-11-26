package io.github.lingsancanmeng.dataGen

import io.github.lingsancanmeng.blocks.ModBlocksMain
import io.github.lingsancanmeng.blocks.advanced.ZincLamp
import io.github.lingsancanmeng.item.ModItemsMain
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.*

class ModModelDataGen(dataGenerator: FabricDataGenerator?) : FabricModelProvider(dataGenerator) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocksMain.ZINC_BLOCK)
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocksMain.ZINC_ORE)
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocksMain.DEEPSLATE_ZINC_ORE)
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocksMain.NUCLEAR_CUBE)
        val zincLampID1 = TexturedModel.CUBE_ALL.upload(ModBlocksMain.ZINC_LAMP, blockStateModelGenerator. modelCollector)
        val zincLampID2 = blockStateModelGenerator.createSubModel(ModBlocksMain.ZINC_LAMP, "_on", Models.CUBE_ALL, TextureMap::all)
        blockStateModelGenerator.blockStateCollector.accept(
            VariantsBlockStateSupplier.create(ModBlocksMain.ZINC_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ZincLamp.LIGHT, zincLampID2, zincLampID1))
        )
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.register(ModItemsMain.ZINC_INGOT, Models.GENERATED)
        itemModelGenerator.register(ModItemsMain.ZINC_NUGGET, Models.GENERATED)
        itemModelGenerator.register(ModItemsMain.RAW_ZINC, Models.GENERATED)
        itemModelGenerator.register(ModItemsMain.GOBBER2_FOO, Models.GENERATED)
        itemModelGenerator.register(ModItemsMain.ZINC_ORE_DETECTION_ROD, Models.GENERATED)
        itemModelGenerator.register(ModItemsMain.EGGPLANT, Models.GENERATED)
        itemModelGenerator.register(ModItemsMain.EGGPLANT_SEED, Models.GENERATED)
    }
}