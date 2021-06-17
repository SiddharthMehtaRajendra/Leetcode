	package Easy;

public class LongestCommonPrefix {
	class NaiveSolution { // Accepted in LeetCode
		public String longestCommonPrefix(String[] strs) {
			if (strs == null || strs.length == 0)
				return "";
			boolean common = true;
			String result = "";
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (String str : strs) {
				min = Math.min(min, str.length());
			}
			int i = 1;
			while (i <= min) {
				String prev = strs[0].substring(0, i);
				for (int j = 1; j < strs.length; j++) {
					String substr = strs[j].substring(0, i);
					if (!substr.equals(prev)) {
						common = false;
						break;
					}
					prev = substr;
				}
				if (common) {
					if (i > max) {
						result = prev;
						max = i;
					}
				}
				i++;
			}
			return result;
		}
	}

	class OptimalSolution {
		public String longestCommonPrefix(String[] strs) {
			if (strs == null || strs.length == 0)
				return "";

			for (int i = 0; i < strs[0].length(); i++) {
				char c = strs[0].charAt(i);
				for (int j = 1; j < strs.length; j++) {
					if (i == strs[j].length() || strs[j].charAt(i) != c) {
						return strs[0].substring(0, i);
					}
				}
			}
			return strs[0];
		}
	}
}
