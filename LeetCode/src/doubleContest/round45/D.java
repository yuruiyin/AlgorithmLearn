package doubleContest.round45;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/6
 */
public class D {

    private int[][] events;
    private int[][] memo;
    private int len;
    private int[] nextIdxMemo;

    private int getNextIdx(int from) {
        if (nextIdxMemo[from] != -1) {
            return nextIdxMemo[from];
        }
        for (int i = from + 1; i < len; i++) {
            if (events[i][0] > events[from][1]) {
                nextIdxMemo[from] = i;
                return i;
            }
        }
        nextIdxMemo[from] = len;
        return len;
    }

    private int rec(int from, int k) {
        if (k == 0) {
            return 0;
        }

        if (from == len) {
            return 0;
        }

        if (memo[from][k] != -1) {
            return memo[from][k];
        }

        int v = events[from][2];

        //选或者不选
        int chooseRes = v + rec(getNextIdx(from), k - 1);
        int nonChooseRes = rec(from + 1, k);

        memo[from][k] = Math.max(chooseRes, nonChooseRes);
        return memo[from][k];
    }

    public int maxValue(int[][] events, int k) {
        this.events = events;
        this.len = events.length;
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));

        memo = new int[len][k + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }

        nextIdxMemo = new int[len];
        Arrays.fill(nextIdxMemo, -1);

        return rec(0, k);
    }

    public static void main(String[] args) {
        System.out.println(new D().maxValue(new int[][]{
                {21,77,43},{2,74,47},{6,59,22},{47,47,38},{13,74,57},{27,55,27},{8,15,8}
        }, 4));
    }

}
