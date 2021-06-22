// https://www.youtube.com/watch?v=i5t2KvDn6DU - S30
package Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PhoneDirectory {
	class PhoneDirectorySolution {

		HashSet<Integer> directory;
		Queue<Integer> queue;

		/**
		 * Initialize your data structure here
		 * 
		 * @param maxNumbers - The maximum numbers that can be stored in the phone
		 *                   directory.
		 */
		public PhoneDirectorySolution(int maxNumbers) {
			this.directory = new HashSet<>();
			this.queue = new LinkedList<>();
			for (int i = 0; i < maxNumbers; i++) {
				this.directory.add(i);
				this.queue.add(i);
			}
		}

		/**
		 * Provide a number which is not assigned to anyone.
		 * 
		 * @return - Return an available number. Return -1 if none is available.
		 */
		public int get() {
			if (this.directory.isEmpty())
				return -1;
			int result = this.queue.poll();
			this.directory.remove(result);
			return result;
		}

		/** Check if a number is available or not. */
		public boolean check(int number) {
			return this.directory.contains(number);
		}

		/** Recycle or release a number. */
		public void release(int number) {
			if (!this.directory.contains(number)) {
				this.directory.add(number);
				this.queue.add(number);
			}
		}
	}

}
