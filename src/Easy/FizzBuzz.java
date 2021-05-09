package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {
	class NaiveSolution {
		public List<String> fizzBuzz(int n) {
			List<String> result = new ArrayList<>();
			if (n == 0)
				return result;
			for (int i = 1; i <= n; i++) {
				if (i % 3 == 0 && i % 5 == 0) {
					result.add("FizzBuzz");
				} else if (i % 3 == 0) {
					result.add("Fizz");
				} else if (i % 5 == 0) {
					result.add("Buzz");
				} else {
					result.add(String.valueOf(i));
				}
			}
			return result;
		}
	}

	class BetterSolution {
		public List<String> fizzBuzz(int n) {
			List<String> result = new ArrayList<>();
			if (n == 0)
				return result;
			for (int i = 1; i <= n; i++) {
				String curr = "";
				if (i % 3 == 0) {
					curr += "Fizz";
				}
				if (i % 5 == 0) {
					curr += "Buzz";
				}
				if (curr.equals("")) {
					curr += String.valueOf(i);
				}
				result.add(curr);
			}
			return result;
		}
	}

	class OptimalSolution {
		public List<String> fizzBuzz(int n) {
			List<String> result = new ArrayList<>();
			@SuppressWarnings("serial")
			Map<Integer, String> map = new HashMap<Integer, String>() {
				{
					put(3, "Fizz");
					put(5, "Buzz");
				}
			};
			if (n == 0)
				return result;
			for (int i = 1; i <= n; i++) {
				String curr = "";
				for (Integer key : map.keySet()) {
					if (i % key == 0) {
						curr += map.get(key);
					}
				}
				if (curr.equals("")) {
					curr += String.valueOf(i);
				}
				result.add(curr);
			}
			return result;
		}
	}
}
