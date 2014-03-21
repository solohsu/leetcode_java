package leetcode_java;

import java.util.Arrays;
import java.util.Hashtable;

public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
		Hashtable<Integer, Integer> nums = new Hashtable<>();
		for (int i = 0; i < numbers.length; i++) {
			Integer j = nums.get(target - numbers[i]);
			if (j != null && i > j) {
				return new int[] { j + 1, i + 1 };
			}
			nums.put(numbers[i], i);
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		System.out.println(Arrays
				.toString(twoSum(new int[] {3,2,4 }, 6)));
	}
}
