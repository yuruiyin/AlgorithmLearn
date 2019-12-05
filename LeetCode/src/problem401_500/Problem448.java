package problem401_500;

import java.util.ArrayList;
import java.util.List;

public class Problem448 {

    // 采用计数排序的思路，将数字移动到该数字对应索引的位置上，如5要放到索引为5-1的位置上。
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (true) {
                int rightIndex = nums[i] - 1;
                if (i+1 == nums[i] || nums[rightIndex] == nums[i]) {
                    // 当前位置已经在正确的位置上或者要替换的位置上的元素已经处在正确的位置上了。
                    break;
                }

                int tmp = nums[i];
                nums[i] = nums[rightIndex];
                nums[rightIndex] = tmp;
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i+1 != nums[i]) {
                ansList.add(i+1);
            }
        }

        return ansList;
    }

}
