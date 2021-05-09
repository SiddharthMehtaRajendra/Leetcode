package Easy;

public class BuyAndSellStock {
	class BruteForceSolution {
		public int maxProfit(int[] prices) {
			if (prices == null || prices.length == 0)
				return 0;
			int maxProfit = 0;
			for (int i = 0; i < prices.length; i++) {
				for (int j = i + 1; j < prices.length; j++) {
					maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
				}
			}
			return maxProfit;
		}
	}

	class OptimizedSolution {
		public int maxProfit(int[] prices) {
			if (prices == null || prices.length == 0)
				return 0;
			int minPrice = Integer.MAX_VALUE, maxProfit = 0;
			for (int price : prices) {
				if (price < minPrice) {
					minPrice = price;
				} else if (price - minPrice > maxProfit) {
					maxProfit = price - minPrice;
				}
			}
			return maxProfit;
		}
	}
}
