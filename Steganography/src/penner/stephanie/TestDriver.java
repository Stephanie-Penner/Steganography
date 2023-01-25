package penner.stephanie;

import java.util.Scanner;

public class TestDriver {

	public static void main(String[] args) throws Exception{

		Scanner in = new Scanner(System.in);
		int choice = displayIntro(in); // Display intro UI and get user choice

		if (choice == 1) { // if user chose to encrypt a message
			String fName = getRefName(in);
						
			// get new file name
			System.out.print("What will be the new file name: ");
			String makeName = in.nextLine();
			
			// get new file type
			System.out.print("What is the new file type to make (without \".\"): ");
			String makeType = in.nextLine();
			
			// make the given picture as an Image 
			Image test = new Image(fName);
			
			// get the maximum num of characters for the message, and then ask 
			// the user for a message
			int maxChars = test.getMaxMsgSize();
			System.out.format("Message has a maximum character limit of %d characters.", 
					maxChars);
			String message = "";

			// If the message is too long, keep asking for a shorter one
			while ((message.length() <= 0) || (maxChars < message.length())) {
				System.out.println("\nWhat is your message?");
				message = in.nextLine();

				if (maxChars < message.length()) {
					System.out.format("Your message is too long by %d characters \n", 
							message.length() - maxChars);
				}
			}
			
			// get the binary version of the message
			String binary = Encode.makeBinary(message);

			// make an encoded image with the binary version of the message
			Encode.makeCodedImage(makeName, makeType, test, binary);
			System.out.println("Image encrypted."); //Tell user the program finished
		}

		if (choice == 2) {
			// ask for and get the file name to decrypt
			String fNameDecrypt = getRefName(in);
			
			// make the picture to decrypt as an Image
			Image toDecrypt = new Image(fNameDecrypt);
			String binary = toDecrypt.getMessageBinary(); // get the binary ver of the msg
			
			// get the decrypted version of the message
			String decryptedMsg = Encode.makeChar(binary);

			// print out the decrypted message
			System.out.println("The decrypted message is: ");
			System.out.println(decryptedMsg);
		}
	}

	/**
	 * Displays the UI start of the program; the greeting and user choice to either
	 * encrypt or decrypt a message into an image.
	 * 
	 * @param in - Scanner
	 * @return choice - user choice to encrypt/decrypt
	 */
	public static int displayIntro(Scanner in) {
		System.out.println("Steganography program");
		System.out.println("Please have an image to encrypt uploaded. \n");

		int choice = 0; //Store user choice

		while ((choice != 1) && (choice != 2)) {
			try {
				System.out.println("To encrypt a message, enter 1." 
						+ "\nTo decrypt a message, enter 2.");
				choice = in.nextInt();
				in.nextLine();

			} catch (Exception e) {
				System.out.println("Please enter either a valid integer (1 or 2).");
				in.nextLine();
			}
		}
		return choice;
	}
	
	public static String getRefName(Scanner in) {
		String fName = "";
		boolean invalid = true; // use to loop for a valid image name from user
		
		while(invalid) {
			try {
				// get reference file name
				System.out.print("What is the reference image file name (include filetype, "
						+ "ex. \".png\"): ");
				fName = in.nextLine();
				
				// check if the image exists, if it doesn't then exception will be thrown 
				Image existing = new Image(fName);
				invalid = false; // given file name is valid, exit loop
				
			}catch(Exception e) { 
				System.out.println("Please enter a valid file name.");
			}	
		}
		
		return fName;
	}
	
}