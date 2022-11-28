package com.matthewperiut.clay.item.common;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.item.disruptor.DisruptorItems;
import com.matthewperiut.clay.item.soldier.SoldierDollItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ClayItemGroup
{
    public static final ItemGroup CLAY_GROUP = FabricItemGroupBuilder.build(
            new Identifier(Clay.MOD_ID, "clay_group"), () -> new ItemStack(SoldierDollItems.CLAY_SOLDIER));

    public static final ItemGroup CLAY_MISC_GROUP = FabricItemGroupBuilder.build(
            new Identifier(Clay.MOD_ID, "clay_misc_group"), () -> new ItemStack(DisruptorItems.CLAY_DISRUPTOR));
}
