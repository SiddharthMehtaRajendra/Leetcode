package Easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	class Solution {
		Map<Character, Integer> map;

		public int romanToInt(String s) {
			if (s == null || s.length() == 0)
				return 0;
			int sum = 0;
			char previous = ' ';
			this.buildHashMap();

			for (int i = 0; i < s.length(); i++) {
				char current = s.charAt(i);
				if (current == 'V' || current == 'X') {
					if (previous == 'I')
						sum -= 2;
				}
				if (current == 'L' || current == 'C') {
					if (previous == 'X')
						sum -= 2 * 10;
				}
				if (current == 'D' || current == 'M') {
					if (previous == 'C')
						sum -= 2 * 100;
				}
				sum += map.get(current);
				previous = current;
			}
			return sum;
		}

		private void buildHashMap() {
			this.map = new HashMap<>();
			this.map.put('I', 1);
			this.map.put('V', 5);
			this.map.put('X', 10);
			this.map.put('L', 50);
			this.map.put('C', 100);
			this.map.put('D', 500);
			this.map.put('M', 1000);
		}
	}
}
