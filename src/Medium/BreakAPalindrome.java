// https://www.youtube.com/watch?v=iXbJ1qvKg28

package Medium;

public class BreakAPalindrome {
	class Solution {
		public String breakPalindrome(String palindrome) {
			if (palindrome == null || palindrome.length() <= 1)
				return "";
			StringBuilder sb = new StringBuilder(palindrome);
			int i = 0;
			int j = sb.length();

			while (i < (j - i - 1)) {
				if (sb.charAt(i) != 'a') {
					sb.setCharAt(i, 'a');
					return sb.toString();
				}
				i++;
			}
			sb.setCharAt(sb.length() - 1, 'b');
			return sb.toString();
		}
	}
}
