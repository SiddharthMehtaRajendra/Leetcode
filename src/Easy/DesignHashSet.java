package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DesignHashSet {
	class MyHashSet {

		class Bucket {
			private LinkedList<Integer> list;

			public Bucket() {
				this.list = new LinkedList<>();
			}

			public boolean insert(int value) {
				if (!this.list.contains(value)) {
					this.list.addFirst(value);
					return true;
				}
				return false;
			}

			public boolean remove(int value) {
				if (this.list.contains(value)) {
					this.list.remove(Integer.valueOf(value));
					return true;
				}
				return false;
			}

			public boolean exists(int value) {
				return this.list.contains(value);
			}
		}

		private int keySpace;
		private List<Bucket> list;

		/** Initialize your data structure here. */
		public MyHashSet() {
			this.keySpace = 1000;
			this.list = new ArrayList<>();
			for (int i = 0; i < this.keySpace; i++) {
				this.list.add(new Bucket());
			}
		}

		private int performHash(int key) {
			return key % this.keySpace;
		}

		public void add(int key) {
			int hash = this.performHash(key);
			this.list.get(hash).insert(key);
		}

		public void remove(int key) {
			int hash = this.performHash(key);
			this.list.get(hash).remove(key);
		}

		/** Returns true if this set contains the specified element */
		public boolean contains(int key) {
			int hash = this.performHash(key);
			return this.list.get(hash).exists(key);
		}
	}
}
