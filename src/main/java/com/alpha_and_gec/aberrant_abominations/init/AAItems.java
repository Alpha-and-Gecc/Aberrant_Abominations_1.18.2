package com.alpha_and_gec.aberrant_abominations.init;

import com.alpha_and_gec.aberrant_abominations.AberrantAbominations;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class AAItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            AberrantAbominations.MODID);



    public static final RegistryObject<Item> NULL_DNA = ITEMS.register("null_dna",
            () -> new Item(new Item.Properties().tab(AberrantAbominations.HYBRIDS)));
    public static final RegistryObject<Item> MAJUNDOST_FLASK = ITEMS.register("majundost_flask",
            () -> new Item(new Item.Properties().tab(AberrantAbominations.HYBRIDS)));
    public static final RegistryObject<Item> ANUROANURUS_FLASK = ITEMS.register("anuroanurus_flask",
            () -> new Item(new Item.Properties().tab(AberrantAbominations.HYBRIDS)));
    public static final RegistryObject<Item> BEELZONITES_FLASK = ITEMS.register("beelzonites_flask",
            () -> new Item(new Item.Properties().tab(AberrantAbominations.HYBRIDS)));
    //^^ DNA

    public static final RegistryObject<Item> MAJUNDOST_SCUTE = ITEMS.register("majundost_scute",
            () -> new Item(new Item.Properties().tab(AberrantAbominations.HYBRIDS)));
    public static final RegistryObject<Item> GLORBO = ITEMS.register("glorbo",
            () -> new Item(new Item.Properties().tab(AberrantAbominations.HYBRIDS)));
    //^^ DROPS

    //^^ GEAR

    //^^ BUCKETS

    public static final RegistryObject<Item> MAJUNDOSTEUS_SPAWN = ITEMS.register("majundosteus_spawn",
            () -> new ForgeSpawnEggItem(AAEntities.MAJUNDOSTEUS, 0X191b0f, 0X7a5c3e ,new Item.Properties().tab(AberrantAbominations.HYBRIDS)));
    public static final RegistryObject<Item> ANUROANURUS_SPAWN = ITEMS.register("anuroanurus_spawn",
            () -> new ForgeSpawnEggItem(AAEntities.ANUROANURUS, 0Xa9775f, 0X3a2248 ,new Item.Properties().tab(AberrantAbominations.HYBRIDS)));
    //^^ SPAWN EGGS

    public static final RegistryObject<Item> MAJUNDRAW = ITEMS.register("majundraw",
            () -> new Item(new Item.Properties().food(AAFoods.MAJUNDRAW).tab(AberrantAbominations.HYBRIDS)));
    public static final RegistryObject<Item> MAJUNDROAST = ITEMS.register("majundroast",
            () -> new Item(new Item.Properties().food(AAFoods.MAJUNDROAST).tab(AberrantAbominations.HYBRIDS)));
    public static final RegistryObject<Item> BEELZOMARI = ITEMS.register("beelzomari",
            () -> new Item(new Item.Properties().food(AAFoods.BEELZOMARI).tab(AberrantAbominations.HYBRIDS)));
    public static final RegistryObject<Item> BEELZOMARI_FRIED = ITEMS.register("beelzomari_fried",
            () -> new Item(new Item.Properties().food(AAFoods.BEELZOMARI_FRIED).tab(AberrantAbominations.HYBRIDS)));
    public static final RegistryObject<Item> FROGFROG_RAW = ITEMS.register("frogfrog_raw",
            () -> new Item(new Item.Properties().food(AAFoods.FROGFROG_RAW).tab(AberrantAbominations.HYBRIDS)));
    public static final RegistryObject<Item> FROGFROG_COOKED = ITEMS.register("frogfrog_cooked.json",
            () -> new Item(new Item.Properties().food(AAFoods.FROGFROG_COOKED).tab(AberrantAbominations.HYBRIDS)));
    //^^ FOOD

}
