package io.github.lingsancanmeng.blocks.advanced

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class ZincLamp(settings: Settings?) : Block(settings) {
    init {
        defaultState = this.getStateManager().defaultState.with(LIGHT, false)
    }
    companion object {
        val LIGHT: BooleanProperty = BooleanProperty.of("light")
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(LIGHT)
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        if (!world.isClient() && hand == Hand.MAIN_HAND){
            world.setBlockState(pos, state.cycle(LIGHT))
        }
        return super.onUse(state, world, pos, player, hand, hit)
    }
}