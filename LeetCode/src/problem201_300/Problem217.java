package problem201_300;

import java.util.HashSet;
import java.util.Set;

public class Problem217 {

    // 使用set记录前面出现过的数字，若后面的数字在set中已经被标记，则说明出现重复数字
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num)) {
                return true;
            }
            visited.add(num);
        }

        return false;
    }

}
