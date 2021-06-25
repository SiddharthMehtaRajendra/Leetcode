// https://www.youtube.com/watch?v=Utf13l9cILg

package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarFleet {
	class Solution {
		public int carFleet(int target, int[] position, int[] speed) {
			assert position != null && speed != null;
			if (position.length == 0 && speed.length == 0)
				return 0;

			List<double[]> list = new ArrayList<double[]>();
			for (int i = 0; i < position.length; i++) {
				list.add(new double[] { (double) position[i], ((double) (target - position[i]) / speed[i]) });
			}
			Collections.sort(list, new Comparator<double[]>() {
				public int compare(double[] a, double[] b) {
					return Double.compare(a[0], b[0]);
				}
			});

			int result = 0;
			for (int i = list.size() - 1; i > 0; i--) {
				if (list.get(i)[1] < list.get(i - 1)[1]) {
					result++;
				} else {
					list.get(i - 1)[1] = list.get(i)[1];
				}
			}
			return result + 1;
		}
	}
}
