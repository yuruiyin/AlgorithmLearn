package problem801_900;

public class Problem878 {

    private static final int MOD = (int) (1e9 + 7);

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public int nthMagicalNumber(int n, int a, int b) {
        int g = gcd(a, b);
        int lcm = a * b / g;
        long low = Math.min(a, b);
        long high = (long) Math.max(a, b) * n;
        long ans = -1;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            long count = mid / a + mid / b - mid / lcm;
            if (count < n) {
                low = mid + 1;
            } else {
                if (count == n && (mid % a == 0 || mid % b == 0)) {
                    ans = mid;
                    break;
                }

                high = mid - 1;
            }
        }

        return (int) (ans % MOD);
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem03().nthMagicalNumber(5, 6, 4));
//        System.out.println(new Problem03().nthMagicalNumber(136, 556, 584));
        System.out.println(new Problem878().nthMagicalNumber(400, 511, 294));
    }

}
