package problem1101_1200;

import java.util.*;

public class Problem1157 {

    class MajorityChecker {

        static class Data {
            int num;
            List<Integer> indexList;
            Data(int num, List<Integer> indexList) {
                this.num = num;
                this.indexList = indexList;
            }
        }

        private List<Data> list;

        private static final int MAX = 20001;

        private int[] arr;

        public MajorityChecker(int[] arr) {
            this.arr = arr;
            int len = arr.length;
            Map<Integer, List<Integer>> indexListMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                if (!indexListMap.containsKey(arr[i])) {
                    indexListMap.put(arr[i], new ArrayList<>());
                }
                indexListMap.get(arr[i]).add(i);
            }

            list = new ArrayList<>();
            for (int num : indexListMap.keySet()) {
                List<Integer> indexList = indexListMap.get(num);
                list.add(new Data(num, indexList));
            }

            // 按元素的个数进行排序
            Collections.sort(list, new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return o1.indexList.size() - o2.indexList.size();
                }
            });
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

        private int findLastSmallerOrEqual(List<Integer> list, int target) {
            int len = list.size();
            int low = 0;
            int high = len - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = list.get(mid);
                if (midVal <= target) {
                    if (mid == len - 1 || list.get(mid + 1) > target) {
                        return mid;
                    }

                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        public int query(int left, int right, int threshold) {
            // 如果区间长度（right - left + 1）在1000以内的，直接暴力就可以了
            int length = right - left + 1;
            if (length <= 25) {
                int[] countArr = new int[MAX];
                for (int i = left; i <= right; i++) {
                    countArr[arr[i]]++;
                }
                int maxCount = 0;
                for (int i = 1; i < MAX; i++) {
                    maxCount = Math.max(maxCount, countArr[i]);
                }
                if (maxCount >= threshold) {
                    for (int i = 1; i < MAX; i++) {
                        if (countArr[i] == maxCount) {
                            return i;
                        }
                    }
                    return -1;
                } else {
                    return -1;
                }
            } else {
                // 由于长度比较大，那么寻找元素个数至少是threshold的就可以筛掉很大一部分元素，我们可以从个数长的往个数端的遍历
                int size = list.size();
                for (int i = size - 1; i >= 0; i--) {
                    Data data = list.get(i);
                    List<Integer> indexList = data.indexList;
                    if (indexList.size() < threshold) {
                        break;
                    }

                    // 二分找到索引第一个比left大于或等于的 和 索引最后一个比right小于或等于的
                    int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(indexList, left);
                    int lastSmallerOrEqualIdx = findLastSmallerOrEqual(indexList, right);
                    if (firstBiggerOrEqualIdx == -1 || lastSmallerOrEqualIdx == -1) {
                        continue;
                    }

                    int tmpLen = lastSmallerOrEqualIdx - firstBiggerOrEqualIdx + 1;
                    if (tmpLen >= threshold) {
                        return data.num;
                    }
                }
                return -1;
            }
        }
    }

}
