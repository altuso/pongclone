package altuso.pong.graphics;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Sprites {
	
	public static BufferedImage background;
	public static BufferedImage ball;
	
	public static void init() {
		
		try {
			InputStream is1 = ClassLoader.class.getResourceAsStream("/resources/space.png");
			background = ImageIO.read(is1);
			InputStream is2 = ClassLoader.class.getResourceAsStream("/resources/ball.png");
			ball = ImageIO.read(is2);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
		
}
