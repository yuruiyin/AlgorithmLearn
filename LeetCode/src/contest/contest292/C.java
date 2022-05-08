package contest.contest292;

import java.util.Arrays;

public class C {

    private static final int MOD = (int) (1e9 + 7);

    private int[] countArr;
    private char[] arr;
    private int len;
    private long[] memo;

    private long rec(int cur) {
        if (cur >= len - 1) {
            return 1;
        }

        if (memo[cur] != -1) {
            return memo[cur];
        }

        long ans = 0;
        char curChar = arr[cur];
        int end = Math.min(len, cur + countArr[curChar - '0']);
        for (int i = cur; i < end; i++) {
            if (arr[i] != arr[cur]) {
                break;
            }
            long res = rec(i + 1);
            ans = (ans + res) % MOD;
        }

        memo[cur] = ans;
        return ans;
    }

    public int countTexts(String pressedKeys) {
        this.arr = pressedKeys.toCharArray();
        this.len = arr.length;
        countArr = new int[10];
        Arrays.fill(countArr, 3);
        countArr[7] = 4;
        countArr[9] = 4;
        memo = new long[len];
        Arrays.fill(memo, -1);
        return (int) (rec(0) % MOD);
    }

    public static void main(String[] args) {
//        System.out.println(new C().countTexts("22233"));
        System.out.println(new C().countTexts("22233"));
    }

}
