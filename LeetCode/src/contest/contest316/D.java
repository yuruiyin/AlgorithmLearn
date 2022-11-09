package contest.contest316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D {

    public long makeSimilar(int[] nums, int[] target) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        Arrays.sort(target);
        Arrays.sort(nums);
        List<Integer> oddList1 = new ArrayList<>();
        List<Integer> oddList2 = new ArrayList<>();
        List<Integer> evenList1 = new ArrayList<>();
        List<Integer> evenList2 = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 1) {
                oddList1.add(nums[i]);
            } else {
                evenList1.add(nums[i]);
            }
        }

        for (int i = 0; i < len; i++) {
            if (target[i] % 2 == 1) {
                oddList2.add(target[i]);
            } else {
                evenList2.add(target[i]);
            }
        }

        long ansCount = 0;
        for (int i = 0; i < oddList1.size(); i++) {
            if (oddList1.get(i) > oddList2.get(i)) {
                ansCount += (oddList1.get(i) - oddList2.get(i)) / 2;
            }
        }

        for (int i = 0; i < evenList1.size(); i++) {
            if (evenList1.get(i) > evenList2.get(i)) {
                ansCount += (evenList1.get(i) - evenList2.get(i)) / 2;
            }
        }
        return ansCount;
    }

}
