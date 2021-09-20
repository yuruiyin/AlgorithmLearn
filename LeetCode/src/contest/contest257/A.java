package contest.contest257;

import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/5
 */
public class A {

    public int countQuadruplets(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    for (int l = k + 1; l < len; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

}
