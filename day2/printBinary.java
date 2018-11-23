package day2;

public class printBinary {
	public static void main(String[] args) {
		printInBinary(21654);
	}
	
	public static void printInBinary(int n){
	    if(n<2)
	        System.out.print(n);
	    else{
	        // n을 2로 나눈 몫을 먼저 2진수로 변환하여 print한 후,
	        printInBinary(n/2);
	        // n을 2로 나눈 나머지를 인쇄한다.
	        System.out.print(n%2);
	    }
	}
}
