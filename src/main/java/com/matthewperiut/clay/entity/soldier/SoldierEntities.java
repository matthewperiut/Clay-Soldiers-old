package com.matthewperiut.clay.entity.soldier;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.entity.client.ClaySoldierModel;
import com.matthewperiut.clay.entity.client.ClaySoldierRenderer;
import com.matthewperiut.clay.entity.soldier.variant.*;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoldierEntities
{
    private static final float height = 0.5f;
    private static final float width = 0.25f;

    public static final EntityType<RegularSoldier> CLAY_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/clay"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RegularSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<RedSoldier> RED_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/red"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<YellowSoldier> YELLOW_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/yellow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, YellowSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<GreenSoldier> GREEN_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/green"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GreenSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<BlueSoldier> BLUE_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/blue"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BlueSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<OrangeSoldier> ORANGE_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/orange"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, OrangeSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<MagentaSoldier> MAGENTA_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/magenta"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MagentaSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<LightblueSoldier> LIGHTBLUE_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/lightblue"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LightblueSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<LimeSoldier> LIME_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/lime"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LimeSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<PinkSoldier> PINK_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/pink"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PinkSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<CyanSoldier> CYAN_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/cyan"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CyanSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<PurpleSoldier> PURPLE_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/purple"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PurpleSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<BrownSoldier> BROWN_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/brown"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BrownSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<BlackSoldier> BLACK_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/black"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BlackSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<GraySoldier> GRAY_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/gray"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GraySoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<WhiteSoldier> WHITE_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Clay.MOD_ID, "soldier/white"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WhiteSoldier::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());

    public static void register()
    {
        registerSoldier(CLAY_SOLDIER, ClaySoldierEntity.TEXTURE_ID);
        registerSoldier(RED_SOLDIER, RedSoldier.TEXTURE_ID);
        registerSoldier(YELLOW_SOLDIER, YellowSoldier.TEXTURE_ID);
        registerSoldier(GREEN_SOLDIER, GreenSoldier.TEXTURE_ID);
        registerSoldier(BLUE_SOLDIER, BlueSoldier.TEXTURE_ID);
        registerSoldier(ORANGE_SOLDIER, OrangeSoldier.TEXTURE_ID);
        registerSoldier(MAGENTA_SOLDIER, MagentaSoldier.TEXTURE_ID);
        registerSoldier(LIGHTBLUE_SOLDIER, LightblueSoldier.TEXTURE_ID);
        registerSoldier(LIME_SOLDIER, LimeSoldier.TEXTURE_ID);
        registerSoldier(PINK_SOLDIER, PinkSoldier.TEXTURE_ID);
        registerSoldier(CYAN_SOLDIER, CyanSoldier.TEXTURE_ID);
        registerSoldier(PURPLE_SOLDIER, PurpleSoldier.TEXTURE_ID);
        registerSoldier(BROWN_SOLDIER, BrownSoldier.TEXTURE_ID);
        registerSoldier(BLACK_SOLDIER, BlackSoldier.TEXTURE_ID);
        registerSoldier(GRAY_SOLDIER, GraySoldier.TEXTURE_ID);
        registerSoldier(WHITE_SOLDIER, WhiteSoldier.TEXTURE_ID);
    }

    private static void registerSoldier(EntityType<? extends ClaySoldierEntity> entityType, Identifier textureID)
    {
        FabricDefaultAttributeRegistry.register(entityType, RegularSoldier.setAttributes());
        EntityRendererRegistry.register(entityType, (context) -> { return new ClaySoldierRenderer(context, new ClaySoldierModel(textureID), textureID); });
    }
}
