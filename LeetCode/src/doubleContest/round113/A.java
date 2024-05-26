package doubleContest.round113;

import java.util.*;

public class A {

    public int minimumRightShifts(List<Integer> nums) {
        int size = nums.size();
        if (size == 1) {
            return 0;
        }

        int minIdx = -1;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (nums.get(i) < minNum) {
                minNum = nums.get(i);
                minIdx = i;
            }
        }

        for (int i = minIdx + 1; i < size; i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return -1;
            }
        }

        if (minIdx == 0) {
            return 0;
        }

        int rightMax = nums.get(size - 1);
        if (nums.get(0) < rightMax) {
            return -1;
        }
        for (int i = 1; i < minIdx; i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return -1;
            }
        }
        return size - minIdx;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
