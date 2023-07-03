package problem1101_1200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1187 {

    private final static int MAX = 0x3fffffff;

    private Map<Long, Integer> memoMap;

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

    private int dfs(int idx, int pre) {
        if (idx == len1) {
            return 0;
        }

        long key = pre * 2000L + idx;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int curVal = arr1[idx];

        // 换
        // 一定要替换成arr2中的数字
        int replaceRes = MAX;
        int idx2 = findFirstBigger(arr2, pre);
        if (idx2 != -1) {
            replaceRes = 1 + dfs(idx + 1, arr2[idx2]);
        }

        // 不换
        int nonReplaceRes = MAX;
        if (curVal > pre) {
            nonReplaceRes = dfs(idx + 1, arr1[idx]);
        }

        int ans = Math.min(replaceRes, nonReplaceRes);
        memoMap.put(key, ans);
        return ans;
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        this.len1 = arr1.length;
        Arrays.sort(arr2);
        this.arr1 = arr1;
        this.arr2 = arr2;
        memoMap = new HashMap<>();
        int ans = dfs(0, -1);
        return ans >= MAX ? -1 : ans;
    }

}
