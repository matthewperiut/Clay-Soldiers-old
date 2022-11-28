package com.matthewperiut.clay.item.horse;

import com.matthewperiut.clay.item.common.SpawnDollItem;
import com.matthewperiut.clay.item.soldier.SoldierDollItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class HorseDollItem extends SpawnDollItem
{

    public HorseDollItem(ArrayList<EntityType<?>> types, Settings settings)
    {
        super(types, settings);
    }

    public HorseDollItem(EntityType<? extends MobEntity> defaultType, Settings settings)
    {
        super(defaultType, settings);
    }
}
