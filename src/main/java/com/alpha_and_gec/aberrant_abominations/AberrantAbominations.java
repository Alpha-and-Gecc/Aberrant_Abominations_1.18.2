package com.alpha_and_gec.aberrant_abominations;

import com.alpha_and_gec.aberrant_abominations.init.AAEntities;
import com.alpha_and_gec.aberrant_abominations.init.AAItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import com.alpha_and_gec.aberrant_abominations.client.render.MajundosteusRenderer;

@Mod(AberrantAbominations.MODID)
public class AberrantAbominations {
    public static final String MODID = ("aberrant_abominations");
    private static final Logger LOGGER = LogUtils.getLogger();

    public AberrantAbominations() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventBus = MinecraftForge.EVENT_BUS;

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.register(this);

        AAItems.ITEMS.register(modEventBus);
        AAEntities.ENTITYTYPE.register(modEventBus);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(AAEntities.MAJUNDOSTEUS.get(), MajundosteusRenderer::new);
    }

    public static final CreativeModeTab HYBRIDS = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return AAItems.NULL_DNA.get().getDefaultInstance();
        }
    };

}
