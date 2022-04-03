package apeclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.core.appender.FileManager;

import apeclient.Event.EventManager;
import apeclient.Event.EventTarget;
import apeclient.Event.impl.ClientTickEvent;
import apeclient.gui.SplashProgress;
import apeclient.gui.hud.HUDManager;
import apeclient.gui.options.GuiModToggle;
import apeclient.mods.ModInstances;
import apeclient.mods.impl.quickplay.ModQuickPlay;
import apeclient.ui.LoginMenu;
import apeclient.util.SessionChanger;
import net.minecraft.client.Minecraft;

public class Client {
	 private ModQuickPlay modQuickPlay;
	 
	public String NAME = "Tutorial";
	String mail;
	String password;
	private static final Client INSTANCE = new Client();
	
	
	private File getFolder() {
		File folder = new File(Filemanager.getUserNameDirectory(), "LoginMenu");
		folder.mkdirs();
		return folder;
		
	 }
	public void load() {
		BufferedReader reader;
		BufferedReader readermail;
		
		
		try {
			reader = new BufferedReader(new FileReader("ApeClient\\UserName\\LoginMenu\\Password.json"));
			readermail = new BufferedReader(new FileReader("ApeClient\\UserName\\LoginMenu\\UserName.json"));
			 mail = readermail.readLine();
			 password = reader.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
		
		
		
		
	}
	
	public static final Client getInstance() {
	return INSTANCE;
	}
	
	private discordrp discordRp = new discordrp();
	
	
	private HUDManager hudmanager;
	
	
	
	public void init() {
		
		Filemanager.init();
		SplashProgress.setProgress(1, "Client starting");
		discordRp.start();
		EventManager.register(this);
		
		
		
		
//		CosmeticController.downloadUserCosmetics();
		
	}
	
	public void start(){
		
	hudmanager = HUDManager.getInstance();
	ModInstances.register(hudmanager);
	
	
	
	SessionChanger.getInstance().setUser(mail, password);

	}

public void shutdown() {
	discordRp.shutdown(); 
}
public discordrp getDiscordRp() {
	return discordRp;
}

@EventTarget
public void ontTick(ClientTickEvent e) {
	if(Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
		hudmanager.openConfigScreen();
		
	}
	if(Minecraft.getMinecraft().gameSettings.CLIENT_QUICKPLAY.isPressed()) {
		hudmanager.openModQuickplay();
		
	}
	if(Minecraft.getMinecraft().gameSettings.GUI_MOD_TOGGLE.isPressed()) {
		hudmanager.openGuiModToggle();
		
	}
//	if(Minecraft.getMinecraft().gameSettings.GUI_COSMETIC_TOGGLE.isPressed()) {
//		hudmanager.openGuiCosmeticsToggle();
//		
//	}
	
	

	
	
	
	
}
}

