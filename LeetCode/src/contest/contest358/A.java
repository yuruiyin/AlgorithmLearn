package contest.contest358;

import java.util.Map;

public class A {

    public int maxSum(int[] nums) {
        int len = nums.length;
        int ansMax = -1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = nums[i];
                int b = nums[j];
                char[] arr1 = String.valueOf(a).toCharArray();
                char[] arr2 = String.valueOf(b).toCharArray();
                char max1 = 0;
                for (char c : arr1) {
                    if (c > max1) {
                        max1 = c;
                    }
                }
                char max2 = 0;
                for (char c : arr2) {
                    if (c > max2) {
                        max2 = c;
                    }
                }
                if (max1 == max2) {
                    ansMax = Math.max(ansMax, a + b);
                }
            }
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
