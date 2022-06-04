package contest.contest278;

import java.util.ArrayList;
import java.util.List;

public class B {

    public List<Integer> maxScoreIndices(int[] nums) {
        int len = nums.length;
        int maxCount = 0;
        int[] preZeroCountArr = new int[len];
        preZeroCountArr[0] = nums[0] == 0 ? 1 : 0;
        for (int i = 1; i < len; i++) {
            preZeroCountArr[i] = preZeroCountArr[i - 1] + (nums[i] == 0 ? 1 : 0);
        }

        for (int i = 0; i <= len; i++) {
            int value;
            if (i == 0) {
                // 只有右数组
                value = len - preZeroCountArr[len - 1];
            } else if (i == len) {
                // 只有左数组
                value = preZeroCountArr[len - 1];
            } else {
                value = preZeroCountArr[i - 1] + (len - i - (preZeroCountArr[len - 1] - preZeroCountArr[i - 1]));
            }
            maxCount = Math.max(maxCount, value);
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i <= len; i++) {
            int value;
            if (i == 0) {
                // 只有右数组
                value = len - preZeroCountArr[len - 1];
            } else if (i == len) {
                // 只有左数组
                value = preZeroCountArr[len - 1];
            } else {
                value = preZeroCountArr[i - 1] + (len - i - (preZeroCountArr[len - 1] - preZeroCountArr[i - 1]));
            }
            if (value == maxCount) {
                ansList.add(i);
            }
        }
        return ansList;
    }

}
