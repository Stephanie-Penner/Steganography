package penner.stephanie;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class TestDriver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the file name: ");
		String fName = in.nextLine();
		
		Image test = new Image(fName);
		
		test.getNumPixels();
		
		String f = "a`";
		String binaryF = Encode.makeBinary(f);
		System.out.println("binaryF: " + binaryF);
		
		System.out.format("Message has a maximum character limit of %d characters.", test.getMaxMsgSize());
		
		System.out.println("What is your message?");
		String message = in.nextLine();
		
		String binary = Encode.makeBinary(message);
		char[] chars = Encode.makeChar(binary);
		System.out.println("chars: " + Arrays.toString(chars));
		System.out.println("binary: " + binary);
		
		Encode.makeCodedImage("iwanttosleeEp.png", test, binary);
		
		String binaryMessage = "0101010101010";
		

		Encode.makeCodedImage("hhhhhhh.jpg", test, binaryMessage);		//Test code: user input msg, covert to char array

	}
}
