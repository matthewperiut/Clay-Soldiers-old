package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.ClaySoldiers;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ClaySoldierModel extends AnimatedGeoModel<ClaySoldierEntity>
{
    @Override
    public Identifier getModelResource(ClaySoldierEntity object)
    {
        return new Identifier(ClaySoldiers.MOD_ID, "geo/clay_soldier.geo.json");
    }

    @Override
    public Identifier getTextureResource(ClaySoldierEntity object)
    {
        return new Identifier(ClaySoldiers.MOD_ID, "textures/entity/soldier/gray.png");
    }

    @Override
    public Identifier getAnimationResource(ClaySoldierEntity animatable)
    {
        return new Identifier(ClaySoldiers.MOD_ID, "animations/clay_soldier.animation.json");
    }
}
