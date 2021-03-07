package contest.contest218;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/6
 */
public class C {

    private static final int MOD = (int) (1e9 + 7);

    public int concatenatedBinary(int n) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int bitCount = Integer.toBinaryString(i).length();
            ans = ((ans << bitCount) + i) % MOD;
        }

        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new C().concatenatedBinary(3));
    }

}
