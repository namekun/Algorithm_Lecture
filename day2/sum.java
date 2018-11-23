package day2;

public class sum {
	public static void main(String[] args) {
		int [] a = {1, 2,3,4,5};
		int sum = sum(5, a);
		System.out.println(sum);
	}
	
	public static int sum(int n, int [] data) {
		if(n<=0)
			return 0;
		else {
			return sum(n-1,data) + data[n-1];
		}
	}
}
