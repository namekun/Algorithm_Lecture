package day2;

public class length {
	public static void main(String[] args) {
		int Length = length("gigigi");
		System.out.println(Length);
	}
	
	public static int length(String str) {
		if(str.equals(""))
			return 0;
		else
			return 1+ length(str.substring(1));
	}
}
 