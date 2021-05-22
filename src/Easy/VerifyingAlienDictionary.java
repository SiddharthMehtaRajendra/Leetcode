package Easy;

public class VerifyingAlienDictionary {
	class Solution {
		int[] charMap = new int[26];

		public boolean isAlienSorted(String[] words, String order) {
			for (int i = 0; i < 26; i++) {
				charMap[order.charAt(i) - 'a'] = i;
			}

			for (int i = 1; i < words.length; i++) {
				if (this.compare(words[i - 1], words[i]) > 0) {
					return false;
				}
			}
			return true;
		}

		private int compare(String wordOne, String wordTwo) {
			int char_compare_value = 0, i = 0, j = 0;
			while (i < wordOne.length() && j < wordTwo.length() && char_compare_value == 0) {
				char_compare_value = this.charMap[wordOne.charAt(i) - 'a'] - this.charMap[wordTwo.charAt(j) - 'a'];
				i++;
				j++;
			}
			if (char_compare_value == 0) {
				return wordOne.length() - wordTwo.length();
			} else {
				return char_compare_value;
			}
		}
	}
}
