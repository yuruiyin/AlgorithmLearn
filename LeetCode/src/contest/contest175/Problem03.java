package contest.contest175;

import utils.PrintUtil;

import java.util.*;

public class Problem03 {

    static class TweetCounts {

        private Map<String, List<Integer>> map;

        public TweetCounts() {
            map = new HashMap<>();
        }

        private int findFirstBiggerOrEqual(List<Integer> list, int target) {
            int low = 0;
            int high = list.size() - 1;

            while (low <= high) {
                int mid = (low + high) >> 1;
                if (target <= list.get(mid)) {
                    if (mid == 0 || target > list.get(mid - 1)) {
                        return mid;
                    }

                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return list.size();
        }

        public void recordTweet(String tweetName, int time) {
            if (map.containsKey(tweetName)) {
                List<Integer> list = map.get(tweetName);
                int insertIndex = findFirstBiggerOrEqual(list, time);
                list.add(insertIndex, time);
                return;
            }

            List<Integer> list = new ArrayList<>();
            list.add(time);
            map.put(tweetName, list);
        }

        private int getDelta(String freq) {
            switch (freq) {
                case "minute":
                    return 60;
                case "hour":
                    return 3600;
                case "day":
                    return 3600 * 24;
            }

            return 0;
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            int delta = getDelta(freq);

            List<Integer> timeList = map.getOrDefault(tweetName, new ArrayList<>());
            int timeSize = timeList.size();

            List<Integer> ansList = new ArrayList<>();
            for (int start = startTime; start <= endTime; start += delta) {
                int end = Math.min(start + delta, endTime + 1) - 1;
                int startIndex = findFirstBiggerOrEqual(timeList, start);
                if (startIndex == timeSize) {
                    ansList.add(0);
                    continue;
                }

                int endIndex = findFirstBiggerOrEqual(timeList, end);
                if (endIndex == timeSize) {
                    ansList.add(timeSize - startIndex);
                } else {
                    int count = endIndex - startIndex;
                    if (timeList.get(endIndex) == end) {
                        count++;
                    }
                    ansList.add(count);
                }
            }

            return ansList;

        }
    }

    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 3700);
        tweetCounts.recordTweet("tweet3", 3000);
        List<Integer> list = tweetCounts.getTweetCountsPerFrequency("day", "tweet3", 0, 40000);
        PrintUtil.printIntList(list);
    }

}
