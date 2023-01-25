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
	
	/**
	 * Creates an Image.
	 * @param fileName - the reference file name of the uploaded image file
	 */
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
	
	/**
	 * Gets an array of red-green-blue pixel values in binary from the image.
	 * @return - the array the rgb values of each pixel as a String of binary.
	 */
	public String[] getRGBBinary(){
		// Makes an empty array list for the rgb values to be placed in.
		int[] rgbArray = new int[numPixels];
		
		// gets the rgb values of the image and assigns them to the previous list.
		rgbArray = image.getRGB(0, 0, width, height, rgbArray, 0, width);
		
		// Makes a string containing the 2 LSBs of blue in the rgb pixel (the message).
		String[] rgbArrayBinary = new String[rgbArray.length];
		
		for(int i = 0; i < numPixels; i++) {
			String binary = Integer.toBinaryString(rgbArray[i]);
			rgbArrayBinary[i] = binary;
		}
		
		return rgbArrayBinary;
	}
	
	/**
	 * Gets the red-green-blue values of the pixels of the image as their integer value.
	 * @return - the array of rgb pixels as ints of type TYPE_INT_RGB.
	 */
	public int[] getRGBInts() {
		int[] rgbArray = new int[numPixels];
		return image.getRGB(0, 0, width, height, rgbArray, 0, width);
	}
	
	/**
	 * Gets the total number of pixels in the image.
	 * @return - the number of pixels in the image.
	 */
	public int getNumPixels() {
		return numPixels;
	}
	
	/**
	 * Calculates and returns the maximum message size a user can input
	 * into a message
	 * @return maximum message size
	 */
	public int getMaxMsgSize() {	
		//Max message is pixels /8 bc there's 8 bits per character
		return (numPixels/4)-1; // -1 because end of msg character is required
	}
	
	
	/**
	 * Gets the last 2 bits binary from the binary from each of the rgb values
	 * (2 LSBs of the blue pixel) which contains the binary of an encoded image.
	 * @return - a string of the binary of the message encrypted in an image.
	 */
	public String getMessageBinary() {
		
		String[] fullBinary = rgbBinary; // Makes a copy of the list of binary of the rgb values.
		
		// Makes a char array containing the 2 LSBs of blue in the rgb pixel (the message).
		char[] charMessage = new char[fullBinary.length*2];

		for (int i = 0; i < rgbBinary.length; i++) {
			int length = rgbBinary[i].length();
			charMessage[i*2] = rgbBinary[i].charAt(length-2);
			charMessage[i*2 + 1] = (char) rgbBinary[i].charAt(length-1);
		}
		
		// Turns the char array of binary into a string.
		String message = String.valueOf(charMessage);
		
		return message;
	}
	
	/**
	 * Gets the height of the image.
	 * @return - the height of the image.
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Gets the height of the image.
	 * @return - the width of the image
	 */
	public int getWidth() {
		return width;
	}
	
}
