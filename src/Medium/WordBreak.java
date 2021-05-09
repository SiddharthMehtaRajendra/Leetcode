package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	class BruteForceSolution {
		Set<String> set;

		public boolean wordBreak(String s, List<String> wordDict) {
			set = new HashSet<>(wordDict);
			return backtrack(s);
		}

		private boolean backtrack(String curr) {
			if (curr.equals(""))
				return true;
			for (int i = 1; i <= curr.length(); i++) {
				if (set.contains(curr.substring(0, i)) && backtrack(curr.substring(i))) {
					return true;
				}
			}
			return false;
		}
	}

	class MemoizedSolution {
		Set<String> set;
		Map<String, Boolean> cache;

		public boolean wordBreak(String s, List<String> wordDict) {
			set = new HashSet<>(wordDict);
			cache = new HashMap<>();
			return backtrack(s);
		}

		private boolean backtrack(String curr) {
			if (curr.equals(""))
				return true;
			if (cache.containsKey(curr))
				return cache.get(curr);
			for (int i = 1; i <= curr.length(); i++) {
				if (set.contains(curr.substring(0, i)) && backtrack(curr.substring(i))) {
					return true;
				}
			}
			cache.put(curr, false);
			return false;
		}
	}

	class DPSolution {
		Set<String> set;

		public boolean wordBreak(String s, List<String> wordDict) {
			set = new HashSet<>(wordDict);
			int size = s.length();
			boolean[] dp = new boolean[size + 1];
			dp[0] = true;

			for (int i = 1; i <= size; i++) {
				for (int j = 0; j < i; j++) {
					if (dp[j] && set.contains(s.substring(j, i))) {
						dp[i] = true;
						break;
					}
				}
			}
			return dp[size];
		}
	}
}
