package contest.contest197;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/12
 */
public class A {

    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
