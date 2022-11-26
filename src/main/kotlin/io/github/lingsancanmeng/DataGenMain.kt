package io.github.lingsancanmeng

import io.github.lingsancanmeng.dataGen.*
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object DataGenMain: DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        fabricDataGenerator.addProvider { dataGenerator: FabricDataGenerator? -> ModBlockLootTableDataGen(dataGenerator) }
        fabricDataGenerator.addProvider { dataGenerator: FabricDataGenerator? -> ModBlockTagDataGen(dataGenerator) }
        fabricDataGenerator.addProvider { dataGenerator: FabricDataGenerator? -> ModPointTagDataGen(dataGenerator) }
        fabricDataGenerator.addProvider { dataGenerator: FabricDataGenerator? -> ModModelDataGen(dataGenerator) }
        fabricDataGenerator.addProvider { dataGenerator: FabricDataGenerator? -> ModRecipeDataGen(dataGenerator) }
    }
}