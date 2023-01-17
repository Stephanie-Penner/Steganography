package penner.stephanie;

public class Encode {
	private int[] getRGB(String binaryMessage, Image image) {
		String[] rgbBinary = image.getRGBValues();
		
		for (int i = 0; i < binaryMessage.length(); i++) {
			String origRGB = rgbBinary[i];
			rgbBinary[i] = origRGB.substring(0, origRGB.length()-2) + binaryMessage.substring(i*2, i*2 + 2);
		}
		
		int[] rgbInts = new int[rgbBinary.length];
		
		for (int i = 0; i < rgbBinary.length; i++) {
			rgbInts[i] = (int) Long.parseLong(rgbBinary[i], 2);
		}
		
		return rgbInts;
	}
	
	public void makeCodedImage (String filename) {
		
	}

}
