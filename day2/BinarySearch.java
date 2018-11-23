package day2;

public class BinarySearch {
	public static void main(String[] args) {
		String [] data = {"hi", "hello", "nihao", "gonnichiwa"};	
		System.out.println(binarySearch(data, "nihao", 0, data.length-1));
	}

	public static int binarySearch(String [] items, String target, int begin, int end) {
		if (begin > end)
			return -1;
		else {
			int middle = (begin + end) / 2;
			int comResult = target.compareTo(items[middle]);
			if (comResult == 0)
				return middle;
			else if (comResult < 0)
				return binarySearch(items, target, begin, middle - 1);
			else
				return binarySearch(items, target, middle + 1, end);
		}
	}
}
