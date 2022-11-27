package com.matthewperiut.clay.item.horse;

import com.matthewperiut.clay.item.soldier.ClaySoldierItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class HorseDollItem extends ClaySoldierItem
{
    public ArrayList<EntityType<? extends MobEntity>> entityTypes;

    public HorseDollItem(EntityType<? extends MobEntity> defaultType, ArrayList<EntityType<? extends MobEntity>> entityTypes, Settings settings)
    {
        super(defaultType, settings);
        this.entityTypes = entityTypes;
    }

    public HorseDollItem(EntityType<? extends MobEntity> defaultType, Settings settings)
    {
        super(defaultType, settings);
        this.entityTypes = new ArrayList<>();
        entityTypes.add(defaultType);
    }

    @Override
    public EntityType<?> getEntityType(@Nullable NbtCompound nbt) {
        if (nbt != null && nbt.contains("EntityTag", 10))
        {
            NbtCompound nbtCompound = nbt.getCompound("EntityTag");
            if (nbtCompound.contains("id", 8))
            {
                return (EntityType)EntityType.get(nbtCompound.getString("id")).orElse(this.type);
            }
        }

        if (entityTypes.size() < 1)
            return this.type;

        int selected = Random.createLocal().nextBetween(0, entityTypes.size()-1);
        return entityTypes.get(selected);
    }
}
