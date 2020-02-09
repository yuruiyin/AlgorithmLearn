package contest.contest175;

import java.util.*;

public class Problem03_1 {

    static class TweetCounts {

        private Map<String, TreeSet<Integer>> map;

        public TweetCounts() {
            map = new HashMap<>();
        }

        public void recordTweet(String tweetName, int time) {
            if (map.containsKey(tweetName)) {
                TreeSet<Integer> set = map.get(tweetName);
                set.add(time);
                return;
            }

            TreeSet<Integer> set = new TreeSet<>();
            set.add(time);
            map.put(tweetName, set);
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

            return -1;
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            int delta = getDelta(freq);

            TreeSet<Integer> timeSet = map.getOrDefault(tweetName, new TreeSet<>());
            List<Integer> timeList = new ArrayList<>(timeSet);
            int timeSize = timeList.size();
            List<Integer> ansList = new ArrayList<>();

            for (int start = startTime; start <= endTime; start += delta) {
                int end = Math.min(start + delta, endTime + 1) - 1;
                int startIndex = findFirstBiggerOrEqual(timeList, start);
                if (startIndex == -1) {
                    ansList.add(0);
                    continue;
                }

                int endIndex = findFirstBiggerOrEqual(timeList, end);
                if (endIndex == -1) {
                    ansList.add(timeSize - startIndex);
                } else {
                    int count = endIndex - startIndex;
                    if (timeList.get(endIndex) == end) {
                        count++;
                    }
                    ansList.add(count);
                }

//                int count = 0;
//                for (Integer time: timeList) {
//                    if (time >= start && time <= end) {
//                        count++;
//                    }
//                }
//                ansList.add(count);
            }

            return ansList;

        }
    }

}
