// https://www.youtube.com/watch?v=9YdGxFgEC1c

package Medium;

import java.util.Arrays;

public class CoinChange2 {
	class NaiveDPSolution {
		public int change(int amount, int[] coins) {
			if (coins == null || coins.length == 0)
				return 0;
			int n = coins.length;
			int[][] dp = new int[n + 1][amount + 1];

			for (int i = 0; i < dp.length; i++) {
				dp[i][0] = 1;
			}

			for (int i = 1; i < dp.length; i++) {
				for (int j = 1; j < dp[i].length; j++) {
					for (int k = 0; k < i; k++) {
						if (j >= coins[k]) {
							dp[i][j] = dp[i - 1][j] + dp[i][j - coins[k]];
						} else {
							dp[i][j] = dp[i - 1][j];
						}
					}
				}
			}
			return dp[n][amount];
		}
	}
	
	class MemoizedSolution {
	    int result = 0;
	    int[][] dp;
	    public int change(int amount, int[] coins) {
	        if(coins == null || coins.length == 0) return 0;
	        dp = new int[amount + 1][coins.length + 1];
	        for(int i = 0; i < dp.length; i++){
	            Arrays.fill(dp[i], -1);
	        }
	        return helper(coins, amount, 0);
	    }
	    
	    private int helper(int[] coins, int amount, int index){
	        if(amount == 0) return 1;
	        if(amount < 0 || index == coins.length) return 0;
	        if(dp[amount][index] > -1) return dp[amount][index];
	        int waysOne = this.helper(coins, amount, index + 1);
	        int waysTwo = this.helper(coins, amount - coins[index], index);
	        dp[amount][index] = waysOne + waysTwo;
	        return dp[amount][index];
	    }
	}
	
	class OptimizedDPSolution {
	    public int change(int amount, int[] coins) {
	        if(coins == null || coins.length == 0) return 0;
	        int[] dp = new int[amount + 1];
	        dp[0] = 1;
	        
	        for(int coin: coins){
	            for(int j = coin; j < amount + 1; j++){
	                dp[j] += dp[j - coin];
	            }
	        }
	        return dp[amount];
	    }
	}
}
