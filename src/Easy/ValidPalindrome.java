package Easy;

public class ValidPalindrome {
	class NaiveSolution {
		public boolean isPalindrome(String s) {
			if (s == null || s.length() == 0)
				return true;
			String str = this.preprocessString(s);
			int left = 0, right = str.length() - 1;

			while (left < right) {
				if (str.charAt(left) != str.charAt(right))
					return false;
				left++;
				right--;
			}
			return true;
		}

		private String preprocessString(String s) {
			StringBuilder result = new StringBuilder();
			for (char c : s.toCharArray()) {
				if (Character.isLetterOrDigit(c)) {
					result.append(c);
				}
			}
			return result.toString().toLowerCase();
		}
	}

	class OptimalSolution {
		public boolean isPalindrome(String s) {
			if (s == null || s.length() == 0)
				return true;
			int left = 0, right = s.length() - 1;
			while (left < right) {
				while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
					left++;
				while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
					right--;
				if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
					return false;
				}
				left++;
				right--;
			}
			return true;
		}
	}
}
