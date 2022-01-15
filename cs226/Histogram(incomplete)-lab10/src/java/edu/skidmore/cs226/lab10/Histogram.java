package edu.skidmore.cs226.lab10;

import java.io.FileReader;
import java.io.LineNumberReader;
import org.apache.log4j.Logger;

public class Histogram {
	
	private final static Logger LOG;
	
	static {
		LOG = Logger.getLogger(Histogram.class);
	}
	
	
	private final static String FILE_NAME = "/cs226-lab10indiv/hist_numbers.scores.small.txt";
	
	/**
	 * The asterisk limit
	 */
	private int limit = 50;
	
	private String letArr[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	private String legendArr[] = {"0-9", "10-19", "20-29", "30-39", "40-49", "50-59", "60-69", "70-79", "80-89", "90-100"};

	
	private int lineCount() {
		LineNumberReader reader = null;
		int lineCount = 0;
		try {
			reader = new LineNumberReader(new FileReader(FILE_NAME));
			while (reader.readLine() != null) {
				;
			}
			
		}
		catch (Throwable throwable) {
			LOG.error("Error occured "+throwable);;
		}
		finally {
			if (reader != null) {
				try {
					reader.close();
				}
				catch (Throwable throwable) {
					LOG.error("Error occured "+throwable);
				}
			}
		}
		System.out.println(lineCount);
		return lineCount;
	}
	
	
	public int[] createArrFromFile() {
		int[] arr = new int[lineCount()];
		
		return arr;
	}
	
	public int[] asteriskValue(int[] arr) {
		int[] valueArr = new int[10];
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]<=9) {
				valueArr[0]+=1;
			}
			else if(arr[i]<=19) {
				valueArr[1]+=1;
			}
			else if(arr[i]<=29) {
				valueArr[2]+=1;
			}
			else if(arr[i]<=39) {
				valueArr[3]+=1;
			}
			else if(arr[i]<=49) {
				valueArr[4]+=1;
			}
			else if(arr[i]<=59) {
				valueArr[5]+=1;
			}
			else if(arr[i]<=69) {
				valueArr[6]+=1;
			}
			else if(arr[i]<=79) {
				valueArr[7]+=1;
			}
			else if(arr[i]<=89) {
				valueArr[8]+=1;
			}
			else if(arr[i]<=100) {
				valueArr[9]+=1;
			}
		}
		return valueArr;
	}
	
	public void returnHistogram(int[] arr) {
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(letArr[i] + ": "); 
			for(int j = 0; i<arr[i]; j++) {
				System.out.print("*");
				System.out.println();
			}
			
		}
		
		System.out.println("Legend");
		for(int i = 0; i<arr.length; i++) {
			System.out.print(letArr[i] + ": ");
			System.out.print(legendArr[i] + " ");
			System.out.println("("+arr[i]+")");
		}
		
	}
}
