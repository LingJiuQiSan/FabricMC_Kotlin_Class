package io.github.lingsancanmeng.villagers

import com.google.common.collect.ImmutableSet
import io.github.lingsancanmeng.Main
import io.github.lingsancanmeng.blocks.ModBlocksMain
import io.github.lingsancanmeng.item.ModItemsMain
import net.fabricmc.fabric.api.`object`.builder.v1.trade.TradeOfferHelper
import net.fabricmc.fabric.api.`object`.builder.v1.villager.VillagerProfessionBuilder
import net.fabricmc.fabric.api.`object`.builder.v1.world.poi.PointOfInterestHelper
import net.minecraft.block.Block
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.village.TradeOffer
import net.minecraft.village.TradeOffers
import net.minecraft.village.VillagerProfession
import net.minecraft.world.poi.PointOfInterestType

object ModVillagersMain {
    val ZINC_BLOCK_POI = registerPOI("zinc_block_poi", ModBlocksMain.ZINC_BLOCK)
    val ZINCMASTER = registerProfession("zincmaster",
        RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, Identifier(Main.MOD_ID, "zinc_block_poi")))
    private fun registerProfession(name: String, type: RegistryKey<PointOfInterestType>): VillagerProfession {
        return Registry.register(
            Registry.VILLAGER_PROFESSION, Identifier(Main.MOD_ID, name),
            VillagerProfessionBuilder.create().id(Identifier(Main.MOD_ID, name)).workstation(type)
                .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build()
        )
    }

    private fun registerPOI(name: String, block: Block): PointOfInterestType {
        return PointOfInterestHelper.register(
            Identifier(Main.MOD_ID, name),
            1,10, ImmutableSet.copyOf(block.stateManager.states))
    }

    fun registerVillagers(){
        Main.LOGGER.debug(Main.MOD_ID + "正在注册村民")
    }

    fun registerTrade(){
        TradeOfferHelper.registerVillagerOffers(ZINCMASTER, 1
        ) { factories: MutableList<TradeOffers.Factory?> ->
            factories.add(
                TradeOffers.Factory { _, _ ->
                    TradeOffer(
                        ItemStack(Items.EMERALD, 9),
                        ItemStack(ModItemsMain.ZINC_INGOT, 1),
                        9, 2, 0.02f
                    )
                })
        }
        TradeOfferHelper.registerVillagerOffers(ZINCMASTER, 1
        ) { factories: MutableList<TradeOffers.Factory?> ->
            factories.add(
                TradeOffers.Factory { _, _ ->
                    TradeOffer(
                        ItemStack(Items.EMERALD, 1),
                        ItemStack(ModItemsMain.ZINC_NUGGET, 1),
                        9, 2, 0.02f
                    )
                })
        }
        TradeOfferHelper.registerVillagerOffers(ZINCMASTER, 1
        ) { factories: MutableList<TradeOffers.Factory?> ->
            factories.add(
                TradeOffers.Factory { _, _ ->
                    TradeOffer(
                        ItemStack(ModItemsMain.ZINC_INGOT, 2),
                        ItemStack(Items.EMERALD, 9),
                        9, 2, 0.02f
                    )
                })
        }
        TradeOfferHelper.registerVillagerOffers(ZINCMASTER, 1
        ) { factories: MutableList<TradeOffers.Factory?> ->
            factories.add(
                TradeOffers.Factory { _, _ ->
                    TradeOffer(
                        ItemStack(ModItemsMain.ZINC_NUGGET, 2),
                        ItemStack(Items.EMERALD, 1),
                        9, 2, 0.02f
                    )
                })
        }
    }
}