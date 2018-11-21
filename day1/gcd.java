package day1;

public class gcd {
	public static void main(String[] args) {
		System.out.println(gcd(15, 48));
	}

	public static double gcd(int m, int n) {
		if (m < n) {
			int tmp = m;
			m = n;
			n = tmp;
		}

		if (m % n == 0)
			return n;
		else
			return gcd(n, m%n);
	}
}
