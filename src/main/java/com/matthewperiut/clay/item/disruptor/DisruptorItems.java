package com.matthewperiut.clay.item.disruptor;

import com.matthewperiut.clay.item.ClayItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import static com.matthewperiut.clay.item.ClayItems.registerItem;

public class DisruptorItems
{
    public static Item CLAY_DISRUPTOR = registerItem(
            "disruptor/clay", new ClayDisruptorItem(new ClayMaterial(), new FabricItemSettings().maxCount(1).group(ClayItemGroup.CLAY_GROUP)));

    public static void register()
    {

    }
}
