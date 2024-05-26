package contest.contest367;

public class D {

    /**
     * 除法取模 (a / b) % mod ，费马小定理
     * @param a 被初始化
     * @param b 除数
     * @param mod 模
     */
    public static int div(long a, long b, int mod) {
        return (int) (a * pow(b, mod - 2, mod) % mod);
    }

    // 快速幂
    public static int pow(long x, long n, int mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }

            x = x * x % mod;
            n >>>= 1;
        }
        return (int) res % mod;
    }

    private long gcd(long m, long n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public int[][] constructProductMatrix(int[][] grid) {
        int sum = 1;
        int mod = (int) 1e9;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = (sum * grid[i][j]) % mod;
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sum % grid[i][j] == 0) {
                    ans[i][j] = sum / grid[i][j];
                } else {
                    int value = sum;
                    if (sum == 0) {
                        value = mod;
                    }
                    long lcm = (long)value * grid[i][j] / gcd(value, grid[i][j]);
                    ans[i][j] = (int) ((lcm / grid[i][j]) % mod);
                }
            }
        }

        return ans;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        int[][] ans = new D().constructProductMatrix(new int[][]{
//                {1,2}, {3,4}
//        });

        System.out.println(isPrime(823));
    }

}
