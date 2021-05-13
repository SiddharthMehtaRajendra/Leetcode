// Leetcode Solution

package Medium;

public class FastPower {
	class RecursiveOptimalSolution {
		public double myPow(double x, int n) {
			long N = n;
			if (n < 0) {
				N *= -1;
			}
			double result = fastPow(x, N);
			return n < 0 ? (1.0 / result) : result;
		}

		private double fastPow(double x, long n) {
			if (n == 0)
				return 1.0;

			double temp = fastPow(x, n / 2);
			if (n % 2 == 0) {
				return temp * temp;
			} else {
				return temp * temp * x;
			}
		}
	}

	class IterativeOptimalSolution {
		public double myPow(double x, int n) {
			long N = n;
			if (n < 0) {
				N *= -1;
			}
			double result = 1.0;
			for (long i = N; i > 0; i /= 2) {
				if (i % 2 == 1) {
					result *= x;
				}
				x *= x;
			}
			return n < 0 ? (1.0 / result) : result;
		}
	}
}
