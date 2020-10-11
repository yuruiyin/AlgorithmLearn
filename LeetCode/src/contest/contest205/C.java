package contest.contest205;

import java.util.LinkedList;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/6
 */
public class C {

    public int minCost(String s, int[] cost) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int preIdx = 0;
        int ans = 0;

        for (int i = 1; i < len; i++) {
            char preChar = arr[preIdx];
            if (arr[i] == preChar) {
                if (cost[i] <= cost[preIdx]) {
                    ans += cost[i];
                } else {
                    ans += cost[preIdx];
                    preIdx = i;
                }
            } else {
                preIdx = i;
            }
        }

        return ans;
    }

}
