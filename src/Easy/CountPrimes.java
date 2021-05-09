package Easy;

import java.util.Arrays;

public class CountPrimes {
	class NaiveSolution {
		public int countPrimes(int n) {
			if (n == 0 || n == 1)
				return 0;
			int result = 0;
			for (int i = 2; i < n; i++) {
				boolean prime = true;
				for (int j = i - 1; j > 1; j--) {
					if (i % j == 0)
						prime = false;
				}
				if (prime)
					result++;
			}
			return result;
		}
	}

	class SieveOfEratosthenesSolution {
		public int countPrimes(int n) {
			if (n == 0 || n == 1)
				return 0;
			boolean[] primes = new boolean[n];
			Arrays.fill(primes, true);

			for (int i = 2; i * i < n; i++) {
				if (primes[i]) {
					for (int j = i; j * i < n; j++) {
						primes[j * i] = false;
					}
				}
			}

			int counter = 0;
			for (int i = 2; i < n; i++) {
				if (primes[i])
					counter++;
			}
			return counter;
		}
	}
}
