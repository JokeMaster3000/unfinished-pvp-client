//package apeclient.mods.impl;
//
//import java.io.IOException;
//
//import apeclient.gui.hud.ScreenPosition;
//import apeclient.mods.ModDraggable;
//import net.minecraft.client.gui.FontRenderer;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityLivingBase;
//
//public class TargetHud extends ModDraggable{
//
//	FontRenderer fr;
//	EntityLivingBase target;
//	@Override
//	public int getWidth() {
//		// TODO Auto-generated method stub
//		return 100;
//	}
//
//	@Override
//	public int getHeight() {
//		// TODO Auto-generated method stub
//		return 50;
//	}
//
//	@Override
//	public void render(ScreenPosition pos) {
//		renderTargetHud();
//	}
//	
//	private void renderTargetHud() {
//		target = (EntityLivingBase)mc.pointedEntity;
//		
//		 if(target != null) {
//			fr.drawStringWithShadow(target.getName(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
//		
//	}
//
//	}
//
//}
