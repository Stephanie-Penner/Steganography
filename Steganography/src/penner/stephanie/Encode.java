package penner.stephanie;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Encode {
	/**
	 * Makes an image with a message encoded in the red-green-blue pixels.
	 * 
	 * @param filename  - the name of the file the encoded image is being created
	 *                  into.
	 * @param image     - the original image being encoded.
	 * @param msgBinary - the message being encoded into the image, as a string of
	 *                  binary.
	 */
	public static void makeCodedImage(String filename, String filetype, Image image, String msgBinary) {
		// Makes a list of the original rgb pixels in strings of binary from the image
		String[] rgbOld = image.getRGBBinary();

		// Initializes a variable for a string of binary representing a single pixel
		String origRGB;

		// Sets an array for the new strings of binary for each pixel encoded with the
		// message
		String[] rgbNew = rgbOld;

		// Loops through the message, encoding 2 bits of binary in each rgb pixel into
		// the list of new binary.
		for (int i = 0; i < msgBinary.length() / 2; i++) {
			origRGB = rgbOld[i];
			rgbNew[i] = origRGB.substring(0, origRGB.length() - 2) + msgBinary.substring(i * 2, i * 2 + 2);
			System.out.println(rgbNew[i]);
		}

		// Initializes an array for the string binary rgb values converted into ints.
		int[] rgbInts = new int[rgbOld.length];

		// Changes the strings of binary representing the rgb of each pixel into their
		// integer equivalent
		for (int i = 0; i < rgbNew.length; i++) {
			rgbInts[i] = (int) Long.parseLong(rgbNew[i], 2);
		}

		// Makes a new buffered imaged for encoded image, that takes the rgb values as
		// ints (TYPE_INT_RGB).
		BufferedImage imageEncoded = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

		// Sets the rgb values of new image to the encoded pixels.
		for (int h = 0; h < image.getHeight(); h++) {
			for (int w = 0; w < image.getWidth(); w++) {
				imageEncoded.setRGB(w, h, rgbInts[h * image.getWidth() + w]);
			}
		}

		// Makes an output file.
		File outputImage = new File(filename + "." + filetype);

		// Writes a file of type
		try {
			ImageIO.write(imageEncoded, filetype, outputImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Converts an arraylist of chars to binary form
	 * 
	 * @param message - message as a string
	 * @return String of binary - binary string of the message
	 */
	public static String makeBinary(String message) {
		char[] messageChar = message.toCharArray();
		String messageBinary = ""; // store the binary version of the msg

		for (int j = 0; j < messageChar.length; j++) {
			int decimal = (int) messageChar[j]; // decimal value of ascII
			String binaryVer = Integer.toBinaryString(decimal);

			// Make sure each character is 8 bits long to decode properly
			while (binaryVer.length() < 8) {
				// Make sure each binary is 8 characters long
				binaryVer = "0" + binaryVer;
			}

			// Append binary of characters to string
			messageBinary = messageBinary + binaryVer;

		}
		// 00011010 is the end of line character in binary
		messageBinary = messageBinary + "00011010";

		return messageBinary;
	}

	/**
	 * Takes a string of binary and converts it into an array of chars
	 * 
	 * @param messageBinary - String of message in binary
	 * @return messageChar - char array of message
	 */
	public static String makeChar(String messageBinary) {
		int i = 0; // Set a counter to use to substring the binary msg
		String messageChar = ""; // Store decrypted msg

		boolean exit = false; // Used to exit binary string when end of msg char is found

		// Continue decrypting until end of line char is reached
		while ((!(exit))) {
			
			// Get the 8-bits that rep the first char
			String binaryChar = messageBinary.substring(i * 8, i * 8 + 8);
			
			// If the end of line character is found, exit the decryption
			if (binaryChar.equals("00011010")) {
				exit = true;
			}

			int decimalVal = 0; // the decmial val of a letter.
			for (int j = 0; j < binaryChar.length(); j++) {
				if (binaryChar.substring(j, j + 1).equals("1")) {
					// Add to decimal value depending on which columns are on and off
					// in the binary string
					decimalVal += Math.pow(2, binaryChar.length() - j - 1);
				}
			}

			// Append characters to the decrypted message
			messageChar = messageChar + (char) decimalVal;
			i++; // increase counter
		}

		// return the decrypted msg without the end of msg character
		return messageChar.substring(0, messageChar.length() - 1);
	}
}
