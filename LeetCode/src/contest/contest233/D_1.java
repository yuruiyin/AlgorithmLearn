package contest.contest233;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/21
 */
public class D_1 {

    public int countPairs(int[] nums, int low, int high) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] ^ nums[j]) >= low && (nums[i] ^ nums[j]) <= high) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D_1().countPairs(new int[]{1, 4, 2, 7}, 2, 6));
    }

}
