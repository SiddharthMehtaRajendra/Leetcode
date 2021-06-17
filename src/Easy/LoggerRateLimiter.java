// https://www.youtube.com/watch?v=UVE8GrzZ_tI

package Easy;

import java.util.HashMap;

public class LoggerRateLimiter {
	class Logger {

		private HashMap<String, Integer> cache;

		/** Initialize your data structure here. */
		public Logger() {
			this.cache = new HashMap<>();
		}

		/**
		 * Returns true if the message should be printed in the given timestamp,
		 * otherwise returns false. If this method returns false, the message will not
		 * be printed. The timestamp is in seconds granularity.
		 */
		public boolean shouldPrintMessage(int timestamp, String message) {
			if (!this.cache.containsKey(message)) {
				this.cache.put(message, timestamp);
				return true;
			}
			int lastTimeStamp = this.cache.get(message);
			if (timestamp - lastTimeStamp < 10) {
				return false;
			}
			this.cache.put(message, timestamp);
			return true;
		}
	}

	/**
	 * Your Logger object will be instantiated and called as such: Logger obj = new
	 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
	 */
}
