/**
 * Methods for converting between binary and decimal.
 *
 * 
 * @author Derrell Downey
 */
public class Binary {

	/** Constant defines the maximum length of binary numbers. */
	private static final int MAX_LENGTH = 32;

	/**
	 * Converts a two's complement binary number to signed decimal
	 *
	 * @param b The two's complement binary number
	 * @return The equivalent decimal value
	 * @exception IllegalArgumentException Parameter array length is longer than
	 *                                     MAX_LENGTH.
	 */
	public static long binToSDec(boolean[] b) {
		boolean[] binArr = new boolean[MAX_LENGTH];
		long decimalNumber = 0;
		int firstOneIndex = 0;
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return

		// Example of throwing an IllegalArgumentException
		// Student must write code for the required exceptions in other methods.
		// If the exception condition is true, throw the exception
		if (b.length > MAX_LENGTH) {
			// If the condition is true, the exception will be thrown
			// and the method execution will stop.
			throw new IllegalArgumentException("parameter array is longer than " + MAX_LENGTH + " bits.");
		}
		// If the method execution reaches this point, the exception was
		// not thrown.
		// Write the rest of the method here.]
		else {
			if (b[MAX_LENGTH - 1] == true) {
				for (int i = 0; binArr[i] == true; i++) {
					if (i != 0) {
						firstOneIndex++;
					}
				}
				for (int i = firstOneIndex; i < MAX_LENGTH; i++) {
					if (b[i] == true) {
						binArr[i] = false;
					} else if (b[i] == false) {
						binArr[i] = true;
					}
				}
				decimalNumber = -1 * (binToUDec(binArr) + 1);
			}
		}
		// System.out.println(decimalNumber);
		return decimalNumber;

	}

	/**
	 * Converts an unsigned binary number to unsigned decimal
	 *
	 * @param b The unsigned binary number
	 * @return The equivalent decimal value
	 * @exception IllegalArgumentException Parameter array length is longer than
	 *                                     MAX_LENGTH.
	 */
	public static long binToUDec(boolean[] b) {
		long decimalNumber = 0;
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		if (b.length > MAX_LENGTH) {
			// If the condition is true, the exception will be thrown
			// and the method execution will stop.
			throw new IllegalArgumentException("parameter array is longer than " + MAX_LENGTH + " bits.");
		} else {
			for (int i = 0; i < b.length; i++) { // going through the array and adding the values together
				if (b[i] == true) {
					decimalNumber = decimalNumber + ((long) Math.pow(2, i));
				}

			}

		}
		return decimalNumber;
	}

	/**
	 * Converts a signed decimal number to two's complement binary
	 *
	 * @param d    The decimal value
	 * @param bits The number of bits to use for the binary number.
	 * @return The equivalent two's complement binary representation.
	 * @exception IllegalArgumentException Parameter is outside valid range that can
	 *                                     be represented with the given number of
	 *                                     bits.
	 */
	public static boolean[] sDecToBin(long d, int bits) {
		int firstOneIndex = 0;
		boolean[] binArr = new boolean[bits]; // creating the binary array
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		if (bits > MAX_LENGTH) {
			// If the condition is true, the exception will be thrown
			// and the method execution will stop.
			throw new IllegalArgumentException("parameter bits is longer than " + MAX_LENGTH + " bits.");
		} else {
			if (d < 0) { // checking if the decimal value is negative to require twos complement
				binArr = uDecToBin((d * -1), bits);
				int j = 0;

				while (binArr[j] != true) {
					j++;
					firstOneIndex = j;
					// System.out.println(j);
				}
				// System.out.println(firstOneIndex);
				binArr[firstOneIndex] = true;
				for (int i = firstOneIndex + 1; i < bits; i++) { // switching all the values in the array
					if (binArr[i] == true) {
						binArr[i] = false;
					} else if (binArr[i] == false) {
						binArr[i] = true;
					}
				}
			}

			else { // if the decimal is not negative then use uDecToBin
				binArr = uDecToBin(d, bits);
			}
		}

		return binArr;
	}

	/**
	 * Converts an unsigned decimal number to binary
	 *
	 * @param d    The decimal value
	 * @param bits The number of bits to use for the binary number.
	 * @return The equivalent binary representation.
	 * @exception IllegalArgumentException Parameter is outside valid range that can
	 *                                     be represented with the given number of
	 *                                     bits.
	 */
	public static boolean[] uDecToBin(long d, int bits) {
		boolean[] binArr = new boolean[bits];
		long quotient = d;
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		if (bits > MAX_LENGTH) {
			// If the condition is true, the exception will be thrown
			// and the method execution will stop.
			throw new IllegalArgumentException("parameter bits is longer than " + MAX_LENGTH + " bits.");
		} else {
			for (int i = 0; quotient > 0 && i < MAX_LENGTH; i++) {
				if ((quotient % 2) * 2 == 0) {
					binArr[i] = false;
					quotient = quotient / 2;
				} else if ((quotient % 2) > 0) {
					binArr[i] = true;
					quotient = quotient / 2;
				}
			}
		}
		return binArr;
	}

	/**
	 * Returns a string representation of the binary number. Uses an underscore to
	 * separate each group of 4 bits.
	 *
	 * @param b The binary number
	 * @return The string representation of the binary number.
	 */
	public static String toString(boolean[] b) {
		String binNum = "";

		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		for (int i = b.length - 1; i >= 0; i--) {

			if (b[i] == false) { // if the array value is false then the toString will add a 0
				binNum = binNum + "0";
			} else if (b[i] == true) { // if the array value is true then the to String will add a 1
				binNum = binNum + "1";
			}
			if (i % 4 == 0 && i != 0) { // every four values to the binNum string will add a _
				binNum = binNum + "_";
			}
		}

		return binNum;
	}

	/**
	 * Returns a hexadecimal representation of the unsigned binary number. Uses an
	 * underscore to separate each group of 4 characters.
	 *
	 * @param b The binary number
	 * @return The hexadecimal representation of the binary number.
	 */
	public static String toHexString(boolean[] b) {
		String hexString = "";
		long binNum = binToUDec(b);
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		hexString = Long.toHexString(binNum);
		for (int i = 1; i < hexString.length(); i++) {
			if (i % 4 == 0 && i != hexString.length() - 1) {
				hexString = hexString.substring(0, i) + "_" + hexString.substring(i);
			}

		}
		// System.out.println(hexString);
		return hexString;
	}

}
