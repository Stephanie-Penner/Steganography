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
	 * Takes a user-inputted message in binary form
	 * and creates a version of type Message.
	 * This constructor is used in decrypting a message.
	 * @param message
	 */
	Message(String memoB) {
		messageChar = new char[memoB.length()];
		messageBinary = memoB;
	}
	
	/**
	 * Converts an array of chars into binary
	 * @param chars - array of chars
	 * @return array of binary version of chars
	 */
	public void makeBinary() {
		for(int j = 0; j < messageChar.length; j ++) {
			int decimalRem = (int) messageChar[j]; // remaining value of ascII
			
			for (int i = 7; i > -1; i--) {
				int binaryColVal = (int) (Math.pow(2,  i));
				
				if(decimalRem >= binaryColVal) {
					decimalRem = decimalRem - binaryColVal;
					messageBinary = messageBinary + "1"; //Col active
				}
				else {
					messageBinary = messageBinary + "0"; //Column inactive
				}
			}
		}
	}
	
	
	public void makeChar() {
		//for(int j = 0; )
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
