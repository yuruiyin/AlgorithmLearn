package contest.contest350;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class D {

    private Integer[][] memo;

    private int[] cost;
    private int[] times;
    private int len;

    private int solve(int idx, int time) {
        if (time >= len) {
            return 0;
        }
        if (idx >= len) {
            return (int) 1e9;
        }

        if (memo[idx][time] != null) {
            return memo[idx][time];
        }

        return memo[idx][time] = Math.min(solve(idx + 1, time), cost[idx] + solve(idx + 1, time + times[idx] + 1));
    }

    public int paintWalls(int[] cost, int[] time) {
        this.len = cost.length;
        this.cost = cost;
        this.times = time;
        memo = new Integer[len][len];
        return solve(0, 0);
    }

    public static void main(String[] args) {
        System.out.println(new D().paintWalls(new int[]{1,2,3,2}, new int[]{1,2,3,2}));
//        System.out.println(new D().paintWalls(new int[]{8,7,5,15}, new int[]{1,1,2,1}));
    }

}
