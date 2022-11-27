package com.matthewperiut.clay.item.horse;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.horse.HorseEntities;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import com.matthewperiut.clay.entity.soldier.SoldierEntities;
import com.matthewperiut.clay.item.ClayItemGroup;
import com.matthewperiut.clay.item.soldier.ClaySoldierItem;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Arrays;

public class HorseDollItems
{
    public static final HorseDollItem DIRT_HORSE = registerHorseDollItem("horse/dirt", HorseEntities.DIRT_HORSE, 0x593A35);

    public static HorseDollItem registerHorseDollItem(String name, EntityType<? extends HorseDollEntity> entity, int color)
    {
        HorseDollItem item = Registry.register(Registry.ITEM, new Identifier(Clay.MOD_ID, name), new HorseDollItem(entity, new FabricItemSettings().maxCount(16).group(ClayItemGroup.CLAY_GROUP)));
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> color, item);
        return item;
    }

    public static void register()
    {
        DIRT_HORSE.entityTypes.add(HorseEntities.GRASS_HORSE);
        DIRT_HORSE.entityTypes.add(HorseEntities.MYCELIUM_HORSE);
        DIRT_HORSE.entityTypes.add(HorseEntities.SNOW_HORSE);
    }
}
