package doubleContest.round091;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A {

    public int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        while (list.size() > 1) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int num : list) {
                if (num < min) {
                    min = num;
                }
            }
            list.remove((Integer) min);
            for (int num : list) {
                if (num > max) {
                    max = num;
                }
            }

            list.remove((Integer) max);
            set.add((min + max) / 2.0);
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
