// Own Solution

package Easy;

public class StrStr {
	class Solution {
		public int strStr(String haystack, String needle) {
			if (needle == null || needle.isEmpty())
				return 0;
			if (haystack == null || haystack.isEmpty())
				return -1;

			int len = needle.length();
			for (int i = 0; i < (haystack.length() - len + 1); i++) {
				if (haystack.substring(i, i + len).equals(needle)) {
					return i;
				}
			}
			return -1;
		}
	}
}
