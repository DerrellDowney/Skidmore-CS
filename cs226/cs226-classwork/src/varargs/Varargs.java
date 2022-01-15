package varargs;

public class Varargs {
	/**
	 * append any number of strings and return result
	 */
	public String appendStrings(String... strings) {
		String allStrings = "";
		for (String str:strings) {
			allStrings = allStrings + str;
		}
		return allStrings;
	}
	
	/**
	 * methods takes doubles and computes average, returning average
	 * @param args
	 */
	public double average(double... numbers) {
		double all = 0;
		for (double d: numbers) {
			all = all+ d;
		}
		return all/numbers.length;
	}
	
	public static void main(String[] args) {
		Varargs instance = new Varargs();
		String result;
		double result1;
		
		result = instance.appendStrings("computer", "cat", "hello");
		System.out.println("The result is: " + result);
		
		result1 = instance.average(2, 4, 6);
		System.out.println("The result is: " + result1);
	}
}

