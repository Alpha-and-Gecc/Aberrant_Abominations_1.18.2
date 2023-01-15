package com.alpha_and_gec.aberrant_abominations.inits.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
public class FoodDefinition {

    public static final FoodProperties MAJUNDRAW = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F).meat().build();
    public static final FoodProperties MAJUNDROAST = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.4F).meat().build();

    public static final FoodProperties BEELZOMARI = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat().build();
    public static final FoodProperties BEELZOMARI_FRIED = (new FoodProperties.Builder()).nutrition(8).saturationMod(.6F).meat().fast().build();

    public static final FoodProperties FROGFROG_RAW = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).meat().build();
    public static final FoodProperties FROGFROG_COOKED = (new FoodProperties.Builder()).nutrition(4).saturationMod(.8F).meat().build();

}
