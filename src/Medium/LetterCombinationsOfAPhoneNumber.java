package Medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	class Solution {
		List<String> result = new ArrayList<>();
		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		public List<String> letterCombinations(String digits) {
			if (digits == null || digits.length() == 0)
				return new ArrayList<>();
			this.letterCombinations(digits, "", 0);
			return this.result;
		}

		private void letterCombinations(String digits, String current, int index) {
			if (index == digits.length()) {
				this.result.add(current);
				return;
			}

			String letters = this.mapping[digits.charAt(index) - '0'];
			for (int i = 0; i < letters.length(); i++) {
				this.letterCombinations(digits, current + letters.charAt(i), index + 1);
			}
		}
	}
}
