package com.alpha_and_gec.aberrant_abominations.client.model;

import com.alpha_and_gec.aberrant_abominations.AberrantAbominations;
import com.alpha_and_gec.aberrant_abominations.common.entity.common.MajundosteusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;
import java.util.List;

public class MajundosteusModel extends AnimatedGeoModel<MajundosteusEntity> {

    @Override
    public void setLivingAnimations(MajundosteusEntity dino, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setCustomAnimations(dino, uniqueID, customPredicate);

        if (customPredicate == null) return;

        List<EntityModelData> extraDataOfType = customPredicate.getExtraDataOfType(EntityModelData.class);
        IBone head = this.getAnimationProcessor().getBone("neck");

    }
    @Override
    public ResourceLocation getModelLocation(MajundosteusEntity object) {
        return new ResourceLocation(AberrantAbominations.MODID, "geo/majundosteus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MajundosteusEntity object) {
        return new ResourceLocation(AberrantAbominations.MODID, "textures/entity/majundosteus.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MajundosteusEntity object) {
        return new ResourceLocation(AberrantAbominations.MODID, "animations/majundosteus.animation.json");
    }

}
