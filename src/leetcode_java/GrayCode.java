package leetcode_java;

import java.util.ArrayList;

public class GrayCode {
	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(0);
		for (int i = 0; i < n; i++) {
			int inc = 1 << i;
			for (int j = ans.size() - 1; j >= 0; j--) {
				ans.add(ans.get(j) + inc);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(grayCode(3));
		// System.out.println(1<<1);
	}
}
