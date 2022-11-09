package contest.contest310;

import java.util.Arrays;

public class A {

    public int mostFrequentEven(int[] nums) {
        int[] countArr = new int[100001];
        Arrays.fill(countArr, -1);
        for (int num : nums) {
            if (num % 2 == 0) {
                countArr[num]++;
            }
        }

        int maxCount = 0;
        for (int i = 0; i <= 100000; i+=2) {
            maxCount = Math.max(maxCount, countArr[i]);
        }

        for (int i = 0; i < 100000; i+=2) {
            if (countArr[i] == maxCount) {
                return i;
            }
        }
        return -1;
    }

}
