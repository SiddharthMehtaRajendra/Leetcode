// https://www.youtube.com/watch?v=TD2g8UjXMLA

package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GetRandom {

	class NonOptimizedRandomizedSet {

		private Set<Integer> set;
		private Random random;

		/** Initialize your data structure here. */
		public NonOptimizedRandomizedSet() {
			this.set = new HashSet<>();
			this.random = new Random();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already contain
		 * the specified element.
		 */
		public boolean insert(int val) {
			return set.add(val);
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the specified
		 * element.
		 */
		public boolean remove(int val) {
			if (!set.contains(val))
				return false;
			set.remove(val);
			return true;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			List<Integer> list = new ArrayList<>(set);
			int index = random.nextInt(list.size());
			return list.get(index);
		}
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
	 */

	class OptimizedRandomizedSet {

		private List<Integer> list;
		private Map<Integer, Integer> map;
		private Random random;

		/** Initialize your data structure here. */
		public OptimizedRandomizedSet() {
			this.list = new ArrayList<>();
			this.map = new HashMap<>();
			this.random = new Random();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already contain
		 * the specified element.
		 */
		public boolean insert(int val) {
			if (map.containsKey(val))
				return false;
			list.add(val);
			map.put(val, list.size() - 1);
			return true;
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the specified
		 * element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val))
				return false;
			int index = map.get(val);
			int element = list.get(list.size() - 1);
			list.set(index, element);
			map.put(element, index);
			list.remove(list.size() - 1);
			map.remove(val);
			return true;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			int index = random.nextInt(list.size());
			return list.get(index);
		}
	}
}
