package apeclient.mods.impl;

import java.awt.Button;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;


import apeclient.gui.hud.ScreenPosition;
import apeclient.mods.ModDraggable;
import apeclient.mods.ModInstances;
import net.minecraft.client.Minecraft;

public class ModPerspective extends ModDraggable {

	

	private static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean returnOnRelease = false;
	public static boolean perspectiveToggled = false;
	private static float cameraYaw = 0F;
	private static float cameraPitch = 0F;
	private static int previousPerspective = 0;
	private static int intt = 0;
	
	 public void onKeyPress()
	{
		if (Keyboard.getEventKey() == mc.gameSettings.CLIENT_PERSPECTIVE.getKeyCode() && ModInstances.getModPerspective().isEnabled())
		{
			
			if(mc.gameSettings.CLIENT_PERSPECTIVE.isPressed()) {
				perspectiveToggled = true;
				previousPerspective = mc.gameSettings.thirdPersonView;
			}
			
			if(mc.gameSettings.CLIENT_PERSPECTIVE.isKeyDown()) {
				perspectiveToggled = true;
				mc.gameSettings.thirdPersonView = 1;
				cameraYaw = mc.thePlayer.rotationYaw;
				cameraPitch = mc.thePlayer.rotationPitch;
			} else if
			
			(!mc.gameSettings.CLIENT_PERSPECTIVE.isKeyDown() && perspectiveToggled) {
				perspectiveToggled = false;
				mc.gameSettings.thirdPersonView = previousPerspective;
			}
			

	}}

	public static float getCameraYaw()
	{
		return perspectiveToggled ? cameraYaw : mc.thePlayer.rotationYaw;
	}

	public static float getCameraPitch()
	{
		return perspectiveToggled ? cameraPitch : mc.thePlayer.rotationPitch;
	}

	public static boolean overrideMouse()
	{
		if (mc.inGameHasFocus && Display.isActive())
		{
			if (!perspectiveToggled)
			{
				return true;
			}

			// CODE
			mc.mouseHelper.mouseXYChange();
			float f1 = mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
			float f2 = f1 * f1 * f1 * 8.0F;
			float f3 = (float) mc.mouseHelper.deltaX * f2;
			float f4 = (float) mc.mouseHelper.deltaY * f2;

			cameraYaw += f3 * 0.15F;
			cameraPitch += f4 * 0.15F;

			if (cameraPitch > 90) cameraPitch = 90;
			if (cameraPitch < -90) cameraPitch = -90;
		}

		return false;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void render(ScreenPosition pos) {
		// TODO Auto-generated method stub
		
	}
	

}
