package apeclient.mods;

import java.io.File;

import apeclient.Filemanager;
import apeclient.gui.hud.IRender;
import apeclient.gui.hud.ScreenPosition;

public abstract class ModDraggable extends mod implements IRender {
	
	protected ScreenPosition pos;
	
	
	public ModDraggable() {
		pos = loadPositionFromFile();
		
	}

	@Override
	public ScreenPosition load() {
		
		return pos;
	}

	 @Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
		savePositionToFile();
		
	}
	 private File getFolder() {
		File folder = new File(Filemanager.getModsDirectory(), this.getClass().getSimpleName());
		folder.mkdirs();
		return folder;
	 }
	 private void savePositionToFile() {
		Filemanager.writeJsonToFile(new File(getFolder(), "pos.josn"), pos);
	}

	ScreenPosition loadPositionFromFile() {
			ScreenPosition loaded = Filemanager.redFromJson(new File(getFolder(), "pos.josn"), ScreenPosition.class);
			
			if(loaded == null) {
				loaded = ScreenPosition.fromRelativePosition(0.5, 0.5);
				this.pos = loaded;
				savePositionToFile();
			}
			return loaded;
		}
	
	public final int getLineOffset(ScreenPosition pos, int lineNum) {
		return pos.getAbsoluteY() + getLineOffset(lineNum);
	}
	private int getLineOffset(int lineNum) {
		return (font.FONT_HEIGHT + 3) * lineNum;
	}

}
