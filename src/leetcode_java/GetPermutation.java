package leetcode_java;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {
	static int[] facts = new int[10]; // 保存1-9的阶乘
	static List<Integer> nums = new ArrayList<>(); // 保存进行排列的集合
	static {
		facts[0] = 1;
		for (int i = 1; i < 10; i++) {
			facts[i] = facts[i - 1] * i;
		}
	}

	public String getPermutation(int n, int k) {
		// 初始化要排列的集合
		for (int i = 0; i < n; i++) {
			nums.add(i + 1);
		}
		return helper(k, nums);
	}

	/**
	 * 获取第一个数字，从要排列的集合中删除这个数字，然后递归
	 * 
	 * @param index
	 *            排列所在的序号
	 * @param nums
	 *            进行排列的数字列表
	 * @return
	 */
	public String helper(int index, List<Integer> nums) {
		int n = nums.size();
		if (n == 0) {
			return "";
		}
		int head_index = (int) Math.ceil((double) index / facts[n - 1]);
		int head = nums.get(head_index - 1);
		nums.remove(head_index - 1);
		index = index % facts[n - 1];
		return head + helper(index == 0 ? index + facts[n - 1] : index, nums);
	}

	public static void main(String[] args) {
		System.out.println(new GetPermutation().getPermutation(3, 6));
	}

}
