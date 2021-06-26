// https://www.youtube.com/watch?v=HQ4U24lRar8

package Medium;

public class CustomSortString {
	class Solution {
		public String customSortString(String order, String str) {
			if (order == null || order.isEmpty() || str == null || str.isEmpty())
				return "";
			int[] charMap = new int[26];

			for (char c : str.toCharArray()) {
				charMap[c - 'a'] += 1;
			}

			StringBuilder sb = new StringBuilder();
			for (char c : order.toCharArray()) {
				if (charMap[c - 'a'] == 0) {
					continue;
				}
				for (int i = 0; i < charMap[c - 'a']; i++) {
					sb.append(c);
				}
				charMap[c - 'a'] = 0;
			}

			for (int i = 0; i < charMap.length; i++) {
				while (charMap[i] > 0) {
					sb.append((char) (i + 'a'));
					charMap[i]--;
				}
			}
			return sb.toString();
		}
	}
}
