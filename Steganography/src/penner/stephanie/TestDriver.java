package penner.stephanie;

import java.util.Arrays;
import java.util.Scanner;

public class TestDriver {

	public static void main(String[] args) {
		
		Image im = new Image("testImage.jpg");
		String binary = Arrays.toString(im.getMessageBinary());
		Message m = new Message(binary);
		
		
		Scanner in = new Scanner(System.in);
		String msg = in.nextLine(); //Get message to encode
		
		char[] chars = msg.toCharArray(); //Convert msg to char array
		Message c = new Message(chars); //Create msg using char array
		
		c.makeBinary(); //Make binary ver of msg
		
		//Print out binary ver of msg
		System.out.println(c.getBinary());
		
		
		
		
		
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
		
		/*
		//Testing images
		
		Image image = new Image("testImage.jpg");
		
		String[] rgbArray = image.getRGBValues();
		
		String[] testBinary = image.getMessageBinary();
		
		for (int i = 0; i < rgbArray.length; i++) {
			System.out.println(rgbArray[i]);
			if (i % 4 == 0) {
				System.out.println(testBinary[i/4]);
			}
			
		}*/
	}
	

}
