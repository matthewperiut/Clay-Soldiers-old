package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SoldierDollModel extends AnimatedGeoModel<ClaySoldierEntity>
{
    Identifier texture_id;
    public SoldierDollModel(Identifier texture_id)
    {
        this.texture_id = texture_id;
    }
    @Override
    public Identifier getModelLocation(ClaySoldierEntity object) {
        return new Identifier(Clay.MOD_ID, "geo/clay_soldier.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ClaySoldierEntity object) {
        return texture_id;
    }

    @Override
    public Identifier getAnimationFileLocation(ClaySoldierEntity animatable) {
        return new Identifier(Clay.MOD_ID, "animations/clay_soldier.animation.json");
    }
}
