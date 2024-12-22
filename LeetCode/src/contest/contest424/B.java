package contest.contest424;

import java.util.Arrays;
import java.util.Comparator;

public class B {

    // 差分
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for (int[] update : updates) {
            int startIdx = update[0];
            int endIdx = update[1];
            diff[startIdx] -= 1;
            if (endIdx < length - 1) {
                diff[endIdx + 1] += 1;
            }
        }

        for (int i = 1; i < length; i++) {
            diff[i] += diff[i-1];
        }

        return diff;
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int len = nums.length;
        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] diff = getModifiedArray(len, queries);
        for (int i = 0; i < len; i++) {
            if (nums[i] + diff[i] > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
