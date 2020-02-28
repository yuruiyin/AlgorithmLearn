package doubleContest.round20;

public class Problem04 {

    private static final int MOD = (int) (1e9 + 7);

    public int countOrders(int n) {
        long ans = 1;
        long emptyCount = 3;
        for (int i = 2; i <= n; i++) {
            ans = (ans * (emptyCount + emptyCount * (emptyCount - 1) / 2)) % MOD;
            emptyCount = i * 2 + 1;
        }

        return (int) (ans % MOD);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem04().countOrders(4));
    }

}
