package apeclient.mods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import apeclient.Client;
import apeclient.Filemanager;
import apeclient.Event.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class BooleanTest {
	
	private boolean isEnabled;
	private String line;

	 public BooleanTest() {
			start();
			setEnabled(isEnabled);
		}
	 
	 
	 
	private File getFolder() throws IOException {
		File folder = new File("C:\\TestFolder\\Test.txt");
		if(!folder.exists())
		{
			folder.createNewFile();
		}
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
//if(line == "true") {
//			
//		boolean isEnabled = true;
//			this.isEnabled = isEnabled;
//		}
//		else {
//		boolean isEnabled = false;
//		this.isEnabled = isEnabled;
//		}
		
}
		 	
	public void save() {
		
		
//		
//			try {
//				Filemanager.writeJsonToFile(new File(getFolder(), "ModToggle.json"), isEnabled);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
	}
	

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
		save();
		
		if(line.equals("true")) {
			EventManager.register(this);	
		}
		else {
			EventManager.unregister(this);
		}
		
	}
		
	
	public boolean isEnabled() {
		return isEnabled;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BooleanTest mo = new BooleanTest();
		mo.setEnabled(false);
		mo.start();
	}

}
