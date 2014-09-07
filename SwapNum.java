public class SwapNum {
	public static void swap(int[] array, int a, int b) {
		array[a] = array[a] + array[b];
		array[b] = array[a] - array[b]; // b = (a + b) - b = a
		array[a] = array[a] - array[b];  // a = (a + b) - a = b
	}

	public static void main(String[] args) {
		int[] array = new int[]{1, 3, 5, 7, 9};
		swap(array, 2, 4);
		for (int i : array) {
			System.out.print(i + "; ");
		}
		System.out.println();
	}
}