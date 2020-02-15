package lcof;

public class Lcof014_2 {

    private static final int MOD = (int) (1e9 + 7);

    private long pow3(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= 3;
            ans %= MOD;
        }
        return ans;
    }

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        int mod = n % 3;
        if (mod == 0) {
            return (int) (pow3(n / 3) % MOD);
        } else if (mod == 1) {
            // 两个2，剩下全是3，如7=2+2+3
            return (int) ((4 * pow3((n - 4) / 3)) % MOD);
        } else {
            // 一个2，剩下全是3，如8=2+3+3
            return (int) ((2 * pow3((n - 2) / 3)) % MOD);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Lcof014_2().cuttingRope(10));
        System.out.println(new Lcof014_2().cuttingRope(1000));
    }

}
