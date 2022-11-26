package com.matthewperiut.clay;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ClayTag
{
    public static final TagKey<Item> SOLDIERS = TagKey.of(Registry.ITEM_KEY, new Identifier(Clay.MOD_ID, "soldiers"));
}
