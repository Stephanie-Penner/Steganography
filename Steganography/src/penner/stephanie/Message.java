package penner.stephanie;

/**
 * A Message is a type that stores the user-given memo 
 * in a char and int array, and string format.
 * Contains methods to convert to each format.
 * 
 * @author jenny
 *
 */
public class Message {
	private char[] messageChar;
	private String[] messageBinary;
	private String message;
	
	/**
	 * Takes a user-inputted message in ASCII form
	 * and creates a version of type Message.
	 * This constructor is used in encrypting a message.
	 * @param message
	 */
	Message(char[] memoC){
		messageChar = memoC;
		messageBinary = new String[memoC.length]; 
	}
	
	/**
	 * Takes a user-inputed message in binary form
	 * and creates a version of type Message.
	 * This constructor is used in decrypting a message.
	 * @param message
	 */
	Message(String[] memoB) {
		messageChar = new char[memoB.length];
		messageBinary = memoB;
	}
	
	/**
	 * Converts an array of chars into binary
	 * @param chars - array of chars
	 * @return array of binary version of chars
	 */
	public String[] toBinary(char[] chars) {

		String[] binary = new String[chars.length];
		
		for(int j = 0; j < chars.length; j ++) {
			int ascII = (int) chars[j];
			
			
			int ascIIrem = ascII; // remaining value of ascII
			String binaryNum = ""; // Binary num
			
			for (int i = 6; i > -1; i--) {
				int binaryColVal = (int) (Math.pow(2,  i));
				if(ascIIrem > binaryColVal) {
					ascIIrem = ascIIrem - binaryColVal;
					binaryNum = binaryNum + "1"; //Col active
				}
				binaryNum = binaryNum + "0"; //Column inactive
			}
			
			binary[j] = binaryNum;
		}
		return binary;
	}


	
	/**
	 * Grab the LSBs from a array of the rgb pixels containing the 
	 * message from the modified image and convert them to the 
	 * message in binary
	 * @param memoBinary
	 */
	public String[] getBits(String[] memoBinary) {
		String[] memoBits = new String[memoBinary.length];
		String binaryNum = "";
		int countBinNum = 0;
		
		for(int i = 0; i < memoBinary.length; i++) {
			String binaryBit = memoBinary[i];
			//Slice for last char, build 7 then convert to a char
			
			
			// build 7 digits:
			if ((i + 1) % 7 == 0) {
				//Convert binaryNum to a char
				memoBits[countBinNum] = binaryNum;
				binaryNum = "";
			}
			
			//TO DO: get LSB and then binary the way through
			//TO DO: fill in each slot with binary form
		}
		
		return memoBits;
	}
	
	/**
	 * Gets and returns the binary form of a memo
	 * @param binaryMsg
	 * @return memo in binary form
	 */
	public String[] getBinary(char[] binaryMsg) {
		return messageBinary;
	}
	
	/**
	 * Gets and returns the char form of a memo
	 * @param binaryMsg
	 * @return memo in char form
	 */
	public char[] getChar(int[] charMsg) {
		return messageChar;
	}
	
	
	
	
}
