package altuso.pong.graphics;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Sprites {
	
	public static BufferedImage background;
	
	public static void init() {
		
		try {
			InputStream is = ClassLoader.class.getResourceAsStream("/resources/space.png");
			background = ImageIO.read(is);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
		
}
