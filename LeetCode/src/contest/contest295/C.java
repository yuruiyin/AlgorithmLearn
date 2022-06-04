package contest.contest295;

import java.util.ArrayList;
import java.util.List;

public class C {

    private int[] nums;
    private int dfs(int pre, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return nums[l] < pre ? 1 : 0;
        }
        int count = 0;
        boolean flag = false;
        int ansMax = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] >= pre) {
                count = Math.max(count, dfs(nums[i], i + 1, r));
                break;
            } else {
                if (!flag) {
                    count++;
                    flag = true;
                    continue;
                }
                // 要被删除的
                if (nums[i] >= nums[i - 1]) {
                    count++;
                } else {
                    count = Math.max(count, dfs(nums[i - 1], i, r));
                    break;
                }
            }
        }
        ansMax = Math.max(ansMax, count);
        return ansMax;
    }

    public int totalSteps(int[] nums) {
        // 第一遍
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        this.nums = nums;
        return dfs(nums[0], 1, len - 1);
    }

    public static void main(String[] args) {
//        System.out.println(new C().totalSteps(new int[]{5,3,4,4,7,3,6,11,8,5,11}));
        //[10,1,2,3,4,5,6,1,2,3]
//        System.out.println(new C().totalSteps(new int[]{10,1,2,3,4,5,6,1,2,3}));
//        [7,14,4,14,13,2,6,13]
        System.out.println(new C().totalSteps(new int[]{7,14,4,14,13,2,6,13}));
    }

}
