package penner.stephanie;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Encode {
	/**
	 * 
	 * @param binaryMessage
	 * @param image
	 * @return - ints of binary of pixels with encoded message.
	 */
	private static int[] getRGB(String binaryMessage, Image image) {
		String[] rgbBinary = image.getRGBValues();
		String origRGB;
		
		for (int i = 0; i < binaryMessage.length()/2; i++) {
			origRGB = rgbBinary[i];
			rgbBinary[i] = origRGB.substring(0, origRGB.length()-2) + binaryMessage.substring(i*2, i*2 + 2);
		}
		
		int[] rgbInts = new int[rgbBinary.length];
		
		for (int i = 0; i < rgbBinary.length; i++) {
			rgbInts[i] = (int) Long.parseLong(rgbBinary[i], 2);
		}
		
		return rgbInts;
	}
	
	public static void makeCodedImage (String filename, Image image, String messageBinary) {
		BufferedImage imageEncoded = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		imageEncoded.setRGB(0, 0, image.getWidth(), image.getHeight(), getRGB(messageBinary, image), 0, 0);
		
		File outputImage = new File(filename);
		
		try {
			ImageIO.write(imageEncoded, "jpg", outputImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
