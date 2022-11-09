package doubleContest.round089;

public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int[] productQueries(int n, int[][] queries) {
        int[] powers = new int[32];
        int pIdx = 0;
        int idx = 0;
        while (n > 0) {
            int x = n % 2;
            n >>= 1;
            if (x == 1) {
                powers[pIdx++] = 1 << idx;
            }
            idx++;
        }

        int[] ansArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int l = q[0];
            int r = q[1];
            long sum = 1;
            for (int j = l; j <= r; j++) {
                sum = (sum * powers[j]) % MOD;
            }
            ansArr[i] = (int) sum;
        }
        return ansArr;
    }

}
