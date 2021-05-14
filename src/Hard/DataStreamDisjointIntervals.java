// https://www.youtube.com/watch?v=44Kn_kX4VRQ

package Hard;

import java.util.LinkedList;
import java.util.List;

public class DataStreamDisjointIntervals {

	class SummaryRanges {
		List<int[]> values;

		/** Initialize your data structure here. */
		public SummaryRanges() {
			this.values = new LinkedList<>();
		}

		public void addNum(int val) {
			int left = 0;
			int right = this.values.size() - 1;
			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (this.values.get(mid)[0] <= val && val <= this.values.get(mid)[1]) {
					return;
				} else if (this.values.get(mid)[1] <= val) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			int i = left;
			this.values.add(i, new int[] { val, val });
			if (i < this.values.size() - 1 && this.values.get(i + 1)[0] == val + 1) {
				this.values.get(i + 1)[0] = val;
				this.values.remove(i);
			}
			if (i > 0 && this.values.get(i - 1)[1] == val - 1) {
				this.values.get(i - 1)[1] = this.values.get(i)[1];
				this.values.remove(i);
			}
		}

		public int[][] getIntervals() {
			return values.toArray(new int[this.values.size()][]);
		}
	}
}
