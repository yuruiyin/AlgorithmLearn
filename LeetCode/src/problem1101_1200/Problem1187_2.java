package problem1101_1200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1187_2 {

    private final static int MAX = 0x3fffffff;

    private Integer[][] memo;
    private int[] arr1;
    private int[] arr2;
    private int len1;
    private int findFirstBigger(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal > target) {
                if (mid == 0 || arr[mid - 1] <= target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int dfs(int idx, int preIdx) {
        if (idx == len1) {
            return 0;
        }

        if (memo[idx][preIdx] != null) {
            return memo[idx][preIdx];
        }

        // 换
        int replaceRes = MAX;
        int pre = preIdx >= len1 ? arr2[preIdx - len1] : arr1[preIdx];
        int idx2 = findFirstBigger(arr2, pre);
        if (idx2 != -1) {
            replaceRes = 1 + dfs(idx + 1, idx2 + len1);
        }

        // 不换
        int nonReplaceRes = MAX;
        if (arr1[idx] > pre) {
            nonReplaceRes = dfs(idx + 1, idx);
        }

        return memo[idx][preIdx] = Math.min(replaceRes, nonReplaceRes);
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        this.len1 = arr1.length;
        int len2 = arr2.length;
        Arrays.sort(arr2);
        this.arr1 = arr1;
        this.arr2 = arr2;
        memo = new Integer[len1][len1 + len2];
        int ans = Math.min(dfs(1, 0), dfs(1, len1) + 1);
        return ans >= MAX ? -1 : ans;
    }

}
