package problem201_300;

import java.util.HashSet;
import java.util.Set;

public class Problem217_2 {

    // 用一个set存储数组中的每个不同元素，若set中的元素个数与原数组中元素个数不同，则说明原数组中存在重复数字
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return set.size() != len;
    }

}
