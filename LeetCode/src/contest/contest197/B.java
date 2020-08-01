package contest.contest197;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/12
 */
public class B {

    private static final int MOD = (int) (1e9 + 7);

    private long getAns(long n) {
        return (n + 1) * n / 2;
    }

    public int numSub(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        int from = -1;
        for (int i = 0; i < len; i++) {
            if (arr[i] == '1') {
                from = i;
                break;
            }
        }

        if (from == -1) {
            return 0;
        }

        int oneCount = 1;
        long ans = 0;
        for (int i = from + 1; i < len; i++) {
            if (arr[i] == '1') {
                oneCount++;
            } else {
                ans = (ans + getAns(oneCount)) % MOD;
                oneCount = 0;
            }
        }

        ans = (ans + getAns(oneCount)) % MOD;
        return (int) ans;
    }

}
