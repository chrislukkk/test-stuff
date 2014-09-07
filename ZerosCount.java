public class ZerosCount {
	public static int countZeroInNFactorial (int n) {
		if (n <= 5)
			return 0;

		int count = 0;
		int k = 5;
		while (n >= k) {
			count += n / k;
			k *= 5;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countZeroInNFactorial(26));
	}
}