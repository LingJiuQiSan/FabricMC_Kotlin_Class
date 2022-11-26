package io.github.lingsancanmeng.dataGen

import io.github.lingsancanmeng.villagers.ModVillagersMain
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.tag.TagKey
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.world.poi.PointOfInterestType

class ModPointTagDataGen(dataGenerator: FabricDataGenerator?
) : FabricTagProvider<PointOfInterestType>(dataGenerator, Registry.POINT_OF_INTEREST_TYPE) {
    override fun generateTags() {
        getOrCreateTagBuilder(TagKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, Identifier("minecraft", "acquirable_job_site")))
            .add(ModVillagersMain.ZINC_BLOCK_POI)
    }
}