//Self Solved

package Easy;

public class DetectCapital {
	class Solution {
		public boolean detectCapitalUse(String word) {
			boolean isFirstUpperCase = Character.isUpperCase(word.charAt(0));
			int upperCaseCount = isFirstUpperCase ? 1 : 0;
			for (int i = 1; i < word.length(); i++) {
				if (Character.isUpperCase(word.charAt(i))) {
					upperCaseCount++;
				}
			}
			if (isFirstUpperCase && upperCaseCount == 1)
				return true;
			else if (upperCaseCount == 0 || upperCaseCount == word.length())
				return true;
			return false;
		}
	}
}
