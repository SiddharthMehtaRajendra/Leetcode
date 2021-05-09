package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	
	class BFSSolution {
	    public int numIslands(char[][] grid) {
	        if(grid == null || grid.length == 0) return 0;
	        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	        int numRows = grid.length;
	        int numCols = grid[0].length;
	        int countOfIslands = 0;
	        
	        for(int i = 0; i < numRows; i++){
	            for(int j = 0; j < numCols; j++){
	                if(grid[i][j] == '1'){
	                    countOfIslands++;
	                    Queue<int[]> q = new LinkedList<>();
	                    q.add(new int[]{i, j});
	                    grid[i][j] = '0';
	                    while(!q.isEmpty()){
	                        int size = q.size();
	                        for(int k = 0; k < size; k++){
	                            int[] curr = q.poll();
	                            for(int[] direction: directions){
	                                int r = curr[0] + direction[0];
	                                int c = curr[1] + direction[1];
	                                if(r >= 0 && r < numRows && c >=0 && c < numCols && grid[r][c] == '1'){
	                                    grid[r][c] = '0';
	                                    q.add(new int[]{r, c});
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        return countOfIslands;
	    }
	}
	
	class DFSSolution {
	    int countOfIslands = 0;
	    int numOfRows = 0, numOfCols = 0;
	    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	    
	    public int numIslands(char[][] grid) {
	        if(grid == null || grid.length == 0) return -1;
	        numOfRows = grid.length;
	        numOfCols = grid[0].length;
	        for(int i = 0; i < numOfRows; i++){
	            for(int j = 0; j < numOfCols; j++){
	                if(grid[i][j] == '1'){
	                    countOfIslands++;
	                    dfs(grid, i, j);
	                }
	            }
	        }
	        return countOfIslands;
	    }
	    
	    private void dfs(char[][] grid, int row, int col){
	        grid[row][col] = '0';
	        for(int[] direction: directions){
	            int r = direction[0] + row;
	            int c = direction[1] + col;
	            if(r >= 0 && r < numOfRows && c >= 0 && c < numOfCols && grid[r][c] == '1'){
	                dfs(grid, r, c);
	            }
	        }
	    }
	}
}
