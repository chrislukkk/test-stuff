public class FindMax {
	public static int findMax(int a, int b) {
		int c = a - b;
		int k = 0, q = 0;

		//sign of a, b and a-b
		int sign_a = (a >> 31) & (0x1);
		int sign_b = (b >> 31) & (0x1);
		int sign_c = (c >> 31) & (0x1) ^ 1;

		//if a and b has different sign
		int isSignDiff = sign_a ^ sign_b; // 1 if sign of a and b are different
		k = sign_a ^ isSignDiff; 	// if sign diff = 1, then 
									// 1) sign_a = 0, a is larger k = 1
									// 2) sign_a = 1, a is smaller k = 0

		// if sign diff = 1, k keep same
		// if sign diff = 0, k = sign_c// 2) sign_a = 1, a is smaller k = 0
		k = isSignDiff * k + (isSignDiff ^ 1) * sign_c;
		q = k ^ 1;
		return k * a + q * b;
	}

	public static void main(String[] args) {
		System.out.println(findMax(-10, Integer.MAX_VALUE));
		System.out.println(findMax(-10, 200));
		System.out.println(findMax(100, -20));
		System.out.println(findMax(200, 300));
		System.out.println(findMax(500, 100));
	}
}