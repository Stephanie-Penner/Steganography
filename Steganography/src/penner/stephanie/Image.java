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
		rgbBinary = getRGBBinary();
	}
	
	public String[] getRGBBinary(){
		int[] rgbArray = new int[numPixels];
		rgbArray = image.getRGB(0, 0, width, height, rgbArray, 0, width);
		String[] rgbArrayBinary = new String[rgbArray.length];
		
		for(int i = 0; i < numPixels; i++) {
			String binary = Integer.toBinaryString(rgbArray[i]);
			rgbArrayBinary[i] = binary;
		}
		return rgbArrayBinary;
	}
	
	public int[] getRGBInts() {
		int[] rgbArray = new int[numPixels];
		return image.getRGB(0, 0, width, height, rgbArray, 0, width);
	}
	
	public int getNumPixels() {
		return numPixels;
	}
	
	public int[] testMethod() {
		int[] rgbArray = new int[numPixels];
		rgbArray = image.getRGB(0, 0, width, height, rgbArray, 0, width);
		System.out.println(rgbArray[0]);
		return rgbArray;
	}
	
	
	/**
	 * Get the last 2 bits from the blue binary code (the encrypted msg)
	 * and put it into groups of 8 bits (8 bits = 1 char in encrypted msg)
	 * and return it as a new array of binary strings
	 * @return
	 */
	public String getMessageBinary() {
		String[] fullBinary = rgbBinary;
		char[] charMessage = new char[fullBinary.length*2];
		
		for (int i = 0; i < rgbBinary.length; i++) {
			int length = rgbBinary[i].length();
			charMessage[i*2] = rgbBinary[i].charAt(length-2);
			charMessage[i*2 + 1] = (char) rgbBinary[i].charAt(length-1);
		}
		
		String message = String.valueOf(charMessage);
		
		return message;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
}
