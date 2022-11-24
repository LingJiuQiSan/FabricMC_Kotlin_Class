package io.github.lingSanCanMeng.item.advanced

import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemStack
import net.minecraft.item.NetherStarItem
import net.minecraft.text.Text
import net.minecraft.world.World

class ZincOreDetectionRod(settings: Settings?) : NetherStarItem(settings) {
    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext?
    ) {
        tooltip.add(Text.literal("用来探测锌矿石"))
        super.appendTooltip(stack, world, tooltip, context)
    }
}