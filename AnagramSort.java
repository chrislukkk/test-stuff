import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class AnagramSort {
	private static String getAnagramStr(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	private static void anagramSort(String[] array) {
		HashMap<String, ArrayList<String>> anagramMap 
			= new HashMap<String, Ar
			rayList<String>>();
		for (String s : array) {
			String anaStr = getAnagramStr(s);
			if (!anagramMap.containsKey(anaStr))
				anagramMap.put(anaStr, new ArrayList<String>());
			anagramMap.get(anaStr).add(s);
		}

		int i = 0;
		for (String key : anagramMap.keySet()) {
			for (String s : anagramMap.get(key)) {
				array[i++] = s;
			}
		}
	}

	public static void main(String[] args) {
		String[] a = new String[] { "sf", "acre", "deb", "bed", "reac", "read", "dear", "jjj" };
		anagramSort(a);
		for (String s : a) {
			System.out.print(s + "; ");
		}
	}
}