package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HorseDollModel extends AnimatedGeoModel<HorseDollEntity>
{
    Identifier texture_id;
    public HorseDollModel(Identifier texture_id)
    {
        this.texture_id = texture_id;
    }

    @Override
    public Identifier getModelLocation(HorseDollEntity object) {
        return new Identifier(Clay.MOD_ID, "geo/doll_horse.geo.json");
    }

    @Override
    public Identifier getTextureLocation(HorseDollEntity object) {
        return texture_id;
    }

    @Override
    public Identifier getAnimationFileLocation(HorseDollEntity animatable) {
        return new Identifier(Clay.MOD_ID, "animations/doll_horse.animation.json");
    }
}
