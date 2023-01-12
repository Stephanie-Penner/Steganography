package penner.stephanie;

import java.util.Arrays;

public class TestDriver {

	public static void main(String[] args) {
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
//hi
		
	}

}
