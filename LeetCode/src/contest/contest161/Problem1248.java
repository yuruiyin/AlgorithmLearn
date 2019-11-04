package contest.contest161;

import java.util.ArrayList;
import java.util.List;

public class Problem1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        List<Integer> oddIndexList = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 1) {
                oddIndexList.add(i);
            }
        }

        if (oddIndexList.size() < k) {
            return 0;
        }

        for (int i = 0; i < oddIndexList.size() - k + 1; i++) {
            int leftEvenCount;
            if (i == 0) {
                leftEvenCount = oddIndexList.get(i);
            } else {
                leftEvenCount = oddIndexList.get(i) - oddIndexList.get(i-1) - 1;
            }

            int rightEvenCount;
            int rightIndex = i + k - 1;
            if (rightIndex == oddIndexList.size() - 1) {
                rightEvenCount = len - oddIndexList.get(rightIndex) - 1;
            } else {
                rightEvenCount = oddIndexList.get(rightIndex + 1) - oddIndexList.get(rightIndex) - 1;
            }

            ans += (leftEvenCount + 1) * (rightEvenCount + 1);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1248().numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
        System.out.println(new Problem1248().numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    }
    
}

//示例 1：
//
//        输入：nums = [1,1,2,1,1], k = 3
//        输出：2
//        解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
//        示例 2：
//
//        输入：nums = [2,4,6], k = 1
//        输出：0
//        解释：数列中不包含任何奇数，所以不存在优美子数组。
//        示例 3：
//
//        输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//        输出：16
//
//
//        提示：
//
//        1 <= nums.length <= 50000
//        1 <= nums[i] <= 10^5
//        1 <= k <= nums.length

//    给你一个整数数组 nums 和一个整数 k。
//
//        如果某个子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
//
//        请返回这个数组中「优美子数组」的数目。
