package com.alpha_and_gec.aberrant_abominations.events;

import com.alpha_and_gec.aberrant_abominations.Aberrant_Abominations;
import com.alpha_and_gec.aberrant_abominations.inits.entity.common.MajundosteusEntity;
import com.alpha_and_gec.aberrant_abominations.inits.entity.HybridEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Aberrant_Abominations.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class Common {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(HybridEntities.MAJUNDOSTEUS.get(), MajundosteusEntity.createAttributes().build());
    }

}
