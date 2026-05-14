package com.food_decoloring;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Food De-Coloring"
)
public class FoodDeColoringPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private FoodDeColoringOverlay foodDeColoringOverlay;

	@Inject
	private Client client;

	@Inject
	private FoodDeColoringConfig config;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(foodDeColoringOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(foodDeColoringOverlay);
	}

	@Provides
	FoodDeColoringConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FoodDeColoringConfig.class);
	}
}
