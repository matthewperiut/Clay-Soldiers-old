package com.matthewperiut.clay.item.soldier;

import com.matthewperiut.clay.entity.ClayEntities;
import com.matthewperiut.clay.item.ClayItemGroup;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import static com.matthewperiut.clay.item.ClayItems.registerClaySoldierItem;
import static com.matthewperiut.clay.item.ClayItems.registerItem;

public class ClaySoldierItems
{
    public static final Item CLAY_SOLDIER = registerClaySoldierItem("soldier/clay", ClayEntities.CLAY_SOLDIER, 0xAFB5C6);
    public static final Item RED_SOLDIER = registerClaySoldierItem("soldier/red", ClayEntities.RED_SOLDIER, 0xF54E42);
    public static final Item YELLOW_SOLDIER = registerClaySoldierItem("soldier/yellow", ClayEntities.YELLOW_SOLDIER, 0xF3CA2F);
    public static final Item GREEN_SOLDIER = registerClaySoldierItem("soldier/green", ClayEntities.GREEN_SOLDIER, 0x536D1B);
    public static final Item BLUE_SOLDIER = registerClaySoldierItem("soldier/blue", ClayEntities.BLUE_SOLDIER, 0x353A9F);
    public static final Item ORANGE_SOLDIER = registerClaySoldierItem("soldier/orange", ClayEntities.ORANGE_SOLDIER, 0xE66E10);
    public static final Item MAGENTA_SOLDIER = registerClaySoldierItem("soldier/magenta", ClayEntities.MAGENTA_SOLDIER, 0xBF4CBB);
    public static final Item LIGHTBLUE_SOLDIER = registerClaySoldierItem("soldier/lightblue", ClayEntities.LIGHTBLUE_SOLDIER, 0x3FB2DB);
    public static final Item LIME_SOLDIER = registerClaySoldierItem("soldier/lime", ClayEntities.LIME_SOLDIER, 0x73BA1A);
    public static final Item PINK_SOLDIER = registerClaySoldierItem("soldier/pink", ClayEntities.PINK_SOLDIER, 0xE791B0);
    public static final Item CYAN_SOLDIER = registerClaySoldierItem("soldier/cyan", ClayEntities.CYAN_SOLDIER, 0x148C93);
    public static final Item PURPLE_SOLDIER = registerClaySoldierItem("soldier/purple", ClayEntities.PURPLE_SOLDIER, 0x792AAB);
    public static final Item BROWN_SOLDIER = registerClaySoldierItem("soldier/brown", ClayEntities.BROWN_SOLDIER, 0x744A2B);
    public static final Item BLACK_SOLDIER = registerClaySoldierItem("soldier/black", ClayEntities.BLACK_SOLDIER, 0x18181D);
    public static final Item GRAY_SOLDIER = registerClaySoldierItem("soldier/gray", ClayEntities.GRAY_SOLDIER, 0x51585D);
    public static final Item WHITE_SOLDIER = registerClaySoldierItem("soldier/white", ClayEntities.WHITE_SOLDIER, 0xE2E6EA);

    public static void register()
    {

    }
}
