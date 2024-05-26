package contest.contest387;

import java.util.ArrayList;
import java.util.List;

public class A {

    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (list1.get(list1.size() - 1) > list2.get(list2.size() - 1)) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        list1.addAll(list2);
        int[] ansArr = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            ansArr[i] = list1.get(i);
        }
        return ansArr;
    }

}
