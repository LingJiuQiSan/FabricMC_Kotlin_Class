package io.github.lingsancanmeng.item.advanced

import io.github.lingsancanmeng.blocks.ModBlocksMain
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.item.NetherStarItem
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.math.BlockPos
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

    override fun useOnBlock(context: ItemUsageContext): ActionResult {
        if (!context.world.isClient()) {
            val clickedBlockPos = context.blockPos
            val player = context.player
            var foundBlock = false
            lateinit var foundBlockPos: BlockPos

            for (i in -64..clickedBlockPos.y) {
                val downBlockPos = clickedBlockPos.down(i + 64)
                val downBlock = context.world.getBlockState(downBlockPos).block

                if (downBlock == ModBlocksMain.ZINC_ORE || downBlock == ModBlocksMain.DEEPSLATE_ZINC_ORE) {
                    foundBlock = true
                    foundBlockPos = downBlockPos
                    break
                }
            }

            if (foundBlock) {
                player!!.sendMessage(Text.literal("发现锌矿石在(" + foundBlockPos.x + "," + foundBlockPos.y + "," + foundBlockPos.z + ")!"))
            } else {
                player!!.sendMessage(Text.literal("未发现锌矿石！"))
            }

            context.stack.damage(
                1, player
            ){
                it.sendToolBreakStatus(it.activeHand)
            }

            player.itemCooldownManager.set(this, 10)
        }
        return super.useOnBlock(context)
    }
}