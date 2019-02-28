import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Bogosort {
	public static void main(String[] args) {
		for (int i = 0; i < 52; i++) {
			ArrayList<Integer> startList = new ArrayList<Integer>();

			for (int j = 0; j < i; j++) {
				startList.add(j);
			}

			Collections.shuffle(startList);
			ArrayList<Integer> endList = new ArrayList<Integer>(startList);

			long startTime = System.nanoTime();
			int comparisons = sort(endList);
			long endTime = System.nanoTime();

			long duration = TimeUnit.NANOSECONDS.toSeconds(endTime - startTime);

			System.out.format("%d element(s) sorted in %d comparisons and %d seconds.%n", i, comparisons, duration);
			System.out.format("%s -> %s %n%n", startList, endList);
		}
	}

	public static boolean isSorted(ArrayList<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).compareTo(list.get(i - 1)) < 0)
				return false;
		}

		return true;
	}

	public static int sort(ArrayList<Integer> list) {
		int i = 0;

		while (!isSorted(list)) {
			Collections.shuffle(list);
			i++;
		}

		return i;
	}
}
