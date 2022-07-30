package contest.contest302;

import java.util.Arrays;

public class A {

    public int[] numberOfPairs(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return new int[]{0, 1};
        }
        int[] countArr = new int[101];
        for (int i = 0; i < len; i++) {
            countArr[nums[i]]++;
        }

        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i <= 100; i++) {
            if (countArr[i] % 2 == 1) {
                count2++;
            }
            count1 += countArr[i] / 2;
        }
        return new int[]{count1, count2};
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
