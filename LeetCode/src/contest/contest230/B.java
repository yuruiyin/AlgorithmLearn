package contest.contest230;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/28
 */
public class B {

    private Set<Integer> set;

    private void dfs(int[] toppingCosts, int idx, int sum) {
        if (idx == toppingCosts.length) {
            set.add(sum);
            return;
        }

        dfs(toppingCosts, idx + 1, sum);
        dfs(toppingCosts, idx + 1, sum + toppingCosts[idx]);
        dfs(toppingCosts, idx + 1, sum + toppingCosts[idx] * 2);
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int ans = baseCosts[0];
        int ansMinDiff = Math.abs(ans - target);

        set = new HashSet<>();
        dfs(toppingCosts, 0, 0);

        for (int i = 0; i < baseCosts.length; i++) {
            int value = baseCosts[i];
            int minDiff = Math.abs(value - target);
            if (value >= target && minDiff >= ansMinDiff) {
                continue;
            }

            if (minDiff < ansMinDiff) {
                ansMinDiff = minDiff;
                ans = value;
            }

            for (int num : set) {
                int tmp = value;
                tmp += num;
                minDiff = Math.abs(tmp - target);
                if (minDiff < ansMinDiff) {
                    ansMinDiff = minDiff;
                    ans = tmp;
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
//        System.out.println(new B().closestCost(new int[]{3, 10}, new int[]{2, 5}, 9));
        System.out.println(new B().closestCost(new int[]{2, 3}, new int[]{4, 5 ,100}, 18));
    }

}
