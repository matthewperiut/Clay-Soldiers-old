package com.matthewperiut.clay.entity.soldier.variant;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class WhiteSoldier extends ClaySoldierEntity
{
    public static final Identifier TEXTURE_ID = new Identifier(Clay.MOD_ID, "textures/entity/soldier/white.png");
    public WhiteSoldier(EntityType<? extends PathAwareEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
}
