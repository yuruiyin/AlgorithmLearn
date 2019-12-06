package problem201_300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem229_1 {

    // 不按题目要求，先排序后处理，时间复杂度O(nlogn)
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int needCount = len / 3;

        int count = 1;
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] != nums[i+1]) {
                if (count > needCount) {
                    ansList.add(nums[i]);
                }
                count = 1;
            } else {
                count++;
            }
        }

        if (count > needCount) {
            ansList.add(nums[len-1]);
        }

        return ansList;
    }

}
