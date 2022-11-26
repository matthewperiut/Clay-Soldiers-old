package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ClaySoldierModel extends AnimatedGeoModel<ClaySoldierEntity>
{
    Identifier texture_id;
    public ClaySoldierModel(Identifier texture_id)
    {
        this.texture_id = texture_id;
    }
    @Override
    public Identifier getModelResource(ClaySoldierEntity object)
    {
        return new Identifier(Clay.MOD_ID, "geo/clay_soldier.geo.json");
    }

    @Override
    public Identifier getTextureResource(ClaySoldierEntity object)
    {
        return texture_id;
    }

    @Override
    public Identifier getAnimationResource(ClaySoldierEntity animatable)
    {
        return new Identifier(Clay.MOD_ID, "animations/clay_soldier.animation.json");
    }
}
