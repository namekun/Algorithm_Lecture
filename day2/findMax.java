package day2;

public class findMax {
	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(findMax(data, 0, data.length-1));
		System.out.println(findMaxVer2(data, 0, data.length-1));
	}

	public static int findMax(int[] data, int begin, int end) {
		if (begin == end)
			return data[begin];
		else
			return Math.max(data[begin], findMax(data, begin + 1, end));
	}

	static int findMaxVer2(int[] data, int begin, int end) {
		if (begin == end)
			return data[begin];
		else {
			int middle = (begin + end) / 2;
			int max1 = findMaxVer2(data, begin, middle);
			int max2 = findMaxVer2(data, middle + 1, end);
			return Math.max(max1, max2);
		}
	}
}
