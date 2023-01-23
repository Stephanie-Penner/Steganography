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
	private String messageBinary;
	//private String message;
	
	/**
	 * Takes a user-inputted message in ASCII form
	 * and creates a version of type Message.
	 * This constructor is used in encrypting a message.
	 * @param message
	 */
	Message(char[] memoC){
		messageChar = memoC;
		messageBinary = ""; 
	}
	
	/**
	 * Takes a user-inputed message in binary form
	 * and creates a version of type Message.
	 * This constructor is used in decrypting a message.
	 * @param message
	 */
	Message(String memoB) {
		//Num chars is /8 bc one char is 8 bits in binary
		messageChar = new char[memoB.length()/8]; 
		messageBinary = memoB;
	}
	
	/**
	 * Converts an array of chars into binary
	 * @param chars - array of chars
	 * @return array of binary version of chars
	 */
	public void makeBinary() {
		for(int j = 0; j < messageChar.length; j ++) {
			int decimal = (int) messageChar[j]; // decimal value of ascII
			String binaryVer = Integer.toBinaryString(decimal);
			messageBinary = messageBinary + binaryVer;
			
		}
	}	
	
	public void makeChar() {
		System.out.println("makeChar msgBinarylen: " + messageBinary.length());
		int msgLength = messageBinary.length()/8;
		
		for (int i = 0; i < (msgLength); i ++) {
			//Get the 8-bits that rep the first char
			String binaryChar = messageBinary.substring(i*8, i*8 + 8);
			
			int decimalVal = 0;
			for (int j = 0; j < binaryChar.length(); j++) {
				//int binaryColVal = (int) (Math.pow(2,  i));
				
				if(binaryChar.substring(j, j + 1).equals("1")) {
					decimalVal += Math.pow(2, binaryChar.length() - j - 1);
				}
			}
			//Decimal val is now the decmial val of a letter.
			messageChar[i] = (char)decimalVal;
		}
		
	}
	
	/**
	 * Gets and returns the binary form of a memo
	 * @param binaryMsg
	 * @return memo in binary form
	 */
	public String getBinary() {
		return messageBinary;
	}
	
	/**
	 * Gets and returns the char form of a memo
	 * @param binaryMsg
	 * @return memo in char form
	 */
	public char[] getChar() {
		return messageChar;
	}
}
	
	/**
	 * public void makeChar() {
		System.out.println("makeChar msgBinarylen" + messageBinary.length());
		int msgLength = messageBinary.length()/8;
		
		for (int i = 0; i < (msgLength); i ++) {
			//Get the 8-bits that rep the first char
			String binaryChar = messageBinary.substring(i*8, i*8 + 8);
			
			int decimalVal = 0;
			for (int j = 0; j < binaryChar.length(); j++) {
				//int binaryColVal = (int) (Math.pow(2,  i));
				
				if(binaryChar.substring(j, j + 1).equals("1")) {
					decimalVal += Math.pow(2, binaryChar.length() - j - 1);
				}
			}
			//Decimal val is now the decmial val of a letter.
			messageChar[i] = (char)decimalVal;
		}
		
	}
	 */