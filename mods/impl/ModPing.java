package apeclient.mods.impl;

import apeclient.gui.hud.ScreenPosition;
import apeclient.mods.ModDraggable;
import apeclient.mods.Rgb;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.server.MinecraftServer;

public class ModPing extends ModDraggable {
    @Override
    public int getWidth() {
        return font.getStringWidth("[00 ms]");
    }
    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }
    @Override
    public void render(ScreenPosition pos) {
        if(!MinecraftServer.getServer().isSinglePlayer()) {
            font.drawStringWithShadow("[" + mc.getCurrentServerData().pingToServer + " ms]", pos.getAbsoluteX(), pos.getAbsoluteY(), Rgb.getRainbow(4, 1, 1));
        } else {
            font.drawStringWithShadow("[0 ms]", pos.getAbsoluteX(), pos.getAbsoluteY(), Rgb.getRainbow(4, 1, 1));
        }
    }
}
