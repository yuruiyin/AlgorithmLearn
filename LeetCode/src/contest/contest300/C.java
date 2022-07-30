package contest.contest300;

public class C {

    private static final int MOD = (int) (1e9 + 7);

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long ans = 0;
        long[] countArr = new long[2 * n + 1];
        countArr[0] = 1;
        for (int i = 2; i <= n; i++) {
            long[] nextCountArr = new long[n + 2];
            for (int j = 0; j <= n; j++) {
                nextCountArr[j + 1] = countArr[j];
            }
            for (int j = 0; j <= n + 1; j++) {
                countArr[j] = nextCountArr[j];
            }

            for (int j = forget; j <= n + 1; j++) {
                countArr[j] = 0;
            }
            for (int j = delay; j <= n + 1; j++) {
                countArr[0] = (countArr[0] + countArr[j]) % MOD;
            }
        }
        for (int i = 0; i <= 2 * n; i++) {
            if (i >= forget) {
                break;
            }
            ans = (ans + countArr[i]) % MOD;
        }
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
//        System.out.println(new C().peopleAwareOfSecret(6, 2, 4));
        System.out.println(new C().peopleAwareOfSecret(6, 2, 4));
    }

}
