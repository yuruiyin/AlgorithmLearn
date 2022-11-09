package contest.contest309;

import java.util.Arrays;

public class C {

    private void calc(int[][] preArr, int num) {

    }

    public int longestNiceSubarray(int[] nums) {
        int len = nums.length;
        int[][] preArr = new int[32][2];
        for (int i = 0; i < 32; i++) {
            preArr[i][0] = -1;
            preArr[i][1] = -1;
        }

        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            int[] arr = new int[32];
            Arrays.fill(arr, len);
            for (int idx = 0; idx < 32; idx++) {
                int value = num % 2;
                num /= 2;
                if (value == 1) {
                    if (preArr[idx][1] == -1) {
                        arr[idx] = i + 1;
                        preArr[idx][1] = i;
                    } else {
                        arr[idx] = i - preArr[idx][1];
                        preArr[idx][0] = preArr[idx][1];
                        preArr[idx][1] = i;
                    }
                } else {
                    if (preArr[idx][1] == -1) {
                        arr[idx] = i + 1;
                    } else {
                        if (preArr[idx][0] == -1) {
                            arr[idx] = i + 1;
                        } else {
                            arr[idx] = i - preArr[idx][0];
                        }
                    }
                }
            }

            int min = len;
            for (int j = 0; j < 32; j++) {
                min = Math.min(min, arr[j]);
            }
            ansMax = Math.max(ansMax, min);
        }
        return ansMax;
    }

}
