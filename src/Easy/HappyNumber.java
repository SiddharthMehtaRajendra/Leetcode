// https://www.youtube.com/watch?v=gW4hSbRoQoY

package Easy;

import java.util.HashSet;

public class HappyNumber {
	class Solution {
		public boolean isHappy(int n) {
			if (n == 1)
				return true;
			HashSet<Integer> seen = new HashSet<>();

			while (n != 1) {
				int current = n;
				int sum = 0;
				while (current != 0) {
					sum += (current % 10) * (current % 10);
					current /= 10;
				}
				if (seen.contains(sum)) {
					return false;
				}
				seen.add(sum);
				n = sum;
			}
			return true;
		}
	}

	// Linked List Cycle (Floyd's algorithm)
	class BetterSolution {

		public int getNext(int n) {
			int totalSum = 0;
			while (n > 0) {
				int d = n % 10;
				n = n / 10;
				totalSum += d * d;
			}
			return totalSum;
		}

		public boolean isHappy(int n) {
			int slowRunner = n;
			int fastRunner = getNext(n);
			while (fastRunner != 1 && slowRunner != fastRunner) {
				slowRunner = getNext(slowRunner);
				fastRunner = getNext(getNext(fastRunner));
			}
			return fastRunner == 1;
		}
	}
}
