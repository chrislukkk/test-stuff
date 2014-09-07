public class MatrixSearch {
	public static int[] search (int[][] mat, int x) {
		int row = 0;
		int col = mat[0].length - 1;
		while (row <= mat.length - 1 && col >= 0) {
			if (mat[row][col] == x)
				return getAns(row, col);
			if (mat[row][col] > x)
				col--;
			else
				row++;
		}
		return notFound();
	}

	private static int[] getAns(int row, int col) {
		return new int[] {row, col};
	}

	private static int[] notFound() {
		return new int[] {-1, -1};
	}

	public static void main(String[] args) {
		int[][] mat = new int[][]{{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
		int[] res = search(mat, 100);
		System.out.println(res[0] + ", " + res[1]);
	}
}