// Four Pointer Solution: https://www.youtube.com/watch?v=Kugr5PTJgmg

package Hard;

public class WildcardMatching {
	class Solution {
		public boolean isMatch(String s, String p) {
			if ((s == null && p == null) || (s.length() == 0 && p.length() == 0))
				return true;
			int m = s.length() + 1;
			int n = p.length() + 1;
			boolean[][] dp = new boolean[m][n];
			dp[0][0] = true;

			for (int i = 1; i < n; i++) {
				if (p.charAt(i - 1) == '*') {
					dp[0][i] = dp[0][i - 1];
				}
			}

			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
						dp[i][j] = dp[i - 1][j - 1];
					} else if (p.charAt(j - 1) == '*') {
						dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
					} else {
						dp[i][j] = false;
					}
				}
			}

			return dp[m - 1][n - 1];
		}
	}
	
	class FourPointerSolution {
	    public boolean isMatch(String s, String p) {
	        if((s == null && p == null) || (s.length() == 0 && p.length() == 0)){ 
	            return true;
	        }
	        if(s.equals(p) || p.equals("*")) {
	            return true;
	        }
	        int sPtr = 0, pPtr = 0;
	        int sStar = -1, pStar = -1;
	        int sLen = s.length(); int pLen = p.length();
	        
	        while(sPtr < sLen){
	            if(pPtr < pLen && (s.charAt(sPtr) == p.charAt(pPtr) || p.charAt(pPtr) == '?')){
	                sPtr++;
	                pPtr++;
	            } else if(pPtr < pLen && p.charAt(pPtr) == '*'){
	                sStar = sPtr;
	                pStar = pPtr;
	                pPtr++;
	            } else if(pStar > -1){
	                sPtr = sStar + 1;
	                pPtr = pStar + 1;
	                sStar = sPtr;
	            } else if(pStar == -1){
	                return false;
	            }
	        }
	        while(pPtr < pLen){
	            if(p.charAt(pPtr) != '*') return false;
	            pPtr++;
	        }
	        return true;
	    }
	}
}
