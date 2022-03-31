
/**
* Assembler for the CS318 simple computer simulation
*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Assembler {

	/**
	 * Assembles the code file. When this method is finished, the dataFile and
	 * codeFile contain the assembled data segment and code segment, respectively.
	 *
	 * @param inFile   The pathname to the assembly language file to be assembled.
	 * @param dataFile The pathname where the data segment file should be written.
	 * @param codeFile The pathname where the code segment file should be written.
	 */
	public static void assemble(String inFile, String dataFile, String codeFile)
			throws FileNotFoundException, IOException {

		// DO NOT MAKE ANY CHANGES TO THIS METHOD

		ArrayList<LabelOffset> labels = pass1(inFile, dataFile, codeFile);
		pass2(inFile, dataFile, codeFile, labels);
	}

	/**
	 * First pass of the assembler. Writes the number of bytes in the data segment
	 * and code segment to their respective output files. Returns a list of code
	 * segment labels and thier relative offsets.
	 *
	 * @param inFile   The pathname of the file containing assembly language code.
	 * @param dataFile The pathname for the data segment binary file.
	 * @param codeFile The pathname for the code segment binary file.
	 * @return List of the code segment labels and relative offsets.
	 * @exception RuntimeException if the assembly code file does not have the
	 *                             correct format, or another error while processing
	 *                             the assembly code file.
	 */
	private static ArrayList<LabelOffset> pass1(String inFile, String dataFile, String codeFile)
			throws FileNotFoundException {

		// PROGRAMMING ASSIGNMENT 2: COMPLETE THIS METHOD
		ArrayList<LabelOffset> codeLabelOffset = new ArrayList<LabelOffset>();
		// find number of bytes in inFile data and code section
		// write num bytes to output files
		// return list of labels of the code and their offsets
		// placeholder return. Student should replace with correct return.
		int dataBytes = 0;
		int codeBytes = 0;
		LineNumberReader reader = null;
		String lineRecord;
		String[] parsedRecord;
		String line = "";

		try {
			reader = new LineNumberReader(new FileReader(inFile)); // creating a new LineNumberReader
			reader.readLine();
			while ((lineRecord = reader.readLine()) != null) { // while the line is not null
				line = lineRecord; // setting line to the line being read
				// System.out.println(line);
				line = line.trim(); // getting rid of empty space
				if (line.startsWith(".word")) { // if the line starts with .word
					parsedRecord = lineRecord.split(",");// breaking the line up by commas to find the amount of values

//					for(int i = 0; i<parsedRecord.length; i++) {
//						System.out.println(parsedRecord[i]);
//					}

					dataBytes = dataBytes + (parsedRecord.length * 4);

				} else {
					String code = line.substring(0, 3);
					if (code.equals("ADD") || code.equals("SUB") || code.equals("AND") || code.equals("STR")
							|| code.equals("LDR") || code.equals("ORR") || code.equals("CBZ") || code.equals("HLT")
							|| code.charAt(0) == 'B') {
						codeBytes += 4;

					} else if (line.contains(":")) {
						LabelOffset temp = new LabelOffset(); // new LabelOffset object to add to output
						temp.label = line.substring(0, line.indexOf(":")); // set the label of object
						temp.offset = codeBytes-4; // set the offset
						codeLabelOffset.add(temp);

					}
				}
			}
		}

		catch (Throwable throwable) {
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Throwable throwable) {
				}
			}
		}
		codeBytes += 4;
		// System.out.println(dataBytes);
		// System.out.println(codeBytes);

		// following code is from
		// https://www.tutorialspoint.com/javaexamples/file_write.htm
		try {
			BufferedWriter dataOut = new BufferedWriter(new FileWriter(dataFile));
			dataOut.write("" + dataBytes);
			dataOut.close();
			BufferedWriter codeOut = new BufferedWriter(new FileWriter(codeFile));
			codeOut.write("" + codeBytes);
			codeOut.close();

		} catch (IOException e) {
		}

		return codeLabelOffset;

	}

	/**
	 * Second pass of the assembler. Writes the binary data and code files.
	 * 
	 * @param inFile   The pathname of the file containing assembly language code.
	 * @param dataFile The pathname for the data segment binary file.
	 * @param codeFile The pathname for the code segment binary file.
	 * @param labels   List of the code segment labels and relative offsets.
	 * @exception RuntimeException if there is an error when processing the assembly
	 *                             code file.
	 */
	public static void pass2(String inFile, String dataFile, String codeFile, ArrayList<LabelOffset> labels)
			throws FileNotFoundException, IOException {

		// PROGRAMMING ASSIGNMENT 2: COMPLETE THIS METHOD
		LineNumberReader reader = null;
		String lineRecord;
		String[] parsedRecord;
		String line = "";
		String binTemp;
		boolean[] binary;
		String machineLang;
		String temp;
	
		FileWriter dataOut = new FileWriter(dataFile, true);
		FileWriter codeOut = new FileWriter(codeFile, true);
		try {
			
			
			reader = new LineNumberReader(new FileReader(inFile)); // creating a new LineNumberReader
			reader.readLine();
			dataOut.write("\n");
			codeOut.write("\n");
			while ((lineRecord = reader.readLine()) != null) { // while the line is not null
				line = lineRecord; // setting line to the line being read
				// System.out.println(line);
				line = line.trim(); // getting rid of empty space
				if (line.startsWith(".word")) { // if the line starts with .word
					line = line.substring(5, line.length());
					parsedRecord = line.split(",");// breaking the line up by commas to find the amount of values
					for (int i = 0; i < parsedRecord.length; i++) {
						//System.out.println(parsedRecord[i]);
						parsedRecord[i] = parsedRecord[i].trim(); // trim white space of each value
						binary = Binary.sDecToBin(Long.parseLong(parsedRecord[i]), 32); // convert each to a boolean
						binTemp = dataBoolToString(binary);																// array
						
						dataOut.write(binTemp+"\n"); // write to dataWriter
					}
//					for(int i = 0; i<parsedRecord.length; i++) {
//						System.out.println(parsedRecord[i]);
//					}

				}
				else if(line.startsWith("ADD")) {
					parsedRecord = formatInstString(line);
					machineLang = formatADDSUBANDORR(Opcode.ADD, parsedRecord);
					codeOut.write(machineLang + '\n');
				}
				else if(line.startsWith("SUB")) {
					parsedRecord = formatInstString(line);
					machineLang = formatADDSUBANDORR(Opcode.SUB, parsedRecord);
					codeOut.write(machineLang + '\n');

				}
				else if(line.startsWith("AND")) {
					parsedRecord = formatInstString(line);
					machineLang = formatADDSUBANDORR(Opcode.AND, parsedRecord);
					codeOut.write(machineLang + '\n');

				}
				else if(line.startsWith("ORR")) {
					parsedRecord = formatInstString(line);
					machineLang = formatADDSUBANDORR(Opcode.ORR, parsedRecord);
					codeOut.write(machineLang + '\n');

				}
				else if(line.startsWith("LDR")) {
					parsedRecord = formatInstString(line);
					machineLang = formatLDRSTR(Opcode.LDR, parsedRecord);
					codeOut.write(machineLang + '\n');

				}
				else if(line.startsWith("STR")) {
					parsedRecord = formatInstString(line);
					machineLang = formatLDRSTR(Opcode.STR, parsedRecord);
					codeOut.write(machineLang + '\n');
				}
				else if(line.startsWith("CBZ")) {
					parsedRecord = formatInstString(line);
					machineLang = formatCBZ(Opcode.CBZ, parsedRecord);
					codeOut.write(machineLang + '\n');
				}
				else if(line.startsWith("B")) {
				
					parsedRecord = formatInstString(line);
					machineLang = formatB(Opcode.B, parsedRecord);
					codeOut.write(machineLang + '\n');
				}
				else if(line.startsWith(".end")) {
					parsedRecord = formatInstString(line);
					machineLang = formatHLT(Opcode.HLT, parsedRecord);
					codeOut.write(machineLang + '\n');
				}
			}
			
		}
		
		
		
		catch (Throwable throwable) {
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Throwable throwable) {
				}
			}
		}
		dataOut.close();
		codeOut.close();
	}
	/**
	  * Method changed data boolean array to a usable string seperated by 8 bits per line
	  * 
	  * @param bin, a binary boolean array
	  * @return a String which is the boolean aray changed to a string
	  */
	private static String dataBoolToString(boolean[] bin) {
		String result = ""; // result string
		int counter = 32;
		for (int i = 0; i < bin.length; i++) { // loop through binary array
			
			if (bin[i] == true) { // set binary to string
				result += "true ";
			} else {
				result += "false ";
			}
			counter--;
			if (counter % 8 == 0 && counter > 0) { // make a new line every 8
				result += "\n";
			}
		}
		return result; // return string result
	}
	 /**
	  * Method changed a boolean array to a usable string seperated by 8 bits per line
	  * 
	  * @param bin, a binary boolean array
	  * @return a String which is the boolean aray changed to a string
	  */
	private static String boolToString(boolean[] bin) {
		String result = ""; // result string
		
		for (int i = bin.length - 1; i >= 0; i--) { // loop through binary array
			
			if (bin[i] == true) { // set binary to string
				result += "true ";
			} else {
				result += "false ";
			}
			
			if (i % 8 == 0 && i > 0) { // make a new line every 8
				result += "\n";
			}
		}
		return result; // return string result
	}
	 /**
	  * Method formats an instruction line to get ride of the instruction and format so 
	  * there is a String array with the operands which will be changed
	  * 
	  * @param val, the string which is the line the reader read
	  * @return parsedString which has the instructions which will be changed to machine code
	  */
	private static String[] formatInstString(String val) {
		String string = val;
		String[] parsedString;
		string = string.substring(4, string.length()); // getting rid of instruction(ADD, SUB,...)
		string = string.trim();
		parsedString = string.split(",");
		return parsedString; //returning the formated parsed string
	}
	
	/**
	 * Method formats a string for the ADD, SUB, AND, ORR instructions
	 * @param opcode, the opcode for the B instruction
	 * @param operands, the operands of the instruction line
	 * @return the string of the instruction 
	 */
	private static String formatADDSUBANDORR(boolean[] opcode,String[] operands) {
		String string = "";
		boolean[] binary = new boolean[32]; // creatng the binary boolean array	
		
		String dest = operands[0].substring(1,operands[0].length()); // setting the destination register string to the last first register in the parsed record	
		boolean[] destBin =  Binary.sDecToBin(Long.parseLong(dest), 5); // changing the destination register number to second register binary boolean array
		String sourceReg1 = operands[1].substring(1,operands[1].length()); // setting the source reg 1 string to the first register in the parsedrecord
		boolean[] sourceReg1Bin = Binary.uDecToBin(Long.parseLong(sourceReg1), 5); // changing the source1 register number to binary boolean array
		boolean[] shiftBin = {false,false,false,false,false,false}; // creating the shift binary array
		String sourceReg2 = operands[2].substring(1,operands[2].length()); // setting the source reg 2 string to the third register in the parsed record
		boolean[] sourceReg2Bin = Binary.uDecToBin(Long.parseLong(sourceReg2), 5);; // changing the source reg 2 register to the binary boolean array
		
		
		int tempDest = 0; // placeholder value to allow binary dest resister to go into binary array with index
		int tempSrc1 = 0; // placeholder value to allow binary source1 resister to go into binary array with index
		int tempSrc2 = 0; // placeholder value to allow binary source2 resister to go into binary array with index
		int tempShift = 0; // placeholder value to allow binary shift resister to go into binary array with index
		int tempOpcode = 10; // placeholder value to allow binary opcode to go into binary array with index
		

		for(int i = 0; i < binary.length; i++) {
			//first inserting the opcode binary
			if(i<11) {
				binary[i] = opcode[tempOpcode];
				tempOpcode--;
			}
			//then inserting the source reg2 binary
			if(i>=11 && i<16) {
				binary[i] = sourceReg2Bin[tempSrc2];
				tempSrc2++;
			}
			//then inserting the shift binary
			if(i>=16 && i<22) {
				binary[i] = shiftBin[tempShift];
				tempShift++;
			}
			//then inserting the source reg1 binary
			if(i>=22 && i<27) {
				binary[i] = sourceReg1Bin[tempSrc1];
				tempSrc1++;
			}
			//then inserting the dest reg binary
			if (i>27) {
				binary[i] = destBin[tempDest];
				tempDest++;
			}
			
			
			
			//System.out.println(i);
			//System.out.println(binary[i]);
			
		}
		//formating the binary array into 4bytes and placing that into a string variable
		string = boolToString(binary);
		//System.out.println(string);
		
		//returning the string variable
		return string;
	}
	
	/**
	 * Method formats a string for the LDR, STR instructions
	 * @param opcode, the opcode for the B instruction
	 * @param operands, the operands of the instruction line
	 * @return the string of the instruction 
	 */
	private static String formatLDRSTR(boolean[] opcode,String[] operands) {
		String string = "";
		boolean[] binary = new boolean[32]; // creatng the binary boolean array	

		String valueReg = operands[0].substring(1,operands[0].length()); // setting the destination register string to the last first register in the parsed record	

		boolean[] valueRegBin =  Binary.uDecToBin(Long.parseLong(valueReg), 5); // changing the destination register number to second register binary boolean array
		String baseReg = operands[1].substring(2,operands[1].length()); // setting the source reg 1 string to the first register in the parsedrecord
		boolean[] baseRegBin = Binary.uDecToBin(Long.parseLong(baseReg), 5); // changing the source1 register number to binary boolean array

		boolean[] shiftBin = {false,false}; // creating the shift binary array
		
		String immediate = operands[2].substring(1,operands[2].length()); // setting the source reg 2 string to the third register in the parsed record
		immediate = immediate.substring(0,1);
//		System.out.println(valueReg);
//		System.out.println(baseReg);
//		System.out.println(immediate);
		boolean[] immediateBin = Binary.sDecToBin(Long.parseLong(immediate), 9);; // changing the source reg 2 register to the binary boolean array
		
		int tempValue = 0; // placeholder value to allow binary value resister to go into binary array with index
		int tempBase = 0; // placeholder value to allow binary base  resister to go into binary array with index
		int tempShift = 0; // placeholder value to allow binary shift amount to go into binary array with index
		int tempImmediate = 0; // placeholder value to allow binary immediate to go into binary array with index
		int tempOpcode = 10; // placeholder value to allow binary opcode to go into binary array with index
		
		
		
		for(int i = 0; i < binary.length; i++) {
			//first inserting the opcode binary
			if(i<11) {
				binary[i] = opcode[tempOpcode];
				tempOpcode--;
			}
			//then inserting the source reg2 binary
			if(i>=11 && i<20) {
				binary[i] = immediateBin[tempImmediate];
				tempImmediate++;
			}
			//then inserting the shift binary
			if(i>=20 && i<22) {
				binary[i] = shiftBin[tempShift];
				tempShift++;
			}
			//then inserting the source reg1 binary
			if(i>=22 && i<27) {
				binary[i] = baseRegBin[tempBase];
				tempBase++;
			}
			//then inserting the dest reg binary
			if (i>27) {
				binary[i] = valueRegBin[tempValue];
				tempValue++;
			}
			
			
			
			//System.out.println(i);
			//System.out.println(binary[i]);
			
		}
		//formating the binary array into 4bytes and placing that into a string variable
		string = boolToString(binary);
		System.out.println(string);
		System.out.println();
		
		//returning the string variable
		return string;
	}
	
	/**
	 * Methods formats a string for the CBZ instruction
	 * @param opcode, the opcode for the B instruction
	 * @param operands, the operands of the instruction line
	 * @return the string of the instruction 
	 */
	private static String formatCBZ(boolean[] opcode,String[] operands) {
		String string = "";
		
		boolean[] binary = new boolean[32]; // creatng the binary boolean array	

		
		int tempOpcode = 10; // placeholder value to allow binary opcode to go into binary array with index

		for(int i = 0; i < binary.length-1; i++) {
			//first inserting the opcode binary
			if(i<11) {
				binary[i] = opcode[tempOpcode];
				tempOpcode--;
			}
			
			
		}
		
		return string;
	}
	
	/**
	 * Methods formats a string for the B instruction
	 * @param opcode, the opcode for the B instruction
	 * @param operands, the operands of the instruction line
	 * @return the string of the instruction 
	 */
	private static String formatB(boolean[] opcode,String[] operands) {
		String string = "";
		
		
		boolean[] binary = new boolean[32]; // creatng the binary boolean array	
		
		int tempOpcode = 10; // placeholder value to allow binary opcode to go into binary array with index

		for(int i = 0; i < binary.length-1; i++) {
			//first inserting the opcode binary
			if(i<11) {
				binary[i] = opcode[tempOpcode];
				tempOpcode--;
			}
			
			
		}
		
		return string;
	}
	
	/**
	 * Methods formats a string for the HLT instruction
	 * @param opcode, the opcode for the B instruction
	 * @param operands, the operands of the instruction line
	 * @return the string of the instruction 
	 */
	private static String formatHLT(boolean[] opcode,String[] operands) {
		String string = "";
		
		boolean[] binary = new boolean[32]; // creatng the binary boolean array	

		int tempOpcode = 10; // placeholder value to allow binary opcode to go into binary array with index
		int tempNotUsed = 0;
		
		boolean[] notUsedBin = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
		for(int i = 0; i < binary.length-1; i++) {
			//first inserting the opcode binary
			if(i<11) {
				binary[i] = opcode[tempOpcode];
				tempOpcode--;
			}
			//then inserting the source reg2 binary
			if(i>=11) {
				binary[i] = notUsedBin[tempNotUsed];
				tempNotUsed++;
			}
		}
			
		string = boolToString(binary); 
		
		return string;
	}

}
