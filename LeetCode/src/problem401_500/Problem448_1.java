package problem401_500;

import java.util.ArrayList;
import java.util.List;

public class Problem448_1 {

    // 采用出现的数字对应的索引上的值+len，全部处理完之后若出现值还是<=len的索引对应的值就是没出现过
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            nums[(nums[i] - 1) % len] += len;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                ansList.add(i+1);
            }
        }

        return ansList;
    }

}
