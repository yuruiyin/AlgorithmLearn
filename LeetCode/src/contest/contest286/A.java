package contest.contest286;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ansList = new ArrayList<>();
        ansList.add(new ArrayList<>());
        ansList.add(new ArrayList<>());
        Set<Integer> set = new HashSet<>();
        for (int num1 : nums1) {
            if (set.contains(num1)) {
                continue;
            }
            set.add(num1);
            boolean isExist = false;
            for (int num2: nums2) {
                if (num1 == num2) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                ansList.get(0).add(num1);
            }
        }

        set.clear();
        for (int num2 : nums2) {
            if (set.contains(num2)) {
                continue;
            }
            set.add(num2);
            boolean isExist = false;
            for (int num1: nums1) {
                if (num1 == num2) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                ansList.get(1).add(num2);
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
    
}
