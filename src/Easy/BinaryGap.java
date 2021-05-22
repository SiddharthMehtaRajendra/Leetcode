package Easy;

public class BinaryGap {
	class Solution {
		public int binaryGap(int n) {
			String binary = Integer.toBinaryString(n);
			int max = 0;
			int end = 0;
			for (int start = 0; start < binary.length();) {
				if (binary.charAt(start) == '1') {
					end = start + 1;
					while (end < binary.length() - 1 && binary.charAt(end) == '0') {
						end++;
					}
					if (end < binary.length() && binary.charAt(end) == '1') {
						max = Math.max(max, end - start);
					}
					start = end;
				} else {
					start++;
				}
			}
			return max;
		}
	}
}
