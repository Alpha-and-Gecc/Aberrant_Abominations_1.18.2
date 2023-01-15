package com.alpha_and_gec.aberrant_abominations.client.renderer;

import com.alpha_and_gec.aberrant_abominations.Aberrant_Abominations;
import com.alpha_and_gec.aberrant_abominations.client.model.MajundosteusModel;
import com.alpha_and_gec.aberrant_abominations.common.entityclasses.MajundosteusEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
public class MajundosteusRenderer {

    public MajundosteusRenderer(EntityRendererProvider.Context context) {
        super(context, new MajundosteusModel());
        this.shadowRadius = 2F;
    }

    public RenderType getRenderType(MajundosteusEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1F, 1F, 1F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    //TODO: Fix this shit
}
