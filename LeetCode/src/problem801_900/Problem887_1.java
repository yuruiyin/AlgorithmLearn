package problem801_900;

/**
 * Problem887_1
 *
 * @author: yry
 * @date: 2020/4/11
 */
public class Problem887_1 {

    private Integer[][] memo;

    private int dfs(int k, int n) {
        if (n <= 1 || k == 1) {
            return n;
        }

        if (memo[k][n] != null) {
            return memo[k][n];
        }

        // 二分
        int ansMin = Integer.MAX_VALUE;
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            // 碎了和没碎
            int brokenRes = dfs(k - 1, mid - 1);
            int nonBrokenRes = dfs(k, n - mid);
            if (brokenRes >= nonBrokenRes) {
                // 放太高了
                ansMin = Math.min(ansMin, brokenRes);
                high = mid - 1;
            } else {
                ansMin = Math.min(ansMin, nonBrokenRes);
                low = mid + 1;
            }
        }

        memo[k][n] = ansMin + 1;
        return memo[k][n];
    }

    public int superEggDrop(int k, int n) {
        memo = new Integer[k + 1][n + 1];
        return dfs(k, n);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem887_1().superEggDrop(2, 6));
        System.out.println(new Problem887_1().superEggDrop(3, 14));
    }

}
