// Leetcode Solutions

package Medium;

public class MaximalSquare {
	class Solution {
	    public int maximalSquare(char[][] matrix) {
	        if(matrix == null || matrix.length == 0) return 0;
	        int rows = matrix.length, cols = matrix[0].length;
	        int[][] dp = new int[rows + 1][cols + 1];
	        int maxSquareLength = 0;
	        for(int i = 1; i <= rows; i++){
	            for(int j = 1; j <= cols; j++){
	                if(matrix[i - 1][j - 1] == '1'){
	                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
	                    maxSquareLength = Math.max(maxSquareLength, dp[i][j]);
	                }
	            }
	        }
	        return maxSquareLength * maxSquareLength;
	    }
	}
}
