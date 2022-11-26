package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.ClaySoldiers;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ClaySoldierRenderer extends GeoEntityRenderer<ClaySoldierEntity>
{
    public ClaySoldierRenderer(EntityRendererFactory.Context renderManager, AnimatedGeoModel<ClaySoldierEntity> modelProvider)
    {
        super(renderManager, modelProvider);
        this.shadowRadius = 0.1f;
    }

    @Override
    public Identifier getTextureResource(ClaySoldierEntity animatable)
    {
        return new Identifier(ClaySoldiers.MOD_ID, "textures/entity/soldier/gray.png");
    }

}
