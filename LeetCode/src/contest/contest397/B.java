package contest.contest397;

public class B {

    public int maximumEnergy(int[] energy, int k) {
        int len = energy.length;
        int[] dp = new int[len];
        dp[len - 1] = energy[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            dp[i] = energy[i] + (i + k < len ? dp[i + k] : 0);
        }
        int ansMax = -1000;
        for (int i = 0; i < len; i++) {
            ansMax = Math.max(ansMax, dp[i]);
        }
        return ansMax;
    }

}
