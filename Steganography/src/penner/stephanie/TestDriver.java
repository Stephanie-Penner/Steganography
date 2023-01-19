package penner.stephanie;

import java.util.Arrays;
import java.util.Scanner;

public class TestDriver {

	public static void main(String[] args) {
		
		// Jenny Testing: Encrypt and decrypt message from characters to binary
		//Image im = new Image("testImage.jpg");
		//String binary = im.getMessageBinary();
		//Message m = new Message(binary);
		
		
		Scanner in = new Scanner(System.in);
		String msg = in.nextLine(); //Get message to encode
		Message c = new Message(msg.toCharArray()); //Create msg using char array
		c.makeBinary(); //Make binary ver of msg
		
		System.out.println(c.getBinary());
		
		//If given a string of binary, get the Print out binary ver of msg
		Message b = new Message(c.getBinary());
		b.makeChar();
		
		System.out.println("Message b" + b.getBinary());
		System.out.println(Arrays.toString(b.getChar()));
		
		
		
		
		
		/*
		//Test code: user input msg, covert to char array
		// then convert to binary.
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		System.out.println(num);
		
		String memo = in.nextLine();
		
		char[] memoChar = memo.toCharArray();
		
		//Message memoA = new Message(memoChar);
		//memoA.toBinary(memoChar);
		
		*/
		
		
		//Testing images
		
		/**
		 * Image image = new Image("testImage.jpg");
		
		//String[] rgbArray = image.getRGBValues();
		
		String testBinary = image.getMessageBinary();
		
		System.out.println(testBinary);
		System.out.println("done");
		 */
		
			
		
	}
	

}
