package ce226.recursion;

public class RecursionExploration {

	
	public int findLargest() {
		int[] values = {17, 35, 2, -7, 14};
		
		int largest = values[0];
		
		for (int i = 0; i < values.length; i++) {
			if (values[i] > largest) {
				largest = values[i];
			}
		}
		
		return largest;
	}
	
	
	public int searchThroughArray(int [] values) {
		int largest = values[0];
		
		for(int i = 0; i < values.length;i++) {
			//call method to compare and return largest
			//between the current largest and current value in the lest
			
			compareForLargestInt(values, i, largest);
		}
		
		return largest;
	}
	
	public int compareForLargestInt(int[] numbers, int position, 
									int currentLargest) {
				
		if(numbers[position] > currentLargest) {
			return numbers[position];
		}
		return currentLargest;
		aa
	}
	
	public int useNewComparison() {
		int[] values = {17, 35, 2, -7, 14};
		
		return searchThroughArray(values);
		
	}
	
	public static void main(String[] args) {
		RecursionExploration me = new RecursionExploration();
		System.out.println(me.useNewComparison());
	}
}
