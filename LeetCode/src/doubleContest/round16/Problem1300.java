package doubleContest.round16;

import java.util.Arrays;

public class Problem1300 {

    private int len;

    private int find(int low, int high, int prevSum, int from, int target) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int sum = prevSum + mid * (len - from);
            if (sum == target) {
                return mid;
            } else if (sum > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int ans1 = Math.abs(prevSum + low * (len - from) - target);
        int ans2 = Math.abs(prevSum + high * (len - from) - target);

        if (ans1 < ans2) {
            return low;
        } else {
            return high;
        }
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        len = arr.length;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += arr[i];
            int tmpSum = sum + (len - i - 1) * arr[i];
            if (tmpSum == target) {
                return arr[i];
            } else if (tmpSum > target) {
                if (i == 0) {
                    if (Math.abs(len * (target / len) - target) <= Math.abs(len * (target / len + 1) - target)) {
                        return target / len;
                    } else {
                        return target / len + 1;
                    }
                } else {
                    sum -= arr[i];
                    return find(arr[i-1], arr[i], sum, i, target);
                }
            }
        }

        return arr[len-1];
    }
    
}
