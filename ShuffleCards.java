import java.util.Random;

public class ShuffleCards {
	//Fisher-Yates shuffle
	public static void shuffle(int[] cards) {
		Random r = new Random();
		for (int i = cards.length - 1; i > 0; i--) {
			int k = r.nextInt(i + 1);
			swap(cards, k, i);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		int[] cards = new int[52];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = i + 1;
		}

		shuffle(cards);

		for (int card : cards)
			System.out.print(card + "; ");
		System.out.println();

	}
}