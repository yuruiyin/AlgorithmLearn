package contest.contest231;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/7
 */
public class B {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        long diff = goal - sum;

        long n = Math.abs(diff / limit);

        return (int) (n + (diff % limit == 0 ? 0 : 1));
    }

}
