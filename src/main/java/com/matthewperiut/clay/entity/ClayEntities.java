package com.matthewperiut.clay.entity;

import com.matthewperiut.clay.ClaySoldiers;
import com.matthewperiut.clay.entity.client.ClaySoldierRenderer;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ClayEntities
{
    public static final EntityType<ClaySoldierEntity> CLAY_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClaySoldiers.MOD_ID, "soldier/clay"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ClaySoldierEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.5f)).build());

    public static void register()
    {
        FabricDefaultAttributeRegistry.register(CLAY_SOLDIER, ClaySoldierEntity.setAttributes());
    }
}
