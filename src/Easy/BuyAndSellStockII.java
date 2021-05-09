// https://www.youtube.com/watch?v=blUwDD6JYaE

package Easy;

public class BuyAndSellStockII {
	class Solution {
		public int maxProfit(int[] prices) {
			if (prices == null || prices.length == 0)
				return 0;

			int profit = 0;
			for (int i = 0; i < prices.length - 1; i++) {
				if (prices[i + 1] > prices[i]) {
					profit += prices[i + 1] - prices[i];
				}
			}
			return profit;
		}
	}
}
