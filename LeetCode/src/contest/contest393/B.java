package contest.contest393;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {

    private static final int N = 101;

    private static final boolean[] isPrime = new boolean[N];

    static {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        int max = (int) Math.sqrt(N);
        for (int i = 2; i <= max; i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < N; j += i) {
                isPrime[j] = false;
            }
        }

    }

    public int maximumPrimeDifference(int[] nums) {
        int len = nums.length;
        int minIdx = len;
        int maxIdx = -1;
        for (int i = 0; i < len; i++) {
            if (isPrime[nums[i]]) {
                minIdx = Math.min(minIdx, i);
                maxIdx = Math.max(maxIdx, i);
            }
        }
        return maxIdx - minIdx;
    }


    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
