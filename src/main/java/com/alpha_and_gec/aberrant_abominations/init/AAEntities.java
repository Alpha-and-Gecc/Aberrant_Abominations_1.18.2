package com.alpha_and_gec.aberrant_abominations.init;

import com.alpha_and_gec.aberrant_abominations.AberrantAbominations;
import com.alpha_and_gec.aberrant_abominations.common.entity.common.AnuroanurusEntity;
import com.alpha_and_gec.aberrant_abominations.common.entity.common.MajundosteusEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = AberrantAbominations.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AAEntities {

    public static final DeferredRegister<EntityType<?>> ENTITYTYPE = DeferredRegister.create(ForgeRegistries.ENTITIES, AberrantAbominations.MODID);

    public static final RegistryObject<EntityType<MajundosteusEntity>> MAJUNDOSTEUS =
            ENTITYTYPE.register("majundosteus",
                    () -> EntityType.Builder.of(MajundosteusEntity::new, MobCategory.WATER_CREATURE)
                            .sized(1.5f, 3f)
                            .build(new ResourceLocation(AberrantAbominations.MODID, "majundosteus").toString()));

    public static final RegistryObject<EntityType<AnuroanurusEntity>> ANUROANURUS =
            ENTITYTYPE.register("anuroanurus",
                    () -> EntityType.Builder.of(AnuroanurusEntity::new, MobCategory.CREATURE)
                            .sized(1.2f, 0.5f)
                            .build(new ResourceLocation(AberrantAbominations.MODID, "anuroanurus").toString()));

    public static void register(IEventBus modEventBus) {
        ENTITYTYPE.register(modEventBus);
    }

}