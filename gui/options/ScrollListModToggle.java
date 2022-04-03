package apeclient.gui.options;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import apeclient.gui.hud.HUDManager;
import apeclient.gui.hud.IRender;
import apeclient.mods.mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;

public class ScrollListModToggle extends GuiListExtended {

	private final List<ModEntry> entrys = new ArrayList<ModEntry>();

	public ScrollListModToggle(Minecraft mcIn, GuiModToggle inGui) {
		super(mcIn, inGui.width, inGui.height, 63, inGui.height - 32, 20);
		for(IRender r : HUDManager.getInstance().getRegisteredRenderers()) {
			if(r instanceof mod) {
				mod m = (mod)r;
				entrys.add(new ModEntry(inGui, m));
			}
		}
		 Collections.sort(this.entrys); 
	}

	@Override
	public IGuiListEntry getListEntry(int index) {
		return entrys.get(index);
	}

	@Override
	protected int getSize() {
		return entrys.size();
	}

}