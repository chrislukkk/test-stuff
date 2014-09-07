//career cup 9.1
public class SortedMerge {
	private static void sort(int[] A, int[] B, int n, int m) {
		//n is number of elements in A array, m is number of elements in B array
		int index_a = n - 1;
		int index_b = m - 1;
		int resIndex = n + m - 1;

		while (index_b >= 0) {
			if (index_a >= 0 && A[index_a] > B[index_b])
				A[resIndex--] = A[index_a--];
			else
				A[resIndex--] = B[index_b--];
		}
	}

	public static void main(String[] args) {
		int[] fir = new int[]{1,3,4,6,8,11,34,0,0,0,0,0};
		int[] sec = new int[]{-2, 2,7,13,45};
		sort(fir, sec, 7, 5);
		for (int a : fir) {
			System.out.print(a + "; ");
		}
	}
}