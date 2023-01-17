package com.alpha_and_gec.aberrant_abominations.common;

import com.alpha_and_gec.aberrant_abominations.AberrantAbominations;
import com.alpha_and_gec.aberrant_abominations.common.entity.common.MajundosteusEntity;
import com.alpha_and_gec.aberrant_abominations.init.AAEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AberrantAbominations.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class CommonEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(AAEntities.MAJUNDOSTEUS.get(), MajundosteusEntity.createAttributes().build());
    }

}
