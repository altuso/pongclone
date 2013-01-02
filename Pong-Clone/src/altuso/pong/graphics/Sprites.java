package altuso.pong.graphics;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Sprites {
	
	public static BufferedImage background;
	
	public static void init() {
		
		try {
			background = ImageIO.read(new File(Sprites.class.getResource("/resources/space.png").getFile()));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
		
}
