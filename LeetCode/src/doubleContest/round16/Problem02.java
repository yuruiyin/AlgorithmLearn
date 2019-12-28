package doubleContest.round16;

import java.util.Arrays;

public class Problem02 {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
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
                    int low = arr[i-1];
                    int high = arr[i];
                    int min = Integer.MAX_VALUE;
                    int ans = -1;
                    sum -= arr[i];
                    for (int j = low; j <= high; j++) {
                        int diff = Math.abs(sum + j * (len - i) - target);
                        if (diff < min) {
                            min = diff;
                            ans = j;
                        }
                    }

                    return ans;
                }
            }
        }

        return arr[len-1];
    }
    
}
