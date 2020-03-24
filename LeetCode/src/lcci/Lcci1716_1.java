package lcci;

/**
 * Lcci1716
 *
 * @author: yry
 * @date: 2020/3/24
 */
public class Lcci1716_1 {

    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int preChooseMax = nums[0];
        int preNoChooseMax = 0;

        for (int i = 1; i < n; i++) {
            int oldPreNoChooseMax = preNoChooseMax;
            preNoChooseMax = Math.max(preNoChooseMax, preChooseMax);
            preChooseMax = oldPreNoChooseMax + nums[i];
        }

        return Math.max(preChooseMax, preNoChooseMax);
    }

}
