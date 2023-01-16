package com.alpha_and_gec.aberrant_abominations.inits.entity.client;

import com.alpha_and_gec.aberrant_abominations.inits.entity.common.AnuroanurusEntity;
import com.alpha_and_gec.aberrant_abominations.inits.entity.common.MajundosteusEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AnuroanurusRenderer extends GeoEntityRenderer<AnuroanurusEntity>{
    public AnuroanurusRenderer(EntityRendererProvider.Context context) {
        super(context, new AnuroanurusModel());
        this.shadowRadius = 0.6F;
    }

    public RenderType getRenderType(AnuroanurusEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if (animatable.isBaby()) {
            stack.scale(0.3F, 0.3F, 0.3F);
        } else {
            stack.scale(1F, 1F, 1F);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

}
