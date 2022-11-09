package contest.contest315;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B {

    private int getReverse(int num) {
        int reverseNum = 0;
        while (num > 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num /= 10;
        }
        return reverseNum;
    }

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        Set<Integer> ansSet = new HashSet<>(set);
        for (int num : set) {
            ansSet.add(getReverse(num));
        }
        return ansSet.size();
    }

}
