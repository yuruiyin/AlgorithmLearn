package doubleContest.round092;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    // 求指定非连续子序列的个数
    private long calcCount(char[] arr, char[] subArr) {
        if (!checkIsSubSeq(arr, subArr)) {
            return 0;
        }
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

    private boolean checkIsSubSeq(char[] arr, char[] subArr) {
        int len = arr.length;
        int subLen = subArr.length;
        int j = 0;
        for (int i = 0; i < len && j < subLen && len - i >= subLen - j; ) {
            if (arr[i] == subArr[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == subLen;
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
        System.out.println(new D().countPalindromes("0000000"));
        System.out.println(new D().countPalindromes("0".repeat(10000)));
    }

}
