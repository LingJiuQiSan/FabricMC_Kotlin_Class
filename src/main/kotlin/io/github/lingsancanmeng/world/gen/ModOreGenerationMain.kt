package io.github.lingsancanmeng.world.gen

import io.github.lingsancanmeng.world.feature.ModPlacedFeaturesMain
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.world.gen.GenerationStep

object ModOreGenerationMain {
    fun generateOres() {
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeaturesMain.ZINC_ORE_PLACED.key.get()
        )
        BiomeModifications.addFeature(
            BiomeSelectors.foundInTheNether(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeaturesMain.NETHER_ZINC_ORE_PLACED.key.get()
        )
        BiomeModifications.addFeature(
            BiomeSelectors.foundInTheEnd(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeaturesMain.END_ZINC_ORE_PLACED.key.get()
        )
        BiomeModifications.addFeature(
            BiomeSelectors.foundInTheEnd(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeaturesMain.END_OBSIDIAN_ZINC_ORE_PLACED.key.get()
        )
    }
}