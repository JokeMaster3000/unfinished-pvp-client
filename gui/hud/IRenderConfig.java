package apeclient.gui.hud;

import org.lwjgl.opengl.XRandR.Screen;

public interface IRenderConfig {
	public void save(ScreenPosition pos);
	
	
	public ScreenPosition load();

}
