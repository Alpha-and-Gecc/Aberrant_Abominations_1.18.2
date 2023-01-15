package com.alpha_and_gec.aberrant_abominations.common.entityclasses;

import com.alpha_and_gec.aberrant_abominations.Aberrant_Abominations;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class HybridEntityType {

    private HybridEntityType(){}

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Aberrant_Abominations.MODID);
}
