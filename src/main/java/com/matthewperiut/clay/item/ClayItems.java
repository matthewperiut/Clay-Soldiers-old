package com.matthewperiut.clay.item;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.item.disruptor.DisruptorItems;
import com.matthewperiut.clay.item.horse.HorseDollItems;
import com.matthewperiut.clay.item.soldier.SoldierDollItems;
import net.minecraft.item.Item;
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
        SoldierDollItems.register();
        HorseDollItems.register();
    }
}
