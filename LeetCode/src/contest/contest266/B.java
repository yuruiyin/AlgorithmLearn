package contest.contest266;

/**
 * B
 *
 * @author: yry
 * @date: 2021/11/7
 */
public class B {

    private boolean isOk(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    public long countVowels(String word) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        long[] dp = new long[len];
        dp[0] = isOk(arr[0]) ? 1 : 0;
        int preIdx = dp[0] == 1 ? 0 : -1;
        long ans = dp[0];
        for (int i = 1; i < len; i++) {
            if (isOk(arr[i])) {
                if (preIdx == -1) {
                    dp[i] = i + 1;
                } else {
                    dp[i] = i - preIdx + (dp[preIdx] + (preIdx + 1L));
                }
                ans += dp[i];
                preIdx = i;
            } else {
                if (preIdx != -1) {
                    ans += dp[preIdx];
                    dp[i] = dp[preIdx];
                }
            }
        }
        return ans;
    }

}
