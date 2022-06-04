package contest.contest279;

import java.util.*;

public class A {

    public int[] sortEvenOdd(int[] nums) {
        LinkedList<Integer> oddList = new LinkedList<>();
        LinkedList<Integer> evenList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                oddList.add(nums[i]);
            } else {
                evenList.add(nums[i]);
            }
        }

        Collections.sort(evenList);
        Collections.sort(oddList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int[] ansArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                ansArr[i] = oddList.pollFirst();
            } else {
                ansArr[i] = evenList.pollFirst();
            }
        }
        return ansArr;
    }

}
