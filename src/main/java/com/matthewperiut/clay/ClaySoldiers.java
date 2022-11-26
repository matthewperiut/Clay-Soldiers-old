package com.matthewperiut.clay;

import com.matthewperiut.clay.item.ClayItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClaySoldiers implements ModInitializer
{
	public static final String MOD_ID = "clay";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ClayItems.registerItems();
	}
}
