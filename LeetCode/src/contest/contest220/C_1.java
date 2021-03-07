package contest.contest220;

import utils.TreeMultiSet;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/20
 */
public class C_1 {

    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (o1, o2) -> dp[o2] - dp[o1]);
        pq.add(0);
        for (int i = 1; i < len; i++) {
            while (pq.peek() < i - k) {
                pq.poll();
            }

            dp[i] = dp[pq.peek()] + nums[i];
            pq.add(i);
        }

        return dp[len - 1];
    }

}
