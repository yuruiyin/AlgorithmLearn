package contest.contest453;

import java.util.Arrays;

public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int countPermutations(int[] complexity) {
        int len = complexity.length;
        Arrays.sort(complexity, 1, len);
        if (complexity[1] <= complexity[0]) {
            return 0;
        }

        long ans = 1;
        for (int i = len - 1; i >= 2; i--) {
            ans = (ans * i) % MOD;
        }

        return (int) ans;
    }

}
