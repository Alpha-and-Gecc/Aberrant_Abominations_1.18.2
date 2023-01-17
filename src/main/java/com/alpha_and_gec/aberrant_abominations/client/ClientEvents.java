package com.alpha_and_gec.aberrant_abominations.client;

import com.alpha_and_gec.aberrant_abominations.AberrantAbominations;
import com.alpha_and_gec.aberrant_abominations.init.AAEntities;
import com.alpha_and_gec.aberrant_abominations.client.render.MajundosteusRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AberrantAbominations.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AAEntities.MAJUNDOSTEUS.get(), MajundosteusRenderer::new);
    }
}