package apeclient.mods;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.core.appender.FileManager;

import apeclient.Client;
import apeclient.Filemanager;
import apeclient.Event.EventManager;
import apeclient.Event.EventTarget;
import apeclient.gui.hud.ScreenPosition;
import javafx.util.converter.IntegerStringConverter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class mod {

	private boolean isEnabled;
	protected final Minecraft mc;
	protected final FontRenderer font;
	protected final Client client;
	private String line;

	 public mod() {
			this.mc =Minecraft.getMinecraft();
			this.font =this.mc.fontRendererObj;
			this.client =Client.getInstance();
			start();
			
				setEnabled(isEnabled);
			
			
		}
	 
	 
	 
	private File getFolder() {
		File folder = new File(Filemanager.getModsDirectory(), this.getClass().getSimpleName());
		folder.mkdirs();
		return folder;
		
	 }
	public void start() {
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(getFolder()));
     		line = reader.readLine();
			if(line.equals("true"))
			{
				isEnabled = true; 
			}
			else
			{
				isEnabled = false; 
			}
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();	
		}

}
		 	
	public  void save() {
		Filemanager.writeJsonToFile(new File(getFolder(), "ModToggle.json"), isEnabled);
		

	}
	  
	

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
		try {
		if(line == null) {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(getFolder()));
			line = reader.readLine();
		}

		if(line.equals("true")) {
			EventManager.register(this);	
		}
		else {
			EventManager.unregister(this);
		}
		save();
		}catch(IOException e) {
		e.printStackTrace();
	}
	}
		
	
	public boolean isEnabled() {
		return isEnabled;
	}
	
	
}

