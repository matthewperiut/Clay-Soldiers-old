package com.matthewperiut.clay;

import com.matthewperiut.clay.entity.ClayEntities;
import com.matthewperiut.clay.item.ClayItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class Clay implements ModInitializer
{
	public static final String MOD_ID = "clay";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		GeckoLib.initialize();
		ClayItems.registerItems();
		ClayEntities.register();
	}
}
