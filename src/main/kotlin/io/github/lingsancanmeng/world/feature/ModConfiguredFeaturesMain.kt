package io.github.lingsancanmeng.world.feature

import io.github.lingsancanmeng.Main
import io.github.lingsancanmeng.blocks.ModBlocksMain
import net.minecraft.block.Blocks
import net.minecraft.structure.rule.BlockMatchRuleTest
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.world.gen.feature.*

object ModConfiguredFeaturesMain {
    private val OVERWORLD_ZINC_ORES = listOf(
        OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocksMain.ZINC_ORE.defaultState),
        OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocksMain.DEEPSLATE_ZINC_ORE.defaultState)
    )
    private val NETHER_ZINC_ORES = listOf(
        OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, ModBlocksMain.ZINC_ORE.defaultState)
    )
    private val END_ZINC_ORES = listOf(
        OreFeatureConfig.createTarget(BlockMatchRuleTest(Blocks.END_STONE), ModBlocksMain.ZINC_ORE.defaultState)
    )
    private val END_OBSIDIAN_ZINC_ORES = listOf(
        OreFeatureConfig.createTarget(BlockMatchRuleTest(Blocks.OBSIDIAN), ModBlocksMain.ZINC_ORE.defaultState)
    )

    val OVERWORLD_ZINC_ORE: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>> =
        ConfiguredFeatures.register("zinc_ore", Feature.ORE, OreFeatureConfig(OVERWORLD_ZINC_ORES, 7))
    val NETHER_ZINC_ORE: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>> =
        ConfiguredFeatures.register("nether_zinc_ore", Feature.ORE, OreFeatureConfig(NETHER_ZINC_ORES, 10))
    val END_ZINC_ORE: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>> =
        ConfiguredFeatures.register("end_zinc_ore", Feature.ORE, OreFeatureConfig(END_ZINC_ORES, 13))
    val END_OBSIDIAN_ZINC_ORE: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>> =
        ConfiguredFeatures.register("end_obsidian_zinc_ore", Feature.ORE, OreFeatureConfig(END_OBSIDIAN_ZINC_ORES, 13))
    fun registerConfiguredFeatures(){
        Main.LOGGER.debug(Main.MOD_ID + "正在注册配置特征")
    }
}