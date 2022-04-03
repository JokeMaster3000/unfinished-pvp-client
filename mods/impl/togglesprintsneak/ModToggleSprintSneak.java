package apeclient.mods.impl.togglesprintsneak;

import apeclient.gui.hud.ScreenPosition;
import apeclient.mods.ModDraggable;
import apeclient.mods.Rgb;

public class ModToggleSprintSneak extends ModDraggable{
	
	
	
	public boolean flyBoost = true;
	public float flyBoostfactor = 4;
	public int keyHoldTicks = 7;
	
	private String texttoRender = "";
	@Override
	public int getWidth() {
		return font.getStringWidth(texttoRender);
	}

	@Override
	public int getHeight() {
		
	return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		texttoRender = mc.thePlayer.movementInput.getDisplayText();
		font.drawString(texttoRender, pos.getAbsoluteX(), pos.getAbsoluteY(), Rgb.getRainbow(4, 1, 1));
		
	}
	@Override
	public void renderDummy(ScreenPosition pos) {
		texttoRender = "[Toggle Sprint/ Sneak]  ";
		font.drawString(texttoRender, pos.getAbsoluteX(), pos.getAbsoluteY(), Rgb.getRainbow(4, 1, 1));
		
	}

	

}
