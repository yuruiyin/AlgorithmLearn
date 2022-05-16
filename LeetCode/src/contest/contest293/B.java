package contest.contest293;

import java.util.Arrays;

public class B {

    public int maxConsecutive(int bottom, int top, int[] special) {
        int pre = bottom;
        Arrays.sort(special);
        int ansMax = 0;
        for (int num : special) {
            ansMax = Math.max(ansMax, num - pre);
            pre = num + 1;
        }

        return Math.max(ansMax, top + 1 - pre);
    }

}
