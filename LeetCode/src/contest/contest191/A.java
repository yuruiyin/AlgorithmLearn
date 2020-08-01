package contest.contest191;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/31
 */
public class A {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                ansMax = Math.max(ansMax, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return ansMax;
    }

}
