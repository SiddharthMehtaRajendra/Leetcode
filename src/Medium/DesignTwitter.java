package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {
	class Twitter {
		private HashMap<Integer, Set<Integer>> followed;
		private HashMap<Integer, List<Tweet>> tweets;
		private int feedSize, timeStamp;

		class Tweet {
			int id;
			int createdAt;

			public Tweet(int id, int createdAt) {
				this.id = id;
				this.createdAt = createdAt;
			}
		}

		/** Initialize your data structure here. */
		public Twitter() {
			this.followed = new HashMap<>();
			this.tweets = new HashMap<>();
			this.feedSize = 10;
			this.timeStamp = 0;
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			this.follow(userId, userId);
			if (!this.tweets.containsKey(userId)) {
				this.tweets.put(userId, new ArrayList<>());
			}
			this.tweets.get(userId).add(new Tweet(tweetId, this.timeStamp++));
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
		 * the news feed must be posted by users who the user followed or by the user
		 * herself. Tweets must be ordered from most recent to least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> (a.createdAt - b.createdAt));
			Set<Integer> followees = this.followed.get(userId);
			if (followees != null) {
				for (Integer followeeId : followees) {
					List<Tweet> tweeted = tweets.get(followeeId);
					if (tweeted != null) {
						for (Tweet tweet : tweeted) {
							if (pq.size() < this.feedSize) {
								pq.add(tweet);
							} else if (tweet.createdAt > pq.peek().createdAt) {
								pq.poll();
								pq.add(tweet);
							}
						}
					}
				}
			}
			List<Integer> result = new LinkedList<>();
			while (!pq.isEmpty()) {
				result.add(0, pq.poll().id);
			}
			return result;
		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void follow(int followerId, int followeeId) {
			if (!this.followed.containsKey(followerId)) {
				this.followed.put(followerId, new HashSet<>());
			}
			this.followed.get(followerId).add(followeeId);
		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			if (this.followed.containsKey(followerId) && followerId != followeeId) {
				this.followed.get(followerId).remove(followeeId);
			}
		}
	}

	/**
	 * Your Twitter object will be instantiated and called as such: Twitter obj =
	 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
	 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
	 * obj.unfollow(followerId,followeeId);
	 */
}
