package contest.contest453;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class C {

    private static final int MOD = (int) (1e9 + 7);

    private int[] arr;
    private int len;
    private int k;
    private int[] memo;

    private int rec(int idx) {
        if (idx == len) {
            return 1;
        }
        if (idx == len - 1) {
            return 1;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        int min = arr[idx];
        int max = arr[idx];
        long res = rec(idx + 1);
        for (int i = idx + 1; i < len; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (max - min > k) {
                break;
            }

            res = (res + rec(i + 1)) % MOD;
        }

        return memo[idx] = (int) res;
    }

    public int countPartitions(int[] nums, int k) {
        this.len = nums.length;
        this.arr = nums;
        this.k = k;
        memo = new int[len];
        Arrays.fill(memo, -1);
        return rec(0);
    }

    public static void main(String[] args) {
        System.out.println(new C().countPartitions(new int[]{3,3,4}, 0));
        System.out.println(new C().countPartitions(new int[]{9,4,1,3,7}, 4));
    }

}
