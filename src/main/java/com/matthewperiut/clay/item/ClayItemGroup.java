package com.matthewperiut.clay.item;

import com.matthewperiut.clay.ClaySoldiers;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ClayItemGroup
{
    public static final ItemGroup CLAY_GROUP = FabricItemGroupBuilder.build(
            new Identifier(ClaySoldiers.MOD_ID, "clay_group"), () -> new ItemStack(ClayItems.CLAY_SOLDIER));
}
