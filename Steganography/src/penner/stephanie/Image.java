package penner.stephanie;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Image {
	private BufferedImage image;
	private int width;
	private int height;
	private int numPixels;
	private String[] rgbBinary;
	
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
		rgbBinary = getRGBValues();
	}
	
	public String[] getRGBValues(){
		int[] rgbArray = new int[numPixels];
		rgbArray = image.getRGB(0, 0, width, height, rgbArray, 0, width);
		String[] rgbArrayBinary = new String[rgbArray.length];
		
		for(int i = 0; i < numPixels; i++) {
			String binary = Integer.toBinaryString(rgbArray[i]);
			rgbArrayBinary[i] = binary;
		}
		return rgbArrayBinary;
	}
	
	public int getNumPixels() {
		return numPixels;
	}
	
	/**
	 * Get the last 2 bits from the blue binary code (the encrypted msg)
	 * and put it into groups of 8 bits (8 bits = 1 char in encrypted msg)
	 * and return it as a new array of binary strings
	 * @return
	 */
	public String getMessageBinary() {
		String[] fullBinary = rgbBinary;
		
		String charBinary;
		String message = "";
		System.out.println("inMsgBinary");
		
		for (int i = 0; i < fullBinary.length; i++) {
			charBinary = fullBinary[i].substring(fullBinary[i].length()-2);
			message += charBinary;
		}
		
		return message;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
}
