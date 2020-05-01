package contest.contest186;

import java.util.Deque;
import java.util.LinkedList;

/**
 * D_1
 *
 * @author: yry
 * @date: 2020/4/26
 */
public class D_1 {

    public int constrainedSubsetSum(int[] nums, int k) {
        // 单调队列， 使用单调递减队列，因为左侧比右侧小的元素一定没用
        int len = nums.length;
        int[] dp = new int[len];
        Deque<Integer> deque = new LinkedList<>(); // 放index
        deque.addLast(0);
        dp[0] = nums[0];
        int ansMax = nums[0];

        for (int i = 1; i < len; i++) {
            int max = dp[deque.getFirst()];
            dp[i] = max <= 0 ? nums[i] : max + nums[i];

            while (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && dp[deque.getLast()] <= dp[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
            ansMax = Math.max(ansMax, dp[i]);
        }

        return ansMax;
    }

}
