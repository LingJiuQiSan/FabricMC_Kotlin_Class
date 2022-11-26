package io.github.lingsancanmeng.blocks.advanced

import io.github.lingsancanmeng.item.ModItemsMain
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.CropBlock
import net.minecraft.item.ItemConvertible
import net.minecraft.state.StateManager
import net.minecraft.state.property.IntProperty

class EggplantCrop(settings: Settings?) : CropBlock(settings) {
    companion object{
        val AGE: IntProperty = IntProperty.of("age",0,6)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(AGE)
    }

    override fun getSeedsItem(): ItemConvertible {
        return ModItemsMain.EGGPLANT_SEED
    }

    override fun getAgeProperty(): IntProperty {
        return AGE
    }

    override fun getMaxAge(): Int {
        return 6
    }
}