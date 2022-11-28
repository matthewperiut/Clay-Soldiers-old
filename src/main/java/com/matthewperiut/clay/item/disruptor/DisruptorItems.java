package com.matthewperiut.clay.item.disruptor;

import com.matthewperiut.clay.item.ClayItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import static com.matthewperiut.clay.item.ClayItems.registerItem;

public class DisruptorItems
{
    public static Item CLAY_DISRUPTOR = registerItem(
                "disruptor/clay", new DisruptorItem(new ClayMaterial(), new FabricItemSettings().maxCount(1).group(ClayItemGroup.CLAY_MISC_GROUP)));
    public static Item TERRACOTTA_DISRUPTOR = registerItem(
                "disruptor/terracotta", new DisruptorItem(new TerracottaMaterial(), new FabricItemSettings().maxCount(1).group(ClayItemGroup.CLAY_MISC_GROUP)));
    public static Item OBSIDIAN_DISRUPTOR = registerItem(
                "disruptor/obsidian", new DisruptorItem(new FabricItemSettings().maxCount(1).group(ClayItemGroup.CLAY_MISC_GROUP)));

    public static void register()
    {

    }
}
