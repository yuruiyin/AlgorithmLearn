package contest.contest296;

import java.util.Arrays;

public class A {

    public int minMaxGame(int[] nums) {
        int len = nums.length;
        int[] newNums = Arrays.copyOf(nums, len);
        while (newNums.length > 1) {
            int[] tmpNums = new int[newNums.length / 2];
            for (int i = 0; i < tmpNums.length; i++) {
                if (i % 2 == 0) {
                    tmpNums[i] = Math.min(newNums[2 * i], newNums[2 * i + 1]);
                } else {
                    tmpNums[i] = Math.max(newNums[2 * i], newNums[2 * i + 1]);
                }
            }
            newNums = tmpNums;
        }
        return newNums[0];
    }

}
