package leetcode_java;

public class MaxProfit {
	public static int maxProfit(int[] prices) {
		int len = prices.length;
		if (len <= 1) {
			return 0;
		}
		int buy, sell, profit = 0;
		for (int i = 0, j = 1; i < len && j < len;) {
			buy = prices[i];
			sell = prices[j];
			if (buy >= sell) {
				i = j;
				j++;
			} else {
				profit += sell - buy;
				i = j;
				j++;
			}
		}

		return profit;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 2, 1, 5, 10}));
	}
}
