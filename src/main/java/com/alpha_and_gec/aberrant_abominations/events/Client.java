package com.alpha_and_gec.aberrant_abominations.events;

import com.alpha_and_gec.aberrant_abominations.Aberrant_Abominations;
import com.alpha_and_gec.aberrant_abominations.inits.entity.HybridEntities;
import com.alpha_and_gec.aberrant_abominations.inits.entity.client.MajundosteusRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Aberrant_Abominations.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class Client {
    @SubscribeEvent
    public static void clientSetup(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(HybridEntities.MAJUNDOSTEUS.get(), MajundosteusRenderer::new);
    }
}