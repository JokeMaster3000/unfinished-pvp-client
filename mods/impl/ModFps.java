package apeclient.mods.impl;

import org.newdawn.slick.Font;

import apeclient.gui.hud.ScreenPosition;
import apeclient.mods.ModDraggable;
import apeclient.mods.Rgb;

public class ModFps extends ModDraggable{
	
	
	

	@Override
	public int getWidth() {
		return 50;
		
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		font.drawString("Fps" + mc.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), Rgb.getRainbow(4, 1, 1));
		
	}

	

	
}
