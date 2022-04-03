package apeclient.mods;

import java.awt.Color;

public class Rgb {
	float hue = (System.currentTimeMillis() % 3000) / 3000f;
	int color = Color.HSBtoRGB(hue, 1, 1);

	public static int getRainbow(float seconds, float saturation, float brightness) {
		
		float hue = (System.currentTimeMillis() % (int)(seconds * 1000)) / (float)(seconds * 1000);
		int color = Color.HSBtoRGB(hue, saturation, brightness);
		return color;
	}
}
