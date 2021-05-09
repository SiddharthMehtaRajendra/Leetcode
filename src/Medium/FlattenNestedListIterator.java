// https://www.youtube.com/watch?v=V-gPWPOyq8I

package Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return empty list if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public class NestedIterator implements Iterator<Integer> {

		List<Integer> flattenedList = new ArrayList<>();
		int current = 0;

		public NestedIterator(List<NestedInteger> nestedList) {
			for (NestedInteger value : nestedList) {
				this.helper(value);
			}
		}

		@Override
		public Integer next() {
			return flattenedList.get(this.current++);
		}

		@Override
		public boolean hasNext() {
			return this.current < this.flattenedList.size();
		}

		private void helper(NestedInteger value) {
			if (value.isInteger()) {
				flattenedList.add(value.getInteger());
			} else {
				for (NestedInteger element : value.getList()) {
					this.helper(element);
				}
			}
		}
	}

}
