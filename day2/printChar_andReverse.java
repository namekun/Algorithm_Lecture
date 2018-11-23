package day2;

public class printChar_andReverse {
	public static void main(String[] args) {

		printChars("Hello");
		System.out.println();
		printCharReverse("Hello");
		
	}
	
	public static void printChars(String str) {
		if(str.length() == 0) 
			return;
		else {
			System.out.print(str.charAt(0) + " ");
			printChars(str.substring(1));
		}
	}
	
	public static void printCharReverse(String str) {
		if(str.length() == 0)
			return;
		else {
			printCharReverse(str.substring(1));
			System.out.print(str.charAt(0) + " ");
		}
	}
}
