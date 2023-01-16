package com.alpha_and_gec.aberrant_abominations.inits.entity;

import com.alpha_and_gec.aberrant_abominations.Aberrant_Abominations;
import com.alpha_and_gec.aberrant_abominations.inits.entity.common.AnuroanurusEntity;
import com.alpha_and_gec.aberrant_abominations.inits.entity.common.MajundosteusEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Aberrant_Abominations.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HybridEntities {

    public static final DeferredRegister<EntityType<?>> ENTITYTYPE = DeferredRegister.create(ForgeRegistries.ENTITIES, Aberrant_Abominations.MODID);

    public static final RegistryObject<EntityType<MajundosteusEntity>> MAJUNDOSTEUS =
            ENTITYTYPE.register("majundosteus",
                    () -> EntityType.Builder.of(MajundosteusEntity::new, MobCategory.WATER_CREATURE)
                            .sized(1.5f, 3f)
                            .build(new ResourceLocation(Aberrant_Abominations.MODID, "majundosteus").toString()));

    public static final RegistryObject<EntityType<AnuroanurusEntity>> ANUROANURUS =
            ENTITYTYPE.register("anuroanurus",
                    () -> EntityType.Builder.of(AnuroanurusEntity::new, MobCategory.CREATURE)
                            .sized(1.2f, 0.5f)
                            .build(new ResourceLocation(Aberrant_Abominations.MODID, "anuroanurus").toString()));

    public static void register(IEventBus modEventBus) {
        ENTITYTYPE.register(modEventBus);
    }

}