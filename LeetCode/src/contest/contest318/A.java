package contest.contest318;

import java.util.ArrayList;
import java.util.List;

public class A {

    public int[] applyOperations(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                if (nums[i] != 0) {
                    list.add(nums[i]);
                }
                nums[i + 1] = 0;
            } else {
                if (nums[i] != 0) {
                    list.add(nums[i]);
                }
            }
        }

        if (nums[len - 1] != 0) {
            list.add(nums[len - 1]);
        }

        int[] ansArr = new int[len];
        for (int i = 0; i < list.size(); i++) {
            ansArr[i] = list.get(i);
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
