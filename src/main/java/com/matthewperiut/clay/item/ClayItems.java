package com.matthewperiut.clay.item;

import com.matthewperiut.clay.ClaySoldiers;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ClayItems
{
    public static final Item CLAY_SOLDIER = registerItem("soldier/clay",
            new Item(new FabricItemSettings().maxCount(16).group(ClayItemGroup.CLAY_GROUP)));
    public static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(ClaySoldiers.MOD_ID, name), item);
    }
    public static void registerItems()
    {

    }
}
