public class FindIndex {
	private class Result {
		private int m;
		private int n;

		public Result(int m, int n) {
			this.m = m;
			this.n = n;
		}

		@Override public String toString() {
			return m + ", " + n;
		}
	}

	private int[] array;
	public FindIndex(int[] array) {
		this.array = array;
	}

	public Result find() {
		int length = array.length;
		//find left increasing sequence
		int m = 0;
		while (m < length - 1 && array[m] <= array[m+1])
			m++;
		if (m == length - 1)//already sorted
			return new Result(-1, -1);

		//find right decreasing sequence
		int n = length - 1;
		while (n > 0 && array[n] >= array[n-1])
			n--;
		if (n == 0)//already sorted
			return this.new Result(-1, -1);
		if(n < m)
			return this.new Result(-1, -1);
		if(n == m)
			return this.new Result(m, m);

		//find min and max from m-n
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = m; i < length; i++) {
			if (array[i] < min)
				min = array[i];
		}

		for (int i = 0; i <= n; i++) {
			if (array[i] > max)
				max = array[i];
		}

		// for (int i = m; i <= n; i++) {
		// 	if (array[i] < min)
		// 		min = array[i];
		// 	else if (array[i] > max)
		// 		max = array[i];
		// }

		//find correct m and n
		while (m >= 0 && array[m] > min)
			m--;
		while (n < length && array[n] < max)
			n++;

		return this.new Result(m + 1, n - 1);
	}

	public static void main(String[] args) {
		FindIndex fi = new FindIndex(new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19});
		FindIndex fi2 = new FindIndex(new int[]{7,16,18,19,21,22,23,1,2,4,7});
		Result res = fi.find();
		Result res2 = fi2.find();
		System.out.println(res);
		System.out.println(res2);
	}
}