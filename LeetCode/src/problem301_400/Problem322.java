package problem301_400;

import java.util.HashMap;
import java.util.Map;

public class Problem322 {

    // 备忘录，key代表金额，value是最少硬币数
    private Map<Integer, Integer> memoMap;

    private int dfs(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (memoMap.containsKey(amount)) {
            return memoMap.get(amount);
        }

        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            int tmpAmount = amount - coin;

            if (tmpAmount < 0) {
                continue;
            }

            int count = dfs(coins, tmpAmount);

            if (count == -1) {
                continue;
            }

            ans = Math.min(count + 1, ans);
        }

        int minCount = ans == Integer.MAX_VALUE ? -1 : ans;
        memoMap.put(amount, minCount);
        return minCount;
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int n = coins.length;
        if (n == 0) {
            return -1;
        }

        memoMap = new HashMap<>();
        return dfs(coins, amount);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem322().coinChange(new int[]{1,2,5}, 11));
        System.out.println(new Problem322().coinChange(new int[]{2}, 3));
        System.out.println(new Problem322().coinChange(new int[]{1,2,5}, 10000));
    }
    
}
