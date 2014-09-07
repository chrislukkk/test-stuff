public class RotateSearch {
	public static int search(int[] array, int lo, int hi, int target) {
		if (lo > hi) return -1;
		int mid = hi - (hi - lo) / 2;
		int res = -1;
		if (array[mid] ==  target)
			return mid;

		//one half is normally ordered
		if (array[mid] > array[lo]) {
			//left half is ordered
			if (target < array[mid] && target >= array[lo])
				res = search(array, lo, mid - 1, target);
			else
				res = search(array, mid + 1, hi, target);
		} else if (array[mid] < array[lo]) {
			//right half is ordered
			if (target > array[mid] && target <= array[hi])
				res = search(array, mid + 1, hi, target);
			else
				res = search(array, lo, mid - 1, target);
		} else {
			//array[mid] == array[left]
			if (array[mid] != array[hi])
				res = search(array, mid + 1, hi, target);
			else {
				res = search(array, mid + 1, hi, target);
				if (res >= 0) return res;
				res = search(array, lo, mid - 1, target);
			}
		}
			
		return res;
	}

	public static void main(String[] args) {
		//int[] array = new int[] {15,16,19,20,25,26,27,28,29,1,3,4,5,7,10,14};
		int[] array = new int[] {2,3,4,2,2,2,2};
		System.out.println(search(array, 0, array.length - 1, 3));
	}
}