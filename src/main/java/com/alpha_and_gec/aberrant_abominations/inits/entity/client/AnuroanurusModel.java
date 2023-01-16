package com.alpha_and_gec.aberrant_abominations.inits.entity.client;

import com.alpha_and_gec.aberrant_abominations.Aberrant_Abominations;
import com.alpha_and_gec.aberrant_abominations.inits.entity.common.AnuroanurusEntity;
import com.alpha_and_gec.aberrant_abominations.inits.entity.common.MajundosteusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;
import java.util.List;

public class AnuroanurusModel extends AnimatedGeoModel<AnuroanurusEntity> {

    @Override
    public void setLivingAnimations(AnuroanurusEntity dino, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setCustomAnimations(dino, uniqueID, customPredicate);

        if (customPredicate == null) return;

        List<EntityModelData> extraDataOfType = customPredicate.getExtraDataOfType(EntityModelData.class);

    }
    @Override
    public ResourceLocation getModelLocation(AnuroanurusEntity object) {
        return new ResourceLocation(Aberrant_Abominations.MODID, "geo/anuroanurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AnuroanurusEntity object) {
        return new ResourceLocation(Aberrant_Abominations.MODID, "textures/entity/anuroanurus.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AnuroanurusEntity object) {
        return new ResourceLocation(Aberrant_Abominations.MODID, "animations/anuroanurus.animation.json");
    }

}
