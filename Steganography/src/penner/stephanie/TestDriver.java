package penner.stephanie;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.w3c.dom.ls.LSOutput;

public class TestDriver {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int choice = displayIntro(in);		
		
		if (choice == 1) {
			System.out.print("What is the reference image file name: ");
			String fName = in.nextLine();

			System.out.println("What will be the new file name: ");
			String makeName = in.nextLine();
			
			System.out.print("What is the new file type to make: ");
			String makeType = in.nextLine();
			
			Image test = new Image(fName);
			
			int maxChars = test.getMaxMsgSize();
			System.out.format("Message has a maximum character limit of %d characters.", maxChars);
			String message = "";
			
			//If the message is too long, keep asking for a shorter one
			while((message.length() <= 0) || (maxChars < message.length())){	
				System.out.println("What is your message?");
				message = in.nextLine();
				
				if(maxChars < message.length()) {
					System.out.format("Your message is too long by %d characters \n", message.length() - maxChars);
				}
			}		
			
			String binary = Encode.makeBinary(message);
			
			Encode.makeCodedImage(makeName, makeType, test, binary);	
			} 
		
		if(choice == 2) {
			System.out.println("What is the filename of the image to decrypt? ");
			String fNameDecrypt = in.nextLine();
			
			Image toDecrypt = new Image(fNameDecrypt);
			String binary = toDecrypt.getMessageBinary();
			
			String decryptedMsg = Encode.makeChar(binary);
			
			System.out.println("The decrypted message is: ");
			System.out.println(decryptedMsg);
			
			//System.out.println(Arrays.toString(decryptedMsg[2));
		}
	}
	
	public static int displayIntro(Scanner in) {
		System.out.println("Steganography program");
		System.out.println("Please have an image to encrypt into uploaded. \n");
		
		int choice = 0;
		
		while((choice != 1) && (choice != 2)) {
			try {	
				System.out.println("To encrypt a message, enter 1."
						+ "\nTo decrypt a message, enter 2.");
				choice = in.nextInt();
				in.nextLine();
				
			} catch(Exception e) {
				System.out.println("Please enter either 1 or 2.");
				in.nextLine();
			}
		}
		return choice;
	}

}
