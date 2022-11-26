package com.matthewperiut.clay.item;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.entity.ClayEntities;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import com.matthewperiut.clay.item.disruptor.DisruptorItems;
import com.matthewperiut.clay.item.soldier.ClaySoldierItem;
import com.matthewperiut.clay.item.soldier.ClaySoldierItems;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ClayItems
{
    public static Item registerClaySoldierItem(String name, EntityType<? extends ClaySoldierEntity> entity, int color)
    {
        Item item = Registry.register(Registry.ITEM, new Identifier(Clay.MOD_ID, name), new ClaySoldierItem(entity, new FabricItemSettings().maxCount(16).group(ClayItemGroup.CLAY_GROUP)));
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> color, item);
        return item;
    }
    public static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(Clay.MOD_ID, name), item);
    }
    public static void registerItems()
    {
        DisruptorItems.register();
        ClaySoldierItems.register();
    }
}
