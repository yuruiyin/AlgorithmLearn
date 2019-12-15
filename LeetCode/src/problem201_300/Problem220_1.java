package problem201_300;

import java.util.Arrays;
import java.util.Comparator;

public class Problem220_1 {

    class Data {
        long value;
        int index;
        Data(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    private int findLastSmaller(Data[] datas, int from, long target) {
        int len = datas.length;
        int low = from;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = datas[mid].value;

            if (midVal <= target) {
                if (mid == len - 1 || datas[mid + 1].value > target) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        int len = nums.length;
        Data[] datas = new Data[len];

        for (int i = 0; i < len; i++) {
            datas[i] = new Data(nums[i], i);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.value == o2.value) {
                    return o1.index - o2.index;
                }

                if (o1.value > o2.value) {
                    return 1;
                }

                return -1;
            }
        });

        for (int i = 0; i < len; i++) {
            Data curData = datas[i];
            // 二分寻找下一个与当前值差的绝对值<=t的元素
            long nextBiggerValue = curData.value + t;
            int nextIndex = findLastSmaller(datas, i+1, nextBiggerValue);
            if (nextIndex == -1) {
                continue;
            }

            for (int j = i + 1; j <= nextIndex; j++) {
                if (Math.abs((long) datas[i].index - datas[j].index) <= k) {
                    return true;
                }
            }
        }

        return false;
    }

}
