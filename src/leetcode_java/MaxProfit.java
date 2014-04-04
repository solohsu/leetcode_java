package leetcode_java;

public class MaxProfit {
	/**
	 * 最大收益或者在以最低价买入时获得，或者在以最高价卖出时获得
	 * 从前往后寻找以最低价买入时能获得的最大受益profit1，
	 * 同时从后往前寻找以最高价卖出时的最大收益profit2，
	 * 二者中的较大值即为可以获取到的最大收益。
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int min, max, profit1 = 0, profit2 = 0, len = prices.length;
		min = prices[0];
		max = prices[len - 1];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - min > profit1) {
				profit1 = prices[i] - min;
			}
			if (prices[i] < min) {
				min = prices[i];
			}
			if (max - prices[len - i - 1] > profit2) {
				profit2 = max - prices[len - i - 1];
			}
			if (prices[len - i - 1] > max) {
				max = prices[len - i - 1];
			}
		}
		int ans = Math.max(profit2, profit1);
		return ans < 0 ? 0 : ans;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 2, 3, 1, 5 }));
	}
}
