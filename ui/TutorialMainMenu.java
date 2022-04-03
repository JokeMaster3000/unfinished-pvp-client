package apeclient.ui;

import java.io.IOException;

import apeclient.Client;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.TransparentButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.GuiMainMenu;

public class TutorialMainMenu extends GuiScreen{
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("apeclient/MainMenuScreen.jpg"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	@Override
	public void initGui() {
		
		
		
		//this.buttonList.add(new GuiButton(1, 350, height / 2 + 250, 150 , 20, "Single Player"));
		this.buttonList.add(new TransparentButton(2, 500, height / 2 + 250, 150 , 20, "Online"));
		this.buttonList.add(new TransparentButton(3, 650, height / 2 + 250, 150 , 20,"Settings"));
	this.buttonList.add(new TransparentButton(4, 800, height / 2 + 250, 150, 20, "Quit"));
		
this.buttonList.add(new TransparentButton(1, 350, height / 2 + 250, 150 , 20, "Single Player"));
this.buttonList.add(new TransparentButton(0, 200, height / 2 + 250, 150 , 20, "Login"));


	super.initGui();
	}
@Override
protected void actionPerformed(GuiButton button) throws IOException {
if(button.id == 1) {
		mc.displayGuiScreen(new GuiSelectWorld(this));
}
if(button.id == 2) {
	mc.displayGuiScreen(new GuiMultiplayer(this));
}
if(button.id == 3) {
	mc.displayGuiScreen(new GuiOptions(this , mc.gameSettings));
}
if(button.id == 4) {
	mc.shutdown();
}
if(button.id == 0) {
	mc.displayGuiScreen(new LoginMenu());
}
	super.actionPerformed(button);
}
}
