package penner.stephanie;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Encode {
	/**
	 * Makes an image with a message encoded in the red-green-blue pixels.
	 * @param filename - the name of the file the encoded image is being created into.
	 * @param image - the original image being encoded.
	 * @param msgBinary - the message being encoded into the image, as a string of binary.
	 */
	public static void makeCodedImage (String filename, Image image, String msgBinary) {
		// Makes a list of the original rgb pixels in strings of binary from the image
		String[] rgbOld = image.getRGBBinary();
		
		// Initializes a variable for a string of binary representing a single pixel
		String origRGB;
		
		// Sets an array for the new strings of binary for each pixel encoded with the message
		String[] rgbNew = rgbOld;
		
		// Loops through the message, encoding 2 bits of binary in each rgb pixel into the list of new binary.
		for (int i = 0; i < msgBinary.length()/2; i++) {
			origRGB = rgbOld[i];
			rgbNew[i] = origRGB.substring(0, origRGB.length()-2) + msgBinary.substring(i*2, i*2 + 2);
			System.out.println(rgbNew[i]);
		}
		
		// Initializes an array for the string binary rgb values converted into ints.
		int[] rgbInts = new int[rgbOld.length];
		
		// Changes the strings of binary representing the rgb of each pixel into their integer equivalent
		for (int i = 0; i < rgbNew.length; i++) {
			rgbInts[i] = (int) Long.parseLong(rgbNew[i], 2);
		}
		
		// Makes a new buffered imaged for encoded image, that takes the rgb values as ints (TYPE_INT_RGB).
		BufferedImage imageEncoded = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		// Sets the rgb values of new image to the encoded pixels.
		for (int h = 0; h < image.getHeight(); h++) {
			for (int w = 0; w < image.getWidth(); w++) {
				imageEncoded.setRGB(w, h, rgbInts[h*image.getWidth() + w]);
			}
		}
		
		// Makes an output file.
		File outputImage = new File(filename);
		
		// Writes a file of type 
		try {
			ImageIO.write(imageEncoded, "jpg", outputImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Converts an arraylist of chars to binary form
	 * @param message - message as a string 
	 * @return String of binary - binary string of the message
	 */
	public static String makeBinary(String message) {
		char[] messageChar = message.toCharArray();
		String messageBinary = "";
		
		for(int j = 0; j < messageChar.length; j ++) {
			
			//--------------DEBUG
			System.out.println("messageChar[j]: " + messageChar[j]);
			
			int decimal = (int) messageChar[j]; // decimal value of ascII
			String binaryVer = Integer.toBinaryString(decimal);
			
			//Make sure each character is 8 bits long to decode properly
			while(binaryVer.length() < 8) {
				binaryVer = "0" + binaryVer;
			}
			
			//--------DEBUG
			System.out.println("binaryVer: "+ binaryVer);
			
			messageBinary = messageBinary + binaryVer;
			
		}
		return messageBinary;
	}	
	
	
	/**
	 * Takes a string of binary and converts it into an array of chars
	 * @param messageBinary - String of message in binary
	 * @return messageChar - char array of message
	 */
	public static char[] makeChar(String messageBinary) {
		int msgLength = messageBinary.length()/8;
		char[] messageChar = new char[msgLength];
		
		for (int i = 0; i < (msgLength); i ++) {
			//Get the 8-bits that rep the first char
			String binaryChar = messageBinary.substring(i*8, i*8 + 8);
			
			int decimalVal = 0;
			for (int j = 0; j < binaryChar.length(); j++) {
				//int binaryColVal = (int) (Math.pow(2,  i));
				
				if(binaryChar.substring(j, j + 1).equals("1")) {
					decimalVal += Math.pow(2, binaryChar.length() - j - 1);
				}
			}
			//Decimal val is now the decmial val of a letter.
			messageChar[i] = (char)decimalVal;
		}
		return messageChar;
	}
	
}
