
/**
* Represents a simple CPU based on the ARMv8 datapath.
*
* CS318 Programming Assignment 4
* Name: Derrell Downey
*
*/
import java.io.*;
import java.util.Arrays;

public class CPU {

	/** Memory unit for instructions */
	private Memory instructionMemory;

	/** Memory unit for data */
	private Memory dataMemory;

	/** Register unit */
	private Registers registers;

	/** Arithmetic and logic unit */
	private ALU alu;

	/** Adder for incrementing the program counter */
	private ALU adderPC;

	/** Adder for computing branches */
	private ALU adderBranch;

	/** Control unit */
	private SimpleControl control;

	/** Multiplexor output connects to Read Register 2 */
	private Multiplexor2 muxRegRead2;

	/** Mulitplexor ouptut connects to ALU input B */
	private Multiplexor2 muxALUb;

	/** Multiplexor output connects to Register Write Data */
	private Multiplexor2 muxRegWriteData;

	/** Multiplexor output connects to Program Counter */
	private Multiplexor2 muxPC;

	/** Program counter */
	private boolean[] pc;

	/**
	 * STUDENT SHOULD NOT MODIFY THIS METHOD
	 *
	 * Constructor initializes all data members.
	 *
	 * @param iMemFile Path to the file with instruction memory contents.
	 * @param dMemFile Path to the file with data memory contents.
	 * @exception FileNotFoundException if a file cannot be opened.
	 */
	public CPU(String iMemFile, String dMemFile) throws FileNotFoundException {

		// Create objects for all data members
		instructionMemory = new Memory(iMemFile);
		dataMemory = new Memory(dMemFile);
		registers = new Registers();
		alu = new ALU();
		control = new SimpleControl();
		muxRegRead2 = new Multiplexor2(5);
		muxALUb = new Multiplexor2(32);
		muxRegWriteData = new Multiplexor2(32);
		muxPC = new Multiplexor2(32);

		// Activate adderPC with ADD operation, and inputB set to 4
		// Send adderPC output to muxPC input 0
		adderPC = new ALU();
		adderPC.setControl(2);
		boolean[] four = Binary.uDecToBin(4L, 32);
		adderPC.setInputB(four);

		// Initalize adderBranch with ADD operation
		adderBranch = new ALU();
		adderBranch.setControl(2);

		// initialize program counter to 0
		pc = new boolean[32];
		for (int i = 0; i < 32; i++) {
			pc[i] = false;
		}
	}

	/**
	 * STUDENT SHOULD NOT MODIFY THIS METHOD
	 *
	 * Runs the CPU in single cycle (non-pipelined) mode. Stops when a halt
	 * instruction is decoded.
	 *
	 * This method can be used with any (assembled) assembly language program.
	 */
	public void singleCycle() {

		int cycleCount = 0;

		// Start the first cycle.
		boolean[] instruction = fetch();
		boolean op = decode(instruction);

		// Loop until a halt instruction is decoded
		while (op) {
			execute();

			memoryAccess();

			writeBack();

			cycleCount++;

			// Start the next cycle
			instruction = fetch();

			op = decode(instruction);
		}

		System.out.println("CPU halt after " + cycleCount + " cycles.");
	}

	/**
	 * STUDENT MAY MODIFY THIS METHOD
	 *
	 * Compares the fetched instruction with the expected instruction
	 *
	 * This method can be used with any (assembled) assembly language program.
	 */

	private void testInstrFetch(int cycleCount, boolean[] instrFetched, boolean[] expected) {
		if (!Arrays.equals(instrFetched, expected)) {
			System.out.println("FAIL Fetch: cycle " + cycleCount + " did not fetch correct instruction:");
			System.out.println("------ fetch returned: " + Binary.toString(instrFetched));
			System.out.println("------ correct instruction: " + Binary.toString(expected));
		} else {
			System.out.println("PASSED Fetch test");
		}
	}

	/**
	 * STUDENT MUST MODIFY THIS METHOD
	 *
	 * Verifies the controls for various instructions
	 *
	 * This method can be used with any (assembled) assembly language program.
	 */

	private void testDecodeControls(int cycleCount, SimpleControl control, boolean[] expectedControls, int aluControl) {
		if (control.Reg2Loc != expectedControls[0] || control.ALUSrc != expectedControls[1]
				|| control.MemtoReg != expectedControls[2] || control.RegWrite != expectedControls[3]
				|| control.MemRead != expectedControls[4] || control.MemWrite != expectedControls[5]
				|| control.Branch != expectedControls[6] || control.Uncondbranch != expectedControls[7]
				|| control.ALUControl != aluControl) {
			System.out.println("FAIL Decode: cycle " + cycleCount + " controls not correct after decode");

		} else {
			System.out.println("PASSED Decode test");
		}
	}

	/**
	 * STUDENT MUST MODIFY THIS METHOD
	 *
	 * Verifies the ALU output for various instructions
	 *
	 * This method can be used with any (assembled) assembly language program.
	 */

	private void testExecuteALUOutput(int cycleCount, boolean[] aluOutput, boolean[] correctALU) {
		if (!Arrays.equals(aluOutput, correctALU)) {
			System.out.println("FAILED ALU Output: cycle " + cycleCount + " not correct output:");
			System.out.println("------ output returned: " + Binary.toString(aluOutput));
			System.out.println("------ correct output: " + Binary.toString(correctALU));
		}
		else {
			System.out.println("PASSED ALU output test");
		}
	}

	/**
	 * STUDENT MUST ADD MORE TESTING CODE TO THIS METHOD AS INDICATED BY COMMENTS
	 * WIHTIN THIS METHOD.
	 *
	 * DO NOT CHANGE the calls to the CPU private methods.
	 *
	 *
	 * Runs the CPU in single cycle (non-pipelined) mode. Stops when a halt
	 * instruction is decoded.
	 *
	 * This method should only be used with the assembled testProg3.s because this
	 * method verifies correct values based on that specific program.
	 */
	public void runTestProg3() throws FileNotFoundException {

		int cycleCount = 0;

		// Start the first cycle.
		boolean[] instruction = fetch();

		// Example Test: Verify that when cycleCount is 0 the insruction returned by
		// fetch is the
		// binary version of the first instruction from testProg3.s ADD R9,R31,R31
		boolean[] firstInstr = { true, false, false, true, false, true, true, true, true, true, false, false, false,
				false, false, false, true, true, true, true, true, false, false, false, true, true, false, true, false,
				false, false, true };
		testInstrFetch(0, instruction, firstInstr);

		boolean op = decode(instruction);

		// *** PROG 4. STUDENT MUST ADD
		// implement the method testDecodeControls
		// example below must test that when cycleCount is 0, the control signals
		// are correctly set for an ADD instruction

		// controls in order: Reg2Loc, ALUSrc, MemtoReg, RegWrite, MemRead, MemWrite,
		// Branch, Uncondbranch
		boolean[] expectedControls = { false, false, false, true, false, false, false, false };
		// ALU control is 2 for ADD
		testDecodeControls(0, control, expectedControls, 2);

		// boolean[] expectedALU = {};
		// Loop until a halt instruction is decoded
		while (op) {

			// *** PROG. 4 STUDENT MUST ADD
			// test code to show that they used to verify that decode worked
			// for e.g., for cycleCount 3, register 1 content must be 6
			// for cycleCount 7, register 2 must be 11
			// for cycleCount 0, muxRegRead2(false) must contain 31
			// for cycleCount 7, muxRegRead2(true) must contain 5
			// Student must create and call a test method to verify
			// - register file inputs and register reads
			// - muxReadReg2() output,

			// for cycleCount 3, register 1 content must be 6
			if (cycleCount == 3 && (Binary.binToUDec(registers.getReadReg1()) != 6)) {
				System.out.println("FAILED: ReadReg1 is not correct value in cycle " + cycleCount);
			}
			// for cycleCount 7, register 2 must be 11
			if (cycleCount == 7 && (Binary.binToUDec(registers.getReadReg2()) != 11)) {
				System.out.println("FAILED: reg2 is not correct value in cycle " + cycleCount);
			}
			// for cycleCount 0, muxRegRead2(false) must contain 31
			if (cycleCount == 0 && control.Reg2Loc == false
					&& Binary.binToUDec(muxRegRead2.output(control.Reg2Loc)) != 31) {
				System.out.println("FAILED: muxRegRead2 is not correct value in cycle " + cycleCount);
			}
			// for cycleCount 7, muxRegRead2(true) must contain 5
			if (cycleCount == 7 && control.Reg2Loc == true
					&& Binary.binToUDec(muxRegRead2.output(control.Reg2Loc)) != 5) {
				System.out.println("FAILED: muxRegRead2 is not correct value in cycle " + cycleCount);
			}

			execute();

			// ** PROG. 4 STUDENT MUST ADD
			// test code to show that they used to verify execute worked
			// for e.g., for cycleCount 1, alu output must be 16 after execute
			boolean[] correctAlUVal = Binary.uDecToBin(16L, 32);
			if (cycleCount == 1) {
				testExecuteALUOutput(1, alu.getOutput(), correctAlUVal);
			}
			
			memoryAccess();

			// ***** PROG. 4 STUDENT MUST ADD
			// test code they used to verify memoryAccess worked
			// for e.g., when cycleCount is 1, the value that was read from
			// memory (should be 6) is in the register write multiplexor
			// (muxRegWriteData) at input 1
			if (cycleCount == 1 && Binary.binToUDec(muxRegWriteData.output(true)) != 6) {
				System.out.println("FAIL: cycle " + cycleCount + " incorrect value in muxRegWriteData:");
				System.out.println("------ muxRegWriteData value: " + Binary.binToUDec(muxRegWriteData.output(true)));
				System.out.println("------ correct value: 6");
			}

			writeBack();

			// ***** PROG. 4 STUDENT MUST ADD
			// test code they used to verify writeBack worked
			// for e.g., when cycleCount is 1, the value that was read from
			// memory (should be 6) is in the register write multiplexor
			// (muxRegWriteData) at input 1
			// when cycleCount is 6, the branch adder's (adderBranch)
			// result is the offset of the branch destination instruction (should be 32)

			if (cycleCount == 6 && Binary.binToUDec(adderBranch.getOutput()) != 32) {
				System.out.println("FAIL: cycle " + cycleCount + " incorrect value in adderBranch:");
				System.out.println("------ adderBranch value: " + Binary.binToUDec(adderBranch.getOutput()));
				System.out.println("------ correct value: 32");
			}

			cycleCount++;

			// Start the next cycle
			instruction = fetch();

			// ***** PROG. 4 STUDENT MUST ADD
			// Test that when cycleCount is 7, the instruction returned by fetch is
			// the last instruction in the program: STR R5,[R9,#8]
			
			boolean[] expectedInstruction = { true, false, true, false, false, true, false, false, true, false, false,
					false, false, false, false, true, false, false, false, false, false, false, false, false, false,
					false, false, true, true, true, true, true };
			if(cycleCount == 7) {
				testInstrFetch(7, instruction, expectedInstruction);
			}

			op = decode(instruction);

			// ***** PROG. 4 STUDENT MUST ADD
			// Test that when cycleCount is 1, the the control signals are correctly
			// set for a LDR instruction
			boolean[] expectedLDRControls = { false, true, true, true, true, false, false, false };
			if(cycleCount == 1) {
				testDecodeControls(1, control, expectedLDRControls, 2);
			}
		}

		System.out.println("CPU halt after " + cycleCount + " cycles.");
		// Write memory contents to a file
		dataMemory.writeToFile("checkMem.txt");

	}

	/**
	 * STUDENT MUST COMPLETE THIS METHOD
	 *
	 * Instruction Fetch Step Fetch the instruction from the instruction memory
	 * starting at address pc. Activate the PC adder and place the adder's output
	 * into muxPC input 0.
	 *
	 * @return The instruction starting at address pc
	 */
	private boolean[] fetch() {
		boolean[] instruction = instructionMemory.read32(pc); // creating instruction
		adderPC.setInputA(pc); // set adderPC's input A to pc
		adderPC.activate(); // activating adderPC
		muxPC.setInput0(adderPC.getOutput()); // setting muxPC 0 to the adderPC output

		return instruction; // returning instruction
	}

	/**
	 * STUDENT MUST COMPLETE THIS METHOD
	 *
	 * Instruction Decode and Register Read
	 * 
	 * Decode the instruction. Sets the control lines and sends appropriate bits
	 * from the instruction to various inputs within the processor.
	 *
	 * Set the Read Register inputs so that the values to be read from the registers
	 * will be available in the next phase.
	 *
	 * @param instruction The 32-bit instruction to decode
	 * @return false if the opcode is HLT; true for any other opcode
	 */
	private boolean decode(boolean[] instruction) {
		//boolean val to hold the 11 opcode bits
		boolean[] op11 = new boolean[11];
		//boolean to hold the 8 CBZ opcode bits
		boolean[] opCBZ = new boolean[8];
		//boolean to hold the 6 B opcode bits
		boolean[] opB = new boolean[6];
		int length;
		//filling the 11op with the correct bits
		length = op11.length - 1;
		for (int i = instruction.length - 1; i >= 21; i--) {
			op11[length] = instruction[i];
			length--;
		}
		
		//filling the CBZop with the correct bits
		length = opCBZ.length - 1;
		for (int i = instruction.length - 1; i >= 24; i--) {
			opCBZ[length] = instruction[i];
			length--;
		}

		//filling the B op with the correct bits
		length = opB.length - 1;
		for (int i = instruction.length - 1; i >= 26; i--) {
			opB[length] = instruction[i];
			length--;
		}
		// opB = Arrays.copyOfRange(instruction, 26, 32);

		if (Arrays.equals(op11, Opcode.ADD)) {
			setRControl(); // setting control lines to R type
			control.ALUControl = 2; // set ALU control to 2
			bitProcess(instruction); // process the bits and send them to the right places in CPU
		} else if (Arrays.equals(op11, Opcode.SUB)) {
			setRControl(); // setting control lines to R type
			control.ALUControl = 6; // set ALU control to 6
			bitProcess(instruction);// process the bits and send them to the right places in CPU
		} else if (Arrays.equals(op11, Opcode.AND)) {
			setRControl(); // setting control lines to R type
			control.ALUControl = 0;// set ALU control to 0
			bitProcess(instruction); // process the bits and send them to the right places in CPU
		} else if (Arrays.equals(op11, Opcode.ORR)) {
			setRControl(); // setting control lines to R type
			control.ALUControl = 1; // set ALU control to 1
			bitProcess(instruction); // process the bits and send them to the right places in CPU
		} else if (Arrays.equals(op11, Opcode.LDR)) {
			// setting control lines
			control.Reg2Loc = false;
			control.ALUSrc = true;
			control.MemtoReg = true;
			control.RegWrite = true;
			control.MemWrite = false;
			control.MemRead = true;
			control.Branch = false;
			control.Uncondbranch = false;
			control.ALUControl = 2;

			// extending the immediate value
			boolean[] immBin = new boolean[32];
			boolean[] immBitsBin = new boolean[9];
			length = immBitsBin.length - 1;
			// finding immediate bits
			for (int i = 20; i >= 12; i--) {
				immBitsBin[length] = instruction[i];
				length--;
			}
			long immVal = Binary.binToSDec(immBitsBin);
			// converting the immediate value to 32 bit binary
			immBin = Binary.sDecToBin(immVal, 32);

			muxALUb.setInput1(immBin);
			adderBranch.setInputB(immBin);
			bitProcess(instruction);
		} else if (Arrays.equals(op11, Opcode.STR)) {
			// setting control lines
			control.Reg2Loc = true;
			control.ALUSrc = true;
			control.MemtoReg = false;
			control.RegWrite = false;
			control.MemRead = false;
			control.MemWrite = true;
			control.Branch = false;
			control.Uncondbranch = false;
			control.ALUControl = 2;

			// extending the immediate value
			boolean[] immBin = new boolean[32];
			boolean[] immBitsBin = new boolean[9];
			length = immBitsBin.length - 1;
			// finding immediate bits
			for (int i = 20; i >= 12; i--) {
				immBitsBin[length] = instruction[i];
				length--;
			}
			long immVal = Binary.binToSDec(immBitsBin);
			// converting the immediate value to 32 bit binary
			immBin = Binary.sDecToBin(immVal, 32);

			muxALUb.setInput1(immBin);
			adderBranch.setInputB(immBin);
			bitProcess(instruction);
		} else if (Arrays.equals(opCBZ, Opcode.CBZ)) {
			// setting control lines
			control.Reg2Loc = true;
			control.ALUSrc = false;
			control.MemtoReg = false;
			control.RegWrite = false;
			control.MemWrite = false;
			control.MemRead = false;
			control.Branch = true;
			control.Uncondbranch = false;
			control.ALUControl = 7;

			// extending the immediate value
			boolean[] immBin = new boolean[32];
			boolean[] immBitsBin = new boolean[19];
			length = immBitsBin.length - 1;
			// finding immediate bits
			for (int i = 23; i >= 5; i--) {
				immBitsBin[length] = instruction[i];
				length--;
			}
			long immVal = Binary.binToSDec(immBitsBin);
			// converting immediate bits to binary
			immBin = Binary.sDecToBin(immVal, 32);

			muxALUb.setInput1(immBin);
			adderBranch.setInputB(immBin);
			bitProcess(instruction);
		} else if (Arrays.equals(opB, Opcode.B)) {
			// setting control lines
			control.Reg2Loc = false;
			control.ALUSrc = false;
			control.MemtoReg = false;
			control.RegWrite = false;
			control.MemWrite = false;
			control.MemRead = false;
			control.Branch = false;
			control.Uncondbranch = true;

			// extending the immediate value
			boolean[] immBin = new boolean[32];
			boolean[] immBitsBin = new boolean[26];
			length = immBitsBin.length - 1;
			// finding immediate bits
			for (int i = 25; i >= 0; i--) {
				immBitsBin[length] = instruction[i];
				length--;
			}
			long immVal = Binary.binToSDec(immBitsBin);
			// converting immediate values to 32 bit binary
			immBin = Binary.sDecToBin(immVal, 32);

			muxALUb.setInput1(immBin);
			adderBranch.setInputB(immBin);
			bitProcess(instruction);
		} else if (Arrays.equals(op11, Opcode.HLT)) {
			bitProcess(instruction);
			return false;
		}
		return true;
	}

	private void setRControl() {
		control.Reg2Loc = false;
		control.ALUSrc = false;
		control.MemtoReg = false;
		control.RegWrite = true;
		control.MemRead = false;
		control.MemWrite = false;
		control.Branch = false;
		control.Uncondbranch = false;
	}

	private void bitProcess(boolean[] instruction) {
		boolean[] readReg1 = new boolean[5];
		boolean[] readReg2 = new boolean[5];
		boolean[] writeReg = new boolean[5];
		int length;

		// getting the read reg 1 from the instruction
		length = readReg1.length - 1;
		for (int i = 9; i >= 5; i--) {
			readReg1[length] = instruction[i];
			length--;
		}

		// getting the read reg 2 from the instruction
		length = readReg2.length - 1;
		for (int i = 20; i >= 16; i--) {
			readReg2[length] = instruction[i];
			length--;
		}

		// getting the write reg from the instruction
		length = writeReg.length - 1;
		for (int i = 4; i >= 0; i--) {
			writeReg[length] = instruction[i];
			length--;
		}

		registers.setRead1Reg(readReg1); // setting readreg1
		muxRegRead2.setInput0(readReg2); // set muxRegRead2 input 0 to readReg2
		muxRegRead2.setInput1(writeReg);
		registers.setRead2Reg(muxRegRead2.output(control.Reg2Loc)); // set read2reg to muxRegRead2 output
		registers.setWriteRegNum(writeReg); // set writeRegNum to writeReg
		muxALUb.setInput0(registers.getReadReg2()); // set muxALUb input 0 to readReg2
		alu.setInputA(registers.getReadReg1()); // set alu input A to ReadReg1
		alu.setInputB(muxALUb.output(control.ALUSrc)); // set alu input B to muxALUb output
		alu.setControl(control.ALUControl);
	}

	/**
	 * STUDENT MUST COMPLETE THIS METHOD
	 *
	 * Execute Phase Activate the ALU to execute an arithmetic or logic operation,
	 * or to calculate a memory address.
	 *
	 * The branch adder is activated during this phase, and the branch adder result
	 * is placed into muxPC input 1.
	 *
	 * This method must make decisions based on the values of the control lines.
	 * This method has no information about the opcode!
	 *
	 */
	private void execute() {
		adderBranch.setInputA(pc); // setting adderBranch input A to pc
		adderBranch.activate(); // activate adderBranch
		alu.activate(); // activate ALU
	}

	/**
	 * STUDENT MUST COMPLETE THIS METHOD
	 *
	 * Memory Access Phase Read or write from/to data memory.
	 *
	 * This method must make decisions based on the values of the control lines.
	 * This method has no information about the opcode!
	 */
	private void memoryAccess() {
		// System.out.println(alu.getOutput().length);

		// if there was memWrite
		if (control.MemWrite) {
			dataMemory.write32(alu.getOutput(), registers.getReadReg2()); // write readreg2 to dataMemory

		}

		// if there was memRead
		if (control.MemRead) {
			muxRegWriteData.setInput1(dataMemory.read32(alu.getOutput())); // setting input 1 of muxRegWriteData to the
																			// binary
		}

	}

	/**
	 * STUDENT MUST COMPLETE THIS METHOD
	 *
	 * Write Back Phase Perform writes to registers: the PC and the processor
	 * registers.
	 *
	 * This method must make decisions based on the values of the control lines.
	 * This method has no information about the opcode!
	 */
	private void writeBack() {

		muxPC.setInput1(adderBranch.getOutput()); // setting muxPC 1 to the adderBranch output
		muxRegWriteData.setInput0(alu.getOutput()); // set muxRegWriteData input 0 to alu output
		registers.setWriteRegData(muxRegWriteData.output(control.MemtoReg)); // set writeregdata to muxRegWriteData
																				// output

		// if reg write is true then write to the register
		if (control.RegWrite) {
			registers.activateWrite(); // activate write
		}

		pc = muxPC.output((control.Branch && alu.getZeroFlag()) || control.Uncondbranch);
	}
}
