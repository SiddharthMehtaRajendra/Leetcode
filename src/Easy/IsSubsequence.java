package Easy;

public class IsSubsequence {
	class Solution {
		public boolean isSubsequence(String s, String t) {
			if (s == null || t == null)
				return false;
			int sPtr = s.length() - 1;
			int tPtr = t.length() - 1;

			while (sPtr >= 0 && tPtr >= 0) {
				char sChar = s.charAt(sPtr);
				char tChar = t.charAt(tPtr);

				if (sChar == tChar) {
					sPtr--;
				}
				tPtr--;
			}

			if (sPtr == -1)
				return true;
			return false;
		}
	}
}
