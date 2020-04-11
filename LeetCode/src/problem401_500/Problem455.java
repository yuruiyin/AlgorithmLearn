package problem401_500;

import java.util.Arrays;

/**
 * Problem455
 *
 * @author: yry
 * @date: 2020/4/9
 */
public class Problem455 {

    private int findFirstBiggerOrEqual(int[] arr, int from, int target) {
        int low = from;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal >= target) {
                if (mid == from || arr[mid - 1] < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int from = 0;
        for (int i = 0; i < g.length; i++) {
            int firstBiggerIdx = findFirstBiggerOrEqual(s, from, g[i]);
            if (firstBiggerIdx == -1) {
                return ans;
            }

            ans++;
            from = firstBiggerIdx + 1;
        }
        return ans;
    }

}
