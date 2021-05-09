package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
	class NaiveSolution {
		Map<String, Integer> cache = new HashMap<>();

		public int coinChange(int[] coins, int amount) {
			int minCoins = helper(coins, amount, 0, 0);
			return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
		}

		private int helper(int[] coins, int current, int index, int numCoins) {
			if (current == 0) {
				return numCoins;
			}
			if (current < 0 || index == coins.length)
				return Integer.MAX_VALUE;
			int choice1 = helper(coins, current, index + 1, numCoins);
			int choice2 = helper(coins, current - coins[index], index, numCoins + 1);
			return Math.min(choice1, choice2);
		}
	}

	class DPSolution {
		public int coinChange(int[] coins, int amount) {
			if (coins == null || coins.length == 0)
				return 0;
			int[] dp = new int[amount + 1];
			Arrays.fill(dp, amount + 1);
			dp[0] = 0;
			for (int i = 0; i <= amount; i++) {
				for (int j = 0; j < coins.length; j++) {
					if (coins[j] <= i) {
						dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
					}
				}
			}
			return dp[amount] > amount ? -1 : dp[amount];
		}
	}
}
