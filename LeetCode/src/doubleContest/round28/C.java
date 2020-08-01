package doubleContest.round28;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/13
 */
public class C {

    class Data {
        int l;
        int r;
        Data(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    private int findFirstBiggerIdx(List<Data> list, int target) {
        int size = list.size();
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Data midData = list.get(mid);
            int midVal = midData.l;
            if (midVal > target) {
                if (mid == 0 || list.get(mid - 1).l <= target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int minSumOfLengths(int[] arr, int target) {
        int len = arr.length;
        List<Data> list = new ArrayList<>();
        int preSum = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            preSum += arr[i];
            indexMap.put(preSum, i);
            if (preSum < target) {
                continue;
            } else if (preSum == target) {
                list.add(new Data(0, i));
            } else {
                if (indexMap.containsKey(preSum - target)) {
                    int l = indexMap.get(preSum - target);
                    list.add(new Data(l + 1, i));
                }
            }
        }

        list.sort(Comparator.comparingInt(o -> o.l));

        int size = list.size();

        if (size <= 1) {
            return -1;
        }

        int[] sufMinLenArr = new int[size];
        sufMinLenArr[size - 1] = list.get(size - 1).r - list.get(size - 1).l + 1;
        for (int i = size - 2; i >= 0; i--) {
            Data data = list.get(i);
            int curLen = data.r - data.l + 1;
            sufMinLenArr[i] = Math.min(sufMinLenArr[i + 1], curLen);
        }

        // 二分
        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            Data data = list.get(i);
            int firstLen = data.r - data.l + 1;
            int r = data.r;
            // 找到后面l大于当前r的
            int firstBiggerIdx = findFirstBiggerIdx(list, r);
            if (firstBiggerIdx == -1) {
                continue;
            }

            int sufMinLen = sufMinLenArr[firstBiggerIdx];
            ansMin = Math.min(ansMin, firstLen + sufMinLen);
        }

        return ansMin == Integer.MAX_VALUE ? -1 : ansMin;
    }

}
