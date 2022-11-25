package io.github.lingsancanmeng.blocks.advanced

import net.minecraft.block.Block
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.world.BlockView

class NuclearBlock(settings: Settings?) : Block(settings) {
    override fun appendTooltip(
        stack: ItemStack?,
        world: BlockView?,
        tooltip: MutableList<Text>,
        options: TooltipContext?
    ) {
        tooltip.add(Text.literal("右击它或站在上面会获得30秒凋零效果"))
    }
}