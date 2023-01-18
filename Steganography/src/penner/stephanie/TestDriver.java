package penner.stephanie;

import java.util.Arrays;
import java.util.Scanner;

public class TestDriver {

	public static void main(String[] args) {
		
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
		
		Image image = new Image("testImage.jpg");
		
		//String[] rgbArray = image.getRGBValues();
		
		String testBinary = image.getMessageBinary();
		
		System.out.println(testBinary);
		System.out.println("done");
			
		
	}
	

}
