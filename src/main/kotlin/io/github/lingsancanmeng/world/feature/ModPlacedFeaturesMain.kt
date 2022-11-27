package io.github.lingsancanmeng.world.feature

import net.minecraft.util.registry.RegistryEntry
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.feature.PlacedFeatures
import net.minecraft.world.gen.placementmodifier.*

object ModPlacedFeaturesMain {
    val ZINC_ORE_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
        "zinc_ore_placed",
        ModConfiguredFeaturesMain.OVERWORLD_ZINC_ORE,
        modifiersWithCount(9, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(256)))
    )
    val NETHER_ZINC_ORE_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
        "nether_zinc_ore_placed",
        ModConfiguredFeaturesMain.NETHER_ZINC_ORE,
        modifiersWithCount(7, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(256)))
    )
    val END_ZINC_ORE_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
        "end_zinc_ore_placed",
        ModConfiguredFeaturesMain.END_ZINC_ORE,
        modifiersWithCount(5, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(256)))
    )
    val END_OBSIDIAN_ZINC_ORE_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
        "end_obsidian_zinc_ore_placed",
        ModConfiguredFeaturesMain.END_OBSIDIAN_ZINC_ORE,
        modifiersWithCount(5, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(256)))
    )
    private fun modifiers(
        countModifier: PlacementModifier,
        heightModifier: PlacementModifier
    ): List<PlacementModifier> {
        return listOf(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of())
    }

    private fun modifiersWithCount(count: Int, heightModifier: PlacementModifier): List<PlacementModifier?> {
        return modifiers(CountPlacementModifier.of(count), heightModifier)
    }

    private fun modifiersWithRarity(chance: Int, heightModifier: PlacementModifier): List<PlacementModifier?> {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier)
    }
}