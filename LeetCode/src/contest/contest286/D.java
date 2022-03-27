package contest.contest286;

import java.util.Arrays;
import java.util.List;

public class D {

    private int[][] arr;
    private int[][] memo;
    private int[][] preSumArr;

    private int dp(int start, int k) {
        if (k <= 0) {
            return 0;
        }

        if (start == arr.length) {
            return -1;
        }

        if (memo[start][k] != -1) {
            return memo[start][k];
        }

        int ansMax = 0;
        for (int j = 0; j < arr[start].length; j++) {
            if (j + 1 > k) {
                break;
            }
            int preSum = preSumArr[start][j];
            int res = dp(start + 1, k - (j + 1));
            if (res == -1) {
                continue;
            }
            ansMax = Math.max(ansMax, preSum + res);
        }

        ansMax = Math.max(ansMax, dp(start + 1, k));
        memo[start][k] = ansMax;
        return ansMax;
    }

    private void calcPreSum(int[][] arr) {
        int rowCount = arr.length;
        preSumArr = new int[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            preSumArr[i] = new int[arr[i].length];
            preSumArr[i][0] = arr[i][0];
            for (int j = 1; j < arr[i].length; j++) {
                preSumArr[i][j] = preSumArr[i][j - 1] + arr[i][j];
            }
        }
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int rowCount = piles.size();
        arr = new int[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            arr[i] = new int[piles.get(i).size()];
            for (int j = 0; j < piles.get(i).size(); j++) {
                arr[i][j] = piles.get(i).get(j);
            }
        }

        calcPreSum(arr);
        memo = new int[rowCount][k + 1];
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, k);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
