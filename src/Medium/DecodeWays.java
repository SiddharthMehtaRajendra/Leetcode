package Medium;

public class DecodeWays {
	class RecursiveSolution {
		public int numDecodings(String s) {
			if (s == null)
				return 0;
			return helper(s, 0);
		}

		private int helper(String s, int index) {
			if (s.length() == index)
				return 1;
			if (s.charAt(index) == '0')
				return 0;
			int ways = helper(s, index + 1);
			if ((index < s.length() - 1) && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
				ways += helper(s, index + 2);
			}
			return ways;
		}
	}
	
	class DPSolution {
	    public int numDecodings(String s) {
	        if(s == null) return 0;
	        int strLen = s.length();
	        int[] dp = new int[strLen + 1];
	        dp[strLen] = 1;
	        for(int i = strLen - 1; i >= 0; i--){
	            if(s.charAt(i) == '0') continue;
	            dp[i] = dp[i + 1];
	            if((i < strLen - 1) && Integer.parseInt(s.substring(i, i + 2)) <= 26){
	                dp[i] += dp[i + 2];
	            }
	        }
	        return dp[0];
	    }
	}
}
