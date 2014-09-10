import java.util.HashSet;
import java.util.Arrays;

public class MinUnrecognizedSeq {
	public static String unfold(String seq, HashSet<String> dict) {
		if(seq == null || seq.isEmpty())
			return "";

		int n = seq.length();

		//s[i][j] is the minimum of unrecognized char between i and j in seq
		int[][] s = new int[n][n];
		int[][] b = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				s[i][j] = (i != j ? Integer.MAX_VALUE : (dict.contains("" + seq.charAt(i)) ? 0 : 1));  
			}
		}
		for (int l = 1; l < n ; l++) {
			for (int i = 0; i < n - l; i++) {
				int j = i + l;
				if (dict.contains(seq.substring(i, j+1))) {
					s[i][j] = 0;
					b[i][j] = -1;
				} else {
					for (int k = i; k < j; k++) {
						int count = s[i][k] + s[k+1][j];
						if (count < s[i][j]){
							s[i][j] = count;
							b[i][j] = k;
						}
					}
					
				}
			}
		}

		System.out.println("min unrecognized count = " + s[0][n - 1]);

		String res = construct(s, b, 0, n - 1, seq);
		return res;
	}

	private static String construct(int[][] s, int[][] b, int i, int j, String seq) {
		if (i > j) 
			return "";
			
		int k = b[i][j];
		if (k == -1)
			return " " + seq.substring(i, j + 1) + " ";
		else if (i == j)
			return "" + seq.charAt(i);
		else
		{
			String left = construct(s, b, i, k, seq);
			String right = construct(s, b, k + 1, j, seq);
			if (left.charAt(left.length() - 1) == ' ' && right.charAt(0) == ' ')
				left = left.substring(0, left.length() - 1);
			return left + "" + right;
		}
	}

	public static void main(String[] args) {
		HashSet<String> test_dict = new HashSet<String>(Arrays.asList("looked", "just", "like", "her", "brother"));
		System.out.println(unfold("jesslookedjustliketimherbrother", test_dict));
	}
}