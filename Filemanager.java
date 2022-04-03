package apeclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import com.google.gson.Gson;

import apeclient.gui.SplashProgress;

public class Filemanager {

	private static Gson gson = new Gson();
	
	private static File ROOT_DIR = new File("ApeClient");
	private static File MODS_DIR = new File(ROOT_DIR, "Mods");
	private static File MODS_ENABLED = new File(ROOT_DIR, "ModsEnabled");
	private static File UserName = new File(ROOT_DIR, "UserName");
	
	public static void init() {
		
		if(!ROOT_DIR.exists()) {
			ROOT_DIR.mkdirs();
		}
		if(!MODS_DIR.exists()) {
			MODS_DIR.mkdirs();
		}
		if(!MODS_ENABLED.exists()) {
			MODS_ENABLED.mkdirs();
		}
		if(!UserName.exists()) {
			UserName.mkdirs();
		}
		
		
	}
	public static Gson getGson() {
		return gson;
	}
	public static File getModsDirectory() {
		return MODS_DIR;
	}
	public static File getModsEnabledDirectory() {
		return MODS_ENABLED;
	}
	public static File getUserNameDirectory() {
		return UserName;
	}
	
	public static boolean writeJsonToFile(File file, Object obj) {
		
	
			try {
				if(!file.exists()) {
				file.createNewFile();
				
			}
				FileOutputStream outPutStream = new FileOutputStream(file);
				outPutStream.write(gson.toJson(obj).getBytes());
				outPutStream.flush();
				outPutStream.close();
				return true;
	}
			catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
	
	public static <T extends Object> T redFromJson(File file, Class<T> c) {
		
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			StringBuilder builder = new StringBuilder();
			String line;
			
			while((line = bufferedReader.readLine()) != null) {
				builder.append(line);
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
			
			return gson.fromJson(builder.toString(), c);
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	
		
		
		
	
	}


