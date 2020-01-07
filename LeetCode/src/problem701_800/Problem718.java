package problem701_800;

public class Problem718 {

    public int findLength(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int ansMax = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                    ansMax = Math.max(ansMax, dp[i][j]);
                }
            }
        }

        return ansMax;
    }

}
