package day2;

public class SequentialSearch {
	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5 };
		int begin = 0;
		int end = 4;
		System.out.println(search(data, begin, end, 4));
	}

	public static int search(int[] data, int begin, int end, int target) {
		if (begin > end)
			return -1;
		else if (target == data[begin])
			return begin;
		else
			return search(data, begin + 1, end, target);
	}
}
