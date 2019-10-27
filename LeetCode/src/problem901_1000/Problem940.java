package problem901_1000;

public class Problem940 {

    private static final int MOD = 1000000007;

    public int distinctSubseqII(String s) {
        int len = s.length();
        if (len == 1) {
            return 1;
        }

        int[] dp = new int[len]; // 以每一位为结尾的序列个数
        dp[0] = 1;
        int ans = 1;
        int sum = 1;

        int[] letterCount = new int[26];
        letterCount[s.charAt(0) - 'a'] = 1;

        for (int i = 1; i < len; i++) {
            char curChar = s.charAt(i);
            dp[i] = (sum + 1 - letterCount[curChar - 'a'] + MOD) % MOD;
            sum = (sum + dp[i]) % MOD;
            letterCount[curChar - 'a'] = (letterCount[curChar - 'a'] + dp[i]) % MOD;
            ans = (ans + dp[i]) % MOD;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem940().distinctSubseqII("abc"));
        System.out.println(new Problem940().distinctSubseqII("aba"));
        System.out.println(new Problem940().distinctSubseqII("aaa"));
        System.out.println(new Problem940().distinctSubseqII("lee"));
        System.out.println(new Problem940().distinctSubseqII("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn"));
        System.out.println(new Problem940().distinctSubseqII("blljuffdyfrkqtwfyfztpdiyktrhftgtabxxoibcclbjvirnqyynkyaqlxgyybkgyzvcahmytjdqqtctirnxfjpktxmjkojlvvrr"));

    }
    
}
