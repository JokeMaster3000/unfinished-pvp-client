package apeclient.gui.hud;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Sets;

import apeclient.Event.EventManager;
import apeclient.Event.EventTarget;
import apeclient.Event.impl.RenderEvent;
//import apeclient.cosmetics.toggleGui.GuiCosmeticsToggle;
import apeclient.gui.options.GuiModToggle;
import apeclient.mods.impl.quickplay.ModQuickPlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;

public class HUDManager {
	ModQuickPlay modQuickPlay;
	private HUDManager() {}
	
	private static HUDManager instance = null;
	public static HUDManager getInstance() {
		if(instance != null) {
			return instance;
		}
		instance = new HUDManager();
		EventManager.register(instance);
		
		return instance;
	}
	private Set<IRender> registeredRenderers = Sets.newHashSet();
	private Minecraft mc = Minecraft.getMinecraft();
	

	public void register(IRender...renders) {
		for(IRender render : renders) {
		this.registeredRenderers.add(render);
		}
	}
	public void unregister(IRender...renders) {
		for(IRender render : renders) {
		this.registeredRenderers.remove(render);
		}
	}

	public Collection<IRender> getRegisteredRenderers() {
		return Sets.newHashSet(registeredRenderers);
	}
	public void openConfigScreen() {
		mc.displayGuiScreen(new HUDConfigScreen(this));
	}
	public void openModQuickplay() {
		
		mc.displayGuiScreen(new ModQuickPlay(modQuickPlay));
	}
	public void openGuiModToggle() {
		mc.displayGuiScreen(new GuiModToggle());
	}
//	public void openGuiCosmeticsToggle() {
//		mc.displayGuiScreen(new GuiCosmeticsToggle());
	//}
	@EventTarget
	
	public void onRender(RenderEvent e) {
		if(mc.currentScreen == null || mc.currentScreen instanceof GuiContainer || mc.currentScreen instanceof GuiChat) {
			for(IRender renderer : registeredRenderers) {
				callRenderer(renderer);
			}
		}
	}
	private void callRenderer(IRender renderer) {
		
		if(!renderer.isEnabled()) {
			return;
		}
		ScreenPosition pos = renderer.load();
		
		if(pos == null) {
			pos = ScreenPosition.fromRelativePosition(0.5, 0.5);
			
		}
		renderer.render(pos);
	}
	
	
}
