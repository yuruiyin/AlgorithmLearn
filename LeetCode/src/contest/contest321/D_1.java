package contest.contest321;

import java.util.HashMap;
import java.util.Map;

public class D_1 {

    public int countSubarrays(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }

        int targetIdx = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == k) {
                targetIdx = i;
                break;
            }
        }

        int ans = 1;
        int biggerCount = 0;
        int smallerCount = 0;
        int[] diffCountArr = new int[2 * len + 1];
        for (int i = targetIdx + 1; i < len; i++) {
            if (nums[i] > k) {
                biggerCount++;
            } else {
                smallerCount++;
            }
            int diff = biggerCount - smallerCount;
            diffCountArr[diff + len]++;
            if (diff >= 0 && diff <= 1) {
                ans++;
            }
        }
        if (targetIdx == 0) {
            return ans;
        }

        biggerCount = 0;
        smallerCount = 0;
        for (int i = targetIdx - 1; i >= 0; i--) {
            if (nums[i] > k) {
                biggerCount++;
            } else {
                smallerCount++;
            }

            int diff = biggerCount - smallerCount;

            // 奇数
            ans += diffCountArr[-diff + len];
            // 偶数
            ans += diffCountArr[-diff + 1 + len];

            if (diff >= 0 && diff <= 1) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // [3,2,1,4,5], k = 4
//        System.out.println(new D().countSubarrays(new int[]{3,2,1,4,5}, 4));
//        [5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14], 6
        System.out.println(new D_1().countSubarrays(new int[]{5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14}, 6));
    }

}
