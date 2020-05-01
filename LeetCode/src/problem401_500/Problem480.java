package problem401_500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem480
 *
 * @author: yry
 * @date: 2020/4/13
 */
public class Problem480 {

    private int findFirstBiggerIdx(List<Double> list, double target) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            double midVal = list.get(mid);
            if (midVal >= target) {
                if (mid == 0 || list.get(mid - 1) < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return list.size();
    }

    private double getMid(List<Double> list, int k) {
        return k % 2 == 1 ? list.get(k / 2) : (list.get(k / 2) + list.get(k / 2 - 1)) / 2;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        List<Double> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            list.add((double) nums[i]);
        }

        Collections.sort(list);
        double[] ansArr = new double[len - k + 1];
        ansArr[0] = getMid(list, k);
        int index = 1;
        for (int i = 1; i <= len - k; i++) {
            // 左边移除一个数，右边增加一个数
            double leftNum = nums[i - 1];
            double rightNum = nums[i + k - 1];
            int leftNumIdx = Collections.binarySearch(list, leftNum);
            list.remove(leftNumIdx);
            int insertIdx = findFirstBiggerIdx(list, rightNum);
            list.add(insertIdx, rightNum);
            ansArr[index++] = getMid(list, k);
        }
        return ansArr;
    }

}
