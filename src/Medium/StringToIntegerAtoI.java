// https://www.youtube.com/watch?v=pcPX_UAuIJA

package Medium;

public class StringToIntegerAtoI {
	class Solution {
		public int myAtoi(String s) {
			if (s == null || s.length() == 0)
				return 0;
			int ptr = 0, sign = 1, n = s.length();

			while (ptr < n && s.charAt(ptr) == ' ')
				ptr++;

			if (ptr == n) {
				return 0;
			}

			if (s.charAt(ptr) == '+' || s.charAt(ptr) == '-') {
				sign = s.charAt(ptr) == '+' ? 1 : -1;
				ptr++;
			}

			long result = 0;
			while (ptr < n && Character.isDigit(s.charAt(ptr))) {
				// Horner's rule
				result = result * 10 + (s.charAt(ptr) - '0');
				if (result * sign > Integer.MAX_VALUE || result * sign < Integer.MIN_VALUE) {
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				ptr++;
			}
			return (int) result * sign;
		}
	}
}
