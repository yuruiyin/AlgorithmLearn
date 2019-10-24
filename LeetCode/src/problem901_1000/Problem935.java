package problem901_1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem935 {


    private static final int MOD = 1000000007;

    private ArrayList<Integer>[] map;

    private int[] memo;

    private int dfs(int start, int step) {
        int key = start * 10000 + step;
        if (memo[key] != 0) {
            return memo[key];
        }
        if (step == 0) {
            return 1;
        }

        List<Integer> neighborList = map[start];
        int sum = 0;
        for (Integer num : neighborList) {
            sum = (sum + dfs(num, step - 1)) % MOD;
        }

        memo[key] = sum;
        return sum;
    }

    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }

        map = new ArrayList[10];
        map[0] = new ArrayList(Arrays.asList(4, 6));
        map[1] = new ArrayList(Arrays.asList(6, 8));
        map[2] = new ArrayList(Arrays.asList(7, 9));
        map[3] = new ArrayList(Arrays.asList(4, 8));
        map[4] = new ArrayList(Arrays.asList(0, 3, 9));
        map[6] = new ArrayList(Arrays.asList(0, 1, 7));
        map[7] = new ArrayList(Arrays.asList(2, 6));
        map[8] = new ArrayList(Arrays.asList(1, 3));
        map[9] = new ArrayList(Arrays.asList(2, 4));

        memo = new int[95000];

        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            if (i == 5) {
                continue;
            }

            ans = (ans + dfs(i, n - 1)) % MOD;
        }

        return  ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem935().knightDialer(1));
        System.out.println(new Problem935().knightDialer(2));
        System.out.println(new Problem935().knightDialer(3));
        System.out.println(new Problem935().knightDialer(4));
        System.out.println(new Problem935().knightDialer(3000));
    }

}
