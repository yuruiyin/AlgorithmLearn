package problem201_300;

import java.util.ArrayList;
import java.util.List;

public class Problem229 {

    // 摩尔投票法，个数超过n/3的数最多只有两个
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int len = nums.length;
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        int needCount = len / 3;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
                continue;
            }

            if (num == candidate2) {
                count2++;
                continue;
            }

            if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
                continue;
            }

            if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
                continue;
            }

            count1--;
            count2--;
        }

        List<Integer> ansList = new ArrayList<>();
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        if (count1 > needCount) {
            ansList.add(candidate1);
        }

        if (count2 > needCount) {
            ansList.add(candidate2);
        }

        return ansList;
    }

}
