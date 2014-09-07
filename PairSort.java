import java.util.ArrayList;

public class PairSort {
	public static int sortPairs(ArrayList<Person> persons) {
		ArrayList<Person> personsByHeight = sortByHeight(persons);
		for (Person p : personsByHeight) {
			System.out.println(p.height + ", " + p.weight);
		}
		return findLIS(personsByHeight);
	}

	private static ArrayList<Person> sortByHeight(ArrayList<Person> persons) {
		int max = Integer.MIN_VALUE;
		for (Person p : persons) {
			if (p.height > max)
				max = p.height;
		}

		ArrayList<ArrayList<Person>> buckets = new ArrayList<ArrayList<Person>>();
		for (int i = 0; i < max+1; i++)
			buckets.add(new ArrayList<Person>());
		for (Person p : persons)
			buckets.get(p.height).add(p);
		
		ArrayList<Person> res = new ArrayList<Person>();
		for (int i = 0; i < buckets.size(); i++) {
			ArrayList<Person> p = buckets.get(i);
			while (!p.isEmpty()) {
				res.add(p.remove(p.size() - 1));
			}
		}
		return res;
	}

	private static int findLIS(ArrayList<Person> persons) {
		if(persons == null || persons.isEmpty())
			return 0;
		//initialize cache
		ArrayList<Info> cache = new ArrayList<>();
		cache.add(new Info(1, 0));

		//iterative loop for the optimal info end at index i
		for (int i = 1; i < persons.size(); i++) {
			Info maxInfo = new Info(1, i);
			for (int j = 0; j < i; j++) {
				Info cur = new Info(cache.get(j).count, cache.get(j).lastIndex);
				if (persons.get(i).weight > persons.get(cur.lastIndex).weight) {
					cur.count++;
					cur.lastIndex = j;
				}
				if (maxInfo.count < cur.count)
					maxInfo = cur;
			}
			cache.add(maxInfo);
		}

		//int a = 0;
		//for (Info inf : cache) {
		//	System.out.println("end at " + a + " " + inf.count + " " + inf.lastIndex);
		//	a++;
		//}

		return cache.get(persons.size() - 1).count;
	}

	public static void main(String[] args) {
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person(65, 100));
		persons.add(new Person(70, 150));
		persons.add(new Person(56, 180));
		persons.add(new Person(75, 190));
		persons.add(new Person(60, 95));
		persons.add(new Person(68, 110));

		int res = sortPairs(persons);
		System.out.println("result is " + res);
	}
}