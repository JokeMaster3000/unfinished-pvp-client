package apeclient.mods.impl;

import apeclient.gui.hud.ScreenPosition;
import apeclient.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class ModFullbright extends ModDraggable {

	private ScreenPosition pos;

	public ModFullbright() {
		Minecraft.getMinecraft().gameSettings.gammaSetting = 10;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public void render(ScreenPosition pos) {
		return;
	}

	@Override
	public void save(ScreenPosition pos) {
		return;
	}

	@Override
	public ScreenPosition load() {
		return pos;
	}
	
}