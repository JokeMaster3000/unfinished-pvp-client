//package apeclient;
//
////import apeclient.http.HTTPFunctions;
//import apeclient.http.gsonobj.ObjUserCosmetics;
//import net.minecraft.client.entity.AbstractClientPlayer;
//
//public class CosmeticController {
//	
//	private static ObjUserCosmetics[] userCosmetics;
//	public static boolean shouldRenderTopHat(AbstractClientPlayer player) {
//		ObjUserCosmetics uc = getCosmetics(player);
//		if(uc == null) {
//			return false;
//		}
//		return uc.getHat().isEnabled();
//	}
//	public static float[] gettopHatColor(AbstractClientPlayer player) {
//		
//	
//		ObjUserCosmetics uc = getCosmetics(player);
//		if(uc == null) {
//			return new float[] {
//					0, 0, 1
//			};}
//			return uc.getHat().getColor();
//	
//	}
//	public static boolean shouldRenderEyes(AbstractClientPlayer player) {
//		ObjUserCosmetics uc = getCosmetics(player);
//		if(uc == null) {
//			return false;
//		}
//		return uc.isGooglyEyesEnabled();
//	}
//	private static ObjUserCosmetics getCosmetics(AbstractClientPlayer player) {
//		for(ObjUserCosmetics uc : userCosmetics) {
//			if(player.getGameProfile().getId().equals(uc.getUuid())) {
//				return uc;
//			}
//		}
//		return null;
//	}
////	public static void downloadUserCosmetics() {
////		
////		userCosmetics = HTTPFunctions.downloadUserCosmetics();
////	}
//
//}
