public class GameOfMasterMind {
	public static final int TOTAL_COLOR_COUNT = 4;

	public static int code(char c) {
		switch (c) {
		case 'B':
			return 0;
		case 'G':
			return 1;
		case 'R':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}
	}

	public static int[] countHit(String guess, String solution) {
		//incorrect input
		if (guess.length() != TOTAL_COLOR_COUNT || solution.length() != TOTAL_COLOR_COUNT) {
			return notFound();
		}

		//scan array and find hit and psuedo hit
		int hitCount = 0;
		int pHitCount = 0;

		int[] freqs = new int[TOTAL_COLOR_COUNT];

		//count hit, and add freq to each color
		for (int i = 0; i < guess.length(); i++) {
			char guess_char = guess.charAt(i);
			if (guess_char == solution.charAt(i)){
				hitCount += 1;
			} else {
				freqs[code(solution.charAt(i))] += 1;
			}
		}

		for (int i = 0; i < guess.length(); i++) {
			int code = code(guess.charAt(i));
			if (code >= 0 && freqs[code] > 0 && solution.charAt(i) != guess.charAt(i)) {
				pHitCount++;
				freqs[code]--;
			}
		}
		return new int[] {hitCount, pHitCount};
	}

	public static int[] notFound() {
		return new int[] {0, 0};
	}

	public static void main(String[] args) {
		String solution = "RGBY";
		String guess = "GGRR";
		int[] res = countHit(guess, solution);
		System.out.println("hit: " + res[0]);
		System.out.println("pseudeo-hit: " + res[1]);
	}
}