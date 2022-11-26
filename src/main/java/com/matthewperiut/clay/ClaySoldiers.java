package com.matthewperiut.clay;

import com.matthewperiut.clay.entity.ClayEntities;
import com.matthewperiut.clay.entity.client.ClaySoldierModel;
import com.matthewperiut.clay.entity.client.ClaySoldierRenderer;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import com.matthewperiut.clay.item.ClayItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class ClaySoldiers implements ModInitializer
{
	public static final String MOD_ID = "clay";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		GeckoLib.initialize();
		ClayItems.registerItems();
		ClayEntities.register();
		EntityRendererRegistry.register(ClayEntities.CLAY_SOLDIER, (context) -> {
			return new ClaySoldierRenderer(context, new ClaySoldierModel());
		});

	}
}
