package io.github.lingsancanmeng.item.advanced

import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.world.World

class Gobber2foo(settings: Settings?) : Item(settings) {

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext?
    ) {
        tooltip.add(Text.translatable("tooltip.gobber2_foo"))
        if (Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.shift.gobber2_foo"))
        } else {
            tooltip.add(Text.translatable("tooltip.not_shift.gobber2_foo"))
        }
        super.appendTooltip(stack, world, tooltip, context)
    }

}