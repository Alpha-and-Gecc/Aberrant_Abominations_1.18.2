package com.alpha_and_gec.aberrant_abominations;

import com.alpha_and_gec.aberrant_abominations.inits.item.CustomItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

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
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);

        CustomItems.ITEMS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    public static final CreativeModeTab HYBRIDS = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return CustomItems.NULL_DNA.get().getDefaultInstance();
        }
    };

}
