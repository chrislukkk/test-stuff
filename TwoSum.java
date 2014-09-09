import java.util.Random;
import java.util.ArrayList;

public class TwoSum {

	private class Res {
		private int fir;
		private int sec;
		public Res(int f, int s) {
			fir = f;
			sec = s;
		}

		@Override public String toString() {
			return "(" + fir + ", "+ sec + ")";
		}
	}

	public ArrayList<Res> findPairs(int[] nums, int sum) {
		ArrayList<Res> results = new ArrayList<>();
		int start = 0;
		int end = nums.length - 1;

		//sort
		qsort(nums, start, end);

		while (start < end) {
			int k = nums[start] + nums[end];
			if (k == sum) {
				results.add(new Res(nums[start], nums[end]));
				while (start < nums.length - 1 && nums[start] == nums[start + 1])
					start++;
				while (end > 0 && nums[end] == nums[end - 1])
					end--;
				start++;
				end--;
			} else if (k < sum) {
				start++;
			} else {
				end--;
			}
		}

		return results;
	}

	private void qsort(int[] nums, int lo, int hi) {
		if (lo >= hi) return;
		Random r = new Random();
		int l = hi - lo + 1;
		swap(nums, lo, lo + r.nextInt(l));
		int pivot = partition(nums, lo, hi);
		qsort(nums, lo, pivot - 1);
		qsort(nums, pivot + 1, hi);
	}

	private int partition(int[] nums, int lo, int hi) {
		int i = lo + 1;
		int j = lo;
		while (i <= hi) {
			if (nums[i] < nums[lo]) {
				swap(nums, i, ++j);
			}
			i++;
		}
		swap(nums, lo, j);
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int a = nums[i];
		nums[i] = nums[j];
		nums[j] = a;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,13,5,6,12,54,2,17,9,-10,0};
		TwoSum ts = new TwoSum();
		ArrayList<Res> results = ts.findPairs(nums, 7);

		for (Res res : results) {
			System.out.print(res);
		}
	}
}