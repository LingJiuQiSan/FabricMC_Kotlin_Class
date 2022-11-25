package io.github.lingsancanmeng.dataGen

import io.github.lingsancanmeng.blocks.ModBlocksMain
import io.github.lingsancanmeng.item.ModItemsMain
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.Items
import java.util.function.Consumer

class ModRecipeDataGen(dataGenerator: FabricDataGenerator?) : FabricRecipeProvider(dataGenerator) {
    override fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {
        offerSmelting(
            exporter,
            listOf(ModItemsMain.RAW_ZINC, ModBlocksMain.ZINC_ORE, ModBlocksMain.DEEPSLATE_ZINC_ORE),
            ModItemsMain.ZINC_INGOT, 1f, 200, "zinc_ingot"
        )
        offerBlasting(
            exporter,
            listOf(ModItemsMain.RAW_ZINC, ModBlocksMain.ZINC_ORE, ModBlocksMain.DEEPSLATE_ZINC_ORE),
            ModItemsMain.ZINC_INGOT, 1f, 100, "zinc_ingot"
        )

        offerReversibleCompactingRecipes(
            exporter, ModItemsMain.ZINC_INGOT, ModBlocksMain.ZINC_BLOCK,
            "zinc_block_from_zinc_ingot", null,
            "zinc_ingot_from_zinc_block", null
        )
        offerReversibleCompactingRecipes(
            exporter, ModItemsMain.ZINC_NUGGET, ModItemsMain.ZINC_INGOT,
            "zinc_ingot_from_zinc_nugget", null,
            "zinc_nugget_from_zinc_ingot", null
        )

        ShapedRecipeJsonBuilder.create(ModItemsMain.GOBBER2_FOO)
            .pattern("ABB")
            .pattern("BBB")
            .pattern("BBB")
            .input('A', ModBlocksMain.ZINC_BLOCK)
            .input('B', Items.COAL)
            .criterion(
                hasItem(ModBlocksMain.ZINC_BLOCK),
                conditionsFromItem(ModBlocksMain.ZINC_BLOCK)
            )
            .criterion(
                hasItem(Items.COAL),
                conditionsFromItem(Items.COAL)
            )
            .offerTo(exporter)
    }
}