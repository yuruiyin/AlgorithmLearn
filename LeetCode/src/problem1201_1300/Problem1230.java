package problem1201_1300;

import java.util.HashMap;
import java.util.Map;

public class Problem1230 {

    private Map<Integer, Double> memoMap = new HashMap<>();
    private double[] tailMultiply1;
    private double[] tailMultiply2;

    private double dfs(double[] prob, int from, int target) {
        int key = from * 1000 +  target;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        if (prob.length - from == target) {
            double res = tailMultiply1[from];
            memoMap.put(key, res);
            return res;
        }

        if (target == 0) {
            double res = tailMultiply2[from];
            memoMap.put(key, res);
            return res;
        }

        double res = (1 - prob[from]) * dfs(prob, from + 1, target) + prob[from] * dfs(prob, from + 1, target - 1);
        memoMap.put(key, res);
        return res;
    }

    private void calcTailMultiply(double[] prob) {
        int n = prob.length;
        tailMultiply1 = new double[n];
        tailMultiply2 = new double[n];

        tailMultiply1[n - 1] = prob[n - 1];
        tailMultiply2[n - 1] = 1 - prob[n - 1];
        for (int i = n - 2; i >=0; i--) {
            tailMultiply1[i] = tailMultiply1[i + 1] * prob[i];
            tailMultiply2[i] = tailMultiply2[i + 1] * (1 - prob[i]);
        }
    }

    public double probabilityOfHeads(double[] prob, int target) {
        calcTailMultiply(prob);
//        return dfs(prob, 0, target);
        return dpVersion(prob, target);
    }

    private double dpVersion(double[] prob, int target) {
        int n = prob.length;
        calcTailMultiply(prob);

        double[][] dp = new double[n+1][n+1];

        dp[n-1][0] = 1 - prob[n-1];
        dp[n-1][1] = prob[n-1];

        for (int i = n - 2; i >= 0; i--) {
            dp[i][0] = tailMultiply2[i];
            for (int j = 1; j <= n - i; j++) {
                dp[i][j] = prob[i] * dp[i+1][j-1] + (1 - prob[i]) * dp[i+1][j];
            }
        }

        return dp[0][target];
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1230().probabilityOfHeads(new double[]{0.5,0.5,0.5,0.5,0.5}, 0));
        System.out.println(new Problem1230().probabilityOfHeads(new double[]{0.4}, 1));
        System.out.println(new Problem1230().probabilityOfHeads(new double[]{0.2,0.8,0,0.3,0.5}, 3));  //0.182
    }
}
