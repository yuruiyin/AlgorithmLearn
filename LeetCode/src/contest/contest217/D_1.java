package contest.contest217;

import java.util.TreeSet;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/29
 */
public class D_1 {

    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        // 从每个数的最大值往下缩小
        for (int num : nums) {
            set.add(num % 2 == 1 ? num * 2 : num);
        }

        int ansMin = set.last() - set.first();
        while (ansMin > 0 && set.last() % 2 == 0) {
            int max = set.pollLast();
            set.add(max / 2);
            ansMin = Math.min(ansMin, set.last() - set.first());
        }
        return ansMin;
    }

}
