package problem1201_1300;

import java.util.ArrayList;
import java.util.List;

public class Problem1220_1 {

    private static final int MOD = 1000000007;

    private int n;
    private Integer[][] memo;

    private List<Integer> getNextCharIndex(int charIndex) {
        List<Integer> list = new ArrayList<>();
        if (charIndex == 0) {
            list.add(1);
        } else if (charIndex == 1) {
            list.add(0);
            list.add(2);
        } else if (charIndex == 2) {
            list.add(0);
            list.add(1);
            list.add(3);
            list.add(4);
        } else if (charIndex == 3) {
            list.add(2);
            list.add(4);
        } else {
            list.add(0);
        }
        return list;
    }

    private int dp(int from, int charIndex) {
        if (from == n) {
            return 1;
        }

        if (memo[from][charIndex] != null) {
            return memo[from][charIndex];
        }

        List<Integer> nextCharIndexList = getNextCharIndex(charIndex);
        long ansCount = 0;
        for (Integer nextIndex : nextCharIndexList) {
            ansCount = (ansCount + dp(from + 1, nextIndex)) % MOD;
        }

        memo[from][charIndex] = Math.toIntExact(ansCount);
        return memo[from][charIndex];
    }

    public int countVowelPermutation(int n) {
        this.n = n;
        memo = new Integer[n][5];
        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp(1, i)) % MOD;
        }

        return (int) ans;
    }

}
