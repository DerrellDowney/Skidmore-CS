import java.lang.Math;

/**
 * Simulates the arithmetic and logic unit (ALU) of a processor. Follows the
 * ARMv8 architecture, with the exception of the number of bits used for input
 * and output values. Uses the BINARY_LENGTH constant from the Binary class as
 * the nubmer of bits for inputs and output.
 *
 * The ALU must be implemented using logic operations (AND, OR, NOT) on each set
 * of input bits because the goal of this assignment is to learn about how a
 * computer processor uses logic gates to perform arithmetic. The Java
 * arithmetic operations should not be used in this class.
 *
 * @author Derrell Downey
 */
public class ALU {

	/** Number of bits used to represent an integer in this ALU */
	public static final int INT_LENGTH = 32;

	/** Input A: an INT_LENGTH bit binary value */
	private boolean[] inputA;

	/** Input B: an INT_LENGTH bit binary value */
	private boolean[] inputB;

	/** Output: an INT_LENGTH bit binary value */
	private boolean[] output;

	/** ALU Control input */
	private int control;

	/** Zero flag */
	private boolean zeroFlag;

	/** Carry flag */
	private boolean carryFlag;

	/** Overflow flag */
	private boolean overflowFlag;

	private long overflowNumber;

	/**
	 * Constructor initializes inputs and output to random binary values, intializes
	 * control to 15, initializes zero flag to false. Inputs and output arrays
	 * should have length INT_LENGTH.
	 */
	public ALU() {
		// PROGRAM 1: Student must complete this method
		inputA = new boolean[INT_LENGTH];
		setInputA(randomArr());
		inputB = new boolean[INT_LENGTH];
		setInputB(randomArr());
		output = new boolean[INT_LENGTH];
		output = randomArr();
		control = 15;
		overflowNumber = 0;
	}

	public boolean[] randomArr() {
		boolean[] out = new boolean[INT_LENGTH];
		for (int i = 0; i < INT_LENGTH; i++) {
			int rand = (int) Math.random();
			if (rand == 1) {
				out[i] = true;
			} else if (rand == 0) {
				out[i] = false;
			}
		}
		return out;
	}

	/**
	 * Sets the value of inputA.
	 *
	 * @param b The value to set inputA to
	 *
	 * @exception IllegalArgumentException if array b does not have length
	 *                                     INT_LENGTH
	 */
	public void setInputA(boolean[] b) {
		// PROGRAM 1: Student must complete this method
		if (b.length != INT_LENGTH) {
			throw new IllegalArgumentException("array b must have length INT_LENGTH");

		} else {
			inputA = b; // setting inputA to the b parameter
		}
	}

	/**
	 * Sets the value of inputB.
	 *
	 * @param b The value to set inputB to
	 *
	 * @exception IllegalArgumentException if array b does not have length
	 *                                     INT_LENGTH
	 */
	public void setInputB(boolean[] b) {
		// PROGRAM 1: Student must complete this method
		if (b.length != INT_LENGTH) {
			throw new IllegalArgumentException("array b must have length INT_LENGTH");

		} else {
			inputB = b; // setting inputB to the b parameter
		}
	}

	/**
	 * Sets the value of the control line to one of the following values. Note that
	 * we are not implementing all possible control line values. 0 for AND; 1 for
	 * OR; 2 for ADD; 6 for SUBTRACT; 7 for PASS INPUT B.
	 *
	 * @param c The value to set the control to.
	 * @exception IllegalArgumentException if c is not 0, 1, 2, 6, or 7.
	 */
	public void setControl(int c) {
		switch (c) {
		case 0:
			// and
			control = c;
			break;
		case 1:
			// or
			control = c;
			break;
		case 2:
			// add
			control = c;
			break;
		case 6:
			// subtract
			control = c;
			break;
		case 7:
			// input b
			control = c;
			break;
		default:
			throw new IllegalArgumentException("value is not 0, 1, 2, 6, or 7");

		}
	}

	/**
	 * Returns a copy of the value in the output.
	 *
	 * @return The value in the output
	 */
	public boolean[] getOutput() {
		boolean[] out = new boolean[INT_LENGTH];
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		for (int i = 0; i < INT_LENGTH; i++) {
			out[i] = output[i]; // sets new array with the value of output at the same index
		}
		return out;
	}

	/**
	 * Returns the value of the zero data member. The zero data member should have
	 * been set to true if the result of the operation was zero.
	 *
	 * @return The value of the zeroFlag data member
	 */
	public boolean getZeroFlag() {
		int counter = 0;
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		for (int i = 0; i < INT_LENGTH; i++) { // looping through the binary output to see if the values
			if (output[i] == false) { //
				counter++;
			}
		}
		if (counter == INT_LENGTH) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the value of the carryFlag data member. The carryFlag data member is
	 * set to true if the ALU addition operation has a carry out of the most
	 * significant bit.
	 *
	 * @return The value of the carryFlag data member
	 */
	public boolean getCarryFlag() {
		boolean carryFlag = false;
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		long valueOut = Binary.binToUDec(output);
		long valueInA = Binary.binToUDec(inputA);
		long valueInB = Binary.binToUDec(inputB);
		if (valueInA + valueInB > valueOut) {
			carryFlag = true;
		}
		return carryFlag;
	}

	/**
	 * Returns the value of the overflowFlag data member. The overflowFlag data
	 * member is set to true if the ALU addition operation has a result that is
	 * overflow when the operands are signed integers.
	 *
	 * @return The value of the overflowFlag data member
	 */
	public boolean getOverflowFlag() {
		boolean overflowFlag = false;

		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return

		// long valueOut = Binary.binToUDec(output);
		long valueInA = Binary.binToSDec(inputA);
		long valueInB = Binary.binToSDec(inputB);
		// System.out.println(overflowNumber);

		if (overflowNumber > 0) {
			overflowFlag = false;
			return overflowFlag;
		}

		else if (valueInA >= 0 && valueInB >= 0 && output[output.length - 1] == true) {
			overflowFlag = true;
			return overflowFlag;
		}

		else if (valueInA < 0 && valueInB < 0 && output[output.length - 1] == false) {

			overflowFlag = true;
			return overflowFlag;

		} else {
			overflowFlag = false;
			return overflowFlag;

		}

	}

	/**
	 * Activates the ALU so that the ALU performs the operation specified by the
	 * control data member on the two input values. When this method is finished,
	 * the output data member contains the result of the operation.
	 *
	 * @exception RuntimeException if the control data member is not set to a valid
	 *                             operation code.
	 */
	public void activate() {
		// PROGRAM 1: Student must complete this method
		switch (control) {
		case 0:
			// and
			and();
			break;
		case 1:
			// or
			or();
			break;
		case 2:
			// add
			add();
			break;
		case 6:
			// subtract
			sub();
			break;
		case 7:
			// input b
			passB();
			break;
		default:
			throw new RuntimeException("control data member is not set to a valid operation code");
		}

	}

	/**
	 * Performs the bitwise AND operation: output = inputA AND inputB
	 */
	private void and() {
		// PROGRAM 1: Student must complete this method
		for (int i = 0; i < INT_LENGTH; i++) {
			if (inputA[i] == true && inputB[i] == true) { // checking if both values of inputA and B are true
				output[i] = true; // setting the output to true
			} else {
				output[i] = false; // if not then the output at index i is false or 0
			}
		}
	}

	/**
	 * Performs the bitwise OR operation: output = inputA OR inputB
	 */
	private void or() {
		// PROGRAM 1: Student must complete this method
		for (int i = 0; i < INT_LENGTH; i++) {
			if (inputA[i] == false && inputB[i] == false) { // checking the index to see if both inputs at index i are
															// false
				output[i] = false; // if so setting output index to false or 0
			} else {
				output[i] = true;
			}
		}
	}

	/**
	 * Performs the addition operation using ripple-carry addition of each bit:
	 * output = inputA + inputB
	 */
	private void add() {
		boolean carry = false;
		// PROGRAM 1: Student must complete this method
		// This method must use the addBit method for bitwise addition.
		for (int i = 0; i < INT_LENGTH; i++) {
			if (carry == false) {
				if (inputA[i] == true && inputB[i] == true) {
					output[i] = false;
					carry = true;
				} else if (inputA[i] == false && inputB[i] == false) {
					output[i] = false;
					carry = false;
				} else {
					output[i] = true;
					carry = false;
				}

			} else if (carry == true) {
				if (inputA[i] == true && inputB[i] == true) {
					output[i] = true;
					carry = true;
				} else if (inputA[i] == false && inputB[i] == false) {
					output[i] = true;
					carry = false;
				} else {
					output[i] = false;
					carry = true;
				}
			}
		}

	}

	/**
	 * Performs the subtraction operation using a ripple-carry adder: output =
	 * inputA - inputB In order to perform subtraction, set the first carry-in to 1
	 * and invert the bits of inputB.
	 */
	private void sub() {
		// System.out.println(Binary.toString(inputA));
		// System.out.println(Binary.toString(inputB));
		// System.out.println("---------");
		int firstOneIndex = 0;
		long copyA = Binary.binToUDec(inputA);
		long copyB = Binary.binToUDec(inputA);
		boolean[] binArr = inputA;

		// PROGRAM 1: Student must complete this method
		// This method must use the addBit method for bitwise subtraction.
		int j = 0;
		// System.out.println(copyA);

		while (inputB[j] != true) {
			j++;
			firstOneIndex = j;
		}

		// System.out.println(firstOneIndex);

		binArr[firstOneIndex] = true;

		for (int i = firstOneIndex + 1; i < inputB.length; i++) {
			if (inputB[i] == true) { // reverting index B back to its form
				inputB[i] = false;
			} else if (inputB[i] == false) {
				inputB[i] = true;
			}
		}

		binArr = Binary.sDecToBin(copyA, inputA.length);
		setInputA(binArr);
		// System.out.println(Binary.toString(inputA));
		// System.out.println(Binary.toString(inputB));
		add();
		// System.out.println("-------");
		// System.out.println(Binary.toString(output));
		overflowNumber = copyB;

		for (int i = firstOneIndex + 1; i < inputB.length; i++) { // reverting the value of the input back to its
																	// original
			if (inputB[i] == true) {
				inputB[i] = false;
			} else if (inputB[i] == false) {
				inputB[i] = true;
			}
		}
	}

	/**
	 * Copies inputB to the output: output = inputB
	 */
	private void passB() {
		// PROGRAM 1: Student must complete this method
		output = inputB;
	}

	/**
	 * Simulates a 1-bit adder.
	 *
	 * @param a Represents an input bit
	 * @param b Represents an input bit
	 * @param c Represents the carry in bit
	 * @return An array of length 2, index 0 holds the output bit and index 1 holds
	 *         the carry out
	 */
	private boolean[] addBit(boolean a, boolean b, boolean c) {
		boolean[] out = new boolean[2];
		// PROGRAM 1: Student must complete this method

		// This method may only use the Java logic operations && (logical and),
		// || (logical or), and ! (logical not). Do not use any Java arithmetic
		// operators in this method.

		// return value is a placeholder, student should replace with correct return
		if (a == true && b == true) {
			out[0] = false;
			out[1] = true;
		}
		if (a == false || b == false) {
			out[0] = false;
			out[1] = false;
		} else if (a == true || b == true) {
			out[0] = true;
			out[1] = false;
		}
		return new boolean[INT_LENGTH];
	}

}
