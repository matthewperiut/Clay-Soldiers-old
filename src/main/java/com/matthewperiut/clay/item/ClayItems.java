package com.matthewperiut.clay.item;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.entity.ClayEntities;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import com.matthewperiut.clay.item.disruptor.DisruptorItems;
import com.matthewperiut.clay.item.horse.HorseDollItems;
import com.matthewperiut.clay.item.soldier.ClaySoldierItem;
import com.matthewperiut.clay.item.soldier.ClaySoldierItems;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ClayItems
{
    public static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(Clay.MOD_ID, name), item);
    }

    public static void registerItems()
    {
        DisruptorItems.register();
        ClaySoldierItems.register();
        HorseDollItems.register();
    }
}
