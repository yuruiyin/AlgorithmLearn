package interview_google.round02;

public class Problem02 {

    private double[] memo;

    private double dp(int N, int K, int W) {
        if (N < 0) {
            return 0.0;
        }

        if (K <= 0) {
            return 1.0;
        }

        if (K == 1) {
            return Math.min(N * 1.0 / W, 1.0);
        }

        if (memo[K] != -1) {
            return memo[K];
        }

        double top = Math.min(N, W);
        double res = 0.0;
        for (int i = 1; i <= top; i++) {
            res += dp(N - i, K - i, W);
        }
        res /=  W;
        memo[K] = res;
        return res;
    }

    public double new21Game(int N, int K, int W) {
//        memo = new double[K + 1];
//        Arrays.fill(memo, -1);

        if (N == 0 || K == 0) {
            return 1.0;
        }

        double[] dp = new double[K + 1];
        dp[1] = Math.min((N - K + 1) * 1.0 / W, 1.0);

        double sum = dp[1];

        // dp[k] = (dp[k-1] + dp[k-2] + dp[k-3] + ... +dp[k-w]) / w
        // 也就是档次投到1-w分值各种情况的概率和。但是要注意k-w可能小于0，比如k=3，w=5的情况，如果我这次投掷出3，后面无需再投了，也就是概率就是1/w了。
        // 可以从dp[1]，dp[2], dp[3] 列出来找一下规律。
        int NKDiff = N - K;
        for (int i = 2; i <= K; i++) {
            if (W >= i) {
                int after = Math.min(NKDiff, W - i);  // 后面有多少个1/W。
                dp[i] = (sum + after + 1) / W;
            } else {
                dp[i] = sum / W;
                sum -= dp[i - W];
            }

            sum += dp[i];
        }

        return dp[K];
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem02().new21Game(10, 1, 10));
//        System.out.println(new Problem02().new21Game(6, 1, 10));
        System.out.println(new Problem02().new21Game(21, 17, 10));
//        System.out.println(new Problem02().new21Game(9676, 8090, 3056));
    }
    
}
