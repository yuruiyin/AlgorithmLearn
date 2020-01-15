package contest.contest112;

import java.util.Arrays;

public class Problem948 {

    public int bagOfTokensScore(int[] tokens, int p) {
        int len = tokens.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(tokens);
        int score = 0;
        int left = 0;
        int right = len - 1;
        int ans = score;
        while (left <= right) {
            if (p >= tokens[left]) {
                score++;
                p -= tokens[left];
                left++;
                ans = Math.max(ans, score);
            } else {
                if (score == 0) {
                    return ans;
                }

                score--;
                p += tokens[right];
                right--;
                ans = Math.max(ans, score);
            }
        }

        return ans;
    }

}
