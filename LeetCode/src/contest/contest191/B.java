package contest.contest191;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/31
 */
public class B {

    private static final int MOD = 1000000007;

    private int getMaxDiff(int[] cuts, int w) {
        int maxDiff = cuts[0] - 0;
        int len = cuts.length;

        for (int i = 1; i < len; i++) {
            maxDiff = Math.max(maxDiff, cuts[i] - cuts[i-1]);
        }

        maxDiff = Math.max(maxDiff, w - cuts[len - 1]);
        return maxDiff;
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int horLen = horizontalCuts.length;
        long verMaxDiff = getMaxDiff(verticalCuts, w);
        long horMaxDiff = getMaxDiff(horizontalCuts, h);

        return (int) ((verMaxDiff * horMaxDiff) % MOD);
    }

}
