package com.alpha_and_gec.aberrant_abominations;

import com.alpha_and_gec.aberrant_abominations.inits.entity.HybridEntities;
import com.alpha_and_gec.aberrant_abominations.inits.entity.common.MajundosteusEntity;
import com.alpha_and_gec.aberrant_abominations.inits.item.CustomItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import com.alpha_and_gec.aberrant_abominations.inits.entity.client.MajundosteusRenderer;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Aberrant_Abominations.MODID)
public class Aberrant_Abominations
{

    public static final String MODID = ("aberrant_abominations");
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Aberrant_Abominations()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventBus = MinecraftForge.EVENT_BUS;

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.register(this);

        CustomItems.ITEMS.register(modEventBus);
        HybridEntities.ENTITYTYPE.register(modEventBus);

        //EntityRenderers.register(HybridEntities.MAJUNDOSTEUS.get(), MajundosteusRenderer::new);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        EntityRenderers.register(HybridEntities.MAJUNDOSTEUS.get(), MajundosteusRenderer::new);
    }

    public static final CreativeModeTab HYBRIDS = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return CustomItems.NULL_DNA.get().getDefaultInstance();
        }
    };

}
