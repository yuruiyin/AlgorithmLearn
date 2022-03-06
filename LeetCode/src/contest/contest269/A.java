package contest.contest269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* a
*
* @author: yry
* @date: 2021/11/28
*/
public class A {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
