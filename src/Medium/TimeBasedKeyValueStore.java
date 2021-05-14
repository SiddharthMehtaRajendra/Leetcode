// https://www.youtube.com/watch?v=eVi4gDimCoo

package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
	class TimeMap {
		Map<String, TreeMap<Integer, String>> cache;
		private static final String EMPTY_STRING = "";

		/** Initialize your data structure here. */
		public TimeMap() {
			this.cache = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {
			if (!this.cache.containsKey(key)) {
				this.cache.put(key, new TreeMap<>());
			}
			this.cache.get(key).put(timestamp, value);
		}

		public String get(String key, int timestamp) {
			if (!this.cache.containsKey(key))
				return EMPTY_STRING;
			TreeMap<Integer, String> timeMap = this.cache.get(key);
			Integer previousTime = timeMap.floorKey(timestamp);
			if (previousTime == null)
				return EMPTY_STRING;
			return timeMap.get(previousTime);
		}
	}

}
