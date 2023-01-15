package com.alpha_and_gec.aberrant_abominations.inits.entities;

import com.alpha_and_gec.aberrant_abominations.Aberrant_Abominations;
import com.alpha_and_gec.aberrant_abominations.common.entityclasses.MajundosteusEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CustomEntities {

    private CustomEntities(){}

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Aberrant_Abominations.MODID);

    public static final RegistryObject<EntityType<MajundosteusEntity>> MAJUNDOSTEUS = ENTITY_TYPES.register("majundosteus",
            () -> EntityType.Builder.of(MajundosteusEntity::new, MobCategory.CREATURE).sized(1.1f, 3.0f)
                    .build(new ResourceLocation(Aberrant_Abominations.MODID, "majundosteus").toString()));
}