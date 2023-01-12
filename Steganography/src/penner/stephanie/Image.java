package penner.stephanie;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	private BufferedImage image;
	private int width;
	private int height;
	private int numPixels;
	private int [] rgbArray;
	
	Image(String fileName){
		try {
			image = ImageIO.read(new File(fileName));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		width = image.getWidth();
		height = image.getHeight();
		numPixels = width*height;
		rgbArray = getRGBValues();
	}
	
	public int[] getRGBValues(){
		int[] rgbArray = new int[numPixels];
		rgbArray = image.getRGB(0, 0, width, height, rgbArray, 0, width);
		return rgbArray;
	}
	
	public int getNumPixels() {
		return numPixels;
	}
	
	
}
