package penner.stephanie;

import java.util.Arrays;
import java.util.Scanner;

public class TestDriver {

	public static void main(String[] args) {
		
		//Test code: user input msg, covert to char array
		// then convert to binary.
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		System.out.println(num);
		
		String memo = in.nextLine();
		
		char[] memoChar = memo.toCharArray();
		
		//Message memoA = new Message(memoChar);
		//memoA.toBinary(memoChar);
		
		
		
		//Testing images
		/*
		Image image = new Image("testImage.jpg");
		
		int[] rgbArray = image.getRGBValues();
		
		String test = Arrays.toString(rgbArray);
		
		System.out.println(test);
		
		for(int i = 0; i < 200; i++) {
			String binary = Integer.toBinaryString(rgbArray[i]);
			System.out.println(binary + ", " + rgbArray[i]);
			int k = (int) Long.parseLong(binary, 2);
			System.out.println(k);
		}
		*/
//hi
		

	}

}
