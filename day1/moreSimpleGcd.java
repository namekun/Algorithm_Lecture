package day1;

public class moreSimpleGcd {
	public static void main(String[] args) {
		System.out.println(gcd(16, 52));
	}

	public static double gcd(int p, int q) {
		if(q==0) 
			return p;
		else 
			return gcd(q, p%q);
	}
}
