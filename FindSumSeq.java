public class FindSumSeq {
	public static int largestContSum(int[] nums) {
		int n = nums.length - 1;
		int maxSum = 0;
		int sum = 0;

		while (n >= 0 && nums[n] <= 0)
			n--;

		while (n >= 0) {
			if (sum + nums[n] >= 0) {
				sum += nums[n];
				if (maxSum < sum)
					maxSum = sum;
			} else {
				sum = 0;
			}
			n--;
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {-2, -3, -8, -1, -2, -4, -2, -3};
		System.out.println(largestContSum(nums));
	}
}