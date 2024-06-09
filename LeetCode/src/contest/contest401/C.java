package contest.contest401;

import java.util.Arrays;

public class C {

    private int[][] memo;
    private int[] arr;
    private int len;

    private int findFirstBiggerIdx(int[] arr, int from, int target) {
        int l = from;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > target) {
                if (mid == 0 || arr[mid - 1] <= target) {
                    return mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int rec(int idx, int preSum) {
        if (idx == len) {
            return 0;
        }

        if (memo[idx][preSum] != -1) {
            return memo[idx][preSum];
        }

        int ansMax = 0;

        if (arr[idx] <= preSum) {
            int rightFirstBiggerIdx = findFirstBiggerIdx(arr, idx, preSum);
            if (rightFirstBiggerIdx == -1) {
                return 0;
            }
            return rec(rightFirstBiggerIdx, preSum);
        }

        int nonChoose = rec(idx + 1, preSum);
        int choose = rec(idx + 1, preSum + arr[idx]) + arr[idx];
        ansMax = Math.max(nonChoose, choose);
        return memo[idx][preSum] = ansMax;
    }

    public int maxTotalReward(int[] arr) {
        Arrays.sort(arr);
        this.arr = arr;
        len = arr.length;
        memo = new int[len][4001];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return rec(0, 0);
    }

}
