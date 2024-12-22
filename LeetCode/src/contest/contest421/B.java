package contest.contest421;

public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int lengthAfterTransformations(String s, int t) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        long ans = len;
        for (int i = 0; i < len; i++) {
            int firstCount = 'z' - arr[i] + 1;
            int curT = t;
            if (curT < firstCount) {
                continue;
            }
            ans = (ans + 1) % MOD;
            if (curT > firstCount) {
                curT -= firstCount;
                int count1 = curT / 26;

                ans = (ans + curT / 26) % MOD;
                ans = (ans + curT / 25) % MOD;
            }
        }

        return (int) (ans % MOD);
    }

}
