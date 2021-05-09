//Source: https://www.youtube.com/watch?v=HAA8mgxlov8

package Hard;

import java.util.HashMap;

public class RegularExpressionMatching {
	class NaiveSolution {
		public boolean isMatch(String s, String p) {
			return dfs(0, 0, s, p);
		}

		private boolean dfs(int i, int j, String s, String p) {
			if (i >= s.length() && j >= p.length())
				return true;
			if (j >= p.length())
				return false;

			boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
			if ((j + 1 < p.length()) && p.charAt(j + 1) == '*') {
				return dfs(i, j + 2, s, p) || (match && dfs(i + 1, j, s, p));
			}
			if (match)
				return dfs(i + 1, j + 1, s, p);
			return false;
		}
	}
	
	class MemoizedSolution {
	    
	    private HashMap<String, Boolean> cache = new HashMap<>();
	    public boolean isMatch(String s, String p) {
	        return dfs(0, 0, s, p);
	    }
	    
	    private boolean dfs(int i, int j, String s, String p){
	        if(cache.get(i + "" + j) != null) return cache.get(i + "" + j);
	        if(i >= s.length() && j >= p.length()) return true;
	        if(j >= p.length()) return false;
	        
	        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
	        if((j + 1 < p.length()) && p.charAt(j + 1) == '*'){
	            cache.put(i + "" + j, dfs(i, j + 2, s, p) || (match && dfs(i + 1, j, s, p)));
	            return cache.get(i + "" + j);
	        }
	        
	        if(match) { 
	            cache.put(i + "" + j, dfs(i + 1, j + 1, s, p));
	            return cache.get(i + "" + j);
	        }
	        cache.put(i + "" + j, false);
	        return false;
	    }
	}
}
