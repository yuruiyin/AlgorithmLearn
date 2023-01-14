package contest.contest321;

import java.util.HashMap;
import java.util.Map;

public class D {

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
        Map<Integer, Integer> rightCountMap = new HashMap<>();
        for (int i = targetIdx + 1; i < len; i++) {
            if (nums[i] > k) {
                biggerCount++;
            } else {
                smallerCount++;
            }
            int key = biggerCount - smallerCount;
            rightCountMap.put(key, rightCountMap.getOrDefault(key, 0) + 1);
            if ((i - targetIdx + 1) % 2 == 0) {
                if (biggerCount == smallerCount + 1) {
                    ans++;
                }
            } else {
                if (biggerCount == smallerCount) {
                    ans++;
                }
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

            // 奇数
            ans += rightCountMap.getOrDefault(smallerCount - biggerCount, 0);

            // 偶数
            ans += rightCountMap.getOrDefault(smallerCount - biggerCount + 1, 0);

            if ((targetIdx - i + 1) % 2 == 0) {
                if (biggerCount == smallerCount + 1) {
                    ans++;
                }
            } else {
                if (biggerCount == smallerCount) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // [3,2,1,4,5], k = 4
//        System.out.println(new D().countSubarrays(new int[]{3,2,1,4,5}, 4));
//        [5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14], 6
        System.out.println(new D().countSubarrays(new int[]{5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14}, 6));
    }

}
