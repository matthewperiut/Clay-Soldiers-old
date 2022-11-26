package com.matthewperiut.clay.item;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.item.soldier.ClaySoldierItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ClayItemGroup
{
    public static final ItemGroup CLAY_GROUP = FabricItemGroupBuilder.build(
            new Identifier(Clay.MOD_ID, "clay_group"), () -> new ItemStack(ClaySoldierItems.CLAY_SOLDIER));
}
