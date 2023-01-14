package doubleContest.round092;

public class D_2 {

    private static final int MOD = (int) (1e9 + 7);

    // 求指定非连续子序列的个数
    private long calcCount(char[] arr, char[] subArr) {
        long[] dp = new long[6];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 5; j >= 1; j--) {
                if (arr[i] == subArr[j - 1]) {
                    dp[j] = (dp[j] + dp[j - 1]) % MOD;
                }
            }
        }
        return dp[5];
    }

    public int countPalindromes(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        if (len < 5) {
            return 0;
        }

        long ans = 0;

        for (int i = 0; i <= 999; i++) {
            String tmpStr = String.format("%03d", i);
            String prefixStr = tmpStr.substring(0, 2);
            String subStr = tmpStr + new StringBuilder(prefixStr).reverse();
            ans = (ans + calcCount(arr, subStr.toCharArray())) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new D_2().countPalindromes("0000000"));
    }

}
