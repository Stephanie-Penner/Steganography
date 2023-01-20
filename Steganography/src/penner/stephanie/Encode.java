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

}
