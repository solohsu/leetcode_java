package leetcode_java;

import java.util.ArrayList;
import java.util.HashSet;

public class ThreeSum {

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		HashSet<ArrayList<Integer>> ans = new HashSet<>();
		int size = num.length;
		int zeroes = 0, tmp;
	
		ArrayList<Integer> posList = new ArrayList<>();
		ArrayList<Integer> negList = new ArrayList<>();
		
		HashSet<Integer> posSet = new HashSet<>();
		HashSet<Integer> negSet = new HashSet<>();

		for (int i = 0; i < size; i++) {
			tmp = num[i];
			if (tmp == 0) {
				zeroes++;
			} else if (tmp > 0) {
				posList.add(tmp);
				posSet.add(tmp);
			} else {
				negList.add(tmp);
				negSet.add(tmp);
			}
		}

		if (zeroes >= 3) {
			produceAns(0, 0, 0, ans);
		}

		if (zeroes >= 1) {
			for (Integer pos : posSet) {
				if (negSet.contains(-pos)) {
					produceAns(-pos, 0, pos, ans);
				}
			}
		}

		int posSize = posList.size();
		int negSize = negList.size();

		for (int i = 0; i < posSize; i++) {
			for (int j = i + 1; j < posSize; j++) {
				int second = Math.min(posList.get(j), posList.get(i)), third = Math
						.max(posList.get(j), posList.get(i)), first = -third
						- second;
				if (negSet.contains(first)) {
					produceAns(first, second, third, ans);
				}
			}
		}

		for (int i = 0; i < negSize; i++) {
			for (int j = i + 1; j < negSize; j++) {
				int first = Math.min(negList.get(j), negList.get(i)), second = Math
						.max(negList.get(j), negList.get(i)), third = -second
						- first;
				if (posSet.contains(third)) {
					produceAns(first, second, third, ans);
				}
			}
		}

		return new ArrayList<>(ans);
	}

	final private void produceAns(Integer first, Integer second, Integer third,
			HashSet<ArrayList<Integer>> ans) {
		ArrayList<Integer> tmpList = new ArrayList<>(3);
		tmpList.add(first);
		tmpList.add(second);
		tmpList.add(third);
		ans.add(tmpList);
	}

	public static void main(String[] args) {
		int num[] = { -1, 0, 1, 2, -1, -4 };
		System.out.println(new ThreeSum().threeSum(num));
	}
}
