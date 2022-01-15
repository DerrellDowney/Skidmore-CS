package cs226.instanceclass;

public class Strings {
	public static void main (String[] args) {
		String s = "Wednesday is today";
		System.out.println(s);
		String t = "Wednesday is today";
		
		
		if (s == t) {
			System.out.println("Same!");
		}
		else {
			System.out.println("Different!");
		}
		
		
		String u = s + ", Thursday is tomorrow";
		System.out.println(u);
	
		
		int r = 5;
		System.out.println(s);
		
		
		String v = u;
		if (s.equalsIgnoreCase(v)) {
			System.out.println("Same!");
		}
		else {
			System.out.println("Different!");
		}
		
		String a = "Apple";
		String b = "apple";
		
		int c = a.compareTo(b);
		System.out.println("Difference is " + c);
		System.out.println(u.indexOf(","));
		
		String phrase = "to be or not to be";
		String phraseNew = phrase.toUpperCase();
		System.out.println(phraseNew);

	}
}
