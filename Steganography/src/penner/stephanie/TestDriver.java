package penner.stephanie;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class TestDriver {

	public static void main(String[] args) {
		String binaryMessage = "0101010101010";
		
		//File image = new File("testImage.jpg");
		
		Image test = new Image("testImage.jpg");


		Encode.makeCodedImage("hhhhhhh.jpg", test, binaryMessage);
		
		/*
		Encode.getRGB(binaryMessage, test);
		
		BufferedImage imageEncoded = new BufferedImage(250, 250, BufferedImage.TYPE_INT_RGB);
		
		int[] rgbTest = new int[250*250];
		
		for (int i = 0; i < 250; i++) {
			for(int j = 0; j < 125; j++) {
				rgbTest[j] = -2303200;
			}
			for(int j = 125; j < 250; j++) {
				rgbTest[j] = -6203200;
			}
		}
		
		imageEncoded.setRGB(0, 0, 250, 250, rgbTest, 0, 0);
		
		File outputImage = new File("white.jpg");
		
		try {
			ImageIO.write(imageEncoded, "jpg", outputImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
	

}
