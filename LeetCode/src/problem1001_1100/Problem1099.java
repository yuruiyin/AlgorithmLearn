package problem1001_1100;

import java.util.Arrays;

public class Problem1099 {

    public int twoSumLessThanK(int[] arr, int k) {
        int ansMax = Integer.MIN_VALUE;
        int len = arr.length;

        int[] countArr = new int[1001];
        for (int num: arr) {
            countArr[num]++;
        }

        int num = 0;
        for (int i = 0; i < 1001; i++) {
            while ((countArr[i]--) > 0) {
                arr[num++] = i;
            }
        }

//        Arrays.sort(arr);

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum >= k) {
                right--;
            } else {
                left++;
                if (sum > ansMax) {
                    ansMax = sum;
                }
            }
        }

        return ansMax == Integer.MIN_VALUE ? -1 : ansMax;
    }
    
    public static void main(String[] args) {

    }
    
}
