package com.alpha_and_gec.aberrant_abominations.inits.item;

import com.alpha_and_gec.aberrant_abominations.Aberrant_Abominations;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class CustomItems {

    private CustomItems(){}

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Aberrant_Abominations.MODID);



    public static final RegistryObject<Item> NULL_DNA = ITEMS.register("null_dna",
            () -> new Item(new Item.Properties().tab(Aberrant_Abominations.HYBRIDS)));
    public static final RegistryObject<Item> MAJUNDOST_FLASK = ITEMS.register("majundost_flask",
            () -> new Item(new Item.Properties().tab(Aberrant_Abominations.HYBRIDS)));
    public static final RegistryObject<Item> ANUROANURUS_FLASK = ITEMS.register("anuroanurus_flask",
            () -> new Item(new Item.Properties().tab(Aberrant_Abominations.HYBRIDS)));
    public static final RegistryObject<Item> BEELZONITES_FLASK = ITEMS.register("beelzonites_flask",
            () -> new Item(new Item.Properties().tab(Aberrant_Abominations.HYBRIDS)));
    //^^ DNA

    public static final RegistryObject<Item> MAJUNDOST_SCUTE = ITEMS.register("majundost_scute",
            () -> new Item(new Item.Properties().tab(Aberrant_Abominations.HYBRIDS)));
    public static final RegistryObject<Item> GLORBO = ITEMS.register("glorbo",
            () -> new Item(new Item.Properties().tab(Aberrant_Abominations.HYBRIDS)));
    //^^ DROPS

    //^^ GEAR

    //^^ BUCKETS

    public static final RegistryObject<Item> MAJUNDRAW = ITEMS.register("majundraw",
            () -> new Item(new Item.Properties().food(FoodDefinition.MAJUNDRAW).tab(Aberrant_Abominations.HYBRIDS)));
    public static final RegistryObject<Item> MAJUNDROAST = ITEMS.register("majundroast",
            () -> new Item(new Item.Properties().food(FoodDefinition.MAJUNDROAST).tab(Aberrant_Abominations.HYBRIDS)));
    public static final RegistryObject<Item> BEELZOMARI = ITEMS.register("beelzomari",
            () -> new Item(new Item.Properties().food(FoodDefinition.BEELZOMARI).tab(Aberrant_Abominations.HYBRIDS)));
    public static final RegistryObject<Item> BEELZOMARI_FRIED = ITEMS.register("beelzomari_fried",
            () -> new Item(new Item.Properties().food(FoodDefinition.BEELZOMARI_FRIED).tab(Aberrant_Abominations.HYBRIDS)));
    public static final RegistryObject<Item> FROGFROG_RAW = ITEMS.register("frogfrog_raw",
            () -> new Item(new Item.Properties().food(FoodDefinition.FROGFROG_RAW).tab(Aberrant_Abominations.HYBRIDS)));
    public static final RegistryObject<Item> FROGFROG_COOKED = ITEMS.register("frogfrog_cooked.json",
            () -> new Item(new Item.Properties().food(FoodDefinition.FROGFROG_COOKED).tab(Aberrant_Abominations.HYBRIDS)));
    //^^ FOOD

}
