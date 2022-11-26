package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ClaySoldierRenderer extends GeoEntityRenderer<ClaySoldierEntity>
{
    public Identifier texture_id;
    public ClaySoldierRenderer(EntityRendererFactory.Context renderManager, AnimatedGeoModel<ClaySoldierEntity> modelProvider, Identifier texture_id)
    {
        super(renderManager, modelProvider);
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
    }

    @Override
    public Identifier getTextureResource(ClaySoldierEntity animatable)
    {
        return new Identifier(Clay.MOD_ID, "textures/entity/soldier/gray.png");
    }

}
