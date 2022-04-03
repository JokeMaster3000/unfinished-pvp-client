package apeclient.mods.impl;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import apeclient.gui.hud.ScreenPosition;
import apeclient.mods.ModDraggable;
import apeclient.mods.Rgb;

public class ModCPS extends ModDraggable{
	
	private List<Long> clicks = new ArrayList<Long>();
	private boolean wasPressed;
	private long lastPressed;

	@Override
	public int getWidth() {
	
		return font.getStringWidth("CPS: 00");
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		
		final boolean pressed = Mouse.isButtonDown(0);
		
		if(pressed != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis();
			this.wasPressed = pressed;
			if(pressed) {
				this.clicks.add(this.lastPressed);
			}
			}
		
		font.drawString("Cps  " + getCps(),pos.getAbsoluteX(), pos.getAbsoluteY(), Rgb.getRainbow(4, 1, 1));
		
		
	}
	private int getCps() {
		final long time = System.currentTimeMillis();
		this.clicks.removeIf(aLong -> aLong + 1000 < time);
		return this.clicks.size();
	}

}
