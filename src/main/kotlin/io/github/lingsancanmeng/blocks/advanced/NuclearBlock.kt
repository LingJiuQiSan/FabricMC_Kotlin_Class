package io.github.lingsancanmeng.blocks.advanced

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView
import net.minecraft.world.World

class NuclearBlock(settings: Settings?) : Block(settings) {
    override fun appendTooltip(
        stack: ItemStack?,
        world: BlockView?,
        tooltip: MutableList<Text>,
        options: TooltipContext?
    ) {
        tooltip.add(Text.literal("右击它或站在上面会获得30秒凋零效果"))
    }

    override fun onUse(
        state: BlockState?,
        world: World?,
        pos: BlockPos?,
        player: PlayerEntity,
        hand: Hand?,
        hit: BlockHitResult?
    ): ActionResult {
        player.addStatusEffect(StatusEffectInstance(StatusEffects.WITHER, 600))
        return super.onUse(state, world, pos, player, hand, hit)
    }

    override fun onSteppedOn(world: World?, pos: BlockPos?, state: BlockState?, entity: Entity) {
        if (entity is LivingEntity){
            entity.addStatusEffect(StatusEffectInstance(StatusEffects.WITHER, 600))
        }
        super.onSteppedOn(world, pos, state, entity)
    }
}