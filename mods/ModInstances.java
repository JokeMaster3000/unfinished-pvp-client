package apeclient.mods;

import java.awt.Component;

import apeclient.gui.hud.HUDManager;

import apeclient.mods.impl.ModCPS;
import apeclient.mods.impl.ModFps;
import apeclient.mods.impl.ModFullbright;
import apeclient.mods.impl.ModHelloWorld;
import apeclient.mods.impl.ModPerspective;
import apeclient.mods.impl.ModPing;
import apeclient.mods.impl.ModPotionStatus;
import apeclient.mods.impl.ModRightClickCps;
//import apeclient.mods.impl.TargetHud;
import apeclient.mods.impl.togglesprintsneak.ModToggleSprintSneak;

public class ModInstances {
	

	private static ModHelloWorld modHelloWorld;
	private static ModFps modFps;
	private static ModToggleSprintSneak modToggleSprintSneak;
	private static ModCPS modCps;
	private static ModRightClickCps rightcps;
	
	private static ModPotionStatus modPotionStatus;
	private static ModPing modPing;
	private static ModFullbright modFullbright;
	//private static TargetHud targetHud;
	
	private static ModPerspective modPerspective;
	
	
	
	public static void register(HUDManager api) {
		modHelloWorld = new ModHelloWorld();
		api.register(modHelloWorld);
		modPotionStatus = new ModPotionStatus();
		api.register(modPotionStatus);
		
		modPing = new ModPing();
		api.register(modPing);
		

		modFps = new ModFps();
		api.register(modFps);
		
		modToggleSprintSneak = new ModToggleSprintSneak();
		api.register (modToggleSprintSneak);
		modFullbright = new ModFullbright();
		api.register (modFullbright);
	
	modCps = new ModCPS();
	api.register (modCps);
	rightcps = new ModRightClickCps();
	api.register (rightcps);
	modPerspective = new ModPerspective();
	api.register (modPerspective);
	
	
//	
//	targetHud = new TargetHud();
//	api.register (targetHud);
//	
	
	
}
	public static ModHelloWorld getModHelloWorld() {

		return modHelloWorld;
	}
	public static ModPing getModPing() {

		return modPing;
	}
	
	public static ModToggleSprintSneak getModToggleSprintSneak() {
		return modToggleSprintSneak;
	}
	
	public static ModPotionStatus getModPotionStatus() {
		return modPotionStatus;
	}
	public static ModFullbright geModFullbright() {

		return modFullbright;
	}
//	public static TargetHud getTargetHud() {
//
//		return targetHud;
//	}
//	
	public static ModPerspective getModPerspective() {
		
		return modPerspective;
	}
	
}
