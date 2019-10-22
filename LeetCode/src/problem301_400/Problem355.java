package problem301_400;

import java.util.*;

public class Problem355 {

    private long internalFeedId = 0;

    class Feed {
        int id;
        long internalId;
        Feed(int id, long internalId) {
            this.id = id;
            this.internalId = internalId;
        }
    }

    class TmpFeed extends Feed {
        int index; // 在列表中的索引，用于优先队列，移除元素的时候可以知道当前元素所在的行（某个用户的feed列表）

        TmpFeed(int id, long internalId, int index) {
            super(id, internalId);
            this.index = index;
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
    public Problem355() {
        userFollowMap = new HashMap<>();
        userFeedMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        internalFeedId++;
        if (userFeedMap.containsKey(userId)) {
            LinkedList<Feed> feedQueue = userFeedMap.get(userId);
            if (feedQueue.size() == MAX_NUM) {
                feedQueue.removeLast();
            }
            feedQueue.addFirst(new Feed(tweetId, internalFeedId));
        } else {
            LinkedList<Feed> feedQueue = new LinkedList<>();
            feedQueue.addFirst(new Feed(tweetId, internalFeedId));
            userFeedMap.put(userId, feedQueue);
        }
    }

    private void addTweet(List<Feed> tweetList, LinkedList<Feed> curTweetList) {
        if (curTweetList != null) {
            int size = curTweetList.size();
            for (int i = 0; i < size; i++) {
                tweetList.add(curTweetList.get(i));
            }
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followSet = userFollowMap.get(userId);
        List<Integer> ansTweetList = new ArrayList<>();
        LinkedList<Feed> curUserTweetList = userFeedMap.get(userId);
        List<LinkedList<Feed>> tweetListList = new ArrayList<>();
        if (curUserTweetList != null && !curUserTweetList.isEmpty()) {
            tweetListList.add(curUserTweetList);
        }
        if (followSet != null) {
            for (Integer followeeId: followSet) {
                LinkedList<Feed> tmpUserTweetList = userFeedMap.get(followeeId);
                if (tmpUserTweetList != null && !tmpUserTweetList.isEmpty()) {
                    tweetListList.add(tmpUserTweetList);
                }
            }
        }

        int tweetListListSize = tweetListList.size();
        if (tweetListListSize == 0) {
            return ansTweetList;
        }

        int[] indexArr = new int[tweetListListSize];
        int n = MAX_NUM;

        // 构建大小为10的优先队列
        Queue<TmpFeed> heap = new PriorityQueue<>(n, new CustomCmp());

        for (int i = 0; i < tweetListListSize; i++) {
            LinkedList<Feed> curTweetList = tweetListList.get(i);
            Feed feed = curTweetList.get(0);
            TmpFeed tmpFeed = new TmpFeed(feed.id, feed.internalId, i);
            heap.add(tmpFeed);
            if (heap.size() > n) {
                heap.poll();
            }
        }

        while ((n--) > 0 && !heap.isEmpty()) {
            TmpFeed feed = heap.poll();
            ansTweetList.add(feed.id);
            int index = feed.index;
            indexArr[index]++;
            LinkedList<Feed> curFeedList = tweetListList.get(index);
            if (indexArr[index] >= curFeedList.size()) {
                continue;
            }
            Feed nextFeed = curFeedList.get(indexArr[index]);
            TmpFeed nextTmpFeed = new TmpFeed(nextFeed.id, nextFeed.internalId, index);
            heap.add(nextTmpFeed);
        }

        return ansTweetList;
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
        Problem355 twitter = new Problem355();
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

//        Problem355 twitter = new Problem355();
//        twitter.postTweet(1, 1);
//        List<Integer> list = twitter.getNewsFeed(1);
//
//        for (Integer feed: list) {
//            System.out.print(feed + ",");
//        }
//        System.out.println();
//
//        twitter.follow(2, 1);
//
//        List<Integer> list1 = twitter.getNewsFeed(2);
//
//        for (Integer feed: list1) {
//            System.out.print(feed + ",");
//        }
//        System.out.println();
//
//        twitter.unfollow(2, 1);
//
//        List<Integer> list2 = twitter.getNewsFeed(2);
//
//        for (Integer feed: list2) {
//            System.out.print(feed + ",");
//        }
//        System.out.println();

    }


}
