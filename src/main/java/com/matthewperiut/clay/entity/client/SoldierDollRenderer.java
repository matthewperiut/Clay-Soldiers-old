package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SoldierDollRenderer extends GeoEntityRenderer<ClaySoldierEntity>
{
    public Identifier texture_id;
    public SoldierDollRenderer(EntityRendererFactory.Context renderManager, AnimatedGeoModel<ClaySoldierEntity> modelProvider, Identifier texture_id)
    {
        super(renderManager, modelProvider);
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
    }
}
