package day2;

public class SequentialSearchVer2 {
	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(search(data, 0, data.length-1, 1));
	}

	public static int search(int[] data, int begin, int end, int target) {
		if (begin > end)
			return -1;
		else {
			int middle = (begin + end) / 2;
			if (data[middle] == target)
				return middle;
			int idx = search(data, begin, middle - 1, target);
			if (idx != -1)
				return idx;
			else
				return search(data, middle + 1, end, target);
		}
	}
}
