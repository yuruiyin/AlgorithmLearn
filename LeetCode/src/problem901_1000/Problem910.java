package problem901_1000;

import java.util.Arrays;

public class Problem910 {

    public int smallestRangeII(int[] arr, int k) {
        int len = arr.length;
        if (len == 1) {
            return 0;
        }

        Arrays.sort(arr);
        int ans = arr[len - 1] - arr[0];
        // 在某一个节点时，之前的数全部加k，之后的数全部减k。
        for (int i = 1; i < len; i++) {
            int min = Math.min(arr[0] + k, arr[i] - k);
            int max = Math.max(arr[len-1] - k, arr[i-1] + k);
            ans = Math.min(ans, max - min);
        }

        return ans;
    }

}
