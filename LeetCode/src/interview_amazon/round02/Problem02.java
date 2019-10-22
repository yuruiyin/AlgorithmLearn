package interview_amazon.round02;

import java.util.*;

public class Problem02 {

    private long internalFeedId = 0;

    class Feed {
        int id;
        long internalId;
        Feed(int id, long internalId) {
            this.id = id;
            this.internalId = internalId;
        }
    }

    class CustomCmp implements Comparator<Feed> {

        @Override
        public int compare(Feed o1, Feed o2) {
            return Long.compare(o2.internalId, o1.internalId);
        }
    }

    private static final int MAX_NUM = 10;

    private Map<Integer, Set<Integer>> userFollowMap;
    private Map<Integer, LinkedList<Feed>> userFeedMap;

    /** Initialize your data structure here. */
    public Problem02() {
        userFollowMap = new HashMap<>();
        userFeedMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        internalFeedId++;
        if (userFeedMap.containsKey(userId)) {
            LinkedList<Feed> feedQueue = userFeedMap.get(userId);
            if (feedQueue.size() == MAX_NUM) {
                feedQueue.removeFirst();
            }
            feedQueue.addLast(new Feed(tweetId, internalFeedId));
        } else {
            LinkedList<Feed> feedQueue = new LinkedList<>();
            feedQueue.addLast(new Feed(tweetId, internalFeedId));
            userFeedMap.put(userId, feedQueue);
        }
    }

    private void addTweet(List<Feed> tweetList, LinkedList<Feed> tweetSet) {
        if (tweetSet != null) {
            List<Feed> curUserTweetList = new ArrayList<>(tweetSet);
            int size = Math.min(curUserTweetList.size(), MAX_NUM);
            for (int i = 0; i < size; i++) {
                tweetList.add(curUserTweetList.get(i));
            }
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followSet = userFollowMap.get(userId);
        List<Feed> tweetList = new ArrayList<>();
        LinkedList<Feed> curUserTweetSet = userFeedMap.get(userId);
        addTweet(tweetList, curUserTweetSet);

        if (followSet != null) {
            for (Integer followeeId: followSet) {
                LinkedList<Feed> tmpUserTweetSet = userFeedMap.get(followeeId);
                addTweet(tweetList, tmpUserTweetSet);
            }
        }

        Collections.sort(tweetList, new CustomCmp());

        List<Integer> ansFeedList = new ArrayList<>();
        int size = tweetList.size();
        int maxSize = Math.min(size, MAX_NUM);
        for (int i = 0; i < maxSize; i++) {
            ansFeedList.add(tweetList.get(i).id);
        }

        return ansFeedList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        if (userFollowMap.containsKey(followerId)) {
            userFollowMap.get(followerId).add(followeeId);
        } else {
            Set<Integer> followSet = new HashSet();
            followSet.add(followeeId);
            userFollowMap.put(followerId, followSet);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        if (!userFollowMap.containsKey(followerId)) {
            return;
        }

        userFollowMap.get(followerId).remove(followeeId);
    }
    
    public static void main(String[] args) {
        Problem02 twitter = new Problem02();
        twitter.postTweet(1, 5);
        List<Integer> list = twitter.getNewsFeed(1);

        for (Integer feed: list) {
            System.out.print(feed + ",");
        }
        System.out.println();

        twitter.follow(1, 2);

        twitter.postTweet(2, 6);
        List<Integer> list1 = twitter.getNewsFeed(1);

        for (Integer feed: list1) {
            System.out.print(feed + ",");
        }
        System.out.println();


    }
    
}
