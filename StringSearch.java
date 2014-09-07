public class StringSearch {

	public static int search(String[] array, int lo, int hi, String x) {
		if (lo > hi) return -1;
		int mid = hi - (hi - lo) / 2;
		if (array[mid] == x)
			return mid;
		int compare_res = 0;
		int left = findNextLeft(array, mid, lo);
		if (left >= lo) {
			if (array[left] == x) return left;
			compare_res = array[left].compareTo(x);
			if (compare_res > 0) // array[left] larger than x
				return search(array, lo, left - 1, x);
			else
				return search(array, left + 1, hi, x);
		}

		int right = findNextLeft(array, mid, hi);
		if (right >= 0 && right <= hi) {
			if (array[right] == x) return right;
			compare_res = array[right].compareTo(x);
			if (compare_res > 0) // array[left] larger than x
				return search(array, lo, right - 1, x);
			else
				return search(array, right + 1, hi, x);
		}

		//not found
		return -1;
		
	}

	private static int findNextLeft(String[] array, int start, int head) {
		int cur = start;
		while (cur >= head) {
			if (array[cur] != "")
				return cur;
			cur--;
		}
		return -1;
	}

	private static int findNextRight(String[] array, int start, int tail) {
		int cur = start;
		while (cur <= tail) {
			if (array[cur] != "")
				return cur;
			cur++;
		}
		return -1;
	}

	public static void main(String[] args) {
		String[] testArray = new String[] {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(search(testArray, 0, testArray.length - 1, "ab"));
		//System.out.println("123" == "123");
	}
}